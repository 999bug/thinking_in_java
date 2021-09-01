package com.fp.lambda;// functional/RecursiveFibonacci.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

public class RecursiveFibonacci {
    IntCall fib;

    // IntCall.call
    RecursiveFibonacci() { // [4]
        fib = n -> n == 0 ? 0 :
                n == 1 ? 1 :
                        fib.call(n - 1) + fib.call(n - 2);
    }

    int fibonacci(int n) {
        return fib.call(n); // [2]
    }


    public static void main(String[] args) {
        RecursiveFibonacci rf = new RecursiveFibonacci();
        for (int i = 0; i <= 10; i++) {
            System.out.println(rf.fibonacci(i)); // [1]
        }
    }
}
/* Output:
0
1
1
2
3
5
8
13
21
34
55
*/
