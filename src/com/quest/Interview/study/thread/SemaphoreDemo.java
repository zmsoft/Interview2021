package com.quest.Interview.study.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @auther agreeya
 * @Created 2021/3/3 14:43
 */
public class SemaphoreDemo {

    public static void main(String[] args){

        Semaphore semaphore = new Semaphore(3); //模拟3个停车位

        for (int i = 1; i <= 6; i++) {  //模拟6部汽车
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"\t 抢到车位");
                    //暂停一会线程
                    try { TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) { e.printStackTrace(); }
                    System.out.println(Thread.currentThread().getName()+"\t 停车3秒后离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
    }
}
