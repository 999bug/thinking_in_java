package com.concurrent.newconcurent;// concurrent/ParallelPrime.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import com.validatingcode.TimerUtils;

import java.util.*;
import java.util.stream.*;

import static java.util.stream.LongStream.*;

import java.io.*;
import java.nio.file.*;

public class ParallelPrime {
    static final int COUNT = 100_000;

    public static boolean isPrime(long n) {
        return rangeClosed(2, (long) Math.sqrt(n))
                .noneMatch(i -> n % i == 0);
    }

    public static void main(String[] args) throws IOException {
        // TimerUtil 计算程序运行总时间
        TimerUtils timer = new TimerUtils();
        List<String> primes =
                iterate(2, i -> i + 1)
                        .parallel()                       // [1]
                        .filter(ParallelPrime::isPrime)
                        .limit(COUNT)
                        .mapToObj(Long::toString)
                        .collect(Collectors.toList());

        System.out.println(timer.duration());
        Files.write(Paths.get("primes.txt"), primes,
                StandardOpenOption.CREATE);
    }
}
/* Output:
1635
*/
