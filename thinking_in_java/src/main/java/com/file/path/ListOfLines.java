package com.file.path;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author Lishiyan
 * @date 2021/9/910:21
 */
public class ListOfLines {

    // TODO: 2021/9/9 读入文件按行读取 Files。readAllLines()
    public static void main(String[] args) throws IOException {
        List<String> list = Files.readAllLines(
                Paths.get("src/main/resources/Cheese.dat"));
        list.stream()
                .filter(line -> !line.startsWith("//"))
                .map(String::toLowerCase)
                .forEach(System.out::println);
    }
}
