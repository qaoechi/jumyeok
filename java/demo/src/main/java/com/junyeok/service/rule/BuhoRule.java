package com.junyeok.service.rule;

import java.util.List;

import com.junyeok.model.braille.BrailleToken;

public class BuhoRule {
    public static void apply(List<BrailleToken> buffer, List<BrailleToken> result) {
        result.addAll(buffer);
    }
}