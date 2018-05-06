package com.soa.jms;

import com.soa.data.Book;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.Topic;

@ApplicationScoped
public class BookRegisterService {

    @Resource(mappedName = "java:/ConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(mappedName = "java:/jms/LibraryTopic")
    private Topic topic;

    public void add(Book book) {
        try (Connection connection = connectionFactory.createConnection()) {
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer publisher = session.createProducer(topic);
            connection.start();
            ObjectMessage objectMessage = session.createObjectMessage(book);
            publisher.send(objectMessage);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
