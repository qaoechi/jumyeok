package com.junyeok.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class HanGeul implements Geul {
    private final String doensori;
    private final String choseong;
    private final String jungseong;
    private final String jongseong;
    private final String gyeopbatchim;

    @Override
    public String render() {
        return  doensori + " " + choseong + "" + jungseong + " " + jongseong + " " + gyeopbatchim;
    }

}