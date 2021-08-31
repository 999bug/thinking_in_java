package stream.readfilesforwords;// streams/FileToWords.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.nio.file.*;
import java.util.Arrays;
import java.util.stream.*;
import java.util.regex.Pattern;

public class FileToWords {

    // TODO: 2021/8/31 flatMAp()：将元素流的流 扁平化为一个简单的元素流
    public static Stream<String> stream(String filePath) throws Exception {
        return Files.lines(Paths.get(filePath))
                .skip(1) // First (comment) line
                // \\W+ 表示非单词字符 \\w ：表示单词字符
                .flatMap(line -> Arrays.stream(line.split("\\W+")));
               // .flatMap(line -> Pattern.compile("\\W+").splitAsStream(line));

        // TODO: 2021/8/31  Pattern.compile().splitAsStream()产生的结果为流，
        //  这意味着当我们只是想要一个简单的单词流时，在传入的行流上调用map()会产生一个单词流的流
    }
}
