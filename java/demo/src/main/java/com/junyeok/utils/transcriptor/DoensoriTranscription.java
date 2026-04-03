package com.junyeok.utils.transcriptor;

import com.junyeok.constants.hangeul.jumja.DoenSoriPyo;

public final class DoensoriTranscription {
    public static char getBraille(char c) {
        return c != '\0' ? DoenSoriPyo.된소리표.getBraille() : c;
    }
}
