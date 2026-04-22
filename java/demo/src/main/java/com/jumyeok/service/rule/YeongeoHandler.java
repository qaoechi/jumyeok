package com.jumyeok.service.rule;

import java.util.List;

import com.jumyeok.constants.rule.BrailleHelper;
import com.jumyeok.model.braille.BrailleToken;
import com.jumyeok.model.braille.Segment;
import com.jumyeok.model.braille.TokenType;

public class YeongeoHandler implements TransitionRule {
    @Override
    public void handle(Segment current, Segment prev, Segment next, List<BrailleToken> result) {
        result.add(new BrailleToken(BrailleHelper.ROMAJAPYO, TokenType.HELPER, null, false));
        result.addAll(current.getTokens());
        if (next != null && !(next.getType() == TokenType.GONGBAEK && next.getTokens().get(0).getOrigin().getChar() == '\n')) {
            result.add(new BrailleToken(BrailleHelper.ROMAJONGRYO, TokenType.HELPER, null, false));
        }
    }
}