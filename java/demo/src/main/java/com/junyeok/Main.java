package com.junyeok;

import java.util.ArrayList;
import java.util.List;

import com.junyeok.model.Geul;

public class Main {
    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        input.add("asd");
        input.add("쀍");

        for (Geul geul : createToken(input)) {
            System.out.println(geul.render());
        }
    }
}