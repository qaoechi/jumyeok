package com.junyeok.model.mukja;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Sutja implements Geul {
    private char su;

    @Override
    public char getChar() {
        return this.su;
    }
}