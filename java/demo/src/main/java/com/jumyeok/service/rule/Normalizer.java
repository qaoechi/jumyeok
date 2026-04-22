package com.jumyeok.service.rule;

import java.util.List;

import com.jumyeok.model.braille.BrailleToken;
import com.jumyeok.model.braille.Segment;

public interface Normalizer {
    Segment apply(List<BrailleToken> buffer);
}