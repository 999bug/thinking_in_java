package com.concurrent.newconcurent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author Lishiyan
 * @date 2021/9/613:58
 */
public class CacheThreadPool2 {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        IntStream.range(0,10)
                .mapToObj(InterferingTask::new)
                .forEach(executor::execute);

        executor.shutdown();

    }
}
