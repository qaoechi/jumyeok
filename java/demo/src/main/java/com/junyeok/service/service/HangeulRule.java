package com.junyeok.service.service;

import java.util.List;

import com.junyeok.constants.onlyBraille.BrailleHelper;
import com.junyeok.constants.onlyBraille.JungseongAE;
import com.junyeok.model.braille.BrailleToken;
import com.junyeok.model.braille.TokenType;
import com.junyeok.model.mukja.Hangeul;

public class HangeulRule {
    public static void apply(List<BrailleToken> buffer, List<BrailleToken> result) {
        result.add(buffer.get(0));
        for (int i = 1; i < buffer.size(); i++) {
            Hangeul target = (Hangeul)buffer.get(i).getOrigin();
            boolean flag = false;
            if (target.getChoseong() == 'ㅇ') {
                Hangeul prev = (Hangeul)buffer.get(i - 1).getOrigin();
                if (target.getJungseong() == 'ㅖ') {
                    flag = true;
                } else if (JungseongAE.exists(prev.getJungseong()) && target.getJungseong() == 'ㅐ') {
                    flag = true;
                }
                if (!flag || !(prev.getJongseong() == '\0' && prev.getGyeopbatchim() == '\0')) {
                    flag = false;
                }

                if (flag) {
                    result.add(new BrailleToken(BrailleHelper.GUBUNPYO, TokenType.HELPER, null, false));
                }
                result.add(buffer.get(i));
            }
            else if (buffer.get(i).isAbbreviation() && target.getJungseong() == '\0') {
                
            }
            System.out.println(buffer.get(i).getOrigin());
        }
    }
}