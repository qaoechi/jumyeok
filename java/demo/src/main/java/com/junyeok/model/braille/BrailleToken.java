package com.junyeok.model.braille;

import com.junyeok.model.mukja.Geul;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BrailleToken {
    private String dots;
    private TokenType type;
    private Geul origin;
    private boolean isAbbreviation;

    @Override
    public String toString() {
        return this.dots;
    }
}