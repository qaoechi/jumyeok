package com.junyeok.service.yakja;

import com.junyeok.model.braille.BrailleToken;
import com.junyeok.model.braille.TokenType;
import com.junyeok.model.mukja.Geul;

public class GongbaekYakja implements YakjaStrategy {

    @Override
    public BrailleToken contraction(Geul geul) {
        return new BrailleToken(String.valueOf(geul.getChar()), TokenType.GONGBAEK, geul, false);
    }
}