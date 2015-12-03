package com.apress.prospring4.ch4;

import org.springframework.context.ApplicationListener;

/**
 * Created by Андрей on 03.12.2015.
 */
public class MessageEventListener implements ApplicationListener<MessageEvent> {
    @Override
    public void onApplicationEvent(MessageEvent messageEvent) {
        System.out.println("Revised: " + messageEvent.getMsg());
    }
}
