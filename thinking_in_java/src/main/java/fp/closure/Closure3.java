package fp.closure;// functional/Closure3.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// {WillNotCompile}

import java.util.function.IntSupplier;

// TODO: 2021/8/30 如果局部变量的初始值永远不会改变，那么它实际上就是 final 的。
class Closure2 {
    // TODO: 2021/8/30  x等同 final 效果
    IntSupplier makeFun(int x) {
        int i = 0;
        return () -> x + i;
    }
}

class Closure3 {
    IntSupplier makeFun(int x) {
        int i = 0;
        // TODO: 2021/8/30 被 Lambda 表达式引用的局部变量必须是 final 或者是等同 final 效果的
        //return () -> x++ + i++; error
        return () -> x;
    }
}

class Closure4 {
    IntSupplier makeFun(final int x) {
        final int i = 0;
        return () -> x + i;
    }
}
