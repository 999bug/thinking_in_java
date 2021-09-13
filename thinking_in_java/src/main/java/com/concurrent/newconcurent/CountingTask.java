package com.concurrent.newconcurent;

import java.util.concurrent.Callable;

/**
 * @author Lishiyan
 * @date 2021/9/614:04
 */
public class CountingTask implements Callable<Integer> {
    final int id;

    CountingTask(int id) {
        this.id = id;
    }

    @Override
    public Integer call() throws Exception {
        Integer val = 0;
        for (int i = 0; i < 100; i++) {
            val++;
        }
        System.out.println(id + " " +
                Thread.currentThread().getName() + " " + val);
        return val;
    }
}
