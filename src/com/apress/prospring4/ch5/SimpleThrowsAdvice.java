package com.apress.prospring4.ch5;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

/**
 * Created by Андрей on 23.12.2015.
 */
public class SimpleThrowsAdvice implements ThrowsAdvice {
    public static void main(String[] args) throws Exception {
        ErrorBean errorBean = new ErrorBean();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(errorBean);
        proxyFactory.addAdvice(new SimpleThrowsAdvice());

        ErrorBean errorBeanProxy = (ErrorBean) proxyFactory.getProxy();

        try {
            errorBeanProxy.errorProneMethod();
        } catch (Exception ignored) {}

        try {
            errorBeanProxy.otherErrorProneMethod();
        } catch (IllegalArgumentException ignored) {}
    }

    public void afterThrowing(Exception ex) throws Throwable {
        System.out.println("***");
        System.out.println("Generic Exception Capture");
        // перехват обобщенного исключения
        System.out.println("Caught: " + ex.getClass() .getName());
        // имя исключения
        System.out.println("***\n");
    }

    public void afterThrowing(Method method, Object[] args, Object target,
                             IllegalArgumentException ex) throws Throwable {
        System.out.println("***");
        System.out.println("IllegalArgumentException Capture");
        // перехват исключения IllegalArgumentException
        System.out.println("Caught: " + ex.getClass().getName());
        //имя исключения
        System.out.println("Method: " + method.getName()); //имя метода
        System.out.println("***\n");
    }
}
