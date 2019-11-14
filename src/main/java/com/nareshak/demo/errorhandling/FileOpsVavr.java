package com.nareshak.demo.errorhandling;

import io.vavr.collection.Stream;
import io.vavr.control.Either;
import io.vavr.control.Try;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Function;

public class FileOpsVavr {
    public static void main(String[] args) {
        Stream.of(10, 20, 30, 40)
                .map(number -> number.toString() + ".txt")
                .map(path -> Paths.get("./", path))
                .map(value -> Try.of(() -> readContent(value)))
                //.flatMap(Function.identity())
                .forEach(System.out::println);

        System.out.println();

       /* Stream.of(10, 20, 30, 40)
                .map(number -> number.toString() + ".txt")
                .map(path -> Paths.get("./", path))
                .map(value ->
                        Try.of(() -> readContent(value))
                                .recover(java.nio.file.NoSuchFileException.class, "Missing File")
                )
                .flatMap(Function.identity())
                .map(value -> value.trim())
                .map(value -> Try.of(() -> lookup(value))
                        .recover(IllegalArgumentException.class, "No File")
                        .recover(exception -> "No Value " + value)

                )
                .flatMap(Function.identity())
                .forEach(System.out::println);*/

        System.out.println();
        /*Stream.of(10, 20, 30, 40)
                .map(number -> number.toString() + ".txt")
                .map(path -> Paths.get("./", path))
                .map(value ->
                        Try.of(() -> readContent(value))
                                .recover(java.nio.file.NoSuchFileException.class, "Missing File")
                )
                .flatMap(Function.identity())
                .map(value -> value.trim())
                .map(value -> Try.of(() -> lookup(value))
                        .map(v -> Either.<String, String>right(v))
                        .recover(IllegalArgumentException.class, Either.left("Missing File"))
                        .recover(RuntimeException.class, Either.left("NOT AVAILABLE"))
                )
                .flatMap(Function.identity())
                .map ( value -> value.map(v -> "> " + v))
                .map(value -> value.isRight() ? value.get() : value.getLeft())
                .forEach(System.out::println);
*/

    }

    public static String readContent(Path path) throws IOException {
        return Files.newBufferedReader(path).readLine();
    }


    public static String lookup(String value) {
        if (value.equalsIgnoreCase("TEN")) {
            return "10";
        } else if (value.equalsIgnoreCase("Missing File")) {
            throw new IllegalArgumentException("Invalid");
        } else {
            throw new RuntimeException("Unknown Value " + value);
        }
    }

}
