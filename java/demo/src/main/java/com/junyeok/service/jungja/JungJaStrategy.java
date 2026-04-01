package com.junyeok.service.jungja;

import com.junyeok.model.Geul;
import com.junyeok.model.braille.BrailleToken;

public interface JungJaStrategy {
    BrailleToken uncontracted(Geul geul);
}