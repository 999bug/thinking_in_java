package com.fp.functioninterface;// functional/FunctionalAnnotation.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

// TODO: 2021/8/30 @FunctionalInterface 作用：接口中如果有多个抽象方法则会产生编译期错误
@FunctionalInterface
interface Functional {
    String goodbye(String arg);
}

interface FunctionalNoAnn {
    String goodbye(String arg);
}

/*
@FunctionalInterface
interface NotFunctional {
  String goodbye(String arg);
  String hello(String arg);
}
Produces error message:
NotFunctional is not a functional interface
multiple non-overriding abstract methods
found in interface NotFunctional
*/

public class FunctionalAnnotation {

    public String goodbye(String arg) {
        return "Goodbye, " + arg;
    }

    public static void main(String[] args) {

        FunctionalAnnotation fa = new FunctionalAnnotation();
// TODO: 2021/8/30 java 8黑魔法：自动适配函数式接口（适配你的值到目标接口），编译器会在后台把方法引用或lambda表达式包装进实现目标接口的类中
        Functional f = fa::goodbye;
        FunctionalNoAnn fna = fa::goodbye;

        // Functional fac = fa; // Incompatible
        Functional fl = a -> "Goodbye, " + a;
        FunctionalNoAnn fnal = a -> "Goodbye, " + a;
    }
}
