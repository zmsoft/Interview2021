package com.quest.juc;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ticket {

    private int number = 30;
    private Lock lock = new ReentrantLock();

    public  void saleTicket(){

        lock.lock();
        try{
            if(number > 0) {
                System.out.println(Thread.currentThread().getName()+"\t 卖出第："+(number--)+"\t 还剩下： "+number);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
}
/**
 * 题目： 三个售票员       卖出    30张票
 *
 * 多线程编程的企业级套路 + 模板
 *
 * 1. 在高内聚低耦合的前提下， 线程     操作(对外保留的调用方法)     资源类
 *
 */
public class SaleTicket {
    public static void main(String[] args) throws Exception{
//        Thread t1 = new Thread();
//        Thread t2 = new Thread();
//        Thread t3 = new Thread();
//        t1.start();
//        t2.start();
//        t3.start();
        Ticket ticket = new Ticket();

        new Thread(() -> {for (int i = 1; i <= 40; i++) ticket.saleTicket();},"A").start();
        new Thread(() -> {for (int i = 1; i <= 40; i++) ticket.saleTicket();},"B").start();
        new Thread(() -> {for (int i = 1; i <= 40; i++) ticket.saleTicket();},"C").start();


        /*new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 40; i++) {
                    ticket.saleTicket();
                }
            }
        },"A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 40; i++) {
                    ticket.saleTicket();
                }
            }
        },"B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 40; i++) {
                    ticket.saleTicket();
                }
            }
        },"C").start();*/
    }
}
