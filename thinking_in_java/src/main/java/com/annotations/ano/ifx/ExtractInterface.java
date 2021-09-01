// annotations/ifx/ExtractInterface.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// javac-based annotation processing
package com.annotations.ano.ifx;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// TODO: 2021/9/1 提取类中方法的注解，
//  RetentionPolicy.SOURCE 目的是为了在提取类中的接口之后不在将注解信息保留在class 文件中
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface ExtractInterface {
    String interfaceName() default "-!!-";
}
