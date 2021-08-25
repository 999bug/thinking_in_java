package generics.suppliers;// generics/WatercolorSets.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.*;

/**
 * 轻松从枚举创建set
 */
public class WatercolorSets {


    public static void main(String[] args) {
        Set<Watercolors> set1 =
                EnumSet.range(Watercolors.BRILLIANT_RED, Watercolors.VIRIDIAN_HUE);
        // 获取 从CERULEAN_BLUE_HUE 到 PAYNES_GRAY 之间的所有enum
        Set<Watercolors> set2 =
                EnumSet.range(Watercolors.CERULEAN_BLUE_HUE, Watercolors.PAYNES_GRAY);

        System.out.println("set1: " + set1);
        System.out.println("set2: " + set2);
        System.out.println("union(set1, set2): " + Sets.union(set1, set2));
        Set<Watercolors> subset = Sets.intersection(set1, set2);

        System.out.println("intersection(set1, set2): " + subset);
        System.out.println("difference(set1, subset): " + Sets.difference(set1, subset));
        System.out.println("difference(set2, subset): " + Sets.difference(set2, subset));
        System.out.println("complement(set1, set2): " + Sets.complement(set1, set2));
    }
}
