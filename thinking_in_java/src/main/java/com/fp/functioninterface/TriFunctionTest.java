package com.fp.functioninterface;// functional/TriFunctionTest.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

public class TriFunctionTest {
    static String f(int i, long l, double d) {
        return String.valueOf((double) i + (double) l + d);
    }

    public static void main(String[] args) {
        TriFunction<Integer, Long, Double, String> tf = TriFunctionTest::f;
        tf = (i, l, d) -> String.valueOf(Double.valueOf(i) + Double.valueOf(l) + d);
        System.out.println("tf.apply(1,2L,2.0) = " + tf.apply(1, 2L, 2.0));
    }
}
