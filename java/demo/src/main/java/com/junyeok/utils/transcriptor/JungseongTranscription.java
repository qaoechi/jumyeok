package com.junyeok.utils.transcriptor;

import com.junyeok.constants.hangeulJumja.JungSeong;

public final class JungseongTranscription {
    public static String getJungseongBraille(char c) {
        return JungSeong.fromChar(c) != null ? JungSeong.fromChar(c).getJungseong() : "";
    }
}
