package com.nareshak.demo.data;

import io.vavr.collection.Stream;
import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.ImmutableList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataProvider {

    public static List<Developer> getSampleListOfDevelopers() {
        List<Developer> developers = new ArrayList<>();
        developers.add(new Developer("Raj", 30, Arrays.asList("Java", "JavaScript")));
        developers.add(new Developer("Meena", 24, Arrays.asList("Java", "Groovy", "Scala")));
        developers.add(new Developer("Mark", 28, Arrays.asList("Java", "JavaScript", "Groovy")));
        return developers;
    }

    public static Stream<Developer> getVavrStreamOfDevelopers() {
        Stream<Developer> developers = Stream.of(
                new Developer("Raj", 30, Arrays.asList("Java", "JavaScript")),
                new Developer("Meena", 24, Arrays.asList("Java", "Groovy", "Scala")),
                new Developer("Mark", 28, Arrays.asList("Java", "JavaScript", "Groovy"))
        );
        return developers;
    }

    public static ImmutableList<Developer> getECDevelopers() {
        ImmutableList<Developer> developers = Lists.immutable.of(
                new Developer("Raj", 30, Arrays.asList("Java", "JavaScript")),
                new Developer("Meena", 24, Arrays.asList("Java", "Groovy", "Scala")),
                new Developer("Mark", 28, Arrays.asList("Java", "JavaScript", "Groovy"))
        );
        return developers;
    }

}
