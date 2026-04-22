package com.jumyeok.service.jungja;

import com.jumyeok.constants.other.Buho;
import com.jumyeok.model.braille.BrailleToken;
import com.jumyeok.model.braille.TokenType;
import com.jumyeok.model.mukja.Geul;

public class BuhoStrategy implements JungjaStrategy {

    @Override
    public BrailleToken uncontracted(Geul geul) {
        return new BrailleToken(
            Buho.fromChar(geul.getChar()).getBraille(),
            TokenType.BUHO,
            geul,
            false);
    }
}