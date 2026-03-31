package com.junyeok.model;

import java.util.function.Function;

import com.junyeok.service.tokenize.HanGeulBunHae;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum GeulType {
    HANGEUL(c -> HanGeulBunHae.splitGyeop(HanGeulBunHae.bunhae(c))),
    SOMUNJA(c -> new SoMunJa(c)),
    DEAMUNJA(c -> new DeaMunJa(c)),
    SutJa(c -> new SutJa(c)),
    Buho(c -> new Buho(c)),
    GONGBAEK(c -> new GongBaek(c));

    private final Function<Character, Geul> creator;

    public Geul create(char c) {
        return creator.apply(c);
    }
}