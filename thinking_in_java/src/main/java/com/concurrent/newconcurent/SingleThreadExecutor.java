package com.concurrent.newconcurent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author Lishiyan
 * @date 2021/9/613:47
 */
public class SingleThreadExecutor {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        IntStream.range(0,10)
                .mapToObj(NapTask::new)
                .forEach(executor::execute);

        System.out.println("all tasks submitted");
        executor.shutdown();
        while (!executor.isTerminated()) {
            System.out.println(Thread.currentThread().getName()+
                    " :awaiting termination");
            new Nap(0.1);
        }

    }
}
