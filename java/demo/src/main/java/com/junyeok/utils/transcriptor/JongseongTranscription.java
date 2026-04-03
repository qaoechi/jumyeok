package com.junyeok.utils.transcriptor;

import com.junyeok.constants.hangeul.jumja.Jongseong;

public final class JongseongTranscription {
    public static char getBraille(char c) {
        return Jongseong.fromChar(c) != null ? Jongseong.fromChar(c).getBraille() : c;
    }
}
