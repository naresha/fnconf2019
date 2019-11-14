package com.nareshak.demo.hello;

import com.nareshak.demo.data.Developer;
import io.vavr.collection.List;

import java.util.Arrays;
import java.util.function.Function;

public class HelloVavr {

    public static List<Developer> getSampleData() {
        List<Developer> developers = List.of(
                new Developer("Raj", 30, Arrays.asList("Java", "JavaScript")),
                new Developer("Meena", 24, Arrays.asList("Java", "Groovy", "Scala")),
                new Developer("Mark", 28, Arrays.asList("Java", "JavaScript", "Groovy")));
        return developers;
    }

    public static void main(String[] args) {
        List<Developer> developers = getSampleData();

        List<Developer> developersYoungerThan30 = developers
                .filter(developer -> developer.getAge() < 30);
        System.out.println(developersYoungerThan30);

        String namesOfDevelopers = developers
                .map(developer -> developer.getName())
                .intersperse(", ")
                .reduce((v1, v2) -> v1 + v2);
        System.out.println(namesOfDevelopers);

        List<String> languagesKnown = developers
                .map(developer -> developer.getLanguages())
                .flatMap(Function.identity())
                .distinct();
        System.out.println(languagesKnown);
    }
}
