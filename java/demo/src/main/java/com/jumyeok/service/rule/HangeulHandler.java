package com.jumyeok.service.rule;

import java.util.List;

import com.jumyeok.constants.rule.BrailleHelper;
import com.jumyeok.constants.rule.hangeul.ButchimGongbaek;
import com.jumyeok.model.braille.BrailleToken;
import com.jumyeok.model.braille.Segment;
import com.jumyeok.model.braille.TokenType;
import com.jumyeok.model.mukja.Hangeul;

public class HangeulHandler implements TransitionRule {
    @Override
    public void handle(Segment current, Segment prev, Segment next, List<BrailleToken> result) {
        if (prev != null && prev.getType() == TokenType.SUTJA) {
            Hangeul curr = (Hangeul)(current.getTokens().get(0).getOrigin());
            String input = curr.getChoseong() != 'ㅇ' ? curr.getChoseong() + "" : curr.getJungseong() + ""  + curr.getJongseong();
            if (ButchimGongbaek.exists(input)) {
                result.add(BrailleHelper.BUTCHIMGONBAEK);
            }
        }
        result.addAll(current.getTokens());
    }
}