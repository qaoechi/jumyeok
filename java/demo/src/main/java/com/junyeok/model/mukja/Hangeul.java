package com.junyeok.model.mukja;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Hangeul implements Geul {
    private final char doensori;
    private final char choseong;
    private final char jungseong;
    private final char jongseong;
    private final char gyeopbatchim;

    @Override
    public char getChar() {
        return '\0';
    }
}