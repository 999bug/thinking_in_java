package com.concurrent.completeable;// concurrent/CompletableApply.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import com.concurrent.Machina;

import java.util.concurrent.*;

public class CompletableApply {
    // TODO: 2021/9/7 CompleteableFutures 的使用
    public static void main(String[] args) {
        CompletableFuture<Machina> cf = CompletableFuture.completedFuture(
                        new Machina(0));
        // TODO: 2021/9/7 thenApply() 应用一个接收输入并产生输出的函数
        CompletableFuture<Machina> cf2 =
                cf.thenApply(Machina::work);

        CompletableFuture<Machina> cf3 =
                cf2.thenApply(Machina::work);

        CompletableFuture<Machina> cf4 =
                cf3.thenApply(Machina::work);

        CompletableFuture<Machina> cf5 =
                cf4.thenApply(Machina::work);
    }
}
/* Output:
Machina0: ONE
Machina0: TWO
Machina0: THREE
Machina0: complete
*/
