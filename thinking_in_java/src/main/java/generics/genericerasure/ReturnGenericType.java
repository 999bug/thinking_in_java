package generics.genericerasure;// generics/ReturnGenericType.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

/**
 * 当有一个返回值 T 的方法，泛型就有了用武之地
 * @param <T>
 */
class ReturnGenericType<T extends HasF> {
    private T obj;

    ReturnGenericType(T x) {
        obj = x;
    }

    public T get() {
        return obj;
    }
}
