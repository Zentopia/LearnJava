package com.utopia.java.lang.thread.lock;

import com.utopia.java.lang.common.Student;

/**
 * @author utopia on 2020/4/6
 */
public class LearnReetrantLock {

    public static void main(String[] args) {

        Student student = new Student();

        Thread waitingThread = new Thread(() -> {
            student.reentrantLockWait();
        });

        Thread sleep = new Thread(() -> {
            student.reentrantLockSleep();
        });

        sleep.start();
        waitingThread.start();
        waitingThread.interrupt();
    }
}
