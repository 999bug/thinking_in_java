package com.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Lishiyan
 * @date 2021/9/915:03
 */
public class ChannelCopy {

    private static final int SIZE = 1024;

    public static void main(String[] args) {
        if (args.length != 2) {
            args[0] = "data.txt";
            args[1] ="channel.txt";
        }
        try (
                FileChannel in = new FileInputStream(args[0]).getChannel();
                FileChannel out = new FileOutputStream(args[1]).getChannel();
        ) {
            ByteBuffer buffer = ByteBuffer.allocate(SIZE);
            // TODO: 2021/9/9 flip() 每次read() 完之后，flip() 准备好缓冲区，以便write() 来提取它的信息
            while (in.read(buffer) != -1) {
                // 准备写入
                buffer.flip();
                out.write(buffer);
                // TODO: 2021/9/9 clear() 重置所有内部指针，以便下一次 read()中接受数据
                // 准备读取
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
