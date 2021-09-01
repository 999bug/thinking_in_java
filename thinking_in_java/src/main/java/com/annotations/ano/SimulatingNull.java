package com.annotations.ano;// annotations/SimulatingNull.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.lang.annotation.*;

// TODO: 2021/9/1 通过定义负数用于表达某个元素不存在，用来绕开不能使用null 值作为默认值
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SimulatingNull {
    int id() default -1;

    String description() default "";
}
