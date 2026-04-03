package com.junyeok.constants.hangeul.mukja;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DoenSori {
    ㄲ('ㄲ', 'ㄱ'),
    ㄸ('ㄸ', 'ㄷ'),
    ㅃ('ㅃ', 'ㅂ'),
    ㅆ('ㅆ', 'ㅅ'),
    ㅉ('ㅉ', 'ㅈ');

    private final char origin;
    private final char jaeum;
    private static final Map<Character, DoenSori> MAP =
        Arrays.stream(values())
            .collect((Collectors.toMap(s -> s.origin, s -> s)));

    public static DoenSori fromChar(char jaeum) {
        return MAP.get(jaeum);
    }
}