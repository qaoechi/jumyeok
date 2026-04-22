package com.jumyeok.service.rule;

import java.util.List;

import com.jumyeok.model.braille.BrailleToken;
import com.jumyeok.model.braille.Segment;
import com.jumyeok.model.braille.TokenType;

public class BuhoNormalizer implements Normalizer {
    @Override
    public Segment apply(List<BrailleToken> buffer) {
        return new Segment(TokenType.BUHO, buffer);
    }
}