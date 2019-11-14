package com.nareshak.demo.lazy;

import com.nareshak.demo.data.Developer;
import io.vavr.collection.List;
import io.vavr.collection.Stream;
import io.vavr.control.Option;

import java.util.Arrays;
import java.util.function.Predicate;

public class VavrLazy {
    public static void main(String[] args) {
        List<Developer> developers = List.of(
                new Developer("Raj", 30, Arrays.asList("Java", "JavaScript")),
                new Developer("Meena", 24, Arrays.asList("Java", "Groovy", "Scala")),
                new Developer("Mark", 28, Arrays.asList("Java", "JavaScript", "Groovy")),
                new Developer("Reema", 27, Arrays.asList("Java", "JavaScript", "Groovy")));

        Predicate<Developer> youngerThan30 = developer -> {
            System.out.println("age<30? " + developer);
            return developer.getAge() < 30;
        };

        Predicate<Developer> olderThan24 = developer -> {
            System.out.println("age>24? " + developer);
            return developer.getAge() > 24;
        };

        Option<Developer> devYoungerThan30AndOlderThan24 = developers
                //.toStream()
                .filter(youngerThan30)
                .find(olderThan24);
        System.out.println(devYoungerThan30AndOlderThan24);

        // Constructions of streams
        Stream<Developer> devs = Stream.of(
                new Developer("Raj", 30, Arrays.asList("Java", "JavaScript")),
                new Developer("Meena", 24, Arrays.asList("Java", "Groovy", "Scala")),
                new Developer("Mark", 28, Arrays.asList("Java", "JavaScript", "Groovy")),
                new Developer("Reema", 27, Arrays.asList("Java", "JavaScript", "Groovy"))
        );
        System.out.println(devs);

        Stream<Integer> evenNumbers = Stream.from(1).filter(number -> number % 2 == 0);
        System.out.println("Even Numbers: " + evenNumbers);
        System.out.println(evenNumbers.take(10).max());
    }
}
