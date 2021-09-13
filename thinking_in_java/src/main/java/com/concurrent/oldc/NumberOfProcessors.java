package com.concurrent.oldc;

public class NumberOfProcessors {
    public static void main(String[] args) {
        System.out.println(
                Runtime.getRuntime().availableProcessors());
    }
}