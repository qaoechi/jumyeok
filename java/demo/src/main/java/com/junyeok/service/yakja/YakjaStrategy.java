package com.junyeok.service.yakja;

import com.junyeok.model.braille.BrailleToken;
import com.junyeok.model.mukja.Geul;

public interface YakjaStrategy {
    BrailleToken contraction(Geul geul);
}