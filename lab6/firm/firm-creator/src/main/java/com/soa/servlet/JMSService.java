package com.soa.servlet;

import lombok.NoArgsConstructor;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

@ApplicationScoped
@NoArgsConstructor
public class JMSService implements FirmProcessor {

    @Resource(mappedName = "java:/ConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(mappedName = "java:/jms/FirmTopic")
    private Topic topic;

    public void processFirm(String name, String owner){
        sendMessage(name, owner);
    }

    private void sendMessage(String name, String owner) {
        try (Connection connection = connectionFactory.createConnection()) {
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer publisher = session.createProducer(topic);
            connection.start();
            TextMessage textMessage = session.createTextMessage("Created firm: [" + name + "], with owner: [ " + owner + "].");
            publisher.send(textMessage);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
