package com.concurrent.newconcurent;// concurrent/CollectionIntoStream.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import com.generics.rand.Rand;

import java.util.*;
import java.util.stream.*;

public class CollectionIntoStream {

    // TODO: 2021/9/6 遍历集合 foreach()
    public static void main(String[] args) {
        List<String> strings =
                Stream.generate(new Rand.String(5))
                        .limit(10)
                        .collect(Collectors.toList());
        strings.forEach(System.out::println);

        // Convert to a Stream for many more options:
        String result = strings.stream()
                .map(String::toUpperCase)
                .map(s -> s.substring(2))
                // TODO: 2021/9/6 reduce() s1 是上一次调用的结果 s2 是从流传递过来的值
                .reduce(":", (s1, s2) -> s1 + s2);
        System.out.println(result);
    }
}
/* Output:
btpen
pccux
szgvg
meinn
eeloz
tdvew
cippc
ygpoa
lkljl
bynxt
:PENCUXGVGINNLOZVEWPPCPOALJLNXT
*/
