package com.junyeok.service.yakja;

import com.junyeok.constants.yeongeo.SoMunJa;
import com.junyeok.model.braille.BrailleToken;
import com.junyeok.model.braille.TokenType;
import com.junyeok.model.mukja.Geul;

public class YeongeoYakja implements YakjaStrategy {

    @Override
    public BrailleToken contraction(Geul geul) {
        return new BrailleToken(SoMunJa.fromChar(geul.getChar() + "").getBraille(), TokenType.YEONGEO, geul, false);
    }
}
