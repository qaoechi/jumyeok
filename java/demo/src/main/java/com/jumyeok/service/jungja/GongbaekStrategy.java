package com.jumyeok.service.jungja;

import com.jumyeok.model.braille.BrailleToken;
import com.jumyeok.model.braille.TokenType;
import com.jumyeok.model.mukja.Geul;

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