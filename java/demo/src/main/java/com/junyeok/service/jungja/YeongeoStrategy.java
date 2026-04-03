package com.junyeok.service.jungja;

import com.junyeok.constants.yeongeo.SoMunJa;
import com.junyeok.model.braille.BrailleToken;
import com.junyeok.model.braille.TokenType;
import com.junyeok.model.mukja.Geul;

public class YeongeoStrategy implements JungjaStrategy {

    @Override
    public BrailleToken uncontracted(Geul geul) {
        return new BrailleToken(
            String.valueOf(SoMunJa.fromChar(geul.getChar() + "").getBraille()),
            TokenType.YEONGEO,
            geul,
            false);
    }
}