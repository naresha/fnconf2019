package com.nareshak.demo.hello;

import com.nareshak.demo.data.Developer;
import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.MutableList;

import java.util.Arrays;
import java.util.List;

public class HelloEC {

    public static MutableList<Developer> getSampleData() {
        MutableList<Developer> developers = Lists.mutable.of(
                new Developer("Raj", 30, Arrays.asList("Java", "JavaScript")),
                new Developer("Meena", 24, Arrays.asList("Java", "Groovy", "Scala")),
                new Developer("Mark", 28, Arrays.asList("Java", "JavaScript", "Groovy"))
        );
        return developers;
    }

    public static void main(String[] args) {
        MutableList<Developer> developers = getSampleData();
//        System.out.println(developers.getClass());
        MutableList<Developer> developersYoungerThan30 =
                developers
                        .select(developer -> developer.getAge() < 30);
        System.out.println("Age < 30: " + developersYoungerThan30);
        System.out.println("All Devs: " + developers);

        MutableList<Developer> developersYoungerThan30Alternate =
                developers
                        .reject(developer -> developer.getAge() >= 30);
        System.out.println("Age < 30: " + developersYoungerThan30Alternate);

        String namesOfDevelopers = developers
                .collect(developer -> developer.getName())
                .makeString(", ");
        System.out.println("Names: " + namesOfDevelopers);

        MutableList<String> languages = developers
                .flatCollect(developer ->
                        Lists.mutable.ofAll(developer.getLanguages()))
                .distinct();
        System.out.println(languages);


    }
}
