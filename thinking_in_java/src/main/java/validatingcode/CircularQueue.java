package validatingcode;// validating/CircularQueue.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Demonstration of Design by Contract (DbC)

import java.util.Arrays;

public class CircularQueue {
    private Object[] data;

    // 数组中下一个对象所在的位置
    private int in = 0;

    // 下一个对象来自何处
    private int out = 0;

    //它是否环绕循环队列？
    private boolean wrapped = false;

    public CircularQueue(int size) {
        data = new Object[size];
        // 构造后必须为真：
        assert invariant();
    }

    public boolean empty() {
        return !wrapped && in == out;
    }

    public boolean full() {
        return wrapped && in == out;
    }

    public boolean isWrapped() {
        return wrapped;
    }

    public void put(Object item) {
        precondition(item != null, "put() null item");
        precondition(!full(),
                "put() into full CircularQueue");
        assert invariant();
        data[in++] = item;
        if (in >= data.length) {
            in = 0;
            wrapped = true;
        }
        assert invariant();
    }

    public Object get() {
        precondition(!empty(),
                "get() from empty CircularQueue");
        assert invariant();
        Object returnVal = data[out];
        data[out] = null;
        out++;
        if (out >= data.length) {
            out = 0;
            wrapped = false;
        }
        assert postcondition(
                returnVal != null,
                "Null item in CircularQueue");
        assert invariant();
        return returnVal;
    }

    // 按合同设计的支持方法：
    private static void precondition(boolean cond, String msg) {
        if (!cond) {
            throw new CircularQueueException(msg);
        }
    }

    private static boolean postcondition(boolean cond, String msg) {
        if (!cond) {
            throw new CircularQueueException(msg);
        }
        return true;
    }

    /**
     * invariant 不变的
     */
    private boolean invariant() {
        // 保证在保存对象的“数据”区域中没有空值：
        for (int i = out; i != in; i = (i + 1) % data.length) {
            if (data[i] == null) {
                throw new CircularQueueException(
                        "null in CircularQueue");
            }
        }
        // 保证只有空值在保存对象的“数据”区域之外：
        if (full()) {
            return true;
        }
        for (int i = in; i != out; i = (i + 1) % data.length) {
            if (data[i] != null) {
                throw new CircularQueueException(
                        "non-null outside of CircularQueue range: "
                                + dump());
            }
        }
        return true;
    }

    public String dump() {
        return "in = " + in +
                ", out = " + out +
                ", full() = " + full() +
                ", empty() = " + empty() +
                ", CircularQueue = " + Arrays.asList(data);
    }
}
