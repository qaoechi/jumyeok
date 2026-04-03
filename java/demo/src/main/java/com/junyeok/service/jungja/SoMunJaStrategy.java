package com.junyeok.service.jungja;

import com.junyeok.constants.yeongeo.SoMunja;
import com.junyeok.model.braille.BrailleToken;
import com.junyeok.model.braille.TokenType;
import com.junyeok.model.mukja.Geul;

public class SoMunjaStrategy implements JungjaStrategy {

    @Override
    public BrailleToken uncontracted(Geul geul) {
        return new BrailleToken(
            String.valueOf(SoMunja.fromChar(geul.getChar()).getBraille()),
            TokenType.SOMUNJA,
            geul,
            false);
    }
}