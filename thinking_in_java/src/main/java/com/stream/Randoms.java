package com.stream;// streams/Randoms.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

// TODO: 2021/8/31 流式编程与普通编程对比
class ImperativeRandoms {
    // TODO: 2021/8/31 外部迭代
    public static void main(String[] args) {
        Random rand = new Random(47);
        SortedSet<Integer> rints = new TreeSet<>();
        while (rints.size() < 7) {
            int r = rand.nextInt(20);
            if (r < 5) {
                continue;
            }
            rints.add(r);
        }
        System.out.println(rints);
    }
}

// TODO: 2021/8/31 使用流的好处：内部迭代产生的代码可读性更强，而且能更简单的的使用多核处理器，
//  通过放弃对迭代的控制，可以把控制权交给并行化机制。
//  流是懒加载的，
public class Randoms {
    // TODO: 2021/8/31 内部迭代
    public static void main(String[] args) {
        // seed（种子）作用，再次运行产生相同的输出
        new Random(47)
                .ints(5, 20)
                .distinct()
                .limit(7)
                .sorted()
                .forEach(System.out::println);


    }
}
/* Output:
6
10
13
16
17
18
19
*/
