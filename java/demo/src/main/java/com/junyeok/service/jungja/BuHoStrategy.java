package com.junyeok.service.jungja;

import com.junyeok.constants.other.Buho;
import com.junyeok.model.braille.BrailleToken;
import com.junyeok.model.braille.TokenType;
import com.junyeok.model.mukja.Geul;

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