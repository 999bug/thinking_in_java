package com.enums.enumcollection;// enums/EnumSets.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Operations on EnumSets
// {java enums.EnumSets}

import com.enums.AlarmPoints;

import java.util.*;

import static com.enums.AlarmPoints.*;

public class EnumSets {

    public static void main(String[] args) {
        // TODO: 2021/9/2  EnumSet.noneOf()创建空的枚举集
        EnumSet<AlarmPoints> points =
                EnumSet.noneOf(AlarmPoints.class); // Empty
        points.add(BATHROOM);
        System.out.println(points);
// TODO: 2021/9/2  EnumSet.of()当使用一个参数或超过5个参数时，将调用可变参数的of()
        points.addAll(
                EnumSet.of(STAIR1, STAIR2, KITCHEN));
        System.out.println(points);
// TODO: 2021/9/2  EnumSet.allOf(A.class) 获取A枚举下所有的enum
        points = EnumSet.allOf(AlarmPoints.class);
        points.removeAll(
                EnumSet.of(STAIR1, STAIR2, KITCHEN));
        System.out.println(points);

        points.removeAll(
                // TODO: 2021/9/2  EnumSet.range(A, B) A到 B范围内所有的 enum
                EnumSet.range(OFFICE1, OFFICE4));
        System.out.println(points);

        // TODO: 2021/9/2  EnumSet.complementOf(A) 根据A的类型返回所有的enum
        points = EnumSet.complementOf(points);
        System.out.println(points);
    }
}
/* Output:
[BATHROOM]
[STAIR1, STAIR2, BATHROOM, KITCHEN]
[LOBBY, OFFICE1, OFFICE2, OFFICE3, OFFICE4, BATHROOM,
UTILITY]
[LOBBY, BATHROOM, UTILITY]
[STAIR1, STAIR2, OFFICE1, OFFICE2, OFFICE3, OFFICE4,
KITCHEN]
*/
