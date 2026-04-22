package com.jumyeok.constants.hangeul.jumja;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Jongseong {
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
    private final char braille;
    private static final Map<Character, Jongseong> MAP =
        Arrays.stream(values())
            .collect((Collectors.toMap(s -> s.origin, s -> s)));

    public static Jongseong fromChar(char jongseong) {
        return MAP.get(jongseong);
    }
}