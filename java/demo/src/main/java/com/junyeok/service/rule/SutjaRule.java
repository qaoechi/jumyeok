package com.junyeok.service.rule;

import java.util.List;

import com.junyeok.constants.onlyBraille.BrailleHelper;
import com.junyeok.model.braille.BrailleToken;
import com.junyeok.model.braille.TokenType;

public class SutjaRule {
    public static void apply(List<BrailleToken> buffer, List<BrailleToken> result) {
        result.add(new BrailleToken(BrailleHelper.SUPYO, TokenType.HELPER, null, false));
        result.addAll(buffer);
    }
}