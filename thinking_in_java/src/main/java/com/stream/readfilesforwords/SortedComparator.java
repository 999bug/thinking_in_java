package com.stream.readfilesforwords;// streams/SortedComparator.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.*;

public class SortedComparator {
    // TODO: 2021/8/31 流元素排序，逆序使用 .sorted(Comparator.reverseOrder())
    public static void main(String[] args) throws Exception {
        FileToWords.stream("src/main/resources/Cheese.dat")
                .skip(10)
                .limit(10)
                // 逆序
                .sorted(Comparator.reverseOrder())
                .map(w -> w + " ")
                .forEach(System.out::print);
    }
}
/* Output:
you what to the that sir leads in district And
*/
