package com.junyeok.constants.otherBraille;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BuHo {
    붙임표('-', "⠤"),
    우측화살표('→', "⠒⠕"),
    좌측화살표('←', "⠪⠒"),
    가운뎃점('·', "⠐⠆");

    private final char symbol;
    private final String braille;
    private static final Map<Character, BuHo> munja =
        Arrays.stream(values())
            .collect((Collectors.toMap(BuHo::getSymbol, s -> s)));

    public static BuHo fromChar(char a) {
        return munja.get(a);
    }
}