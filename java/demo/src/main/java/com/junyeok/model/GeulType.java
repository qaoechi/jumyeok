package com.junyeok.model;

import java.util.function.Function;

import com.junyeok.service.tokenize.HanGeulBunHae;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum GeulType {
    HANGEUL(c -> HanGeulBunHae.splitGyeop(HanGeulBunHae.bunhae(c))),
    YeongEo(c -> new SoMunJa(c)),
    SutJa(c -> new SutJa(c)),
    Buho(c -> new Buho(c)),
    GONGBAEK(c -> new GongBaek(c));

    private final Function<String, Geul> creator;

    public Geul create(String s) {
        return creator.apply(s);
    }
}