package com.nareshak.demo.immutability;

import com.nareshak.demo.data.DataProvider;
import com.nareshak.demo.data.Developer;

import java.util.Arrays;
import java.util.List;

public class JavaMutability {
    public static void main(String[] args) {
        List<Developer> developers = DataProvider.getSampleListOfDevelopers();
        try {
            developers
                    .stream()
                    .filter(developer -> developer.getAge() >= 30)
                    .peek(developers::remove)
                    .forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //  Immutable List
       /* try {
            List<Developer> devs = List.of(
                    new Developer("Raj", 30, Arrays.asList("Java", "JavaScript")),
                    new Developer("Meena", 24, Arrays.asList("Java", "Groovy", "Scala")),
                    new Developer("Mark", 28, Arrays.asList("Java", "JavaScript", "Groovy"))
            );
            devs.add(new Developer("Raju", 28, Arrays.asList("Java", "JavaScript", "Groovy")));
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
