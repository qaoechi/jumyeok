package com.jumyeok.service.jungja;

import com.jumyeok.constants.yeongeo.SoMunJa;
import com.jumyeok.model.braille.BrailleToken;
import com.jumyeok.model.braille.TokenType;
import com.jumyeok.model.mukja.Geul;

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