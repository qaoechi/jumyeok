package com.junyeok.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SsangJaEum {
    ㄲ("ㄱ"),
    ㄸ("ㄷ"),
    ㅃ("ㅂ"),
    ㅆ("ㅅ"),
    ㅉ("ㅈ");

    private final String c;

    public static boolean exists(String c) {
        for (SsangJaEum s : values()) {
            if (s.name().equals(c)) return true;
        }
        return false;
    }
    public static SsangJaEum fromChar(String c) {
        for (SsangJaEum s : values()) {
            if (s.name().equals(c)) return s;
        }
        return null;
    }
}