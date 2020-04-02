package com.utopia.java.lang.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author utopia on 2020/3/31
 */
public class Thead {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

    }

    public static void threadShare(){
        String value = "Hello world";
        Thread thread = new Thread(() -> System.out.println(value));
        thread.start();
    }

    public static void threadWait() throws InterruptedException {

        Object waitObject = new Object();

        synchronized (waitObject){
            waitObject.wait();
            System.out.println("wait");
        }
    }


    public static void join() throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.start();
        thread.join();

        System.out.println("finish");
    }

    public static void callable() throws ExecutionException, InterruptedException {
        MyCallable callable = new MyCallable();

        FutureTask<String> result = new FutureTask<>(callable);
        Thread thread = new Thread(result);
        thread.start();
//        thread.interrupt();

        String res = result.get();

        System.out.println(res);
    }

    public static class MyRunnable implements Runnable {
        @Override
        public void run() {

        }
    }

    static class MyCallable implements Callable {
        @Override
        public Object call() throws Exception {
//            Thread.sleep(10000);

            System.out.println("Hello");

            return "success";
        }
    }
}
