package com.apress.prospring4.ch5;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

/**
 * Created by Андрей on 21.12.2015.
 */
public class SimpleBeforeAdvice implements MethodBeforeAdvice {

    public static void main(String[] args) {
        MessageWriter messageWriter = new MessageWriter();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new SimpleBeforeAdvice());
        proxyFactory.setTarget(messageWriter);

        MessageWriter messageWriterProxy = (MessageWriter) proxyFactory.getProxy();
        messageWriterProxy.writeMessage();
    }

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("Before method: " + method.getName());
    }
}
