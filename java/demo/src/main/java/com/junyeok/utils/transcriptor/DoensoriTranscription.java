package com.junyeok.utils.transcriptor;

import com.junyeok.constants.hangeulJumja.DoenSoRi;

public final class DoensoriTranscription {
    public static char getDoensoriBraille(char c) {
        return c != '\0' ? DoenSoRi.쌍.getDoen() : c;
    }
}
