package com.junyeok.service.rule;

import java.util.List;

import com.junyeok.constants.rule.BrailleHelper;
import com.junyeok.constants.rule.hangeul.ButchimGongbaek;
import com.junyeok.model.braille.BrailleToken;
import com.junyeok.model.braille.Segment;
import com.junyeok.model.braille.TokenType;
import com.junyeok.model.mukja.Hangeul;

public class HangeulHandler implements TransitionRule {
    @Override
    public void handle(Segment current, Segment prev, Segment next, List<BrailleToken> result) {
        if (prev != null && prev.getType() == TokenType.SUTJA) {
            Hangeul curr = (Hangeul)(current.getTokens().get(0).getOrigin());
            String input = curr.getChoseong() != 'ㅇ' ? curr.getChoseong() + "" : curr.getJungseong() + ""  + curr.getJongseong();
            if (ButchimGongbaek.exists(input)) {
                result.add(new BrailleToken(BrailleHelper.BUTCHIMGONBAEK, TokenType.HELPER, null, false));
            }
        }
        result.addAll(current.getTokens());
    }
}