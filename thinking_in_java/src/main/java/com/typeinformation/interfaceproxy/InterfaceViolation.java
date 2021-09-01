package com.typeinformation.interfaceproxy;// reflection/InterfaceViolation.java

// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Sneaking around an interface
interface A {
    void f();
}

class B implements A {
    @Override
    public void f() {
    }

    public void g() {
    }
}

public class InterfaceViolation {
    public static void main(String[] args) {
        A a = new B();
        a.f();
        // a.g(); // Compile error
        System.out.println(a.getClass().getName());
        // TODO: 2021/8/30 子类要使用自身方法要转型为本类，才可以使用自身方法
        if (a instanceof B) {
            B b = (B) a;
            b.g();
        }
    }
}
/* Output:
B
*/
