package com.apress.prospring4.ch5;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

/**
 * Created by Андрей on 23.12.2015.
 */
public class SimpleAfterReturningAdvice implements AfterReturningAdvice {
    public static void main(String[] args) {
        MessageWriter messageWriter = new MessageWriter();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new SimpleAfterReturningAdvice());
        proxyFactory.setTarget(messageWriter);

        MessageWriter messageWriterProxy = (MessageWriter) proxyFactory.getProxy();
        messageWriterProxy.writeMessage();
    }

    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println();
        System.out.println("After method: " + method.getName());
    }
}
