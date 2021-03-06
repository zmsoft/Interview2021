package com.quest.Interview.study.thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * @auther agreeya
 * @Created 2021/3/3 17:34
 *
 *  第4种获取使用java多线程的方式，线程池
 */
public class MyThreadPoolDemo {

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());

        // Array Arrays
        // Collection Collections
        // Executor, Executors

//        List<String> list = Arrays.asList("a","b","c");

//        ExecutorService threadPool = Executors.newFixedThreadPool(5);//一池5个处理线程。
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();//一池1个处理线程。
//        ExecutorService threadPool = Executors.newCachedThreadPool();//一池N个处理线程。

        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
//                new ThreadPoolExecutor.CallerRunsPolicy());
//                new ThreadPoolExecutor.DiscardOldestPolicy());
//                new ThreadPoolExecutor.DiscardPolicy());





        try{
            //模拟10个用户来办理业务，每个用户就是一个来自外部的请求线程
            for (int i = 1; i <= 10; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });
                //暂停一会线程
                try { TimeUnit.MILLISECONDS.sleep(200);} catch (InterruptedException e) { e.printStackTrace(); }
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }

    }
}
