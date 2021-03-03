package com.quest.Interview.study.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @auther agreeya
 * @Created 2021/3/3 14:29
 */
public class CountDownLatchDemo {

    public static void main(String[] args){
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 上完自习，离开教室");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "\t *********关门走人" );
    }
}
