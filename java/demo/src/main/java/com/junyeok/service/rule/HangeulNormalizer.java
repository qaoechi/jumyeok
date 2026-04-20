package com.junyeok.service.rule;

import java.util.ArrayList;
import java.util.List;

import com.junyeok.constants.rule.BrailleHelper;
import com.junyeok.constants.rule.hangeul.CancelSaenglyak;
import com.junyeok.constants.rule.hangeul.JungseongAE;
import com.junyeok.model.braille.BrailleToken;
import com.junyeok.model.braille.Segment;
import com.junyeok.model.braille.TokenType;
import com.junyeok.model.mukja.Hangeul;
import com.junyeok.service.jungja.HangeulStrategy;

public class HangeulNormalizer implements Normalizer {
    @Override
    public Segment apply(List<BrailleToken> buffer) {
        List<BrailleToken> result = new ArrayList<>();
        for (int i = 0; i < buffer.size() - 1; i++) {
            Hangeul next = (Hangeul)buffer.get(i + 1).getOrigin();
            boolean flag = false;
            if (next.getChoseong() == 'ㅇ') {
                Hangeul target = (Hangeul)buffer.get(i).getOrigin();
                if (next.getJungseong() == 'ㅖ') flag = true;
                else if (JungseongAE.exists(target.getJungseong()) && next.getJungseong() == 'ㅐ') flag = true;
                
                if (!flag || !(target.getJongseong() == '\0' && target.getGyeopbatchim() == '\0')) flag = false;
                
                if (flag) {
                    result.add(buffer.get(i));
                    result.add(new BrailleToken(BrailleHelper.GUBUNPYO, TokenType.HELPER, null, false));
                    continue;
                }

                if (buffer.get(i).isAbbreviation() && CancelSaenglyak.exists(target.getChoseong())) {
                    if (target.getJongseong() == '\0' && target.getGyeopbatchim() == '\0') flag = true;
                }
                if (flag) {
                    result.add(new HangeulStrategy().uncontracted(target));
                    continue;
                }
                result.add(buffer.get(i));
            }
            else {
                result.add(buffer.get(i));
            }
        }
        result.add(buffer.getLast());
        return new Segment(TokenType.HANGEUL, result);
    }
}