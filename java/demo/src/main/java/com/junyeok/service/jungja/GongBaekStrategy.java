package com.junyeok.service.jungja;

import com.junyeok.model.braille.BrailleToken;
import com.junyeok.model.braille.TokenType;
import com.junyeok.model.mukja.Geul;

public class GongbaekStrategy implements JungjaStrategy {

    @Override
    public BrailleToken uncontracted(Geul geul) {
        return new BrailleToken(
            String.valueOf(geul.getChar()),
            TokenType.GONGBAEK,
            geul,
            false);
    }
}