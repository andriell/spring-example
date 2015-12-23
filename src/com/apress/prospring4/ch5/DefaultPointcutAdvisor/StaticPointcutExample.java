package com.apress.prospring4.ch5.DefaultPointcutAdvisor;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * Created by Андрей on 23.12.2015.
 */
public class StaticPointcutExample {
    public static void main(String[] args) {
        BeanOne beanOne = new BeanOne();
        BeanTwo beanTwo = new BeanTwo();

        BeanOne proxyOne;
        BeanTwo proxyTwo;

        Pointcut pc = new SimpleStaticPointcut(); // Новый срез
        Advice advice = new SimpleAdvice(); // Новый совет
        Advisor advisor = new DefaultPointcutAdvisor(pc, advice); // Новый советчик

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setTarget(beanOne);
        proxyOne = (BeanOne) proxyFactory.getProxy();

        proxyFactory = new ProxyFactory();
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setTarget(beanTwo);
        proxyTwo = (BeanTwo) proxyFactory.getProxy();

        proxyOne.foo();
        proxyTwo.foo();

        proxyOne.bar();
        proxyTwo.bar();
    }
}
