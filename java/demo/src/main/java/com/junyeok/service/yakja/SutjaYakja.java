package com.junyeok.service.yakja;

import com.junyeok.constants.other.Sutja;
import com.junyeok.model.braille.BrailleToken;
import com.junyeok.model.braille.TokenType;
import com.junyeok.model.mukja.Geul;

public class SutjaYakja implements YakjaStrategy {

    @Override
    public BrailleToken contraction(Geul geul) {
        return new BrailleToken(Sutja.fromChar(geul.getChar()).getBraille(), TokenType.SUTJA, geul, false);
    }
}