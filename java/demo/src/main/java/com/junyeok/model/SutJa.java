package com.junyeok.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SutJa implements Geul {
    private String su;

    @Override
    public String render() {
        return this.su;
    }
}