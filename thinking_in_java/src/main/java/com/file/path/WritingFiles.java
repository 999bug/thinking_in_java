package com.file.path;

import com.generics.rand.Rand;
import com.google.common.base.Utf8;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

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
        Path path = Paths.get("bytes.txt");
        Files.write(path,bytes);
        System.out.println("bytes.txt: " + Files.size(path));

        List<String> list = Files.readAllLines(Paths.get("src/main/resources/Cheese.dat"));
        Files.write(Paths.get("Cheese.txt"), list);
        System.out.println("Cheese.txt: " + Files.size(Paths.get("Cheese.txt")));
        byte[] bytes1 = Files.readAllBytes(path);
        try (PrintWriter printWriter = new PrintWriter("Bufffer.txt")) {
            for (byte b : bytes1) {
                printWriter.write(b);
            }
        }
    }
}
