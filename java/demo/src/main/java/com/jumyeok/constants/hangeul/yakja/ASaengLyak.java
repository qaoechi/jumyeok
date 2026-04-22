package com.jumyeok.constants.hangeul.yakja;

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
    다('ㄷ', '⠊'),
    마('ㅁ', '⠑'),
    바('ㅂ', '⠘'),
    사('ㅅ', '⠇'),
    자('ㅈ', '⠨'),
    카('ㅋ', '⠋'),
    타('ㅌ', '⠓'),
    파('ㅍ', '⠙'),
    하('ㅎ', '⠚');

    private final char choseong;
    private final char braille;
    private static final Map<Character, ASaengLyak> MAP =
        Arrays.stream(values())
            .collect((Collectors.toMap(s -> s.choseong, s -> s)));

    public static ASaengLyak fromChar(char choseong) {
        return MAP.get(choseong);
    }
}