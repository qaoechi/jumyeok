package com.junyeok.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class YeongEo implements Geul {
    private String c;

    @Override
    public String render() {
        return this.c;
    }
}