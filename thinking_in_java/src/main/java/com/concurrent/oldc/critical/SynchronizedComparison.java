package com.concurrent.oldc.critical;// lowlevel/SynchronizedComparison.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Synchronizing blocks instead of entire methods
// speeds up access.

import com.concurrent.newconcurent.Nap;

import java.util.*;
import java.util.stream.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

abstract class Guarded {

    AtomicLong callCount = new AtomicLong();

    public abstract void method();

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                ": " + callCount.get();
    }
}

class SynchronizedMethod extends Guarded {
    @Override
    public synchronized void method() {
        new Nap(0.01);
        callCount.incrementAndGet();
    }
}

// TODO: 2021/9/14 synchronized(syncobject) 使用同步控制块取代控制整个方法，
//  从而达到更多的并发量，
class CriticalSection extends Guarded {

    @Override
    public void method() {
        new Nap(0.01);
        synchronized (this) {
            callCount.incrementAndGet();
        }
    }
}

class Caller implements Runnable {
    private Guarded g;

    Caller(Guarded g) {
        this.g = g;
    }

    private AtomicLong successfulCalls = new AtomicLong();
    private AtomicBoolean stop = new AtomicBoolean(false);

    @Override
    public void run() {
        // 设置退出循环的条件
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                stop.set(true);
            }
        }, 2500);

        while (!stop.get()) {
            g.method();
            successfulCalls.getAndIncrement();
        }
        System.out.println(
                "-> " + successfulCalls.get());
    }
}

/**
 * 统计成功访问 method() 的计数并且发起一些任务来尝试竞争调用 method() 方法
 */
public class SynchronizedComparison {

    static void test(Guarded g) {
        List<CompletableFuture<Void>> callers =
                Stream.of(
                        new Caller(g),
                        new Caller(g),
                        new Caller(g),
                        new Caller(g))
                        .map(CompletableFuture::runAsync)
                        .collect(Collectors.toList());

        callers.forEach(CompletableFuture::join);
        System.out.println(g);
    }

    public static void main(String[] args) {
       // test(new CriticalSection());
        System.out.println("==============");

        for (int i = 0; i < 10; i++) {

            test(new SynchronizedMethod());
        }
    }
}
/* Output:
-> 159
-> 159
-> 159
-> 159
CriticalSection: 636
-> 65
-> 21
-> 11
-> 68
SynchronizedMethod: 165
*/
