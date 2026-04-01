package com.junyeok.service.tokenize;

import com.junyeok.constants.hangeul.GyeopBatChim;
import com.junyeok.constants.hangeul.HanGeulMukJa;
import com.junyeok.constants.hangeul.SsangJaEum;
import com.junyeok.model.Geul;
import com.junyeok.model.HanGeul;

public class HanGeulBunHae {
    public static HanGeul bunhae(char c) {
        int base = c - 0xAC00;

        int cho = base / (21 * 28);
        int jung = (base % (21 * 28)) / 28;
        int jong = base % 28;

        char choseong = HanGeulMukJa.HANGEUL_CHOSEONG[cho];
        char jungseong = HanGeulMukJa.HANGEUL_JUNGSEONG[jung];
        char jongseong = HanGeulMukJa.HANGEUL_JONGSEONG[jong];

        return HanGeul.builder()
            .choseong(choseong)
            .jungseong(jungseong)
            .jongseong(jongseong)
            .build();
    }
    public static Geul splitGyeop(HanGeul hangeul) {
        char doensori = '\0';
        char choseong = hangeul.getChoseong();
        char jongseong = hangeul.getJongseong();
        char jungseong = hangeul.getJungseong();
        char gyeop = '\0';

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