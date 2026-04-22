package com.jumyeok.service.rule;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.jumyeok.model.braille.BrailleToken;
import com.jumyeok.model.braille.Segment;
import com.jumyeok.model.braille.TokenType;

public class RuleEngine {
    private Map<TokenType, Normalizer> normalizer = Map.of(
        TokenType.HANGEUL, new HangeulNormalizer(),
        TokenType.YEONGEO, new YeongeoNormalizer(),
        TokenType.SUTJA, new SutjaNormalizer(),
        TokenType.BUHO, new BuhoNormalizer(),
        TokenType.GONGBAEK, new GongbeakNormalizer()
    );
    private Map<TokenType, TransitionRule> transition = Map.of(
        TokenType.HANGEUL, new HangeulHandler(),
        TokenType.YEONGEO, new YeongeoHandler(),
        TokenType.SUTJA, new SutjaHandler(),
        TokenType.BUHO, new BuhoHandler(),
        TokenType.GONGBAEK, new BuhoHandler()
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
        for (int i = 0; i < segments.size(); i++) {
            Segment prev = i > 0 ? segments.get(i - 1) : null;
            Segment curr = segments.get(i);
            Segment next = i < segments.size() - 1 ? segments.get(i + 1) : null;
            transition.get(curr.getType()).handle(curr, prev, next, result);
        }
        return result;
    }
}