package com.junyeok.constants.hangeulJumja;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum JungSeong {
    ㅏ('ㅏ', "⠣"),
    ㅐ('ㅐ', "⠗"),
    ㅑ('ㅑ', "⠜"),
    ㅒ('ㅒ', "⠜⠗"),
    ㅓ('ㅓ', "⠎"),
    ㅔ('ㅔ', "⠝"),
    ㅕ('ㅕ', "⠱"),
    ㅖ('ㅖ', "⠌"),
    ㅗ('ㅗ', "⠥"),
    ㅘ('ㅘ', "⠧"),
    ㅙ('ㅙ', "⠧⠗"),
    ㅚ('ㅚ', "⠽"),
    ㅛ('ㅛ', "⠬"),
    ㅜ('ㅜ', "⠍"),
    ㅝ('ㅝ', "⠏"),
    ㅞ('ㅞ', "⠏⠗"),
    ㅟ('ㅟ', "⠍⠗"),
    ㅠ('ㅠ', "⠩"),
    ㅡ('ㅡ', "⠪"),
    ㅢ('ㅢ', "⠺"),
    ㅣ('ㅣ', "⠕");

    private final char origin;
    private final String jungseong;
    private static final Map<Character, JungSeong> JUNGSEONG_MAP =
        Arrays.stream(values())
            .collect((Collectors.toMap(s -> s.origin, s -> s)));

    public static JungSeong fromChar(char jungseong) {
        return JUNGSEONG_MAP.get(jungseong);
    }
}