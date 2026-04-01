package com.junyeok.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class HanGeul implements Geul {
    private final char doensori;
    private final char choseong;
    private final String jungseong;
    private final char jongseong;
    private final char gyeopbatchim;

    @Override
    public String render() {
        return  doensori + "" + choseong + "" + jungseong + "" + jongseong + "" + gyeopbatchim;
    }

}