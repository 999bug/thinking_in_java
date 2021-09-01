package com.typeinformation;// reflection/ClassInitialization.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.*;

class Initable {
    static final int STATIC_FINAL = 47;
    static final int STATIC_FINAL2 =
            ClassInitialization.rand.nextInt(1000);

    static {
        System.out.println("Initializing Initable");
    }
}

class Initable2 {
    static int staticNonFinal = 147;

    static {
        System.out.println("Initializing Initable2");
    }
}

class Initable3 {
    static int staticNonFinal = 74;

    static {
        System.out.println("Initializing Initable3");
    }
}

public class ClassInitialization {
    public static Random rand = new Random(47);

    public static void
    main(String[] args) throws Exception {
        Class initable = Initable.class;
        System.out.println("After creating Initable ref");
        // Does not trigger initialization:
        System.out.println(Initable.STATIC_FINAL);
        System.out.println("=====");
        // Triggers initialization: 不是常量会进行类的初始化
        System.out.println(Initable.STATIC_FINAL2);
        System.out.println("=====");
        // Triggers initialization:
        System.out.println(Initable2.staticNonFinal);
        System.out.println("=====");
        // Class.forName()会立即初始化
        Class initable3 = Class.forName("com.typeinformation.Initable3");
        System.out.println("After creating Initable3 ref");
        System.out.println("=====");
        System.out.println(Initable3.staticNonFinal);
        System.out.println("=====");
    }
}
/* Output:
After creating Initable ref
47
Initializing Initable
258
Initializing Initable2
147
Initializing Initable3
After creating Initable3 ref
74
*/
