package com.nareshak.demo.hello;

import com.nareshak.demo.data.Developer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Hello {

    public static void populateData(List<Developer> developers) {
        developers.add(new Developer("Raj", 30, Arrays.asList("Java", "JavaScript")));
        developers.add(new Developer("Meena", 24, Arrays.asList("Java", "Groovy", "Scala")));
        developers.add(new Developer("Mark", 28, Arrays.asList("Java", "JavaScript", "Groovy")));
    }

    public static void main(String[] args) {
        List<Developer> developers = new ArrayList<>();
        populateData(developers);

        List<Developer> developerYoungerThan30Years = developers
                .stream()
                .filter(developer -> developer.getAge() < 30)
                .collect(Collectors.toList());
        System.out.println(developerYoungerThan30Years);

        String namesOfDevelopersSeparatedByComma = developers
                .stream()
                .map(developer -> developer.getName())
                .collect(Collectors.joining(", "));
        System.out.println(namesOfDevelopersSeparatedByComma);

        Set<String> languagesKnown = developers
                .stream()
                .map(developer -> developer.getLanguages())
                .flatMap(List::stream)
                .collect(Collectors.toSet());
        System.out.println(languagesKnown);
        
    }
}
