package com.jumyeok.service.tokenize;

import com.jumyeok.model.mukja.GeulType;

public class GeulTypeResolver {
    public static GeulType resolve(char c) {
        if (c >= '가' && c <= '힣') return GeulType.HANGEUL;
        if (65 <= c && c <= 122) return GeulType.YEONGEO;
        if (c == ' ' || c == '\n') return GeulType.GONGBAEK;
        if (c >= '0' && c <= '9') return GeulType.SUTJA;
        return GeulType.Buho;
    }
}