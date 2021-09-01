// onjava/atunit/Test.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// The @Test tag
package com.annotations.atunit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author User
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)

public @interface Test {
    // TODO: 2021/9/1 不包含任何元素的注解称为标记注解 @Test()
    // TODO: 2021/9/1 @Target() 定义注解可以用在哪里（方法、字段）
    // TODO: 2021/9/1 @Retention() 定义注解在哪里可用（Source、class文件、Runtime）
}
