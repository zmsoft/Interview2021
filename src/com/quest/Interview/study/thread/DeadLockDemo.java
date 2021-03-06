package com.quest.Interview.study.thread;

import java.util.concurrent.TimeUnit;

/**
 * @auther zmsoft
 * @Created 2021/3/6 10:21
 * 死锁是指两个或两个以上的进程在执行过程中，
 * 因争夺资源而造成的一种互相等待的现象，
 * 若无外力干涉那它们都将无法推进下去
 */
public class DeadLockDemo {

    public static void main(String[] args){
        String lockA = "lockA";
        String lockB = "lockB";

        new Thread(new HoldLockThread(lockA,lockB),"ThreadAAA").start();
        new Thread(new HoldLockThread(lockB,lockA),"ThreadBBB").start();


        /**
         * linux       ps -ef|grep  xxxx    ls -l
         * window下的java运行程序 也有类似ps的查看进程的命令，
         * 但是目前我们需要查看的只是
         *      jps = java ps           jps -l
         *
         *
         */

    }
}

class HoldLockThread implements Runnable{

    private String lockA;

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    private String lockB;



    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+"\t 自己持有："+lockA+"\t 尝试获得："+lockB);
            //暂停一会线程
            try { TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) { e.printStackTrace(); }

            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName()+"\t 自己持有："+lockB+"\t 尝试获得："+lockA);
            }
        }
    }
}