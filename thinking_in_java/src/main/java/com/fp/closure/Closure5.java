package com.fp.closure;// functional/Closure5.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// {WillNotCompile}

import java.util.function.IntSupplier;

public class Closure5 {
    IntSupplier makeFun(int x) {
        int i = 0;
        i++;
        x++;
        // TODO: 2021/8/30  lambda 中的变量必须是final的
        // return () -> x + i;
        return () -> 1;
    }
}

// TODO: 2021/8/30 通过在闭包中使用final关键字提前修饰变量，解决了被lambd表达式引用的局部变量必须是final类型的
class Closure6 {
    IntSupplier makeFun(int x) {
        int i = 0;
        i++;
        x++;
        // 下面的2个final 是多余的
        // TODO: 2021/8/30 只要对lambda 中的变量进行重新赋值即可解决问题
        final int iFinal = i;
        final int xFinal = x;
        return () -> xFinal + iFinal;
    }
}


