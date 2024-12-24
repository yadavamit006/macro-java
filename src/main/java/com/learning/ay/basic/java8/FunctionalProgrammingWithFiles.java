package com.learning.ay.basic.java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FunctionalProgrammingWithFiles {
    public static void main(String[] args)  {

        try {
            Files.lines(Paths.get("dummy.txt"))
                    .map(s->s.split(" "))
                    .flatMap(Arrays::stream)
                    .distinct()
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}