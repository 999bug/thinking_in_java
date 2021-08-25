package generics.genericerasure;// generics/Erased.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// {WillNotCompile}

public class Erased<T> {
    private final int SIZE = 100;

    public void f(Object arg) {

        // error: illegal generic type for instanceof
       // if (arg instanceof T) {
      //  }

        // TODO: 2021/8/25  不可以直接 new T 的原因
        // 不可以直接new T，原因：
        // 1、擦除了相关信息
        // 2、编译器无法验证T是否具有默认（午餐）构造函数
       // T var = new T();

        // error: generic array creation
      //  T[] array = new T[SIZE];

        // warning: [unchecked] unchecked cast
        T[] array = (T[]) new Object[SIZE];

    }
}
