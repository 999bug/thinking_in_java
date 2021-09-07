package com.concurrent.completeable;// concurrent/CompletableApplyChained.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.concurrent.*;

import com.concurrent.Machina;
import com.validatingcode.TimerUtil;

public class CompletableApplyChained {

    public static void main(String[] args) {
        TimerUtil timer = new TimerUtil();
        // TODO: 2021/9/7 使用 thenApply() 来应用一个不对外通信的函数，它只需要一个参数并返回一个结果
        CompletableFuture<Machina> cf =
                CompletableFuture.completedFuture(
                        new Machina(0))
                        .thenApply(Machina::work)
                        .thenApply(Machina::work)
                        .thenApply(Machina::work)
                        .thenApply(Machina::work);
        System.out.println(timer.duration());
        // TODO: 2021/9/7 回调 thenApply() 一旦开始一个操作，在完成所有任务之前，
        //  不会完成 CompletableFuture 的构建
    }
}
/* Output:
Machina0: ONE
Machina0: TWO
Machina0: THREE
Machina0: complete
521
*/
