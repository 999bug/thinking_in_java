package com.fp.currying;// functional/CurryingAndPartials.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.function.*;

// TODO: 2021/8/30 柯里化 将一个多参数的函数，转换为一系列单参数函数
public class CurryingAndPartials {
    // Uncurried:
    static String uncurried(String a, String b) {
        return a + b;
    }

    public static void main(String[] args) {
        // TODO: 2021/8/30 第二个参数是另一个函数
        // TODO: 2021/8/30 柯里化的目的是能够通过提供一个参数来创建一个新函数，所以现在有了一个“带参函数”和剩下的自由函数。实际上，从一个双参函数开始，最后得到一个单参数函数
        // Curried function:
        Function<String, Function<String, String>> sum = a -> b -> a + b;  // [1]

        System.out.println(uncurried("Hi ", "Ho"));

        Function<String, String> hi = sum.apply("Hi ");        // [2]
        System.out.println(hi.apply("Ho"));

        // Partial application:
        Function<String, String> sumHi = sum.apply("Hup ");

        System.out.println(sumHi.apply("Ho"));
        System.out.println(sumHi.apply("Hey"));
    }
}
/* Output:
Hi Ho
Hi Ho
Hup Ho
Hup Hey
*/
