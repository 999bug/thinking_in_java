package com.enums;// enums/Burrito2.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// {java enums.Burrito2}

// TODO: 2021/9/2 使用 import statis com.enums.* 静态导入，就不需要使用enum类型来修饰enum 实例了
import static com.enums.SpicinessEnum.*;

public class Burrito2 {
    SpicinessEnum degree;

    public Burrito2(SpicinessEnum degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Burrito is " + degree;
    }

    public static void main(String[] args) {
        System.out.println(new Burrito2(NOT));
        System.out.println(new Burrito2(SpicinessEnum.MEDIUM));
        System.out.println(new Burrito2(SpicinessEnum.HOT));
    }
}
/* Output:
Burrito is NOT
Burrito is MEDIUM
Burrito is HOT
*/
