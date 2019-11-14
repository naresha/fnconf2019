package com.nareshak.demo.lazy;

import com.nareshak.demo.data.DataProvider;
import com.nareshak.demo.data.Developer;

import java.util.List;

public class JavaLazy {
    public static void main(String[] args) {
        List<Developer> developers = DataProvider.getSampleListOfDevelopers();
        String devYoungerThan30 = developers
                .stream()
                .peek(developer -> System.out.println("age < 30 check for " + developer.getName()))
                .filter(developer -> developer.getAge() < 30)
                .peek(developer -> System.out.println("Map to name for " + developer.getName()))
                .map(developer -> developer.getName())
                .findFirst()
                .orElse("NA");
        System.out.println(devYoungerThan30);
    }
}
