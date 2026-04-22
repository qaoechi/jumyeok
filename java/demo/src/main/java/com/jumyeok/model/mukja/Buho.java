package com.jumyeok.model.mukja;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Buho implements Geul {
    private char munja;

    @Override
    public char getChar() {
        return this.munja;
    }
}