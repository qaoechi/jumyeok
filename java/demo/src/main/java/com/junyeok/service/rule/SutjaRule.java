package com.junyeok.service.rule;

import java.util.ArrayList;
import java.util.List;

import com.junyeok.constants.onlyBraille.BrailleHelper;
import com.junyeok.model.braille.BrailleToken;
import com.junyeok.model.braille.Segment;
import com.junyeok.model.braille.TokenType;

public class SutjaRule {
    public static Segment apply(List<BrailleToken> buffer) {
        List<BrailleToken> result = new ArrayList<>();
        result.add(new BrailleToken(BrailleHelper.SUPYO, TokenType.HELPER, null, false));
        result.addAll(buffer);
        return new Segment(TokenType.SUTJA, result);
    }
}