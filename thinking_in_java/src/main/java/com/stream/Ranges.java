package com.stream;// streams/Ranges.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.Arrays;

import static java.util.stream.IntStream.*;

public class Ranges {
    // TODO: 2021/8/31 range()流操作大用处，转换成数组，计算区间总和
    public static void main(String[] args) {

        // The traditional way:
        int result = 0;
        for (int i = 10; i < 20; i++) {
            result += i;
        }
        System.out.println(result);
        // range(a,b) 左闭右开区间[a,b)
        int[] ints = range(10, 20).toArray();
        System.out.println(Arrays.toString(ints));
        // for-in with a range:
        result = 0;
        for (int i : range(10, 20).toArray()) {
            result += i;
        }
        System.out.println(result);

        // Use streams:
        System.out.println(range(10, 20).sum());
    }
}
/* Output:
145
145
145
*/
