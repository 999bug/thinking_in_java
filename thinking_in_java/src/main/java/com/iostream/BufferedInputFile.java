package com.iostream;// iostreams/BufferedInputFile.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// {VisuallyInspectOutput}

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.*;

public class BufferedInputFile {

    public static String read(String filename) {
        try (BufferedReader in =
                     new BufferedReader(new FileReader(filename))) {
            return in.lines()
                    .collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        List<String> list = Files.readAllLines(Paths.get("src/main/java/com/iostream/BufferedInputFile.java"));
        try (PrintWriter printWriter = new PrintWriter("Bufffer.txt")) {
            list.forEach(printWriter::println);
        }
    }
}
