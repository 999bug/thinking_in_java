package com.concurrent.oldc;// lowlevel/CaptureUncaughtException.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.concurrent.*;

class ExceptionThread2 implements Runnable {
    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("run() by " + t.getName());
        System.out.println(
                "eh = " + t.getUncaughtExceptionHandler()); // [3]
        throw new RuntimeException();
    }
}

// TODO: 2021/9/13 Thread.UncaughtExceptionHandler 设置未捕获异常处理器，
//  当发生异常时，被调用。
class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caught " + e); // [4]
    }
}


class HandlerThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        System.out.println(this + " creating new Thread");
        Thread t = new Thread(r);
        System.out.println("created " + t);
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler()); // [2]
        System.out.println(
                "eh = " + t.getUncaughtExceptionHandler());
        return t;
    }
}

public class CaptureUncaughtException {

    public static void main(String[] args) {
        ExecutorService exec =
                Executors.newCachedThreadPool(new HandlerThreadFactory());  // [1]
        exec.execute(new ExceptionThread2());
        exec.shutdown();
    }
}
/* Output:
HandlerThreadFactory@106d69c creating new Thread
created Thread[Thread-0,5,main]
eh = MyUncaughtExceptionHandler@52e922
run() by Thread-0
eh = MyUncaughtExceptionHandler@52e922
caught java.lang.RuntimeException
*/
