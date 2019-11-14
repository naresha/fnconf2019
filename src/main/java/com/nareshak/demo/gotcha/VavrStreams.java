package com.nareshak.demo.gotcha;

import com.nareshak.demo.data.DataProvider;
import com.nareshak.demo.data.Developer;
import io.vavr.collection.Stream;

import java.util.function.Function;

public class VavrStreams {
    public static void main(String[] args) {
        Stream<Developer> developers = DataProvider.getVavrStreamOfDevelopers();

        developers
                .filter(developer11 -> developer11.getAge() < 30)
                .filter(developer11 -> developer11.getName().startsWith("M"))
                .forEach(System.out::println);

        developers
                .filter(developer1 -> developer1.getAge() < 30)
                .filter(developer1 -> developer1.getName().startsWith("M"))
                .flatMap(developer -> Stream.ofAll(developer.getLanguages()))
                .distinct()
                .forEach(System.out::println);

        System.out.println("isTraversableAgain? " + developers.isTraversableAgain());
    }
}
