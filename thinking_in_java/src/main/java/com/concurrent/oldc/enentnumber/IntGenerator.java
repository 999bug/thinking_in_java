package com.concurrent.oldc.enentnumber;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Lishiyan
 * @date 2021/9/1310:12
 */
public abstract class IntGenerator {

    private AtomicBoolean canceled = new AtomicBoolean(false);

    public abstract int next();

    public void cancel() {
        canceled.set(true);
    }

    public boolean isCanceled() {
        return canceled.get();
    }
}
