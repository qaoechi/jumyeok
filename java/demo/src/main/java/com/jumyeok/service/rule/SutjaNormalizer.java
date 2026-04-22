package com.jumyeok.service.rule;

import java.util.ArrayList;
import java.util.List;

import com.jumyeok.constants.rule.BrailleHelper;
import com.jumyeok.model.braille.BrailleToken;
import com.jumyeok.model.braille.Segment;
import com.jumyeok.model.braille.TokenType;

public class SutjaNormalizer implements Normalizer {
    @Override
    public Segment apply(List<BrailleToken> buffer) {
        List<BrailleToken> result = new ArrayList<>();
        result.add(new BrailleToken(BrailleHelper.SUPYO, TokenType.HELPER, null, false));
        result.addAll(buffer);
        return new Segment(TokenType.SUTJA, result);
    }
}