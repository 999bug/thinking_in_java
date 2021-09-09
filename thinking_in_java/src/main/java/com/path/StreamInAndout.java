package com.path;

import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author Lishiyan
 * @date 2021/9/910:44
 */
public class StreamInAndout {
    // TODO: 2021/9/9 将输入流转换输出到输出流中
    public static void main(String[] args) {
        try (
                Stream<String> input = Files.lines(Paths.get("src/main/java/com/path/PathInfo.java"));
                PrintWriter output = new PrintWriter("StreamOutput.txt");
        ) {
            input.map(String::toUpperCase)
                    .forEachOrdered(output::println);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

