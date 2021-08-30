package fp.closure;// functional/Closure8.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

class Closure7 {
    IntSupplier makeFun(int x) {
        Integer i = 0;
        i = i + 1;
        //return () -> x + i; error！！变量 i 的值发生了变化
        return () -> x;
    }
}

public class Closure8 {

    // 每次调用makeFun()时都会重新创建一个新集合，而非是共享的，
    // 每个闭包都有自己独立的集合，他们之间互不干扰
    Supplier<List<Integer>> makeFun() {
        final List<Integer> ai = new ArrayList<>();
        ai.add(1);
        return () -> ai;
    }

    public static void main(String[] args) {
        Closure8 c7 = new Closure8();
        List<Integer> l1 = c7.makeFun().get(), l2 = c7.makeFun().get();
        System.out.println(l1);
        System.out.println(l2);
        l1.add(42);
        l2.add(96);
        System.out.println(l1);
        System.out.println(l2);
    }
}

/* Output:
[1]
[1]
[1, 42]
[1, 96]
*/
class Closure9 {
    Supplier<List<Integer>> makeFun() {
        List<Integer> ai = new ArrayList<>();
        // TODO: 2021/8/30 lambda 表达式中不可以重新赋值
        ai = new ArrayList<>(); // Reassignment
        return Collections::emptyList;
    }
}