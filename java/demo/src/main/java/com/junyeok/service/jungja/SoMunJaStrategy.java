package com.junyeok.service.jungja;

import com.junyeok.constants.otherBraille.SoMunJa;
import com.junyeok.model.Geul;
import com.junyeok.model.braille.BrailleToken;
import com.junyeok.model.braille.TokenType;

public class SoMunJaStrategy implements JungJaStrategy {

    @Override
    public BrailleToken uncontracted(Geul geul) {
        return new BrailleToken(
            String.valueOf(SoMunJa.fromChar(geul.getChar()).getBraille()),
            TokenType.SOMUNJA,
            geul);
    }
}