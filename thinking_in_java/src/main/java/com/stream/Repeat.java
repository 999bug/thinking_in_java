package com.stream;// onjava/Repeat.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import static java.util.stream.IntStream.*;

public class Repeat {
    // TODO: 2021/8/31 命令模式 产生循环操作
    public static void repeat(int n, Runnable action) {
        // TODO: 2021/8/31 range(0,n).forEach() 执行n次循环
        range(0, n).forEach(i -> action.run());
    }

    static void hi() {
        System.out.println("Hi!");
    }

    public static void main(String[] args) {
        repeat(3, () -> System.out.println("Looping!"));
        repeat(2, Repeat::hi);

        repeat(2, new Runnable() {
            @Override
            public void run() {
                System.out.println("111");
            }
        });
    }
}
