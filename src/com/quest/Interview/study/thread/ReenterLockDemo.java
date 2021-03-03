package com.quest.Interview.study.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther agreeya
 * @Created 2021/3/3 14:03
 *
 *  可重入锁（也叫递归锁）
 *
 *  指的是同一个线程外层函数获得锁之后，内层递归函数仍然能获取该锁的代码，
 *  在同一个线程在外层方法获取锁的时候，在进入内层方法会自动获取锁
 *
 *  也就是说，线程可以进入任何一个它已经拥有的锁所同步着的代码块。
 *
 *      case one Syncchronized就是一个典型的可重入锁
 *
 *      case two ReentrantLock就是一个典型的可重入锁
 */
public class ReenterLockDemo {

    public static void main(String[] args){
        Phone phone = new Phone();

        new Thread(() -> {
            try{
                phone.sendSMS();
            }catch (Exception e){
                e.printStackTrace();
            }finally {

            }
        },"t1").start();

        new Thread(() -> {
            try{
                phone.sendSMS();
            }catch (Exception e){
                e.printStackTrace();
            }finally {

            }
        },"t2").start();

        //暂停一会线程
        try { TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        Thread t3 = new Thread(phone);
        Thread t4 = new Thread(phone);
        t3.start();
        t4.start();

    }
}

class Phone implements Runnable{
    public synchronized void sendSMS() throws Exception{
        System.out.println(Thread.currentThread().getName() + "\t invoked sendSMS()");
        sendEmail();
    }
    public synchronized void sendEmail() throws Exception{
        System.out.println(Thread.currentThread().getName() + "\t ############invoked sendEmail()");
    }

    // =================================================
    Lock lock = new ReentrantLock();
    @Override
    public void run() {
        try {
            get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void get() throws Exception{
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName() + "\t invoked get()");
            set();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void set() throws Exception{
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName() + "\t invoked set()");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
