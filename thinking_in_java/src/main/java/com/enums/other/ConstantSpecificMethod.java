package com.enums.other;// enums/ConstantSpecificMethod.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.*;
import java.text.*;

// TODO: 2021/9/2 表驱动代码，常量特定方法，通过一个 abstract 方法，然后为每个 enum 实例实现该抽象方法，
public enum ConstantSpecificMethod {
    DATE_TIME {
        @Override
        String getInfo() {
            return
                    DateFormat.getDateInstance()
                            .format(new Date());
        }
    },
    CLASSPATH {
        @Override
        String getInfo() {
            return System.getenv("CLASSPATH");
        }
    },
    VERSION {
        @Override
        String getInfo() {
            return System.getProperty("java.version");
        }
    };

    abstract String getInfo();

    public static void main(String[] args) {
        for (ConstantSpecificMethod csm : values()) {
            System.out.println(csm.getInfo());
        }
    }
}
/* Output:
Jan 24, 2021
C:\Git\OnJava8\ExtractedExamples\\gradle\wrapper\gradle
-wrapper.jar
1.8.0_41
*/
