package com.junyeok.utils.transcriptor;

import com.junyeok.constants.hangeul.jumja.Choseong;

public final class ChoseongTranscription {
    public static char getBraille(char c) {
        return Choseong.fromChar(c) != null ? Choseong.fromChar(c).getBraille() : c;
    }
}
