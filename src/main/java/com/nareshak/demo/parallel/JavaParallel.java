package com.nareshak.demo.parallel;

import java.util.List;
import java.util.stream.Collectors;

public class JavaParallel {
    public static void main(String[] args) {
        List<Integer> result = List.of(1, 2, 3, 4, 5, 6, 7, 8)
                .stream()
                //.parallelStream()
                .map(number -> {
                    System.out.println(Thread.currentThread() + ": " + number);
                    return number + 1;
                })
                .collect(Collectors.toList());
        System.out.println(result);
    }
}
