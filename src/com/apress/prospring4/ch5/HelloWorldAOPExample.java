package com.apress.prospring4.ch5;

import org.springframework.aop.framework.ProxyFactory;

/**
 * Created by ������ on 21.12.2015.
 */
public class HelloWorldAOPExample {
    public static void main(String[] args) {
        MessageWriter messageWriter = new MessageWriter();
        ProxyFactory proxyFactory = new ProxyFactory();
        // ��������� �����
        proxyFactory.addAdvice(new MessageDecorator());
        // ��������� ����
        proxyFactory.setTarget(messageWriter);

        MessageWriter messageWriterProxy = (MessageWriter) proxyFactory.getProxy();
        messageWriter.writeMessage();
        System.out.println();
        messageWriterProxy.writeMessage();
    }
}
