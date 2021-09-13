package com.file.path;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Lishiyan
 * @date 2021/9/717:45
 */
public class PartsOfPaths {

    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        Path p= Paths.get("src/main/java/com/path/PartsOfPaths.java");
        for(int i = 0; i < p.getNameCount(); i++) {
            System.out.println(p.getName(i));
        }
        // TODO: 2021/9/7  endsWith() 比较的是整个路径的部分，而不会包含文件路径的后缀
        System.out.println("ends with '.java': " +
                p.endsWith(".java"));
        System.out.println("======");
        for(Path pp : p) {
            System.out.print(pp + ": ");
            System.out.print(p.startsWith(pp) + " : ");
            System.out.println(p.endsWith(pp));
        }
        System.out.println("Starts with " + p.getRoot() + " " + p.startsWith(p.getRoot()));
    }
}
