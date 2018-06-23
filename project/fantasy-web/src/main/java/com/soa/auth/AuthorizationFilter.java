package com.soa.auth;

import com.soa.domain.UserData;
import com.soa.domain.categories.Category;
import com.soa.domain.categories.Cave;
import com.soa.domain.categories.Forest;
import com.soa.domain.categories.Tower;
import com.soa.jms.TextMessageListener;
import com.soa.service.DataAccessService;
import com.soa.session.SessionManagerBean;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.Topic;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static com.soa.service.JMSService.DRAGON_TOPIC_NAME;
import static com.soa.service.JMSService.ELF_TOPIC_NAME;
import static com.soa.service.JMSService.MAG_TOPIC_NAME;
import static com.soa.session.HttpSessionListenerImpl.LOGIN_SESSION_PARAMETER;

public class AuthorizationFilter implements Filter {

    public static final String MESSAGES_SESSION_ATTRIBUTE = "messages";

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @EJB
    private SessionManagerBean sessionManagerBean;

    @EJB
    private DataAccessService dataService;

    @Resource(mappedName = "java:/ConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(mappedName = DRAGON_TOPIC_NAME)
    private Topic dragonTopic;

    @Resource(mappedName = ELF_TOPIC_NAME)
    private Topic elfTopic;

    @Resource(mappedName = MAG_TOPIC_NAME)
    private Topic magTopic;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (request instanceof HttpServletRequest) {
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            if (httpServletRequest.getHeader("User-Agent").contains("Firefox")) {
                if (response instanceof HttpServletResponse) {
                    ((HttpServletResponse) response).sendError(403);
                    httpServletRequest.logout();
                }
                return;
            }
            Principal userPrincipal = httpServletRequest.getUserPrincipal();
            if(userPrincipal == null) {
                chain.doFilter(request, response);
               return;
            }
            String name = userPrincipal.getName();
            if (sessionManagerBean.isLocked(name, httpServletRequest.getSession())) {
                if (response instanceof HttpServletResponse) {
                    ((HttpServletResponse) response).sendError(423);
                    httpServletRequest.logout();
                }
                return;
            } else {
                httpServletRequest.getSession(true).setAttribute(LOGIN_SESSION_PARAMETER, name);
            }
            registerJms(httpServletRequest);
        }
        chain.doFilter(request, response);
    }

    private void registerJms(HttpServletRequest httpServletRequest) {
        String name = httpServletRequest.getUserPrincipal().getName();
        if(name == null || name.isEmpty()){
            return;
        }
        HttpSession httpSession = httpServletRequest.getSession();
        if(httpSession.getAttribute(MESSAGES_SESSION_ATTRIBUTE) == null) {
            UserData user = dataService.findUserDataByLogin(name);
            List<Category> categories = user.getCategories();
            try {
                Connection connection = connectionFactory.createConnection();
                Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

                List<String> messages = new ArrayList<>();
                MessageListener messageListener = new TextMessageListener(messages);
                httpSession.setAttribute(MESSAGES_SESSION_ATTRIBUTE, messages);
                if (categories.stream().anyMatch(c -> c instanceof Cave)) {
                    MessageConsumer subscriber = session.createSharedConsumer(dragonTopic, "Dragon Subscriber");
                    subscriber.setMessageListener(messageListener);
                }
                if (categories.stream().anyMatch(c -> c instanceof Tower)) {
                    MessageConsumer subscriber = session.createSharedConsumer(magTopic, "Mag Subscriber");
                    subscriber.setMessageListener(messageListener);
                }
                if (categories.stream().anyMatch(c -> c instanceof Forest)) {
                    MessageConsumer subscriber = session.createSharedConsumer(elfTopic, "Forest Subscriber");
                    subscriber.setMessageListener(messageListener);
                }
                connection.start();
            } catch (JMSException e) {
                logger.throwing("HttpSessionListenerImpl", "sessionCreated", e);
            }
        }
    }

    @Override
    public void destroy() {
    }
}
