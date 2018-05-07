package com.soa;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class Subscriber {

    private final String id;

    public Subscriber(String id) {
        this.id = id;
    }

    public void subscribeToTopic(String topicName) {
        try {
            InitialContext ctx = new InitialContext();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public void sendPublicMessage(String topicName, String message) {
        try {
            Properties jndiProps = new Properties();
            jndiProps.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
            jndiProps.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
            jndiProps.put(Context.SECURITY_PRINCIPAL, "test");
            jndiProps.put(Context.SECURITY_CREDENTIALS, "test");

            Context ctx = new InitialContext(jndiProps);
            TopicConnectionFactory f = (TopicConnectionFactory) ctx.lookup("jms/RemoteConnectionFactory");
            TopicConnection con = f.createTopicConnection("test", "test");
            con.start();
            TopicSession ses = con.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);

            String topic = "java:jboss/jms/ThemeListTopic";
            Topic t = (Topic) ctx.lookup(topic);
            TopicPublisher publisher = ses.createPublisher(t);

            TextMessage msg = ses.createTextMessage();
            msg.setText(message);

            publisher.publish(msg);
            con.close();
        } catch (NamingException | JMSException e) {
            e.printStackTrace();
        }
    }

    public void sendPrivateMessage(String userId, String message) {
        try {
            InitialContext ctx = new InitialContext();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
