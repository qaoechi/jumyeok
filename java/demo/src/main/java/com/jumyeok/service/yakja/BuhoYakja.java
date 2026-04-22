package com.jumyeok.service.yakja;

import com.jumyeok.constants.other.Buho;
import com.jumyeok.model.braille.BrailleToken;
import com.jumyeok.model.braille.TokenType;
import com.jumyeok.model.mukja.Geul;

public class BuhoYakja implements YakjaStrategy {

    @Override
    public BrailleToken contraction(Geul geul) {
        return new BrailleToken(Buho.fromChar(geul.getChar()).getBraille(), TokenType.BUHO, geul, false);
    }
}