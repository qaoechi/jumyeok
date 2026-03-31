package com.junyeok.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GongBaek implements Geul {
    private char bin;

    @Override
    public String render() {
        return String.valueOf(bin);
    }
}