package com.apress.prospring4.ch4;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by Андрей on 02.12.2015.
 */
public class MessageDigestExample {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("META-INF/spring/ch4.xml");
        context.refresh();

        MessageDigester digester = (MessageDigester) context.getBean("digest");
        digester.digest("Hello World!");
    }
}
