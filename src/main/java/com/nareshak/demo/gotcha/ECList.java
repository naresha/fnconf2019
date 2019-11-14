package com.nareshak.demo.gotcha;

import com.nareshak.demo.data.DataProvider;
import com.nareshak.demo.data.Developer;
import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.api.list.ImmutableList;

public class ECList {
    public static void main(String[] args) {
        ImmutableList<Developer> developers = DataProvider.getECDevelopers();

        developers
                .asLazy()
                .select(developer11 -> developer11.getAge() < 30)
                .select(developer11 -> developer11.getName().startsWith("M"))
                .forEach(System.out::println);

        developers
                .asLazy()
                .select(developer1 -> developer1.getAge() < 30)
                .select(developer1 -> developer1.getName().startsWith("M"))
                .flatCollect(developer -> developer.getLanguages())
                .distinct()
                .forEach(System.out::println);

    }
}
