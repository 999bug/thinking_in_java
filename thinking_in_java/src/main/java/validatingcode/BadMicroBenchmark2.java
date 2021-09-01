package validatingcode;// validating/BadMicroBenchmark2.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Relying on a common resource

import java.util.Arrays;
import java.util.Random;
import java.util.SplittableRandom;

// TODO: 2021/9/1 微基准测试 SplittableRandom 加快random 的速度
public class BadMicroBenchmark2 {
    //减小 SIZE 以使其运行速度更快:
    static final int SIZE = 5_000_000;

    public static void main(String[] args) {
        long[] la = new long[SIZE];
        Random r = new Random();
        System.out.println("parallelSetAll: " +
                Timer.duration(() ->
                        Arrays.parallelSetAll(la, n -> r.nextLong())));

        System.out.println("setAll: " +
                Timer.duration(() ->
                        Arrays.setAll(la, n -> r.nextLong())));

        SplittableRandom sr = new SplittableRandom();
        System.out.println("parallelSetAll: " +
                Timer.duration(() ->
                        Arrays.parallelSetAll(la, n -> sr.nextLong())));

        System.out.println("setAll: " +
                Timer.duration(() ->
                        Arrays.setAll(la, n -> sr.nextLong())));

    }
}
/* Output:
parallelSetAll: 1008
setAll: 294
parallelSetAll: 78
setAll: 88
*/
