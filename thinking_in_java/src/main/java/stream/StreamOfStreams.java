package stream;// streams/StreamOfStreams.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.stream.*;

public class StreamOfStreams {

    // TODO: 2021/8/31 flatMap()作用：将产生流的函数应用在每个元素上，然后
    //  将每个流都扁平化为元素，因而最终产生 的仅仅是元素
    public static void main(String[] args) {
        Stream.of(1, 2, 3)
                .map(i -> Stream.of("Gonzo", "Kermit", "Beaker"))
                .map(e -> e.getClass().getName())
                .forEach(System.out::println);
        System.out.println();

        Stream.of(1,2,3)
                .flatMap(integer -> Stream.of("Gonzo", "Kermit", "Beaker"))
                .forEach(System.out::println);
    }
}
/* Output:
java.util.stream.ReferencePipeline$Head
java.util.stream.ReferencePipeline$Head
java.util.stream.ReferencePipeline$Head
*/
