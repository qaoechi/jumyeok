package com.jumyeok.model.braille;

import com.jumyeok.model.mukja.Geul;

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