package com.concurrent.newconcurent;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Lishiyan
 * @date 2021/9/613:58
 */
public class CacheThreadPool3 {

    // TODO: 2021/9/6 Callable 返回值的使用
    public static Integer extractResult(Future<Integer> f) {
        try {
            return f.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        List<CountingTask> countingTaskList = IntStream.range(0, 10)
                .mapToObj(CountingTask::new)
                .collect(Collectors.toList());

        List<Future<Integer>> futures = executor.invokeAll(countingTaskList);
        Integer sum = futures.stream()
                .map(CacheThreadPool3::extractResult)
                .reduce(0, Integer::sum);

        System.out.println("sum = " + sum);
        executor.shutdown();


    }
}
