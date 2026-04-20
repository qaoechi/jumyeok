package com.junyeok.service.rule;

import java.util.List;

import com.junyeok.model.braille.BrailleToken;
import com.junyeok.model.braille.Segment;

public interface Normalizer {
    Segment apply(List<BrailleToken> buffer);
}