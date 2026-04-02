package com.junyeok.constants.yakja;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BatChimSaengLyak {
    억("ㅓㄱ", '⠹'),
    언("ㅓㄴ", '⠾'),
    얼("ㅓㄹ", '⠞'),
    연("ㅕㄴ", '⠡'),
    열("ㅕㄹ", '⠳'),
    영("ㅕㅇ", '⠻'),
    옥("ㅗㄱ", '⠭'),
    온("ㅗㄴ", '⠷'),
    옹("ㅗㅇ", '⠿'),
    운("ㅜㄴ", '⠛'),
    울("ㅜㄹ", '⠯'),
    은("ㅡㄴ", '⠮'),
    을("ㅡㄹ", '⠵'),
    인("ㅣㄴ", '⠟');

    private final String key;
    private final char aSaengLyak;
    private static final Map<String, BatChimSaengLyak> BATCHIMSAENGLYAK_MAP =
        Arrays.stream(values())
            .collect((Collectors.toMap(s -> s.key, s -> s)));

    public static BatChimSaengLyak fromChar(String key) {
        return BATCHIMSAENGLYAK_MAP.get(key);
    }
}