package com.utopia.java.lang.thread;

import com.utopia.java.lang.common.Student;

/**
 * @author utopia on 2020/4/5
 */
public class SleepAndWait {

    public static void main(String[] args) throws InterruptedException {

        Student student = new Student();

        Thread waitingThread = new Thread(() -> {
                student.waiting();
        });

        Thread sleep = new Thread(() -> {
           student.sleep();
        });

        Thread goToBedThread = new Thread(() -> {
            student.goToBed();
        });

        waitingThread.start();
        sleep.start();
        goToBedThread.start();

        waitingThread.interrupt();
        System.out.println("end");

    }
}
