package com.junyeok.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Buho implements Geul {
    private char munja;

    @Override
    public String render() {
        return String.valueOf(munja);
    }
}