package com.junyeok.constants.other;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Sutja {
    일('1', '⠁'),
    이('2', '⠃'),
    삼('3', '⠉'),
    사('4', '⠙'),
    오('5', '⠑'),
    육('6', '⠋'),
    칠('7', '⠛'),
    팔('8', '⠓'),
    구('9', '⠊'),
    영('0', '⠚');

    private final char number;
    private final char braille;
    private static final Map<Character, Sutja> MAP =
        Arrays.stream(values())
            .collect((Collectors.toMap(Sutja::getNumber, s -> s)));

    public static Sutja fromChar(char a) {
        return MAP.get(a);
    }
}