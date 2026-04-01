package com.junyeok;

import java.util.ArrayList;
import java.util.List;

import com.junyeok.model.Geul;
import com.junyeok.service.tokenize.GeulTypeResolver;

public class Main {
    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        input.add("as\nd");
        input.add("쀍");
        input.add(" 강의실");

        
        List<Geul> result = input.stream()
            .flatMap(in -> in.chars().mapToObj(c -> (char) c))
            .map(c -> GeulTypeResolver.resolve(c).create(c))
            .toList();


        // result.stream()
        //     .map(Geul::render)
        //     .forEach(System.out::println);
        result.stream()
            .map(Geul::toString)
            .forEach(System.out::println);
    }
}