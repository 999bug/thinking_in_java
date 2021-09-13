package com.concurrent.oldc.enentnumber;// lowlevel/TestAbort.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import com.concurrent.newconcurent.Nap;
import com.validatingcode.TimerUtils;


// TODO: 2021/9/13 手写守护线程
public class TestAbort {

    public static void main(String[] args) {
        TimerUtils timeUnit = new TimerUtils();
        new TimedAbort(4);
        System.out.println("Napping for 4");
        new Nap(4);
        System.out.println("总用时"+timeUnit.duration());
    }
}
/* Output:
Napping for 4
TimedAbort 1.0
*/
