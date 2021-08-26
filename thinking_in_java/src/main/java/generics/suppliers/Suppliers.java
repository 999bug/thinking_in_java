package generics.suppliers;// onjava/Suppliers.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// A utility to use with Suppliers

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

// TODO: 2021/8/26 生成器 Suppliers
public class Suppliers {
    // 创建一个集合并填充它：
    public static <T, C extends Collection<T>> C create(Supplier<C> factory, Supplier<T> gen, int n) {
        return Stream.generate(gen).limit(n).collect(factory, C::add, C::addAll);
    }

    // 填充现有集合：
    public static <T, C extends Collection<T>> C fill(C coll, Supplier<T> gen, int n) {
        Stream.generate(gen).limit(n).forEach(coll::add);
        return coll;
    }

    // 使用未绑定的方法引用来生成更通用的方法：
    public static <H, A> H fill(H holder, BiConsumer<H, A> adder, Supplier<A> gen, int n) {
        Stream.generate(gen).limit(n).forEach(a -> adder.accept(holder, a));
        return holder;
    }
}
