package com.junyeok.constants.hangeulJumja;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum JongSeong {
    ㄱ('ㄱ', '⠁'),
    ㄴ('ㄴ', '⠒'),
    ㄷ('ㄷ', '⠔'),
    ㄹ('ㄹ', '⠂'),
    ㅁ('ㅁ', '⠢'),
    ㅂ('ㅂ', '⠃'),
    ㅅ('ㅅ', '⠄'),
    ㅇ('ㅇ', '⠶'),
    ㅈ('ㅈ', '⠅'),
    ㅊ('ㅊ', '⠆'),
    ㅋ('ㅋ', '⠖'),
    ㅌ('ㅌ', '⠦'),
    ㅍ('ㅍ', '⠲'),
    ㅎ('ㅎ', '⠴');

    private final char origin;
    private final char jongseong;
    private static final Map<Character, JongSeong> JONGSEONG_MAP =
        Arrays.stream(values())
            .collect((Collectors.toMap(s -> s.origin, s -> s)));

    public static JongSeong fromChar(char jongseong) {
        return JONGSEONG_MAP.get(jongseong);
    }
}