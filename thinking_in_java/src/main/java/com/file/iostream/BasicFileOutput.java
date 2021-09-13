package com.file.iostream;// iostreams/BasicFileOutput.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// {VisuallyInspectOutput}

import java.io.*;

public class BasicFileOutput {
    static String file = "BasicFileOutput.dat";

    // TODO: 2021/9/9 try-with-resources 会自动 flush 并关闭文件
    public static void main(String[] args) {
        try (
                BufferedReader in = new BufferedReader(
                        new StringReader(
                                BufferedInputFile.read(
                                        "src/main/java/com/iostream/BasicFileOutput.java")));
                PrintWriter out = new PrintWriter(
                        new BufferedWriter(new FileWriter(file)))
        ) {
            in.lines().forEach(out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Show the stored file:
        System.out.println(BufferedInputFile.read(file));
    }
}
