package com.concurrent.completeable;// concurrent/CompletableApplyAsync.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.concurrent.*;

import com.concurrent.Machina;
import com.validatingcode.TimerUtil;

public class CompletableApplyAsync {

    public static void main(String[] args) {
        TimerUtil timer = new TimerUtil();
        // TODO: 2021/9/7 使用 thenApplyAsync() 异步调用
        CompletableFuture<Machina> cf =
                CompletableFuture.completedFuture(
                        new Machina(0))
                        .thenApplyAsync(Machina::work)
                        .thenApplyAsync(Machina::work)
                        .thenApplyAsync(Machina::work)
                        .thenApplyAsync(Machina::work);
        System.out.println(timer.duration());
        // TODO: 2021/9/7 join() 当完成所有操作时，程序才会退出
        System.out.println(cf.join());
        System.out.println(timer.duration());
    }
}
/* Output:
103
Machina0: ONE
Machina0: TWO
Machina0: THREE
Machina0: complete
Machina0: complete
545
*/
