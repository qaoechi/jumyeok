package com.junyeok.service.jungja;

import com.junyeok.constants.otherBraille.SoMunJa;
import com.junyeok.model.Geul;
import com.junyeok.model.braille.BrailleToken;
import com.junyeok.model.braille.TokenType;

public class DeaMunJaStrategy implements JungJaStrategy {

    @Override
    public BrailleToken uncontracted(Geul geul) {
        return new BrailleToken(
            String.valueOf(SoMunJa.fromChar(Character.toLowerCase(geul.getChar())).getBraille()),
            TokenType.SOMUNJA,
            geul);
    }
}