package com.junyeok.service.jungja;

import com.junyeok.constants.hangeulJumja.ChoSeong;
import com.junyeok.constants.hangeulJumja.DoenSoRi;
import com.junyeok.constants.hangeulJumja.JongSeong;
import com.junyeok.constants.hangeulJumja.JungSeong;
import com.junyeok.model.Geul;
import com.junyeok.model.HanGeul;
import com.junyeok.model.braille.BrailleToken;
import com.junyeok.model.braille.TokenType;

public class HanGeulStrategy implements JunJaStrategy {

    @Override
    public BrailleToken uncontracted(Geul geul) {
        StringBuilder result = new StringBuilder();
        HanGeul hanGeul = (HanGeul)geul;
        
        if (hanGeul.getDoensori() != '\0') result.append(String.valueOf(DoenSoRi.쌍.getDoen()));
        result.append(String.valueOf(ChoSeong.fromChar(hanGeul.getChoseong()).getChoseong()));
        result.append(String.valueOf(JungSeong.fromChar(hanGeul.getJungseong()).getJungseong()));
        if (hanGeul.getJongseong() != '\0') result.append(String.valueOf(JongSeong.fromChar(hanGeul.getJongseong()).getJongseong()));
        if (hanGeul.getGyeopbatchim() != '\0') result.append(String.valueOf(JongSeong.fromChar(hanGeul.getGyeopbatchim()).getJongseong()));
        
        return new BrailleToken(result.toString(), TokenType.HANGEUL, geul);
    }
}
