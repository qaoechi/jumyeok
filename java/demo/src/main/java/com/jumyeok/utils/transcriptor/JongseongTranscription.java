package com.jumyeok.utils.transcriptor;

import com.jumyeok.constants.hangeul.jumja.Jongseong;

public final class JongseongTranscription {
    public static char getBraille(char c) {
        return Jongseong.fromChar(c) != null ? Jongseong.fromChar(c).getBraille() : c;
    }
}
