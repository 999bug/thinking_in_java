package com.path;// files/PathAnalysis.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.nio.file.*;
import java.io.IOException;

public class PathAnalysis {
    static void say(String id, Object result) {
        System.out.print(id + ": ");
        System.out.println(result);
    }

    // TODO: 2021/9/7 Files类的使用
    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("os.name"));
        Path p =
                Paths.get("src/main/java/com/path/PathAnalysis.java").toAbsolutePath();
        say("Exists", Files.exists(p));
        say("Directory", Files.isDirectory(p));
        // TODO: 2021/9/7 Files.isExecutable() 是否是可执行文件
        say("Executable", Files.isExecutable(p));
        say("Readable", Files.isReadable(p));
        // TODO: 2021/9/7 Files.isRegularFile() 是否是普通文件
        say("RegularFile", Files.isRegularFile(p));
        say("Writable", Files.isWritable(p));
        say("notExists", Files.notExists(p));
        say("Hidden", Files.isHidden(p));
        say("size", Files.size(p));
        say("FileStore", Files.getFileStore(p));
        say("LastModified: ", Files.getLastModifiedTime(p));
        say("Owner", Files.getOwner(p));
        say("ContentType", Files.probeContentType(p));
        say("SymbolicLink", Files.isSymbolicLink(p));
        if (Files.isSymbolicLink(p))
            say("SymbolicLink", Files.readSymbolicLink(p));
        if (FileSystems.getDefault()
                .supportedFileAttributeViews().contains("posix"))
            say("PosixFilePermissions",
                    Files.getPosixFilePermissions(p));
    }
}
/* Output:
Windows 8.1
Exists: true
Directory: false
Executable: true
Readable: true
RegularFile: true
Writable: true
notExists: false
Hidden: false
size: 1617
FileStore: (C:)
LastModified: : 2021-01-24T15:48:37.461504Z
Owner: GROOT\Bruce (User)
ContentType: null
SymbolicLink: false
*/
