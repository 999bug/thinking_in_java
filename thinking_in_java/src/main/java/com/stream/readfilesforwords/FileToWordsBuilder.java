package com.stream.readfilesforwords;// streams/FileToWordsBuilder.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.nio.file.*;
import java.util.stream.*;

// TODO: 2021/8/31 流的建造者模式 之读取文件
public class FileToWordsBuilder {
    Stream.Builder<String> builder = Stream.builder();

    public FileToWordsBuilder(String filePath) throws Exception {

        Files.lines(Paths.get(filePath))
                .skip(1) // Skip the comment line at the beginning
                .forEach(line -> {
                    for (String w : line.split("[ .?,]+")) {
                        builder.add(w);
                    }
                });
    }

    Stream<String> stream() {
        return builder.build();
    }

    public static void main(String[] args) throws Exception {

        new FileToWordsBuilder("src/main/resources/Cheese.dat").stream()
                .limit(7)
                .map(w -> w + " ")
                .forEach(System.out::print);
    }
}
/* Output:
Not much of a cheese shop really
*/
