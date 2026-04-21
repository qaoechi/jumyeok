package com.junyeok.service.rule;

import java.util.List;

import com.junyeok.model.braille.BrailleToken;
import com.junyeok.model.braille.Segment;

public interface TransitionRule {
    void handle(Segment current, Segment prev, Segment next, List<BrailleToken> result);
}