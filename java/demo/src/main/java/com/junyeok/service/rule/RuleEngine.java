package com.junyeok.service.rule;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.junyeok.model.braille.BrailleToken;
import com.junyeok.model.braille.Segment;
import com.junyeok.model.braille.TokenType;

public class RuleEngine {
    private Map<TokenType, Normalizer> normalizer = Map.of(
        TokenType.HANGEUL, new HangeulNormalizer(),
        TokenType.YEONGEO, new YeongeoNormalizer(),
        TokenType.SUTJA, new SutjaNormalizer(),
        TokenType.BUHO, new BuhoNormalizer(),
        TokenType.GONGBAEK, new GongbeakNormalizer()
    );

    public List<BrailleToken> process(List<BrailleToken> input) {
        if (input.isEmpty()) return null;

        TokenType type = input.get(0).getType();
        List<BrailleToken> buffer = new ArrayList<>();
        List<Segment> segments = new ArrayList<>();

        for (BrailleToken token : input) {
            if (token.getType() == type) {
                buffer.add(token);
            } else {
                segments.add(normalizer.get(type).apply(new ArrayList<>(buffer)));
                buffer.clear();
                type = token.getType();
                buffer.add(token);
            }
        }
        segments.add(normalizer.get(type).apply(buffer));

        List<BrailleToken> result = new ArrayList<>();
        for (Segment segment : segments) {
            result.addAll(segment.getTokens());
        }

        return result;
    }
}