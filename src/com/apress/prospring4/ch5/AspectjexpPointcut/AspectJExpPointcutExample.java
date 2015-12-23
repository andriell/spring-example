package com.apress.prospring4.ch5.AspectjexpPointcut;

import com.apress.prospring4.ch5.DefaultPointcutAdvisor.SimpleAdvice;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * Created by Андрей on 23.12.2015.
 */
public class AspectJExpPointcutExample {
    public static void main(String[] args) {
        AspectJExpBean target = new AspectJExpBean();
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(*foo*(..))");
        Advisor advisor = new DefaultPointcutAdvisor(pointcut, new SimpleAdvice());

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvisor(advisor);

        AspectJExpBean aspectJExpBeanProxy = (AspectJExpBean) proxyFactory.getProxy();

        aspectJExpBeanProxy.fool();
        aspectJExpBeanProxy.foo2();
        aspectJExpBeanProxy.bar();
    }
}
