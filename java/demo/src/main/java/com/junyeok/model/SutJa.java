package com.junyeok.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class SutJa implements Geul {
    private char su;

    @Override
    public String render() {
        return String.valueOf(su);
    }
}