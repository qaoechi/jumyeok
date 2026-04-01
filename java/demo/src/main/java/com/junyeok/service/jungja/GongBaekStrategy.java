package com.junyeok.service.jungja;

import com.junyeok.model.Geul;
import com.junyeok.model.braille.BrailleToken;
import com.junyeok.model.braille.TokenType;

public class GongBaekStrategy implements JungJaStrategy {

    @Override
    public BrailleToken uncontracted(Geul geul) {
        return new BrailleToken(
            String.valueOf(geul.getChar()),
            TokenType.GONGBAEK,
            geul);
    }
}