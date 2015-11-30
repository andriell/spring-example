package com.apress.prospring4.ch2;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by Андрей on 23.11.2015.
 */
public class HelloWorldMessageProvider implements MessageProvider, InitializingBean, BeanNameAware, DisposableBean {
    @Override
    public String getMessage() {
        return "Hello world";
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("HelloWorldMessageProvider.afterPropertiesSet");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("HelloWorldMessageProvider.setBeanName: " + s);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("HelloWorldMessageProvider.destroy");
    }
}
