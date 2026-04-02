package com.junyeok.service.yakja;

import com.junyeok.constants.yakja.SsangSiOt;
import com.junyeok.model.HanGeul;
import com.junyeok.model.braille.BrailleToken;

public class HanGeulYakJa {
    public BrailleToken contraction(BrailleToken geul) {
        HanGeul hangeul = (HanGeul) geul.getOrigin();
        String dots = geul.getDots();

        if (hangeul.getJongseong() == 'ㅅ' && hangeul.getGyeopbatchim() == 'ㅅ') {
            dots = dots.substring(0, dots.length() -2) +  SsangSiOt.ㅆ.getSs();
            return new BrailleToken(dots, geul.getType(), hangeul);
        }
        return geul;
        // if (hangeul.getJungseong() == 'ㅏ') {

        // }
        // if (han)
    }
}