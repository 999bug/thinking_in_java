package com.concurrent.oldc;// lowlevel/WorkStealingPool.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.stream.*;
import java.util.concurrent.*;

class ShowThread implements Runnable {
    @Override
    public void run() {
        System.out.println(
                Thread.currentThread().getName());
    }
}

public class WorkStealingPool {
  // TODO: 2021/9/13 newWorkStealingPool() 工作窃取线程，工作窃取算法允许已经耗尽输入队列中的
  //  工作项的线程从其他队列窃取工作项。目标是在处理器之间分配工作项，
  //  从而最大限度的利用所有可用的处理器来完成计算密集型任务
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Runtime.getRuntime().availableProcessors());
        ExecutorService exec = Executors.newWorkStealingPool();
        IntStream.range(0, 10)
                .mapToObj(n -> new ShowThread())
                .forEach(exec::execute);
        exec.awaitTermination(1, TimeUnit.SECONDS);
    }
}
/* Output:
8
ForkJoinPool-1-worker-1
ForkJoinPool-1-worker-2
ForkJoinPool-1-worker-1
ForkJoinPool-1-worker-3
ForkJoinPool-1-worker-4
ForkJoinPool-1-worker-4
ForkJoinPool-1-worker-2
ForkJoinPool-1-worker-3
ForkJoinPool-1-worker-5
ForkJoinPool-1-worker-1
*/
