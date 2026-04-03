package com.junyeok.model.mukja;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Gongbaek implements Geul {
    private char bin;

    @Override
    public char getChar() {
        return this.bin;
    }
}