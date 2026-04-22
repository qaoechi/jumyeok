package com.jumyeok.constants.hangeul.mukja;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum GyeopBatchim {
    ㄲ('ㄲ', 'ㄱ', 'ㄱ'),
    ㄳ('ㄳ', 'ㄱ', 'ㅅ'),
    ㄵ('ㄵ', 'ㄴ', 'ㅈ'),
    ㄶ('ㄶ', 'ㄴ', 'ㅎ'),
    ㄺ('ㄺ', 'ㄹ', 'ㄱ'),
    ㄻ('ㄻ', 'ㄹ', 'ㅁ'),
    ㄼ('ㄼ', 'ㄹ', 'ㅂ'),
    ㄽ('ㄽ', 'ㄹ', 'ㅅ'),
    ㄾ('ㄾ', 'ㄹ', 'ㅌ'),
    ㄿ('ㄿ', 'ㄹ', 'ㅍ'),
    ㅀ('ㅀ', 'ㄹ', 'ㅎ'),
    ㅄ('ㅄ', 'ㅂ', 'ㅅ'),
    ㅆ('ㅆ', 'ㅅ', 'ㅅ');

    private final char origin;
    private final char first;
    private final char second;
    
    private static final Map<Character, GyeopBatchim> MAP =
        Arrays.stream(values())
            .collect((Collectors.toMap(s -> s.origin, s -> s)));

    public static GyeopBatchim fromChar(char batchim) {
        return MAP.get(batchim);
    }
}