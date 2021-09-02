package com.enums;// enums/EnumClass.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Capabilities of the Enum class

enum Shrubbery {GROUND, CRAWLING, HANGING}

// TODO: 2021/9/2 values() 遍历所有枚举字段, name()获取字段名称
public class EnumClass {
    public static void main(String[] args) {
        // TODO: 2021/9/2 遍历枚举类 .ordinal() 返回一个 int 值，这是每个 enum 实例声明的次序，从 0 开始
        for (Shrubbery s : Shrubbery.values()) {
            System.out.println(
                    s + " ordinal: " + s.ordinal());
            System.out.print(
                    s.compareTo(Shrubbery.CRAWLING) + " ");
            System.out.print(
                    s.equals(Shrubbery.CRAWLING) + " ");
            System.out.println(s == Shrubbery.CRAWLING);
            System.out.println(s.getDeclaringClass());
            System.out.println(s.name());
            System.out.println("********************");
        }
        // Produce an enum value from a String name:
        for (String s : "HANGING CRAWLING GROUND".split(" ")) {
            // TODO: 2021/9/2 Enum.valueOf(A.class,name) 根据 name 返回相应的 enum 实例
            Shrubbery shrub = Enum.valueOf(Shrubbery.class, s);
            System.out.println(shrub);
        }
    }
}
/* Output:
GROUND ordinal: 0
-1 false false
class Shrubbery
GROUND
********************
CRAWLING ordinal: 1
0 true true
class Shrubbery
CRAWLING
********************
HANGING ordinal: 2
1 false false
class Shrubbery
HANGING
********************
HANGING
CRAWLING
GROUND
*/
