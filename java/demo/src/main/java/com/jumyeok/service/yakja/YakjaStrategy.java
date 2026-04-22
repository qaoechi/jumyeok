package com.jumyeok.service.yakja;

import com.jumyeok.model.braille.BrailleToken;
import com.jumyeok.model.mukja.Geul;

public interface YakjaStrategy {
    BrailleToken contraction(Geul geul);
}