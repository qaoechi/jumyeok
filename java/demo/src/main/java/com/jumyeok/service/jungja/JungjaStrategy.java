package com.jumyeok.service.jungja;

import com.jumyeok.model.braille.BrailleToken;
import com.jumyeok.model.mukja.Geul;

public interface JungjaStrategy {
    BrailleToken uncontracted(Geul geul);
}