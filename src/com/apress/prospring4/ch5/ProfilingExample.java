package com.apress.prospring4.ch5;

import org.springframework.aop.framework.ProxyFactory;

/**
 * Created by Андрей on 23.12.2015.
 */
public class ProfilingExample {
    public static void main(String[] args) {
        WorkerBean bean = getWorkerBean();
        bean.doSomeWork(10000000);
    }

    public static WorkerBean getWorkerBean() {
        WorkerBean target = new WorkerBean();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvice(new ProfilingInterceptor());
        return (WorkerBean) proxyFactory.getProxy();
    }
}
