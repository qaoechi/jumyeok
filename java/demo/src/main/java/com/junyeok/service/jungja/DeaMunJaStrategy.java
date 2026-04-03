package com.junyeok.service.jungja;

import com.junyeok.constants.yeongeo.SoMunJa;
import com.junyeok.model.braille.BrailleToken;
import com.junyeok.model.braille.TokenType;
import com.junyeok.model.mukja.Geul;

public class DeaMunjaStrategy implements JungjaStrategy {

    @Override
    public BrailleToken uncontracted(Geul geul) {
        return new BrailleToken(
            SoMunJa.fromChar((geul.getChar() + "").toLowerCase()).getBraille(),
            TokenType.DEAMUNJA,
            geul,
            false);
    }
}