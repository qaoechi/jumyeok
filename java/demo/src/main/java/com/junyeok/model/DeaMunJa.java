package com.junyeok.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DeaMunJa implements Geul {
    private char c;

    @Override
    public String render() {
        return String.valueOf(c);
    }
}