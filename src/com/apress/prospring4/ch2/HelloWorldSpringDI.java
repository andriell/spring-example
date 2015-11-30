package com.apress.prospring4.ch2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ������ on 23.11.2015.
 */
public class HelloWorldSpringDI {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/spring/app-context.xml");
        // ��� ����� ������� destroy ��� ����� �� ����� �������
        applicationContext.registerShutdownHook();
        MessageRenderer messageRenderer = applicationContext.getBean("renderer", MessageRenderer.class);
        messageRenderer.render();
    }
}
