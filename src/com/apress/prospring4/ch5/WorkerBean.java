package com.apress.prospring4.ch5;

/**
 * Created by ������ on 23.12.2015.
 */
public class WorkerBean {
    public void doSomeWork(int noOfTimes) {
        for (int � = 0; � < noOfTimes; �++) {
            work();
        }
    }

    private void work() {
        System.out.print("");
    }
}
