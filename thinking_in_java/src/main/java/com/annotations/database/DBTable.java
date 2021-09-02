// annotations/database/DBTable.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
package com.annotations.database;

import java.lang.annotation.*;

// TODO: 2021/9/1 它告诉注解处理器应该创建一个数据库表
@Target(ElementType.TYPE) // Applies to classes only
@Retention(RetentionPolicy.RUNTIME)
public @interface DBTable {
    // TODO: 2021/9/1  ElementType.TYPE 这个自定义注解只能用于指定的类型，
    //  如果想要应用于所有的ElementType.TYPE 那么可以省去 @Target 注解
    String name() default "";
}
