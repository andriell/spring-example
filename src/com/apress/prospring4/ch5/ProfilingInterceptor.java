package com.apress.prospring4.ch5;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;

/**
 * Created by Андрей on 23.12.2015.
 */
public class ProfilingInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start(invocation.getMethod().getName());
        Object returnValue = invocation.proceed();
        sw.stop();
        dumpInfo(invocation, sw.getTotalTimeMillis());
        return returnValue;
    }

    private void dumpInfo(MethodInvocation invocation, long ms) {
        Method m = invocation.getMethod();
        Object target = invocation.getThis();
        Object[] args = invocation.getArguments();
        System.out.println("Executed method: " + m.getName()); // выполняемый метод
        System.out.println("On object of type: " +
                target.getClass().getName()); // класс объекта
        System.out.println("With arguments:"); // аргументы
        for (Object arg : args) {
            System.out.print(" > " + arg);
        }
        System.out.print("\n");
        System.out.println("Took: " + ms + " ms"); // время выполнения

    }
}
