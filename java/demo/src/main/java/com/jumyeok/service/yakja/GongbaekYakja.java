package com.jumyeok.service.yakja;

import com.jumyeok.model.braille.BrailleToken;
import com.jumyeok.model.braille.TokenType;
import com.jumyeok.model.mukja.Geul;

public class GongbaekYakja implements YakjaStrategy {

    @Override
    public BrailleToken contraction(Geul geul) {
        return new BrailleToken(String.valueOf(geul.getChar()), TokenType.GONGBAEK, geul, false);
    }
}