package com.nio;// newio/LargeMappedFiles.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Creating a very large file using mapping

import java.nio.*;
import java.nio.channels.*;
import java.io.*;

public class LargeMappedFiles {
    static int length = 0x8000000; // 128 MB

    // TODO: 2021/9/9 RandomAccessFile 内存映射大文件操作
    public static void main(String[] args) throws Exception {
        try (
                RandomAccessFile tdat = new RandomAccessFile("test.dat", "rw")
        ) {
            // TODO: 2021/9/9 MappedByteBuffer，直接缓冲区，需要指定要在文件中映射的区域的起点和长度。
            //  这意味着你可以选择映射大文件的较小区域。
            MappedByteBuffer out = tdat.getChannel()
                    .map(FileChannel.MapMode.READ_WRITE, 0, length);
            for (int i = 0; i < length; i++) {
              out.put((byte) 'x');
            }
            System.out.println("Finished writing");
            for (int i = length / 2; i < length / 2 + 6; i++) {
              System.out.print((char) out.get(i));
            }
        }
    }
}
/* Output:
Finished writing
xxxxxx
*/
