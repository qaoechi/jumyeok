package com.junyeok.model.mukja;

import java.util.function.Function;

import lombok.AllArgsConstructor;

import com.junyeok.service.tokenize.HanGeulBunHae;

@AllArgsConstructor
public enum GeulType {
    HANGEUL(c -> HanGeulBunHae.splitGyeop(HanGeulBunHae.bunhae(c))),
    SOMUNJA(c -> new SoMunja(c)),
    DEAMUNJA(c -> new DeaMunja(c)),
    SUTJA(c -> new Sutja(c)),
    Buho(c -> new Buho(c)),
    GONGBAEK(c -> new GongBaek(c));

    private final Function<Character, Geul> creator;

    public Geul create(char c) {
        return creator.apply(c);
    }
}