// enums/menu/TypeOfFood.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// {java enums.menu.TypeOfFood}
package com.enums.menu;


public class TypeOfFood {
    // 所有的东西都是实现了Food 接口，我们可以向上转型为food，所以 以下所有东西都是Food
    public static void main(String[] args) {
        Food food = Food.Appetizer.SALAD;
        food = Food.MainCourse.LASAGNE;
        food = Food.Dessert.GELATO;
        food = Food.Coffee.CAPPUCCINO;
    }
}
