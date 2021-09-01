package com.stream.readfilesforwords;// streams/FileToWordsRegexp.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.nio.file.*;
import java.util.stream.*;
import java.util.regex.Pattern;

// TODO: 2021/8/31 使用流将文件转换为一个字符串，接着使用正则表达式将字符串转化为单词流
public class FileToWordsRegexp {
    private String all;

    public FileToWordsRegexp(String filePath) throws Exception {
        all = Files.lines(Paths.get(filePath))
                .skip(1) // First (comment) line
                .collect(Collectors.joining(" "));
    }

    public Stream<String> stream() {
        return Pattern
                .compile("[ .,?]+").splitAsStream(all);
    }

    public static void main(String[] args) throws Exception {

        FileToWordsRegexp fw = new FileToWordsRegexp("src/main/resources/Cheese.dat");
        fw.stream()
                .limit(7)
                .map(w -> w + " ")
                .forEach(System.out::print);
      System.out.println();
        // output Not much of a cheese shop really
        fw.stream()
                .skip(7)
                .limit(2)
                .map(w -> w + " ")
                .forEach(System.out::print);
        // output Not much of a cheese shop really is it
    }
}
/* Output:
Not much of a cheese shop really is it
*/
