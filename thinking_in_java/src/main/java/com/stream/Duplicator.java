package com.stream;// streams/Duplicator.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.stream.*;

public class Duplicator {

    public static void main(String[] args) {
        // TODO: 2021/8/31 generate()创建相同的流
        Stream.generate(() -> "duplicate")
                .limit(3)
                .forEach(System.out::println);

        Stream.generate(Bubble::bubbler)
                .limit(5)
                .forEach(System.out::println);
    }
}
/* Output:
duplicate
duplicate
duplicate
*/
