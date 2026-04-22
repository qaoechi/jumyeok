package com.jumyeok.service.yakja;

import com.jumyeok.constants.other.Sutja;
import com.jumyeok.model.braille.BrailleToken;
import com.jumyeok.model.braille.TokenType;
import com.jumyeok.model.mukja.Geul;

public class SutjaYakja implements YakjaStrategy {

    @Override
    public BrailleToken contraction(Geul geul) {
        return new BrailleToken(Sutja.fromChar(geul.getChar()).getBraille(), TokenType.SUTJA, geul, false);
    }
}