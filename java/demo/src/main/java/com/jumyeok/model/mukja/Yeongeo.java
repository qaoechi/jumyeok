package com.jumyeok.model.mukja;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Yeongeo implements Geul {
    private boolean isUpper;
    private char c;

    public Yeongeo(char c) {
        if (Character.isUpperCase(c)) {
            isUpper = true;
            this.c = Character.toLowerCase(c);
        } else {
            isUpper = false;
            this.c = c;
        }
    }

    @Override
    public char getChar() {
        return this.c;
    }
}