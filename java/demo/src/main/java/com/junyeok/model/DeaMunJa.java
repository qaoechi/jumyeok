package com.junyeok.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class DeaMunJa implements Geul {
    private char c;

    @Override
    public String render() {
        return String.valueOf(c);
    }
}