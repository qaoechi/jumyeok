package com.junyeok.service;

import com.junyeok.constants.HanGeulMukJa;
import com.junyeok.model.Geul;
import com.junyeok.model.HanGeul;

public class HanGeulBunHae {
    public static Geul bunhae(String c) {
        int base = c.charAt(0) - 0xAC00;
        if (base < 0 || base >= 0x2BA3) return null;

        int cho = base / (21 * 28);
        int jung = (base % (21 * 28)) / 28;
        int jong = base % 28;

        String choseong = HanGeulMukJa.HANGEUL_CHOSEONG[cho];
        String jungseong = HanGeulMukJa.HANGEUL_JUNGSEONG[jung];
        String jongseong = HanGeulMukJa.HANGEUL_JONGSEONG[jong];

        return HanGeul.builder()
            .choseong(choseong)
            .jungseong(jungseong)
            .jongseong(jongseong)
            .build();
    }
}