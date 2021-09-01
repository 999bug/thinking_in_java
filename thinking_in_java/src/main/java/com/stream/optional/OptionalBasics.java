package com.stream.optional;// streams/OptionalBasics.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.*;
import java.util.stream.*;

class OptionalBasics {

    // TODO: 2021/8/31 Optional 基本用法
    static void test(Optional<String> optString) {
        if (optString.isPresent()) {
            System.out.println(optString.get());
        } else {
            System.out.println("Nothing inside!");
        }
    }

    public static void main(String[] args) {
        test(Optional.of("Epithets"));
        test(Stream.<String>empty().findFirst());
    }
}
/* Output:
Epithets
Nothing inside!
*/
