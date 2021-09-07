package com.concurrent;

import java.util.stream.IntStream;

/**
 * @author Lishiyan
 * @date 2021/9/614:20
 */
public class CountingStream {

    // TODO: 2021/9/6 使用 parallel() 优雅的解决 多线程问题
    public static void main(String[] args) {
        System.out.println(
                IntStream.range(0,10)
                .parallel()
                .mapToObj(CountingTask::new)
                .map(ct -> {
                    try {
                        return ct.call();
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    }
                })
                .reduce(0,Integer::sum)

        );
    }
}
