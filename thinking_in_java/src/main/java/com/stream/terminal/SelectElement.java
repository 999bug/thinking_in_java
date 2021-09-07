package com.stream.terminal;// streams/SelectElement.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

public class SelectElement {

    public static void main(String[] args) {

        System.out.println(RandInts.rands().findFirst().getAsInt());

        System.out.println(RandInts.rands().parallel().findFirst().getAsInt());

        // TODO: 2021/9/1 对于非并行流，findAny()会选择流中的第一个元素
        System.out.println(RandInts.rands().findAny().getAsInt());

        // TODO: 2021/9/1 对于并行流，findAny()不会选择第一个元素
        System.out.println(RandInts.rands().parallel().findAny().getAsInt());
        System.out.println("=====");
        RandInts.rands().limit(4).forEach(System.out::println);
        System.out.println("=====");

    }
}
/* Output:
258
258
258
242
*/
