package com.junyeok.service.jungja;

import com.junyeok.constants.otherBraille.SutJa;
import com.junyeok.model.Geul;
import com.junyeok.model.braille.BrailleToken;
import com.junyeok.model.braille.TokenType;

public class SutJaStrategy implements JungJaStrategy {

    @Override
    public BrailleToken uncontracted(Geul geul) {
        return new BrailleToken(
            String.valueOf(SutJa.fromChar(geul.getChar()).getBraille()),
            TokenType.SUTJA,
            geul);
    }
}