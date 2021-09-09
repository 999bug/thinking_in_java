package com.stream;// streams/Bubble.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

public class Bubble {
    public final int i;

    public Bubble(int n) {
        i = n;
    }

    @Override
    public String toString() {
        return "Bubble(" + i + ")" + count;
    }

    private static int count = 0;

    public static Bubble bubbler() {
        return new Bubble(count++);
    }
}