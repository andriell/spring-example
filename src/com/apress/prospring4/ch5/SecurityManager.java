package com.apress.prospring4.ch5;

/**
 * Created by Андрей on 21.12.2015.
 */
public class SecurityManager {
    private static ThreadLocal<UserInfo> threadLocal = new ThreadLocal<UserInfo>();

    public void login(String userName, String password) {
        threadLocal.set(new UserInfo(userName, password));
    }

    public void logout() {
        threadLocal.set(null);
    }

    public UserInfo getLoggedUser() {
        return threadLocal.get();
    }
}
