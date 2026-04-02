package com.junyeok.constants.yakja;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ASaengLyak {
    가('ㄱ', '⠫'),
    나('ㄴ', '⠉'),
    다('ㄷ', '⠑'),
    마('ㅁ', '⠊'),
    바('ㅂ', '⠘'),
    사('ㅅ', '⠇'),
    자('ㅈ', '⠨'),
    카('ㅋ', '⠋'),
    타('ㅌ', '⠓'),
    파('ㅍ', '⠙'),
    하('ㅎ', '⠚');

    private final char choseong;
    private final char aSaengLyak;
    private static final Map<Character, ASaengLyak> ASAENGLYAK_MAP =
        Arrays.stream(values())
            .collect((Collectors.toMap(s -> s.choseong, s -> s)));

    public static ASaengLyak fromChar(char choseong) {
        return ASAENGLYAK_MAP.get(choseong);
    }
}