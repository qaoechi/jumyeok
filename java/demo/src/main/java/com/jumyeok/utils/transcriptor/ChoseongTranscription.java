package com.jumyeok.utils.transcriptor;

import com.jumyeok.constants.hangeul.jumja.Choseong;

public final class ChoseongTranscription {
    public static char getBraille(char c) {
        return Choseong.fromChar(c) != null ? Choseong.fromChar(c).getBraille() : c;
    }
}
