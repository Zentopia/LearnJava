package com.utopia.java.lang.common;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author utopia on 2020/4/5
 */
public class Student {

    ReentrantLock reentrantLock = new ReentrantLock();

    public synchronized void waiting()  {

        System.out.println("I am waiting");
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("I am finish waiting");
    }

    public synchronized void sleep(){
        System.out.println("I am sleeping");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("I wake up");
        notify();

    }

    public synchronized void goToBed(){
        System.out.println("go to bed");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("I get up");
    }

    public void reentrantLockWait(){

        try {
            reentrantLock.lockInterruptibly();
            System.out.println("I am waiting");
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    public void reentrantLockSleep(){

        try {
            reentrantLock.lock();
            System.out.println("I am sleeping");
            Thread.sleep(5000);
            System.out.println("I am wakeup");
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

}
