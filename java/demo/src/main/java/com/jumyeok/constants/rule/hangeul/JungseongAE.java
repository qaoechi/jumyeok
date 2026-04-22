package com.jumyeok.constants.rule.hangeul;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum JungseongAE {
    ㅑ,
    ㅘ,
    ㅝ,
    ㅜ;

    public static boolean exists(char jungseong) {
        for (JungseongAE ae : JungseongAE.values()) {
            if (ae.name().equals(jungseong + "")) {
                return true;
            }
        }
        return false;
    }
}