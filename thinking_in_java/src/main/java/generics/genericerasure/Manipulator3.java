package generics.genericerasure;// generics/Manipulator3.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import generics.genericerasure.HasF;

class Manipulator3 {
    private HasF obj;

    Manipulator3(HasF x) {
        obj = x;
    }

    public void manipulate() {
        obj.f();
    }
}