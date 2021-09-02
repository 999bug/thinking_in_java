// enums/menu/Food.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
// Subcategorization of enums within interfaces
package com.enums.menu;

public interface Food {
    // Appetizer:开胃菜
    enum Appetizer implements Food {
        SALAD, SOUP, SPRING_ROLLS;
    }

    // 主菜
    enum MainCourse implements Food {
        LASAGNE, BURRITO, PAD_THAI,
        LENTILS, HUMMUS, VINDALOO;
    }

    // 点心
    enum Dessert implements Food {
        TIRAMISU, GELATO, BLACK_FOREST_CAKE,
        FRUIT, CREME_CARAMEL;
    }

    // 咖啡
    enum Coffee implements Food {
        BLACK_COFFEE, DECAF_COFFEE, ESPRESSO,
        LATTE, CAPPUCCINO, TEA, HERB_TEA;
    }
}
