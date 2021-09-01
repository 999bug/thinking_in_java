package com.fp.closure;// functional/AnonymousClosure.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.function.*;

public class AnonymousClosure {

    IntSupplier makeFun(int x) {
        int i = 0;
        // Same rules apply:
        // i++; // Not "effectively final"
        // x++; // Ditto
        return () -> x + i;
    }

    /*IntSupplier makeFun(int x) {
        int i = 0;
        // Same rules apply:
        // i++; // Not "effectively final"
        // x++; // Ditto
        return new IntSupplier() {
            @Override
            public int getAsInt() {
                return x + i;
            }
        };
    }*/
}
