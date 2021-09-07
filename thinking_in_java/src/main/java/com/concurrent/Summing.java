package com.concurrent;// concurrent/Summing.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.stream.*;
import java.util.function.*;

import com.validatingcode.TimerUtil;

public class Summing {

    static void timeTest(String id, long checkValue, LongSupplier operation) {
        System.out.print(id + ": ");
        TimerUtil timer = new TimerUtil();
        long result = operation.getAsLong();
        if (result == checkValue) {
            System.out.println(timer.duration() + "ms");
        } else {
            System.out.format("result: %d%ncheckValue: %d%n",
                    result, checkValue);
        }
    }

    public static final int SZ = 100_000_000;
    // This even works:
    // public static final int SZ = 1_000_000_000;
    public static final long CHECK =
            (long) SZ * ((long) SZ + 1) / 2; // Gauss's formula

    public static void main(String[] args) {
        System.out.println("check" + CHECK);
        // TODO: 2021/9/6 流并行算法：流并行性将输入数据切分成多个部分，因此算法可以应用于那些单独的部分。
        //  数组的分割成本低，分割均匀且对分割的大小有着完美的掌握，
        //  链表的拆分意味着分成第一元素和其余元素，这相对无用
        //  无状态生成器的行为类似于数组，使用range() 是无状态的，
        //  迭代生成器的行为类似于链表，iterate() 是一个迭代器，
        timeTest("Sum Stream", CHECK, () ->
                LongStream.rangeClosed(0, SZ).sum());
        timeTest("Sum Stream Parallel", CHECK, () ->
                LongStream.rangeClosed(0, SZ).parallel().sum());
        // TODO: 2021/9/6 使用iterate() 的速度是最慢的
        timeTest("Sum Iterated", CHECK, () ->
                LongStream.iterate(0, i -> i + 1)
                        .limit(SZ + 1).sum());
        // Slower & runs out of memory above 1_000_000:
        // timeTest("Sum Iterated Parallel", CHECK, () ->
        //   LongStream.iterate(0, i -> i + 1)
        //     .parallel()
        //     .limit(SZ+1).sum());
    }
}
/* Output:
5000000050000000
Sum Stream: 841ms
Sum Stream Parallel: 179ms
Sum Iterated: 4051ms
*/
