package com.junyeok.utils.transcriptor;

import com.junyeok.constants.hangeulJumja.JongSeong;

public final class JongseongTranscription {
    public static char getJongseongBraille(char c) {
        return JongSeong.fromChar(c) != null ? JongSeong.fromChar(c).getJongseong() : c;
    }
}
