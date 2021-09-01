package com.generics.wildcard;// generics/CompilerIntelligence.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.*;

public class CompilerIntelligence {
    public static void main(String[] args) {

        List<? extends Fruit> flist = Arrays.asList(new Apple(), new Orange());

        Apple a = (Apple) flist.get(0); // No warning

        System.out.println(flist.contains(new Apple()));
        System.out.println(flist.contains(new Fruit()));
        System.out.println(flist.contains(new Orange()));

        flist.indexOf(new Apple()); // Argument is 'Object'

    }
}
