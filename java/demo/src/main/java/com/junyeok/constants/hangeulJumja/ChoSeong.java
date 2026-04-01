package com.junyeok.constants.hangeulJumja;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ChoSeong {
    ㄱ('ㄱ', '⠈'),
    ㄴ('ㄴ', '⠉'),
    ㄷ('ㄷ', '⠊'),
    ㄹ('ㄹ', '⠐'),
    ㅁ('ㅁ', '⠑'),
    ㅂ('ㅂ', '⠘'),
    ㅅ('ㅅ', '⠠'),
    ㅇ('ㅇ', '\0'),
    ㅈ('ㅈ', '⠨'),
    ㅊ('ㅊ', '⠰'),
    ㅋ('ㅋ', '⠋'),
    ㅌ('ㅌ', '⠓'),
    ㅍ('ㅍ', '⠙'),
    ㅎ('ㅎ', '⠚');

    private final char origin;
    private final char choseong;
    private static final Map<Character, ChoSeong> GYEOP_MAP =
        Arrays.stream(values())
            .collect((Collectors.toMap(s -> s.origin, s -> s)));

    public static ChoSeong fromChar(char choseong) {
        return GYEOP_MAP.get(choseong);
    }
}