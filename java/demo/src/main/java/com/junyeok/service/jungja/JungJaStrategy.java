package com.junyeok.service.jungja;

import com.junyeok.model.braille.BrailleToken;
import com.junyeok.model.mukja.Geul;

public interface JungjaStrategy {
    BrailleToken uncontracted(Geul geul);
}