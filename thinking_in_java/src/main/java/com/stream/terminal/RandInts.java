package com.stream.terminal;// streams/RandInts.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.*;
import java.util.stream.*;

public class RandInts {

    // TODO: 2021/8/31 toArray() 将流转换成适当类型的数组
    private static int[] rints = new Random(47)
            .ints(0, 1000)
            .limit(100)
            .toArray();

    /**
     * 将 100 个数值范围在 0 到 1000 之间的随机数流转换成为数组并将其存储在
     * rints 中。这样一来，每次调用 rands() 的时候可以重复获取相同的整数流。
     */
    public static IntStream rands() {
        return Arrays.stream(rints);
    }
}
