package com.junyeok.service.rule;

import java.util.List;

import com.junyeok.model.braille.BrailleToken;
import com.junyeok.model.braille.Segment;

public class SutjaHandler implements TransitionRule {
    @Override
    public void handle(Segment current, Segment prev, Segment next, List<BrailleToken> result) {
        result.addAll(current.getTokens());
    }
    
}