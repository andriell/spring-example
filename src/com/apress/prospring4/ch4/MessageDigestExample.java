package com.apress.prospring4.ch4;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by Андрей on 02.12.2015.
 */
public class MessageDigestExample {
    public void go() {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("META-INF/spring/ch4.xml");
        context.refresh();

        MessageDigester digester = (MessageDigester) context.getBean("digest");
        digester.digest("Hello World!");

        context.publishEvent(new MessageEvent(this, "Event 1"));
        context.publishEvent(new MessageEvent(this, "Event 2"));
    }

    public static void main(String[] args) {
        MessageDigestExample example = new MessageDigestExample();
        example.go();
    }
}
