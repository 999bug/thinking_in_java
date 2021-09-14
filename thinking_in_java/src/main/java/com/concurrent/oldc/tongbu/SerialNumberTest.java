package com.concurrent.oldc.tongbu;// lowlevel/SerialNumberTest.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

public class SerialNumberTest {
    // TODO: 2021/9/13 volatile 是不需要的，现在我们只需要使用 synchronized 替换即可
    public static void main(String[] args) {
        SerialNumberChecker.test(new SerialNumbers());
    }
}
/* Output:
Duplicate: 33280
Duplicate: 33278
Duplicate: 33290
Duplicate: 33277
*/
