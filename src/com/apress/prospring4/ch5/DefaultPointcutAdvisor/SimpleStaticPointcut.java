package com.apress.prospring4.ch5.DefaultPointcutAdvisor;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

/**
 * Это сраз, его функция в том, что бы сказать советчику нужно ли применять совет для данного метода или нет
 * Created by Андрей on 23.12.2015.
 */
public class SimpleStaticPointcut extends StaticMethodMatcherPointcut {
    @Override
    public boolean matches(Method method, Class<?> aClass) {
        return "foo".equals(method.getName());
    }

    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> aClass) {
                return aClass == BeanOne.class;
            }
        };
    }
}
