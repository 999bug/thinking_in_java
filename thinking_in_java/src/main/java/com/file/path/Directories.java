package com.file.path;// files/Directories.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.*;
import java.nio.file.*;

public class Directories {

    static Path test = Paths.get("test");
    static String sep = FileSystems.getDefault().getSeparator();
    static List<String> parts = Arrays.asList("foo", "bar", "baz", "bag");

    static Path makeVariant() {
        Collections.rotate(parts, 1);
        return Paths.get("test", String.join(sep, parts));
    }

    static void refreshTestDir() throws Exception {
        if (Files.exists(test)) {
            RmDir.rmdir(test);
        }
        if (!Files.exists(test)) {
            Files.createDirectory(test);
        }
    }

    public static void main(String[] args) throws Exception {
        refreshTestDir();
        // TODO: 2021/9/8 resolved() 将文件名 添加到路径末尾
        Files.createFile(test.resolve("Hello.txt"));
        Path variant = makeVariant();
        // Throws exception (too many levels):
        try {
            Files.createDirectory(variant);
        } catch (Exception e) {
            System.out.println("Nope, that doesn't work.");
        }
        populateTestDir();
        // TODO: 2021/9/8 createTempDirectory() 创建临时目录
        Path tempdir =
                Files.createTempDirectory(test, "DIR_");

        // 将临时文件放入临时目录中
        Files.createTempFile(tempdir, "pre", ".non");
        // TODO: 2021/9/8 Files.newDirectoryStream() 返回该一级目录下所有的文件Stream流
        Files.newDirectoryStream(test)
                .forEach(System.out::println);
        System.out.println("*********");
        // TODO: 2021/9/8 Files.walk() 返回目录下所有的文件路径
        Files.walk(test).forEach(System.out::println);
    }

    static void populateTestDir() throws Exception {
        for (int i = 0; i < parts.size(); i++) {
            Path variant = makeVariant();
            if (!Files.exists(variant)) {
                Files.createDirectories(variant);
                Files.copy(Paths.get("src/main/java/com/path/Directories.java"),
                        variant.resolve("File.txt"));
                // TODO: 2021/9/8 创建临时文件如不指定后缀则默认为 .tmp
                Files.createTempFile(variant, null, null);
            }
        }
    }
}
/* Output:
Nope, that doesn't work.
test\bag
test\bar
test\baz
test\DIR_8683707748599240459
test\foo
test\Hello.txt
*********
test
test\bag
test\bag\foo
test\bag\foo\bar
test\bag\foo\bar\baz
test\bag\foo\bar\baz\4316127347949967230.tmp
test\bag\foo\bar\baz\File.txt
test\bar
test\bar\baz
test\bar\baz\bag
test\bar\baz\bag\foo
test\bar\baz\bag\foo\1223263495976065729.tmp
test\bar\baz\bag\foo\File.txt
test\baz
test\baz\bag
test\baz\bag\foo
test\baz\bag\foo\bar
test\baz\bag\foo\bar\6666183168609095028.tmp
test\baz\bag\foo\bar\File.txt
test\DIR_8683707748599240459
test\DIR_8683707748599240459\pre6366626804787365549.non
test\foo
test\foo\bar
test\foo\bar\baz
test\foo\bar\baz\bag
test\foo\bar\baz\bag\4712324129011589115.tmp
test\foo\bar\baz\bag\File.txt
test\Hello.txt
*/
