package com.concurrent;// concurrent/Futures.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

public class Futures {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService exec =
                Executors.newSingleThreadExecutor();
        // TODO: 2021/9/6 ExecutorService.submit() 提交任务而无需等待它完成
        Future<Integer> f =
                exec.submit(new CountingTask(99));
        // TODO: 2021/9/6  调用get() 是阻塞式的，直到有返回结果
        System.out.println(f.get());               // [1]
        exec.shutdown();
    }
}
/* Output:
99 pool-1-thread-1 100
100
*/
