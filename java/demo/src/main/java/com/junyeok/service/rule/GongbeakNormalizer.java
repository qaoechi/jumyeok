package com.junyeok.service.rule;

import java.util.List;

import com.junyeok.model.braille.BrailleToken;
import com.junyeok.model.braille.Segment;
import com.junyeok.model.braille.TokenType;

public class GongbeakNormalizer implements Normalizer {
    @Override
    public Segment apply(List<BrailleToken> buffer) {
        return new Segment(TokenType.GONGBAEK, buffer);
    }
}