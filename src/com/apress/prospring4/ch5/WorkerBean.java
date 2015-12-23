package com.apress.prospring4.ch5;

/**
 * Created by Андрей on 23.12.2015.
 */
public class WorkerBean {
    public void doSomeWork(int noOfTimes) {
        for (int x = 0; x < noOfTimes; x++) {
            work();
        }
    }

    private void work() {
        System.out.print("");
    }
}
