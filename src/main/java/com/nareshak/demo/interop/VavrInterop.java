package com.nareshak.demo.interop;

import com.nareshak.demo.data.DataProvider;
import com.nareshak.demo.data.Developer;
import io.vavr.collection.Array;
import io.vavr.collection.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class VavrInterop {
    public static void main(String[] args) {
        List<Developer> developers = DataProvider.getSampleListOfDevelopers();

        Stream<Developer> devStream = Stream.ofAll(developers);
        System.out.println(devStream);

        System.out.println(devStream.toJavaList());

        devStream
                .toJavaStream()
                .forEach(System.out::println);

        devStream
                .toJavaParallelStream()
                .forEach(System.out::println);


        io.vavr.collection.List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5)
                .stream()
                .collect(io.vavr.collection.List.collector());
        System.out.println(numbers);

        System.out.println(numbers.asJava());

    }
}
