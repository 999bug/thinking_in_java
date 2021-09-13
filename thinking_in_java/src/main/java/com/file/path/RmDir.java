package com.file.path;// onjava/RmDir.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.io.IOException;

// TODO: 2021/9/7 删除目录树 Files.walkFileTree()

public class RmDir {

    /**
     * 1.  **preVisitDirectory()**：在访问目录中条目之前在目录上运行。
     * 2.  **visitFile()**：运行目录中的每一个文件。
     * 3.  **visitFileFailed()**：调用无法访问的文件。
     * 4.  **postVisitDirectory()**：在访问目录中条目之后在目录上运行，包括所有的子目录。
     */
    public static void rmdir(Path dir) throws IOException {
        Files.walkFileTree(dir,
                new SimpleFileVisitor<Path>() {
                    // 删除文件
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                            throws IOException {
                        Files.delete(file);
                        return FileVisitResult.CONTINUE;
                    }
                    // 删除目录
                    @Override
                    public FileVisitResult postVisitDirectory(Path dir, IOException exc)
                            throws IOException {
                        Files.delete(dir);
                        return FileVisitResult.CONTINUE;
                    }
                });
    }
}
