package com.junyeok.service.rule;

import java.util.ArrayList;
import java.util.List;

import com.junyeok.model.braille.BrailleToken;
import com.junyeok.model.braille.Segment;
import com.junyeok.model.braille.TokenType;

public class RuleEngine {
    public static List<BrailleToken> process(List<BrailleToken> input) {
        if (input.isEmpty()) return null;

        TokenType type = input.get(0).getType();
        List<BrailleToken> buffer = new ArrayList<>();
        List<Segment> segments = new ArrayList<>();

        for (BrailleToken token : input) {
            if (token.getType() == type) {
                buffer.add(token);
            } else {
                segments.add(flush(buffer));
                buffer.clear();
                type = token.getType();
                buffer.add(token);
            }
        }
        segments.add(flush(buffer));

        List<BrailleToken> result = new ArrayList<>();
        for (Segment segment : segments) {
            result.addAll(segment.getTokens());
        }

        return result;
    }
    private static Segment flush(List<BrailleToken> buffer) {
        List<BrailleToken> input = new ArrayList<>(buffer);
        switch (buffer.get(0).getType()) {
            case HANGEUL:
                return HangeulRule.apply(input);
            case SUTJA:
                return SutjaRule.apply(input);
            case YEONGEO:
                return YeongeoRule.apply(input);
            case BUHO:
                return BuhoRule.apply(input);
            default:
                return new Segment(TokenType.GONGBAEK, input);
        }
    }
}