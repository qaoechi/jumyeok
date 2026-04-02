package com.junyeok.service.yakja;

import com.junyeok.constants.hangeulJumja.ChoSeong;
import com.junyeok.constants.hangeulJumja.DoenSoRi;
import com.junyeok.constants.hangeulJumja.JongSeong;
import com.junyeok.constants.yakja.ASaengLyak;
import com.junyeok.constants.yakja.BatChimSaengLyak;
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
        if (hangeul.getJungseong() == 'ㅏ') {
            StringBuilder result = new StringBuilder();
            if (ASaengLyak.fromChar(hangeul.getChoseong()) != null) {
                if (hangeul.getDoensori() != '\0') result.append(DoenSoRi.쌍.getDoen());
                result.append(ASaengLyak.fromChar(hangeul.getChoseong()).getASaengLyak());
                if (hangeul.getJongseong() != '\0') result.append(JongSeong.fromChar(hangeul.getJongseong()).getJongseong());
                if (hangeul.getGyeopbatchim() != '\0') result.append(JongSeong.fromChar(hangeul.getGyeopbatchim()).getJongseong());
                return new BrailleToken(result.toString(), geul.getType(), hangeul);
            }
            return geul;
        }
        if (BatChimSaengLyak.fromChar(hangeul.getJungseong() + "" + hangeul.getJongseong()) != null) {
            StringBuilder result = new StringBuilder();
            if (hangeul.getDoensori() != '\0') result.append(DoenSoRi.쌍.getDoen());
            result.append(ChoSeong.fromChar(hangeul.getChoseong()).getChoseong());
            result.append(BatChimSaengLyak.fromChar(hangeul.getJungseong() + "" + hangeul.getJongseong()).getBatChimSaengLyak());
            if (hangeul.getGyeopbatchim() != '\0') result.append(JongSeong.fromChar(hangeul.getGyeopbatchim()).getJongseong());
            return new BrailleToken(result.toString(), geul.getType(), hangeul);
        }
        return geul;
    }
}