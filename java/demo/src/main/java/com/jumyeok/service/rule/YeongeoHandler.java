package com.jumyeok.service.rule;

import java.util.List;

import com.jumyeok.constants.rule.BrailleHelper;
import com.jumyeok.model.braille.BrailleToken;
import com.jumyeok.model.braille.Segment;
import com.jumyeok.model.braille.TokenType;
import com.jumyeok.model.mukja.Yeongeo;

public class YeongeoHandler implements TransitionRule {
    @Override
    public void handle(Segment current, Segment prev, Segment next, List<BrailleToken> result) {
        if (prev.getType() != TokenType.YEONGEO) result.add(BrailleHelper.ROMAJAPYO);

        List<BrailleToken> tokens = current.getTokens();
        for (int i = 0; i < tokens.size(); i++) {
            boolean curr = ((Yeongeo)tokens.get(i).getOrigin()).isUpper();
            boolean pre = i > 0 ? ((Yeongeo)tokens.get(i - 1).getOrigin()).isUpper() : false;
            Yeongeo nex = i < tokens.size() - 1 ? ((Yeongeo)tokens.get(i + 1).getOrigin()) : null;

            if (curr && !pre && (nex != null && nex.isUpper())) result.add(BrailleHelper.DAEMUNGIHO);
            if (curr && !pre && (nex != null && !nex.isUpper())) result.add(BrailleHelper.DAEMUNJA);
            result.add(tokens.get(i));
            if (curr && pre && (nex != null && !nex.isUpper())) result.add(BrailleHelper.DAEMUNJONGRYO);
        }
        if (next != null && (next.getType() == TokenType.SUTJA)) return;
        // if (next != null && (next.getType() == TokenType.GONGBAEK && next.getTokens().get(0).getOrigin().getChar() == '\n')) {
        //     return;
        // }
        if (next.getType() != TokenType.YEONGEO) result.add(BrailleHelper.ROMAJONGRYO);
    }
}