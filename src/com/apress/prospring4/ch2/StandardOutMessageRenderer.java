package com.apress.prospring4.ch2;

/**
 * Created by Андрей on 23.11.2015.
 */
public class StandardOutMessageRenderer implements MessageRenderer {
    private MessageProvider messageProvider;

    @Override
    public void render() throws RuntimeException {
        if (messageProvider == null) {
            throw new RuntimeException("123");
        }
        System.out.println(messageProvider.getMessage());
    }

    public MessageProvider getMessageProvider() {
        return messageProvider;
    }

    public void setMessageProvider(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }
}
