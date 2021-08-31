package stream;// streams/StreamOf.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.*;
import java.util.stream.*;

public class StreamOf {
    // TODO: 2021/8/31 创建流、遍历流
    public static void main(String[] args) {
        // createStream1();
        collectionToStream();
    }

    private static void collectionToStream() {
        List<Bubble> bubbles = Arrays.asList(
                new Bubble(1), new Bubble(2), new Bubble(3));
        // 所有集合都有的stream（），map()获取流中所有的元素，并进行深克隆
        System.out.println(
                // TODO: 2021/8/31 stream()
                bubbles.stream()
                        // 将一个对象流转换成为包含整形数字的IntStream
                        .mapToInt(b -> b.i)
                        .sum());

        Set<String> w = new HashSet<>(Arrays.asList(
                "It's a wonderful day for pie!".split(" ")));
        w.stream()
                .map(x -> x + ",")
                .forEach(System.out::print);
        System.out.println();

        Map<String, Double> m = new HashMap<>();
        m.put("pi", 3.14159);
        m.put("e", 2.718);
        m.put("phi", 1.618);
        // 首先调用 entrySet()产生一个对象流，通过 map()获取所有的对象
        m.entrySet().stream()
                .map(e -> e.getKey() + ": " + e.getValue())
                .forEach(System.out::println);
    }

    private static void createStream1() {
        // TODO: 2021/8/31 Stream.of()
        Stream.of(
                new Bubble(1), new Bubble(2), new Bubble(3))
                .forEach(System.out::println);

        Stream.of("It's ", "a ", "wonderful ",
                "day ", "for ", "pie!")
                .forEach(System.out::print);

        System.out.println();

        Stream.of(3.14159, 2.718, 1.618)
                .forEach(System.out::println);
    }


}
/* Output:
Bubble(1)
Bubble(2)
Bubble(3)
It's a wonderful day for pie!
3.14159
2.718
1.618
*/
