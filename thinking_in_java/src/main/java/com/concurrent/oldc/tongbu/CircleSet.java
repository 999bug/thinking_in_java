package com.concurrent.oldc.tongbu;

import java.util.Arrays;

/**
 * @author Lishiyan
 * @date 2021/9/1314:33
 */
public class CircleSet {
    private int size;
    private int[] array;
    private int index = 0;

    public CircleSet(int size) {
        this.size = size;
        array = new int[size];
        Arrays.fill(array, -1);
    }

    public synchronized void add(int val) {
        array[index] = val;
        index = ++index % size;
    }

    public synchronized boolean contains(int val) {
        for (int i : array) {
            if (array[i] == val) {
                return true;
            }
        }
        return false;
    }
}
