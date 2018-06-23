package com.soa.service;

import com.soa.domain.hero.Dragon;
import com.soa.domain.hero.Elf;
import com.soa.domain.hero.Hero;
import com.soa.domain.hero.Mag;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import java.util.logging.Logger;

@ApplicationScoped
public class JMSService {

    public static final String DRAGON_TOPIC_NAME = "java:jboss/jms/DragonTopic";
    public static final String ELF_TOPIC_NAME = "java:jboss/jms/ElfTopic";
    public static final String MAG_TOPIC_NAME = "java:jboss/jms/MagTopic";

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Resource(mappedName = "java:/ConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(mappedName = DRAGON_TOPIC_NAME)
    private Topic dragonTopic;

    @Resource(mappedName = ELF_TOPIC_NAME)
    private Topic elfTopic;

    @Resource(mappedName = MAG_TOPIC_NAME)
    private Topic magTopic;

    public void send(Hero hero) {
        if (hero instanceof Dragon) {
            send(dragonTopic, hero);
        } else if (hero instanceof Elf) {
            send(elfTopic, hero);
        } else if (hero instanceof Mag) {
            send(magTopic, hero);
        }
    }

    private void send(Topic topic, Hero hero) {
        try (Connection connection = connectionFactory.createConnection()) {
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer publisher = session.createProducer(topic);
            connection.start();
            TextMessage textMessage = session.createTextMessage("Add new hero in your category with id: [" + hero.getId() + "]");
            publisher.send(textMessage);
        } catch (JMSException e) {
            logger.throwing("Unexpected", "send", e);
        }
    }
}
