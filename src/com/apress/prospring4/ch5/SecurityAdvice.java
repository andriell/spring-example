package com.apress.prospring4.ch5;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by Андрей on 21.12.2015.
 */
public class SecurityAdvice implements MethodBeforeAdvice {
    private SecurityManager securityManager = new SecurityManager();
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        UserInfo userInfo = securityManager.getLoggedUser();
        if (userInfo == null) {
            System.out.println("User not set");
            throw new SecurityException("You must be logged before call method " + method.getName());
        } else if ("chris".equals(userInfo.getUserName())) {
            System.out.println("Okay!");
        } else {
            System.out.println("For user " + userInfo.getUserName() + " access denied");
            throw new SecurityException("User " + userInfo.getUserName() + " can not call method " + method.getName());
        }
    }
}
