package com.junyeok.service.yakja;

import com.junyeok.constants.other.Buho;
import com.junyeok.constants.other.Sutja;
import com.junyeok.model.braille.BrailleToken;
import com.junyeok.model.braille.TokenType;
import com.junyeok.model.mukja.Geul;

public class OtherYakja implements YakjaStrategy {

    @Override
    public BrailleToken contraction(Geul geul) {
        char c = geul.getChar();
        String result;
        TokenType type;
        if (c == ' ' || c == '\n') {
            type = TokenType.GONGBAEK;
            result = String.valueOf(c);
        }
        else if (c >= '0' && c <= '9') {
            type = TokenType.SUTJA;
            result = String.valueOf(Sutja.fromChar(c).getBraille());
        }
        else {
            type = TokenType.BUHO;
            result = Buho.fromChar(c).getBraille();
        }

        return new BrailleToken(result, type, geul, false);
    }
}