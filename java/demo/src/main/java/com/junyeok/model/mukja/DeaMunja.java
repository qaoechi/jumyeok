package com.junyeok.model.mukja;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class DeaMunja implements Geul {
    private char c;

    @Override
    public char getChar() {
        return this.c;
    }
}