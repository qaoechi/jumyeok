package com.junyeok.model.braille;

import com.junyeok.model.mukja.Hangeul;

class HanGeulContext {
    char choseong;
    String jungseong;
    char jongseong;
    char gyeopbatchim;
    boolean is;
    
    HanGeulContext(Hangeul h) {
        this.choseong = h.getChoseong();
        this.jungseong = h.getJungseong() + "";
        this.jongseong = h.getJongseong();
        this.gyeopbatchim = h.getGyeopbatchim();
        this.is = false;
    }
}