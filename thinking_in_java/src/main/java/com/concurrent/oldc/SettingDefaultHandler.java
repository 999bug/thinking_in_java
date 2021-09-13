package com.concurrent.oldc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Lishiyan
 * @date 2021/9/1310:02
 */
public class SettingDefaultHandler {
    // TODO: 2021/9/13 设置默认的未捕获异常处理器
    static {
        Thread.setDefaultUncaughtExceptionHandler(
                new MyUncaughtExceptionHandler()
        );
    }

    public static void main(String[] args) {

        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(new ExceptionThread());
        es.shutdown();
    }
}
