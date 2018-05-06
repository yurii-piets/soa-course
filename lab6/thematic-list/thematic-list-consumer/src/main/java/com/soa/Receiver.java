package com.soa;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(name = "Receiver", activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/ThemeListQueue"),
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge")
})
public class Receiver implements MessageListener {

    public void onMessage(Message message) {
        TextMessage tm = (TextMessage) message;
        try {
            System.out.println(
                    String.format(
                            "A message was found! ^__^ It is: '%s'",
                            tm.getText())
            );
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
