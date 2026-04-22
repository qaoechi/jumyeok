package com.jumyeok.service.rule;

import java.util.List;

import com.jumyeok.model.braille.BrailleToken;
import com.jumyeok.model.braille.Segment;

public interface TransitionRule {
    void handle(Segment current, Segment prev, Segment next, List<BrailleToken> result);
}