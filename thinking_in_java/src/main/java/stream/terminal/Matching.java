package stream.terminal;// streams/Matching.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Demonstrates short-circuiting of *Match() operations

import java.util.stream.*;
import java.util.function.*;

// TODO: 2021/9/1 BiPredicate 是一个二元谓词，
//  第一个参数是我们要测试的流，第二个参数是谓词Predicate
//  简单的说第一个参数是模式匹配，第二个参数是模式匹配的值
interface Matcher extends BiPredicate<Stream<Integer>, Predicate<Integer>> {
}

// TODO: 2021/9/1 匹配
public class Matching {

    static void show(Matcher match, int val) {
        System.out.println(match.test(
                IntStream.rangeClosed(1, 9)
                        .boxed()
                        .peek(n -> System.out.format("%d ", n)),
                n -> n < val));
    }

    public static void main(String[] args) {
        // TODO: 2021/9/1 allMatch 如果流的每个元素提供给Predicate 都返回true，结果返回为true，在第一个false时，则停止执行计算
        show(Stream::allMatch, 10);

        // TODO: 2021/9/1 anyMatch 如果流的任意一个元素提供给 Predicate 返回true，结果返回为true，在第一个false时，则停止执行计算
        show(Stream::allMatch, 4);
        show(Stream::anyMatch, 2);
        show(Stream::anyMatch, 0);

        // TODO: 2021/9/1 noneMatch 如果流的任意一个元素提供给 Predicate 返回false，结果返回为true，在第一个true时，则停止执行计算
        show(Stream::noneMatch, 5);
        show(Stream::noneMatch, 0);
    }
}
/* Output:
1 2 3 4 5 6 7 8 9 true
1 2 3 4 false
1 true
1 2 3 4 5 6 7 8 9 false
1 false
1 2 3 4 5 6 7 8 9 true
*/
