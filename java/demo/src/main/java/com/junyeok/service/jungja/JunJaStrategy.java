package com.junyeok.service.jungja;

import com.junyeok.model.Geul;
import com.junyeok.model.braille.BrailleToken;

public interface JunJaStrategy {
    BrailleToken uncontracted(Geul geul);
}