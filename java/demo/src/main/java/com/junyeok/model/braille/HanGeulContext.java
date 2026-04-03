package com.junyeok.model.braille;

import com.junyeok.model.mukja.Hangeul;

public class HanGeulContext {
    public char choseong;
    public String jungseong;
    public char jongseong;
    public char gyeopbatchim;
    public boolean is;
    
    public HanGeulContext(Hangeul h) {
        this.choseong = h.getChoseong();
        this.jungseong = h.getJungseong() + "";
        this.jongseong = h.getJongseong();
        this.gyeopbatchim = h.getGyeopbatchim();
        this.is = false;
    }
}