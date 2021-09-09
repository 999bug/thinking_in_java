package com.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Lishiyan
 * @date 2021/9/914:17
 * 从流中获取通道
 */
public class GetChannel {

    private static final String name = "data.txt";
    private static final int SIZE = 1024;

    public static void main(String[] args) {
        try (FileChannel fileChannel = new FileOutputStream(name).getChannel();) {
            fileChannel.write(ByteBuffer.wrap("some else thing to say".getBytes()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileChannel fileChannel = new RandomAccessFile(name, "rw").getChannel()) {
            // 移动到结尾
            fileChannel.position(fileChannel.size());
            fileChannel.write(ByteBuffer.wrap("love you".getBytes()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 读取文件
        try(FileChannel fc = new FileInputStream(name).getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocate(SIZE);
            fc.read(buffer);
            buffer.flip();

            while (buffer.hasRemaining()) {
                System.out.write(buffer.get());
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.flush();

    }

}
