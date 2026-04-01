package com.junyeok.service.jungja;

import com.junyeok.constants.otherBraille.BuHo;
import com.junyeok.model.Geul;
import com.junyeok.model.braille.BrailleToken;
import com.junyeok.model.braille.TokenType;

public class BuHoStrategy implements JungJaStrategy {

    @Override
    public BrailleToken uncontracted(Geul geul) {
        return new BrailleToken(
            BuHo.fromChar(geul.getChar()).getBraille(),
            TokenType.BUHO,
            geul);
    }
}