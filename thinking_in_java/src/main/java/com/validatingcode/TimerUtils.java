package com.validatingcode;// onjava/Timer.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import static java.util.concurrent.TimeUnit.*;

public class TimerUtils {
    private long start = System.nanoTime();

    public long duration() {
        return NANOSECONDS.toMillis(System.nanoTime() - start);
    }

    public static long duration(Runnable test) {
        TimerUtils timerUtils = new TimerUtils();
        test.run();
        return timerUtils.duration();
    }
}
