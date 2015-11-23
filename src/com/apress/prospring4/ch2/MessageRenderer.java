package com.apress.prospring4.ch2;

/**
 * Created by ������ on 23.11.2015.
 */
public interface MessageRenderer {
    public void render() throws Exception;
    public MessageProvider getMessageProvider();
    public void setMessageProvider(MessageProvider messageProvider);
}
