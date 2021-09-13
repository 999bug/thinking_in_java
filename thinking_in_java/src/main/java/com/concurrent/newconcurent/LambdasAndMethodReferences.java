package com.concurrent.newconcurent;// concurrent/LambdasAndMethodReferences.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.concurrent.*;

class NotRunnable {
    public void go() {
        System.out.println("NotRunnable");
    }
}

class NotCallable {
    public Integer get() {
        System.out.println("NotCallable");
        return 1;
    }
}

public class LambdasAndMethodReferences {
    // TODO: 2021/9/6 java8 d lambdas 和方法引用可以通过匹配方法签名来使用，即它支持结构一致性，
    //  我们可以将非 Runnable 或 Callable 的参数传递给 ExecutorService，
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService exec =
                Executors.newCachedThreadPool();
        exec.submit(() -> System.out.println("Lambda1"));
        exec.submit(new NotRunnable()::go);
        exec.submit(() -> {
            System.out.println("Lambda2");
            return 1;
        });
        Future<Integer> submit = exec.submit(new NotCallable()::get);
        System.out.println("submit = " + submit.get());
        exec.shutdown();
    }
}
/* Output:
Lambda1
NotRunnable
Lambda2
NotCallable
*/
