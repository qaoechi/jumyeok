package com.junyeok.service.jungja;

import com.junyeok.constants.other.Sutja;
import com.junyeok.model.braille.BrailleToken;
import com.junyeok.model.braille.TokenType;
import com.junyeok.model.mukja.Geul;

public class SutjaStrategy implements JungjaStrategy {

    @Override
    public BrailleToken uncontracted(Geul geul) {
        return new BrailleToken(
            Sutja.fromChar(geul.getChar()).getBraille(),
            TokenType.SUTJA,
            geul,
            false);
    }
}