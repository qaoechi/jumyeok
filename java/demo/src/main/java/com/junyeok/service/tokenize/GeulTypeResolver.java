package com.junyeok.service.tokenize;

import com.junyeok.model.GeulType;

public class GeulTypeResolver {
    public static GeulType resolve(char c) {
        if (c >= '가' && c <= '힣') return GeulType.HANGEUL;
        if (c >= 'a' && c <= 'z') return GeulType.YeongEo;
        if (c == ' ' || c == '\n') return GeulType.GONGBAEK;
        if (c >= '0' && c <= '9') return GeulType.SutJa;
        return GeulType.Buho;
    }
}