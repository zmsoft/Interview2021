package com.quest.juc;

interface Foo{

    public void sayHello();
}

/***
 * 2. Lambda Express
 *   2.1  口诀：
 *          拷贝小括号，写死右箭头，落地大括号
 */
public class LambdaExpressDemo {
    public static void main(String[] args){

        /*Foo foo = new Foo(){

            @Override
            public void sayHello() {
                System.out.println("************hello java0222");
            }
        };
        foo.sayHello();*/

        Foo foo = () -> {System.out.println("************hello java0222 lambda Express");};
        foo.sayHello();
    }
}
