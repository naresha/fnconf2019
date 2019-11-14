package com.nareshak.demo.lazy;

import com.nareshak.demo.data.Developer;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.predicate.Predicate;
import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.ImmutableList;

import java.util.Arrays;

public class ECLazy {
    public static void main(String[] args) {
        ImmutableList<Developer> developers = Lists.immutable.of(
                new Developer("Raj", 30, Arrays.asList("Java", "JavaScript")),
                new Developer("Meena", 24, Arrays.asList("Java", "Groovy", "Scala")),
                new Developer("Mark", 28, Arrays.asList("Java", "JavaScript", "Groovy")),
                new Developer("Reema", 27, Arrays.asList("Java", "JavaScript", "Groovy"))
        );

        System.out.println("Age < 30 and > 24 :" +
                developers
                        //.asLazy()
                        .tap(developer -> System.out.println("age < 30: " + developer))
                        .select(developer -> developer.getAge() < 30)
                        .tap(developer -> System.out.println("age > 24: " + developer))
                        .detect(developer -> developer.getAge() > 24)
                        .getName());

        System.out.println(developers.asLazy().getClass());


        Predicate<Integer> isEven = number -> {
            System.out.println("Even? " + number);
            return number % 2 == 0;
        };

        Function<Integer, Integer> increment = number -> {
            System.out.println("Inc " + number);
            return number + 1;
        };

        Integer result = Lists.immutable.of(1, 2, 3, 4, 5, 6, 7, 8)
                //.asLazy()
                .select(isEven)
                .collect(increment)
                .detect(number -> number > 6);
        System.out.println(result);

    }
}
