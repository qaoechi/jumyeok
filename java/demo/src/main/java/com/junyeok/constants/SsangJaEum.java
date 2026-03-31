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

    private final String jaeum;

    public static SsangJaEum fromChar(String jaeum) {
        for (SsangJaEum s : values()) {
            if (s.name().equals(jaeum)) return s;
        }
        return null;
    }
}