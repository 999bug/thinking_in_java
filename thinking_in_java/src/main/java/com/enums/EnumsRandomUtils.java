package com.enums;

import java.util.Random;

/**
 * @author Lishiyan
 * @date 2021/9/211:14
 */
// TODO: 2021/9/2 枚举工具类
public class EnumsRandomUtils {
    private static Random random = new Random(47);

    public static <T extends Enum<T>> T random(Class<T> ec) {
        return random(ec.getEnumConstants());
    }

    public static <T> T random(T[] values) {
        return values[random.nextInt(values.length)];
    }
}
