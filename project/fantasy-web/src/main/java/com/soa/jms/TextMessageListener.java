package com.soa.jms;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

@Getter
@RequiredArgsConstructor
public class TextMessageListener implements Serializable, MessageListener {

    private final List<String> messages;

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof TextMessage) {
                String text = ((TextMessage) message).getText();
                messages.add(text);
            }
        } catch (JMSException e) {
            logger.throwing("Unexpected", "onMessage", e);
        }
    }

}
