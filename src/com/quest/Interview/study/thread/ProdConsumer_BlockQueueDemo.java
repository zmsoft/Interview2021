package com.quest.Interview.study.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @auther agreeya
 * @Created 2021/3/3 16:44
 *
 *  volatile/CAS/AtomicInteger/BlockQueue/线程交互/原子引用
 */
public class ProdConsumer_BlockQueueDemo {

    public static void main(String[] args){
        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(10));

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"\t 生产线程启动");
            try{
                myResource.myProd();
            }catch (Exception e){
                e.printStackTrace();
            }finally {

            }
        },"Prod").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"\t 消费线程启动");
            try{
                myResource.myConsumer();
                System.out.println();
                System.out.println();

            }catch (Exception e){
                e.printStackTrace();
            }finally {

            }
        },"Consumer").start();

        //暂停一会线程
        try { TimeUnit.SECONDS.sleep(5);} catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println();
        System.out.println();
        System.out.println();
        myResource.stop();
    }
}

class MyResource{
    private volatile boolean FLAG = true;//默认开启，进行生产+消费
    private AtomicInteger atomicInteger = new AtomicInteger();

    BlockingQueue<String> blockingQueue = null;
    public MyResource(BlockingQueue<String> blockingQueue){
        this.blockingQueue = blockingQueue;
        System.out.println(Thread.currentThread().getName());
    }

    public void myProd() throws Exception{
        String data = null;
        boolean retValue;
        while (FLAG){
            data = atomicInteger.incrementAndGet()+"";
            retValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (retValue) {
                System.out.println(Thread.currentThread().getName()+"\t 插入队列"+data+"成功");
            } else {
                System.out.println(Thread.currentThread().getName()+"\t 插入队列"+data+"失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName()+"\t FLAG=false, 停止" );
    }

    public void myConsumer() throws Exception{
        String result = null;
        while (FLAG) {
            result = blockingQueue.poll(2L,TimeUnit.SECONDS);
            if (null == result || result.equalsIgnoreCase("")){
                FLAG = false;
                System.out.println(Thread.currentThread().getName()+"\t 超过2秒钟没有取到蛋糕，消费退出");
            }
            System.out.println(Thread.currentThread().getName()+"\t 消费队列" +result+"成功");
        }
    }

    public void stop(){
        FLAG = false;
    }
}
