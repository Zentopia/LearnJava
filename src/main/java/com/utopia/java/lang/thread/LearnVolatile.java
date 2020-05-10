package com.utopia.java.lang.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author utopia on 2020/5/10
 */
public class LearnVolatile {

    public static AtomicInteger m =new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[100];

        for(int i = 0; i < threads.length; i++){
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 100; j ++) {
                    m.incrementAndGet();
                }
            });
        }

        for (Thread t : threads) {
            t.start();
        }

//        for (Thread t : threads) {
//            t.join();
//        }

        System.out.println(m);
    }
}
