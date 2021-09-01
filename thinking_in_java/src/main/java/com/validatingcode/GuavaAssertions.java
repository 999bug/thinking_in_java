package com.validatingcode;// validating/GuavaAssertions.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Assertions that are always enabled.

import com.google.common.base.*;

import static com.google.common.base.Verify.*;

public class GuavaAssertions {
    // TODO: 2021/9/1 guava包中 verify和verfyNotNull 的使用
    public static void main(String[] args) {

        verify(2 + 2 == 4);
        try {
            verify(1 + 2 == 4);
        } catch (VerifyException e) {
            e.printStackTrace();
        }
        System.out.println("=====");
        try {
            verify(1 + 2 == 4, "Bad math");
        } catch (VerifyException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("=====");
        try {
            verify(1 + 2 == 4, "Bad math: %s", "not 4");
        } catch (VerifyException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("=====");
        String s = "";
        s = verifyNotNull(s);
        s = null;
        try {
            verifyNotNull(s);
        } catch (VerifyException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("=====");
        try {
            verifyNotNull(
                    s, "Shouldn't be null: %s", "arg s");
        } catch (VerifyException e) {
            System.out.println(e.getMessage());
        }
    }
}
/* Output:
com.google.common.base.VerifyException
Bad math
Bad math: not 4
expected a non-null reference
Shouldn't be null: arg s
*/
