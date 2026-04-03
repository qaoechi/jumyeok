package com.junyeok.utils.transcriptor;

import com.junyeok.constants.hangeul.jumja.Jungseong;

public final class JungseongTranscription {
    public static String getBraille(String c) {
        return Jungseong.fromChar(c) != null ? Jungseong.fromChar(c).getBraille() : "";
    }
}
