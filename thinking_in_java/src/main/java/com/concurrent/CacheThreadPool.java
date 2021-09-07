package com.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author Lishiyan
 * @date 2021/9/613:58
 */
public class CacheThreadPool {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        IntStream.range(0,10)
                .mapToObj(InterferingTask::new)
                .forEach(executor::execute);

        executor.shutdown();

    }
}
