package com.quest.Interview.study.javase;

/**
 * @auther zmsoft
 * @Created 2021/3/16 9:47
 */
public class StringPoolDemo {
    public static void main(String[] args){
        String str1 = new StringBuilder("58").append("同城").toString();
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str1);
        System.out.println(str1.intern());
        System.out.println(str1 == str1.intern());

        System.out.println("============================================");
        System.out.println(str2);
        System.out.println(str2.intern());
        System.out.println(str2 == str2.intern());

    }
}
