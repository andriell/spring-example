package com.apress.prospring4.ch5;

import org.springframework.aop.framework.ProxyFactory;

/**
 * Created by Андрей on 21.12.2015.
 */
public class SecurityExample {
    public static void main(String[] args) {
        SecurityManager securityManager = new SecurityManager();
        SecureBean secureBean = getSecureBean();
        securityManager.login("chris", "password");
        secureBean.writeSecureMessage();
        securityManager.logout();

        try {
            securityManager.login("user1", "password");
            secureBean.writeSecureMessage();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            securityManager.logout();
        }

        try {
            secureBean.writeSecureMessage();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    private static SecureBean getSecureBean() {
        SecureBean secureBean = new SecureBean();
        SecurityAdvice securityAdvice = new SecurityAdvice();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(secureBean);
        proxyFactory.addAdvice(securityAdvice);
        SecureBean secureBeanProxy = (SecureBean) proxyFactory.getProxy();
        return secureBeanProxy;
    }
}
