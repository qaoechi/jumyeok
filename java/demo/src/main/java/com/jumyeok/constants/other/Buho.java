package com.jumyeok.constants.other;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Buho {
    붙임표('-', "⠤"),
    우측화살표('→', "⠒⠕"),
    좌측화살표('←', "⠪⠒"),
    가운뎃점('·', "⠐⠆");

    private final char symbol;
    private final String braille;
    private static final Map<Character, Buho> MAP =
        Arrays.stream(values())
            .collect((Collectors.toMap(Buho::getSymbol, s -> s)));

    public static Buho fromChar(char a) {
        return MAP.get(a);
    }
}