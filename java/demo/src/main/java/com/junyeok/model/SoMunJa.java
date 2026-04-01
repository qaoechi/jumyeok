package com.junyeok.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class SoMunJa implements Geul {
    private char c;

    @Override
    public String render() {
        return String.valueOf(c);
    }

    @Override
    public char getChar() {
        return this.c;
    }
}