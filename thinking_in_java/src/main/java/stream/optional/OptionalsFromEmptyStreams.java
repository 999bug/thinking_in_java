package stream.optional;// streams/OptionalsFromEmptyStreams.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.*;
import java.util.stream.*;

class OptionalsFromEmptyStreams {

    public static void main(String[] args) {
        // TODO: 2021/8/31 创建空流 Stream.<String>empty()
        // TODO: 2021/8/31 findFirst() 返回一个包含第一个元素的对象，如果流为空则返回Optional.empty
        System.out.println(Stream.<String>empty().findFirst());

        // TODO: 2021/8/31 findAny 返回任意元素的optional 对象，如果流为空则返回Optional.empty
        System.out.println(Stream.<String>empty().findAny());

        // TODO: 2021/8/31 max 返回一个包含最大值或者最小值的 Optional 对象，如果流为空则返回Optional.empty
        System.out.println(Stream.<String>empty().max(String.CASE_INSENSITIVE_ORDER));

        System.out.println(Stream.<String>empty().min(String.CASE_INSENSITIVE_ORDER));

        // TODO: 2021/8/31 reduce 将返回值包装在Optional 中
        System.out.println(Stream.<String>empty().reduce((s1, s2) -> s1 + s2));

        // TODO: 2021/8/31 对于数字流IntStream、LongStream、DoubleStream，average()，会将结果包装在Optional以防止流为空
        System.out.println(IntStream.empty().average());
    }
}
/* Output:
Optional.empty
Optional.empty
Optional.empty
Optional.empty
Optional.empty
OptionalDouble.empty
*/
