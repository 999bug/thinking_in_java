package com.stream.optional;// streams/CreatingOptionals.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.*;
import java.util.stream.*;
import java.util.function.*;

class CreatingOptionals {

    static void test(String testName, Optional<String> opt) {
        System.out.println(" === " + testName + " === ");
        System.out.println(opt.orElse("Null"));
    }

    public static void main(String[] args) {
        // TODO: 2021/8/31 empty() 生成一个空 Optional 
        test("empty", Optional.empty());

        // TODO: 2021/8/31 Optional.of 将一个非空值包装到 Optional里
        test("of", Optional.of("Howdy"));
        System.out.println();
        try {
            test("of", Optional.of(null));
        } catch (Exception e) {
            System.out.println(e);
        }

        // TODO: 2021/8/31 对于一个可能为空的值，为空时自动生成Optional.empty()，否则将值包装在Optional中
        test("ofNullable", Optional.ofNullable("Hi"));
        test("ofNullable", Optional.ofNullable(null));
    }
}
/* Output:
 === empty ===
Null
 === of ===
Howdy
java.lang.NullPointerException
 === ofNullable ===
Hi
 === ofNullable ===
Null
*/
