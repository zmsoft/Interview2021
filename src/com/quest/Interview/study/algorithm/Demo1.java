package com.quest.Interview.study.algorithm;

import static com.sun.xml.internal.fastinfoset.util.ValueArray.MAXIMUM_CAPACITY;

/**
 * @auther zmsoft
 * @Created 2021/3/16 10:23
 *   给定一个数m，求大于该数的最小2的n次幂，返回n
 */
public class Demo1 {
    public static void main(String[] args){
        System.out.println("输入整数的最小2的n次幂，返回n为："+tableSizeFor(228));
        System.out.println("输入整数的最小2的n次幂，返回n为："+rebuildNum(228));
    }

    /**
     * Returns a power of two size for the given target capacity.
     */
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }


    public static int rebuildNum(int num){
        int max = 1 << 30;
        int n = num - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n < 0 ? 1 : (n >= max ? max : n + 1);
    }
}
