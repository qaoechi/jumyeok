package com.jumyeok.constants.hangeul.yakja;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Eong {
    ㅅ('ㅅ', '⠠'),
    ㅈ('ㅈ', '⠨'),
    ㅊ('ㅊ', '⠰');

    private final char choseong;
    private final char braille;
    private static final Map<Character, Eong> MAP =
        Arrays.stream(values())
            .collect((Collectors.toMap(s -> s.choseong, s -> s)));

    public static Eong fromChar(char choseong) {
        return MAP.get(choseong);
    }
}