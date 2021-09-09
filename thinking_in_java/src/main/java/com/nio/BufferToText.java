package com.nio;// newio/BufferToText.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Converting text to and from ByteBuffers

import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;
import java.io.*;

public class BufferToText {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        try (
                FileChannel fc = new FileOutputStream(
                        "data1.txt").getChannel()
        ) {
            fc.write(ByteBuffer.wrap("Some text".getBytes()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        try (
                FileChannel fc = new FileInputStream(
                        "data1.txt").getChannel()
        ) {
            fc.read(buff);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        buff.flip();
        // Doesn't work:
        System.out.println(buff.asCharBuffer());
        System.out.println("=======1=====");

        // 使用该系统的默认字符集解码：
        // TODO: 2021/9/9 rewind() 回到数据开头
        buff.rewind();
        // TODO: 2021/9/9 System.getProperty("file.encoding")  查看平台的默认字符集编码
        String encoding = System.getProperty("file.encoding");
        // TODO: 2021/9/9  Charset.forName(encoding).decode(buff) 对 buff 解码使用 encoding
        System.out.println("Decoded using " + encoding + ": "
                + Charset.forName(encoding).decode(buff));
        System.out.println("========2==========");

        // 用可打印的东西编码:
        try (
                FileChannel fc = new FileOutputStream("data2.txt").getChannel()
        ) {
            fc.write(ByteBuffer.wrap("Some text".getBytes("UTF-16BE")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Now try reading again:
        buff.clear();
        try (
                FileChannel fc = new FileInputStream("data2.txt").getChannel()
        ) {
            fc.read(buff);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // flip() 每次read() 后准备好缓冲区，以便下次 write() 使用
        buff.flip();
        System.out.println(buff.asCharBuffer());
        System.out.println("=========3===========");


        // Use a CharBuffer to write through:
        buff = ByteBuffer.allocate(24);
        buff.asCharBuffer().put("Some text");
        try (
                FileChannel fc = new FileOutputStream("data3.txt").getChannel()
        ) {
            fc.write(buff);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // clear() 重置所有的内部指针，以便下次read() 使用
        buff.clear();
        try (
                FileChannel fc = new FileInputStream("data3.txt").getChannel()
        ) {
            fc.read(buff);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        buff.flip();
        System.out.println(buff.asCharBuffer());
    }
}
/* Output:
????
Decoded using windows-1252: Some text
Some text
Some textNULNULNUL
*/
