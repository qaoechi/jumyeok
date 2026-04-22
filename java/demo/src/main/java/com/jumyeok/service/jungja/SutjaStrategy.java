package com.jumyeok.service.jungja;

import com.jumyeok.constants.other.Sutja;
import com.jumyeok.model.braille.BrailleToken;
import com.jumyeok.model.braille.TokenType;
import com.jumyeok.model.mukja.Geul;

public class SutjaStrategy implements JungjaStrategy {

    @Override
    public BrailleToken uncontracted(Geul geul) {
        return new BrailleToken(
            Sutja.fromChar(geul.getChar()).getBraille(),
            TokenType.SUTJA,
            geul,
            false);
    }
}