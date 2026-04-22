package com.jumyeok.model.mukja;

import java.util.function.Function;

import com.jumyeok.service.tokenize.HanGeulBunHae;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum GeulType {
    HANGEUL(c -> HanGeulBunHae.splitGyeop(HanGeulBunHae.bunhae(c))),
    YEONGEO(c -> new Yeongeo(c)),
    SUTJA(c -> new Sutja(c)),
    Buho(c -> new Buho(c)),
    GONGBAEK(c -> new Gongbaek(c));

    private final Function<Character, Geul> creator;

    public Geul create(char c) {
        return creator.apply(c);
    }
}