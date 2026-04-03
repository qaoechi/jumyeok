package com.junyeok.service.yakja;

import com.junyeok.constants.yeongeo.SoMunJa;
import com.junyeok.model.braille.BrailleToken;
import com.junyeok.model.braille.TokenType;
import com.junyeok.model.mukja.Geul;
import com.junyeok.model.mukja.SoMunja;

public class YeongeoYakja implements YakjaStrategy {

    @Override
    public BrailleToken contraction(Geul geul) {
        TokenType type = geul.getClass() == SoMunja.class ? TokenType.SOMUNJA : TokenType.DEAMUNJA;
        return new BrailleToken(SoMunJa.fromChar((geul.getChar() + "").toLowerCase()).getBraille(), type, geul, false);
    }
}
