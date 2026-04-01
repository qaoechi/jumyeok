package com.junyeok.constants.hangeul;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SsangJaEum {
    ㄲ('ㄲ', 'ㄱ'),
    ㄸ('ㄸ', 'ㄷ'),
    ㅃ('ㅃ', 'ㅂ'),
    ㅆ('ㅆ', 'ㅅ'),
    ㅉ('ㅉ', 'ㅈ');

    private final char origin;
    private final char jaeum;
    private static final Map<Character, SsangJaEum> GYEOP_MAP =
        Arrays.stream(values())
            .collect((Collectors.toMap(s -> s.origin, s -> s)));

    public static SsangJaEum fromChar(char jaeum) {
        return GYEOP_MAP.get(jaeum);
    }
}