package com.quest.Interview.study.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @auther agreeya
 * @Created 2021/3/3 14:39
 */
public class CyclicBarrierDemo {

    public static void main(String[] args){

        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,() -> {
            System.out.println("***********当当当当");
        });

        for (int i = 1; i <= 7; i++) {
            final int tempInt = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 收集到第："+tempInt+"当");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
