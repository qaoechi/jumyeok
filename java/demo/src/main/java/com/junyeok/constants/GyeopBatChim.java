package com.junyeok.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum GyeopBatChim {
    ㄲ("ㄱ", "ㄱ"),
    ㄳ("ㄱ", "ㅅ"),
    ㄵ("ㄴ", "ㅈ"),
    ㄶ("ㄴ", "ㅎ"),
    ㄺ("ㄹ", "ㄱ"),
    ㄻ("ㄹ", "ㅁ"),
    ㄼ("ㄹ", "ㅂ"),
    ㄽ("ㄹ", "ㅅ"),
    ㄾ("ㄹ", "ㅌ"),
    ㄿ("ㄹ", "ㅍ"),
    ㅀ("ㄹ", "ㅎ"),
    ㅄ("ㅂ", "ㅅ"),
    ㅆ("ㅅ", "ㅅ");

    private final String first;
    private final String second;

    public static GyeopBatChim fromChar(String batchim) {
        for (GyeopBatChim g : values()) {
            if (g.name().equals(batchim)) return g;
        }
        return null;
    }
}