package com.apress.prospring4.ch2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Андрей on 23.11.2015.
 */
public class HelloWorldSpringDI {
    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/spring/app-context.xml");
        MessageRenderer messageRenderer = applicationContext.getBean("renderer", MessageRenderer.class);
        MessageProvider messageProvider = applicationContext.getBean("provider", MessageProvider.class);
        messageRenderer.setMessageProvider(messageProvider);
        messageRenderer.render();
    }
}
