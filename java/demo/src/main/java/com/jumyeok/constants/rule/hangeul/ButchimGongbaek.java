package com.jumyeok.constants.rule.hangeul;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ButchimGongbaek {
    ㄴ,
    ㄷ,
    ㅁ,
    ㅋ,
    ㅌ,
    ㅍ,
    ㅎ,
    ㅜㄴ;

    public static boolean exists(String first) {
        for (ButchimGongbaek e : ButchimGongbaek.values()) {
            if (e.name().equals(first)) {
                return true;
            }
        }
        return false;
    }
}