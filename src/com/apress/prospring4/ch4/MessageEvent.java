package com.apress.prospring4.ch4;

import org.springframework.context.ApplicationEvent;

/**
 * Created by Андрей on 03.12.2015.
 */
public class MessageEvent extends ApplicationEvent {
    private String msg;

    public MessageEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
