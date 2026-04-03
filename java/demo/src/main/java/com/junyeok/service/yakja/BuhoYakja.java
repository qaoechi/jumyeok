package com.junyeok.service.yakja;

import com.junyeok.constants.other.Buho;
import com.junyeok.model.braille.BrailleToken;
import com.junyeok.model.braille.TokenType;
import com.junyeok.model.mukja.Geul;

public class BuhoYakja implements YakjaStrategy {

    @Override
    public BrailleToken contraction(Geul geul) {
        return new BrailleToken(Buho.fromChar(geul.getChar()).getBraille(), TokenType.BUHO, geul, false);
    }
}