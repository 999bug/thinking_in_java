package com.annotations;

import com.annotations.ano.UseCase;

import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Lishiyan
 * @date 2021/9/118:39
 */
public class UseCaseTracker {

    public static void trackUseCase(List<Integer> useCase, Class<?> clazz) {
        for (Method declaredMethod : clazz.getDeclaredMethods()) {
            UseCase annotation = declaredMethod.getAnnotation(UseCase.class);
            if (annotation != null) {
                System.out.println("Found Use Case " +
                        annotation.id() + "\n " + annotation.description());
            }
        }
        useCase.forEach(integer -> System.out.println("Missing use case " + integer));
    }

    public static void main(String[] args) {
        List<Integer> collect = IntStream.range(47, 51).boxed().collect(Collectors.toList());
        trackUseCase(collect,PasswordUtils.class);
    }
}
