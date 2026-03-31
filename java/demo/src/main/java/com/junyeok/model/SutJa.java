package com.junyeok.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SutJa implements Geul {
    private char su;

    @Override
    public String render() {
        return String.valueOf(su);
    }
}