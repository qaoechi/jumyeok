package com.jumyeok.service.yakja;

import com.jumyeok.constants.yeongeo.SoMunJa;
import com.jumyeok.model.braille.BrailleToken;
import com.jumyeok.model.braille.TokenType;
import com.jumyeok.model.mukja.Geul;

public class YeongeoYakja implements YakjaStrategy {

    @Override
    public BrailleToken contraction(Geul geul) {
        return new BrailleToken(SoMunJa.fromChar(geul.getChar() + "").getBraille(), TokenType.YEONGEO, geul, false);
    }
}
