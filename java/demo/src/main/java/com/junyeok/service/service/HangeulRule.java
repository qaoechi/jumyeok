package com.junyeok.service.service;

import java.util.List;

import com.junyeok.constants.onlyBraille.BrailleHelper;
import com.junyeok.constants.onlyBraille.JungseongAE;
import com.junyeok.model.braille.BrailleToken;
import com.junyeok.model.braille.TokenType;
import com.junyeok.model.mukja.Hangeul;

public class HangeulRule {
    public static void apply(List<BrailleToken> buffer, List<BrailleToken> result) {
        for (int i = 0; i < buffer.size() - 1; i++) {
            Hangeul next = (Hangeul)buffer.get(i + 1).getOrigin();
            boolean flag = false;
            if (next.getChoseong() == 'ㅇ') {
                Hangeul target = (Hangeul)buffer.get(i).getOrigin();
                if (next.getJungseong() == 'ㅖ') {
                    flag = true;
                } else if (JungseongAE.exists(target.getJungseong()) && next.getJungseong() == 'ㅐ') {
                    flag = true;
                }
                if (!flag || !(target.getJongseong() == '\0' && target.getGyeopbatchim() == '\0')) {
                    flag = false;
                }
                result.add(buffer.get(i));
                if (flag) {
                    result.add(new BrailleToken(BrailleHelper.GUBUNPYO, TokenType.HELPER, null, false));
                }
            }
            else if (buffer.get(i).isAbbreviation() && next.getChoseong() == 'ㅇ') {

            }
        }
        result.add(buffer.getLast());
    }
}