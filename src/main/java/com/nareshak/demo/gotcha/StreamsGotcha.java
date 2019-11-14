package com.nareshak.demo.gotcha;

import com.nareshak.demo.data.DataProvider;
import com.nareshak.demo.data.Developer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsGotcha {
    public static void main(String[] args) {
        List<Developer> developers = DataProvider.getSampleListOfDevelopers();

        try {
            List<Developer> developersYoungerThan30WhoseNameStartsWithM = developers
                    .stream()
                    .filter(developer11 -> developer11.getAge() < 30)
                    .filter(developer11 -> developer11.getName().startsWith("M"))
                    .collect(Collectors.toList());
            System.out.println(developersYoungerThan30WhoseNameStartsWithM);

            List<String> languagesKnownByMDevelopersYoungerThan30 = developers
                    .stream()
                    .filter(developer1 -> developer1.getAge() < 30)
                    .filter(developer1 -> developer1.getName().startsWith("M"))
                    .map(developer -> developer.getLanguages())
                    .flatMap(List::stream)
                    .distinct()
                    .collect(Collectors.toList());
            System.out.println(languagesKnownByMDevelopersYoungerThan30);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
