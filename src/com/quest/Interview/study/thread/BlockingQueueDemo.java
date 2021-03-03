package com.quest.Interview.study.thread;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @auther agreeya
 * @Created 2021/3/3 14:54
 *
 *  ArrayBlockingQueue: 是一个基于数组结构的有界阻塞队列，此队列按FIFO(先进先出)原则对元素进行排序。
 *  LinkedBlockingQueue: 一个基于链表结构的阻塞队列，此队列按FIFO(先进先出)排序元素，吞吐量通常要高于ArrayBlockingQueue.
 *  SynchronousQueue: 一个不存储元素的阻塞队列。每个插入操作必须等到另一个线程调用移除操作，否则插入操作一直处于阻塞状态，吞吐量通常要高。
 *
 *   1. 队列
 *
 *   2. 阻塞队列
 *      2.1 阻塞队列有没有好的一面
 *      2.2 不得不阻塞，你如何管理
 *
 *
 */
public class BlockingQueueDemo {

    public static void main(String[] args){
//        List list = null;
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
       /* System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));

        System.out.println(blockingQueue.element());  // a 队首元素

//        System.out.println(blockingQueue.add("x"));  //Queue full
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());  //NoSuchElementException*/
        /*System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("x"));   // false 不抛异常

        System.out.println(blockingQueue.peek());   //a 队首元素

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());  //取不到值，返回null*/

        try {
           /* blockingQueue.put("a");
            blockingQueue.put("a");
            blockingQueue.put("a");
//            blockingQueue.put("a");    //满了，一直阻塞

            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
//            System.out.println(blockingQueue.take());   //取不到，一直等待*/

            System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));
            System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));
            System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));
            System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));  //false  阻塞2秒钟
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
