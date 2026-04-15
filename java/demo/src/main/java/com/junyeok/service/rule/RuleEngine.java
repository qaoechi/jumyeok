package com.junyeok.service.rule;

import java.util.ArrayList;
import java.util.List;

import com.junyeok.model.braille.BrailleToken;
import com.junyeok.model.braille.TokenType;

public class RuleEngine {
    public static List<BrailleToken> process(List<BrailleToken> input) {
        List<BrailleToken> result = new ArrayList<>();
        List<BrailleToken> buffer = new ArrayList<>();

        TokenType type = input.get(0).getType();

        for (BrailleToken b : input) {
            if (b.getType() == type) {
                buffer.add(b);
            } else {
                flush(buffer, result);
                buffer.clear();
                buffer.add(b);
                type = b.getType();
            }
        }
        flush(buffer, result);
        return result;
    }

    private static void flush(List<BrailleToken> buffer, List<BrailleToken> result) {
        switch (buffer.get(0).getType()) {
            case HANGEUL -> HangeulRule.apply(buffer, result);
            case SUTJA -> SutjaRule.apply(buffer, result);
            case YEONGEO -> YeongeoRule.apply(buffer, result);
            case BUHO -> BuhoRule.apply(buffer, result);
            default -> result.addAll(buffer);
        }
    }
}