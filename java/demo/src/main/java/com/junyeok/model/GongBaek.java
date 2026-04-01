package com.junyeok.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class GongBaek implements Geul {
    private char bin;

    @Override
    public String render() {
        return String.valueOf(bin);
    }

    @Override
    public char getChar() {
        return this.bin;
    }
}