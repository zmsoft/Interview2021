package com.quest.Interview.study.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @auther agreeya
 * @Created 2021/3/3 17:05
 */
public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());
        FutureTask<Integer> futureTask2 = new FutureTask<>(new MyThread());

        new Thread(futureTask, "AA").start();
        new Thread(futureTask2, "BB").start();

        while (!futureTask.isDone()){

        }
        System.out.println(""+futureTask.get());
    }
}

class MyThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("**********come in Callable");
        return 1024;
    }
}
