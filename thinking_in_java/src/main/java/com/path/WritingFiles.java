package com.path;

import com.generics.rand.Rand;
import com.google.common.base.Utf8;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author Lishiyan
 * @date 2021/9/910:28
 */
public class WritingFiles {

    static Random random = new Random(47);
    static final int SIZE = 1000;

    public static void main(String[] args) throws IOException {
        byte[] bytes = new byte[SIZE];
        random.nextBytes(bytes);
        Files.write(Paths.get("bytes.txt"),bytes);
        System.out.println("bytes.txt: " + Files.size(Paths.get("bytes.txt")));

        List<String> list = Files.readAllLines(Paths.get("src/main/resources/Cheese.dat"));
        Files.write(Paths.get("Cheese.txt"),list);
        System.out.println("Cheese.txt: " + Files.size(Paths.get("Cheese.txt")));

        List<String> list1 = Files.readAllLines(Paths.get("bytes.txt"));
        list1.stream().forEach(System.out::println);


    }
}
