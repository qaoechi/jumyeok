package com.junyeok.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GongBaek implements Geul {
    private String bin;

    @Override
    public String render() {
        return this.bin;
    }
}