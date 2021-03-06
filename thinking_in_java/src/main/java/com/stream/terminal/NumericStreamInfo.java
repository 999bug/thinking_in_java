package com.stream.terminal;// streams/NumericStreamInfo.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

public class NumericStreamInfo {
    // TODO: 2021/9/1 数字流的 max() min() average() summaryStatistics（）
    public static void main(String[] args) {
        System.out.println(RandInts.rands().average().getAsDouble());
        System.out.println(RandInts.rands().max().getAsInt());
        System.out.println(RandInts.rands().min().getAsInt());
        System.out.println(RandInts.rands().sum());
        // TODO: 2021/9/1 summaryStatistics（）生成可能有用的数据
        System.out.println(RandInts.rands().summaryStatistics());
    }
}
/* Output:
507.94
998
8
50794
IntSummaryStatistics{count=100, sum=50794, min=8,
average=507.940000, max=998}
*/
