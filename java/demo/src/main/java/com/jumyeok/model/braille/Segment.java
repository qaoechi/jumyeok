package com.jumyeok.model.braille;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Segment {
    private TokenType type; 
    private List<BrailleToken> tokens;

    public Segment(TokenType type) {
        this.type = type;
        this.tokens = new ArrayList<>();
    }

    public void add(BrailleToken token) {
        tokens.add(token);
    }
}