package com.junyeok.service.tokenize;

import com.junyeok.model.mukja.GeulType;

public class GeulTypeResolver {
    public static GeulType resolve(char c) {
        if (c >= '가' && c <= '힣') return GeulType.HANGEUL;
        if (c >= 'a' && c <= 'z') return GeulType.SOMUNJA;
        if (c >= 'A' && c <= 'Z') return GeulType.DEAMUNJA;
        if (c == ' ' || c == '\n') return GeulType.GONGBAEK;
        if (c >= '0' && c <= '9') return GeulType.SUTJA;
        return GeulType.Buho;
    }
}