package com.junyeok.service.yakja;

import com.junyeok.model.HanGeul;

class HanGeulContext {
    char choseong;
    String jungseong;
    char jongseong;
    char gyeopbatchim;
    boolean is;
    
    HanGeulContext(HanGeul h) {
        this.choseong = h.getChoseong();
        this.jungseong = h.getJungseong() + "";
        this.jongseong = h.getJongseong();
        this.gyeopbatchim = h.getGyeopbatchim();
        this.is = false;
    }
}