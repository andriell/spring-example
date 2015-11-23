package com.apress.prospring4.ch2;

/**
 * Created by Андрей on 23.11.2015.
 */
public class HelloWorldMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello world";
    }
}
