package com.junyeok.service.rule;

import java.util.List;

import com.junyeok.constants.rule.BrailleHelper;
import com.junyeok.model.braille.BrailleToken;
import com.junyeok.model.braille.Segment;
import com.junyeok.model.braille.TokenType;

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