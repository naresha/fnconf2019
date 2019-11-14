package com.nareshak.demo.immutability;

import com.nareshak.demo.data.Developer;
import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;

import java.util.Arrays;

public class ECMutability {
    public static void main(String[] args) {
        //Mutable version
        MutableList<Developer> developers = Lists.mutable.of(
                new Developer("Raj", 30, Arrays.asList("Java", "JavaScript")),
                new Developer("Meena", 24, Arrays.asList("Java", "Groovy", "Scala"))
        );
        developers.add(new Developer("Mark", 28, Arrays.asList("Java", "JavaScript", "Groovy")));
        System.out.println(developers.getClass());

        //Immutable version
        ImmutableList<Developer> devs = Lists.immutable.of(
                new Developer("Raj", 30, Arrays.asList("Java", "JavaScript")),
                new Developer("Meena", 24, Arrays.asList("Java", "Groovy", "Scala")),
                new Developer("Mark", 28, Arrays.asList("Java", "JavaScript", "Groovy"))
        );
        System.out.println(devs.getClass());
//        devs.add
    }
}
