package com.utopia.java.lang.thread.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author utopia on 2020/5/10
 */
public class LearnCountDownLatch {

    public static int m = 0;
    public static CountDownLatch latch = new CountDownLatch(100);
    public ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[100];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    m++;
                    latch.countDown();
                }
            });
        }

        for (int i = 0; i < 100; i++){
            threads[i].start();
        }

        latch.wait();
    }
}
