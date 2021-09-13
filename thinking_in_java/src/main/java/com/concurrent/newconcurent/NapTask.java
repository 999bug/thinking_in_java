package com.concurrent.newconcurent;

/**
 * @author Lishiyan
 * @date 2021/9/613:42
 */
public class NapTask implements Runnable {
    final int id;

    NapTask(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        new Nap(0.1);
        System.out.println(this + " " +
                Thread.currentThread().getName());
    }

    @Override
    public String toString() {
        return "NapTask{" +
                "id=" + id +
                '}';
    }
}
