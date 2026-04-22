package com.jumyeok.service.rule;

import java.util.List;

import com.jumyeok.constants.rule.BrailleHelper;
import com.jumyeok.model.braille.BrailleToken;
import com.jumyeok.model.braille.Segment;
import com.jumyeok.model.braille.TokenType;

public class BuhoHandler implements TransitionRule {
    @Override
    public void handle(Segment current, Segment prev, Segment next, List<BrailleToken> result) {
        if (current.getTokens().size() == 1) {
            char buho = current.getTokens().get(0).getOrigin().getChar();
            if (buho == '→') {
                result.add(new BrailleToken(BrailleHelper.BUTCHIMGONBAEK, TokenType.HELPER, null, false));
            }
            if (buho == '←') {
                result.add(current.getTokens().get(0));
                result.add(new BrailleToken(BrailleHelper.BUTCHIMGONBAEK, TokenType.HELPER, null, false));
                return;
            }
        }
        result.addAll(current.getTokens());
    }
    
}