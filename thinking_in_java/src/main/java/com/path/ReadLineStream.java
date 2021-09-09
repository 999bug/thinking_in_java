package com.path;// files/ReadLineStream.java
import java.nio.file.*;

public class ReadLineStream {
    // TODO: 2021/9/9 如果文件太大，一次性的读取完整个文件，可能会耗尽内存，所以我们可以将文件转换为，
    //  行的 stream()，
    public static void main(String[] args) throws Exception {
        Files.lines(Paths.get("src/main/java/com/path/PathInfo.java"))
          .skip(17)
          .findFirst()
          .ifPresent(System.out::println);
    }
}
/* Output:
    show("RegularFile", Files.isRegularFile(p));
*/