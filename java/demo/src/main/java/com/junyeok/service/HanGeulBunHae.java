package com.junyeok.service;

import com.junyeok.constants.GyeopBatChim;
import com.junyeok.constants.HanGeulMukJa;
import com.junyeok.constants.SsangJaEum;
import com.junyeok.model.Geul;
import com.junyeok.model.HanGeul;

public class HanGeulBunHae {
    public static HanGeul bunhae(String c) {
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
    public static Geul splitGyeop(HanGeul hangeul) {
        String doensori = "";
        String choseong = hangeul.getChoseong();
        String jongseong = hangeul.getJongseong();
        String jungseong = hangeul.getJungseong();
        String gyeop = "";

        SsangJaEum jaeum = SsangJaEum.fromChar(choseong);
        if (jaeum != null) {
            doensori = jaeum.getJaeum();
            choseong = jaeum.getJaeum();
        }
        GyeopBatChim batchim = GyeopBatChim.fromChar(jongseong);
        if (batchim != null) {
            jongseong = batchim.getFirst();
            gyeop = batchim.getSecond();
        }

        return HanGeul.builder()
            .doensori(doensori)
            .choseong(choseong)
            .jungseong(jungseong)
            .jongseong(jongseong)
            .gyeopbatchim(gyeop)
            .build();
    }
}