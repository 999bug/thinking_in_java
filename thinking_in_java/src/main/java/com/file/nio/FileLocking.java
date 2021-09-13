package com.file.nio;// newio/FileLocking.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.nio.channels.*;
import java.util.concurrent.*;
import java.io.*;

// TODO: 2021/9/9 文件锁定
public class FileLocking {
    public static void main(String[] args) {
        // TODO: 2021/9/9 tryLock() 非阻塞的。他试图获取锁，
        //  若不能获取（当其他进程已经持有相同的锁，并且它不是共享的），他只是从方面调用返回
        // TODO: 2021/9/9 lock() 会阻塞，直到获取锁，或者调用 lock() 的线程中断，或者调用 lock() 方法的通道关闭 
        try (
                FileOutputStream fos = new FileOutputStream("file.txt");
                FileLock fl = fos.getChannel().tryLock()
        ) {
            if (fl != null) {
                System.out.println("Locked File");
                TimeUnit.MILLISECONDS.sleep(100);
                // TODO: 2021/9/9 FileLock.release() 释放锁 
                fl.release();
                System.out.println("Released Lock");
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    // TODO: 2021/9/9  tryLock(long position, long size, boolean shared)。
    //  lock(long position, long size, boolean shared)
    //  锁定文件的一部分，锁住size-position 区域。
    //  shared 是否共享此锁 。
}
/* Output:
Locked File
Released Lock
*/
