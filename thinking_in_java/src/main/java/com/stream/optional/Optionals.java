package com.stream.optional;// streams/Optionals.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class Optionals {

    static void basics(Optional<String> optString) {
        if (optString.isPresent()) {
            System.out.println(optString.get());
        } else {
            System.out.println("Nothing inside!");
        }
    }

    // TODO: 2021/8/31 ifPresent 当值存在时调用 consumer，否则什么也不做
    static void ifPresent(Optional<String> optString) {
        optString.ifPresent(System.out::println);
    }

    // TODO: 2021/8/31 orElse 如果值存在直接返回，否则生成otherObject
    static void orElse(Optional<String> optString) {
        System.out.println(optString.orElse("Nada"));
    }

    // TODO: 2021/8/31  orElseGet 如果值存在直接返回，否则使用 Supplier生成一个可替代对象
    static void orElseGet(Optional<String> optString) {
        System.out.println(
                optString.orElseGet(() -> "Generated"));
    }

    // TODO: 2021/8/31  orElseThrow 如果值存在直接返回，否则使用 Supplier生成一个异常
    static void orElseThrow(Optional<String> optString) {
        try {
            System.out.println(optString.orElseThrow(
                    () -> new Exception("Supplied")));
        } catch (Exception e) {
            System.out.println("Caught " + e);
        }
    }

    static void test(String testName, Consumer<Optional<String>> cos) {
        System.out.println(" === " + testName + " === ");
        cos.accept(Stream.of("Epithets").findFirst());
        cos.accept(Stream.<String>empty().findFirst());
    }

    public static void main(String[] args) {
        test("basics", Optionals::basics);
        test("ifPresent", Optionals::ifPresent);
        test("orElse", Optionals::orElse);
        test("orElseGet", Optionals::orElseGet);
        test("orElseThrow", Optionals::orElseThrow);
    }
}
/* Output:
 === basics ===
Epithets
Nothing inside!
 === ifPresent ===
Epithets
 === orElse ===
Epithets
Nada
 === orElseGet ===
Epithets
Generated
 === orElseThrow ===
Epithets
Caught java.lang.Exception: Supplied
*/
