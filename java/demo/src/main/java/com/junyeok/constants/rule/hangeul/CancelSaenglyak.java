package com.junyeok.constants.rule.hangeul;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CancelSaenglyak {
    ㄴ,
    ㄷ,
    ㅁ,
    ㅂ,
    ㅈ,
    ㅋ,
    ㅌ,
    ㅍ,
    ㅎ;

    public static boolean exists(char choseong) {
        for (CancelSaenglyak ae : CancelSaenglyak.values()) {
            if (ae.name().equals(choseong + "")) {
                return true;
            }
        }
        return false;
    }
}