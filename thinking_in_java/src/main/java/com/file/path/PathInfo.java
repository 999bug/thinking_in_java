package com.file.path;// files/PathInfo.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.nio.file.*;
import java.net.URI;
import java.io.File;
import java.io.IOException;

public class PathInfo {
    static void show(String id, Object p) {
        System.out.println(id + ": " + p);
    }

    // TODO: 2021/9/7 Files.exists() Files.getFileName()
    static void info(Path p) {
        show("toString", p);
        show("Exists", Files.exists(p));
        // TODO: 2021/9/7 isRegularFile() 是否是常规文件
        show("RegularFile", Files.isRegularFile(p));
        show("Directory", Files.isDirectory(p));
        show("Absolute", p.isAbsolute());
        show("FileName", p.getFileName());
        show("Parent", p.getParent());
        show("Root", p.getRoot());
        System.out.println("******************");
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        // TODO: 2021/9/7 Paths.get(a)  键入文件 a 返回一个 Path 对象
        info(Paths.get(
                "C:", "path", "to", "nowhere", "NoFile.txt"));
        Path p = Paths.get("src/main/java/com/path/PathInfo.java");
        info(p);

        // TODO: 2021/9/7 toAbsolutePath() 相对路径转换成绝对路径
        Path ap = p.toAbsolutePath();
        info(ap);

        info(ap.getParent());

        try {
            info(p.toRealPath());
        } catch (IOException e) {
            System.out.println(e);
        }
        // TODO: 2021/9/7  将路径转换为 URI
        URI u = p.toUri();
        System.out.println("URI: " + u);
        Path puri = Paths.get(u);
        System.out.println(Files.exists(puri));
        File f = ap.toFile(); // Don't be fooled
    }
}
/* Output:
Windows 8.1
toString: C:\path\to\nowhere\NoFile.txt
Exists: false
RegularFile: false
Directory: false
Absolute: true
FileName: NoFile.txt
Parent: C:\path\to\nowhere
Root: C:\
******************
toString: PathInfo.java
Exists: true
RegularFile: true
Directory: false
Absolute: false
FileName: PathInfo.java
Parent: null
Root: null
******************
toString:
C:\Git\OnJava8\ExtractedExamples\files\PathInfo.java
Exists: true
RegularFile: true
Directory: false
Absolute: true
FileName: PathInfo.java
Parent: C:\Git\OnJava8\ExtractedExamples\files
Root: C:\
******************
toString: C:\Git\OnJava8\ExtractedExamples\files
Exists: true
RegularFile: false
Directory: true
Absolute: true
FileName: files
Parent: C:\Git\OnJava8\ExtractedExamples
Root: C:\
******************
toString:
C:\Git\OnJava8\ExtractedExamples\files\PathInfo.java
Exists: true
RegularFile: true
Directory: false
Absolute: true
FileName: PathInfo.java
Parent: C:\Git\OnJava8\ExtractedExamples\files
Root: C:\
******************
URI: file:///C:/Git/OnJava8/ExtractedExamples/files/Pat
hInfo.java
true
*/
