package com.soa.jms;

import com.soa.data.Book;
import com.soa.ejb.BookManager;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

@MessageDriven(name = "BookMDB", activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/LibraryTopic"),
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge")
})
public class BookMDB implements MessageListener {

    @Inject
    private BookManager bookManager;

    @Override
    public void onMessage(Message message) {
        try {
            ObjectMessage objectMessage = (ObjectMessage) message;
            Book book = (Book) objectMessage.getObject();
            bookManager.getBooks().add(book);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
