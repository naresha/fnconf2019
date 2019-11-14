package com.nareshak.demo.immutability;

import com.nareshak.demo.data.Developer;
import io.vavr.collection.List;

import java.util.Arrays;

public class VavrImmutability {
    public static void main(String[] args) {
        List<Developer> developers = List.of(new Developer("Raj", 30, Arrays.asList("Java", "JavaScript")),
                new Developer("Meena", 24, Arrays.asList("Java", "Groovy", "Scala")),
                new Developer("Mark", 28, Arrays.asList("Java", "JavaScript", "Groovy")));

        List<Developer> newDevs = developers.append(new Developer("Raju", 28, Arrays.asList("Java", "JavaScript", "Groovy")));
        System.out.println(newDevs);
        System.out.println(developers);
    }
}
