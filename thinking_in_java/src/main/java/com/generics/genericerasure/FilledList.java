package com.generics.genericerasure;// generics/FilledList.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.


import com.generics.suppliers.Suppliers;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class FilledList<T> extends ArrayList<T> {

    FilledList(Supplier<T> gen, int size) {
        Suppliers.fill(this, gen, size);
    }

    public FilledList(T t, int size) {
        for (int i = 0; i < size; i++) {
            this.add(t);
        }
    }

    public static void main(String[] args) {
        List<String> list = new FilledList<>("Hello", 4);
        System.out.println(list);

        // Supplier version:
        List<String> ilist = new FilledList<>(() -> "dsf ddfs  sds", 4);
        System.out.println(ilist);


    }
}
/* Output:
[Hello, Hello, Hello, Hello]
[47, 47, 47, 47]
*/
