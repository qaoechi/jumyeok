package com.jumyeok.service.rule;

import java.util.List;

import com.jumyeok.constants.other.Sutja;
import com.jumyeok.constants.rule.BRFMap;
import com.jumyeok.constants.rule.BrailleHelper;
import com.jumyeok.model.braille.BrailleToken;
import com.jumyeok.model.braille.TokenType;

public class BRFEngine {
    public static String toBRF(List<BrailleToken> tokens) {
        StringBuilder sb = new StringBuilder();
        int size = 0, line = 1, page = 1;

        for (BrailleToken token : tokens) {
            String dots = token.getDots().replace("\0", "");
            if (token.getType() == TokenType.GONGBAEK && dots.equals("\n")) {
                sb.append("\n");
                line++;
                size = 0;
                continue;
            }
            int len = dots.length();
            if (size + len > 32) {
                sb.append('\n');
                line++;
                size = 0;
                if (token.getType() == TokenType.GONGBAEK) continue;
            }
            if (line == 26) {
                String pageNumber = BrailleHelper.SUPYO + Sutja.fromChar(Character.forDigit(page, 10)).getBraille();
                String space = " ".repeat(32 - pageNumber.length());
                
                sb.append(space);
                for (int i = 0; i < pageNumber.length(); i++) {
                    sb.append(BRFMap.get(pageNumber.charAt(i)));
                }
                sb.append('\n');
                line = 0;
                size = 0;
            }
            for (int i = 0; i < dots.length(); i++) {
                sb.append(BRFMap.get(dots.charAt(i)));
            }
            size += len;
        }
        return sb.toString();
    }
}