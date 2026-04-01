package com.junyeok.service.jungja;

import com.junyeok.constants.otherBraille.SoMunJa;
import com.junyeok.model.Geul;
import com.junyeok.model.braille.BrailleToken;

public class YeongEoStrategy implements JunJaStrategy {

    @Override
    public BrailleToken uncontracted(Geul geul) {
        return SoMunJa.fromChar(geul.getData());
    }
}