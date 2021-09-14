package com.concurrent.oldc.critical;// lowlevel/SyncOnObject.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Synchronizing on another object

import com.concurrent.newconcurent.Nap;

import java.util.*;
import java.util.stream.*;
import java.util.concurrent.*;

class DualSynch {

    ConcurrentLinkedQueue<String> trace = new ConcurrentLinkedQueue<>();

    // TODO: 2021/9/14 f()方法通过同步整个方法在this上同步，
    //  而g() 方法有一个在 syncObject上同步的synchronized 块，
    //  因此，这两个同步是互相独立的。
    public synchronized void f(boolean nap) {
        for (int i = 0; i < 5; i++) {
            trace.add("f() " + i);
            if (nap) {
                new Nap(0.01);
            }
        }
    }

    private Object syncObject = new Object();

    public void g(boolean nap) {
        synchronized (syncObject) {
            for (int i = 0; i < 5; i++) {
                trace.add("g() " + i);
                if (nap) {
                    new Nap(0.01);
                }
            }
        }
    }
}

/**
 * 当对象中的方法在不同的锁上同步时，两个任务可以同时进入同一对象
 */
public class SyncOnObject {

    static void test(boolean fNap, boolean gNap) {
        DualSynch ds = new DualSynch();
        List<CompletableFuture<Void>> cfs =
                Arrays.stream(new Runnable[]{
                        () -> ds.f(fNap), () -> ds.g(gNap)})
                        .map(CompletableFuture::runAsync)
                        .collect(Collectors.toList());
        cfs.forEach(CompletableFuture::join);
        ds.trace.forEach(System.out::println);
    }

    public static void main(String[] args) {
        test(true, false);
        System.out.println("****");
        test(false, true);
    }
}
/* Output:
f() 0
g() 0
g() 1
g() 2
g() 3
g() 4
f() 1
f() 2
f() 3
f() 4
****
f() 0
g() 0
f() 1
f() 2
f() 3
f() 4
g() 1
g() 2
g() 3
g() 4
*/
