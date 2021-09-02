package com.enums;// enums/SpaceShip.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.stream.*;

public enum SpaceShip {
    SCOUT, CARGO, TRANSPORT,
    CRUISER, BATTLESHIP, MOTHERSHIP;

    @Override
    public String toString() {
        String id = name();
        // 从指定索引开始截取
        String lower = id.substring(1).toLowerCase();
        return id.charAt(0) + lower;
    }

    public static void main(String[] args) {
        // 遍历所有的枚举字段，并将其转换成小驼峰类型
        Stream.of(values())
                .forEach(System.out::println);
    }
}
/* Output:
Scout
Cargo
Transport
Cruiser
Battleship
Mothership
*/
