package com.junyeok.utils.transcriptor;

import com.junyeok.constants.hangeulJumja.ChoSeong;

public final class ChoseongTranscription {
    public static char getChoseongBraille(char c) {
        return ChoSeong.fromChar(c) != null ? ChoSeong.fromChar(c).getChoseong() : c;
    }
}
