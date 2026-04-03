package com.junyeok.service.tokenize;

import com.junyeok.constants.hangeul.mukja.DoenSori;
import com.junyeok.constants.hangeul.mukja.GyeopBatchim;
import com.junyeok.constants.hangeul.mukja.HangeulMukja;
import com.junyeok.model.mukja.Geul;
import com.junyeok.model.mukja.Hangeul;

public class HanGeulBunHae {
    public static Hangeul bunhae(char c) {
        int base = c - 0xAC00;

        int cho = base / (21 * 28);
        int jung = (base % (21 * 28)) / 28;
        int jong = base % 28;

        char choseong = HangeulMukja.CHOSEONG[cho];
        char jungseong = HangeulMukja.JUNGSEONG[jung];
        char jongseong = HangeulMukja.JONGSEONG[jong];

        return Hangeul.builder()
            .choseong(choseong)
            .jungseong(jungseong)
            .jongseong(jongseong)
            .build();
    }
    public static Geul splitGyeop(Hangeul hangeul) {
        char doensori = '\0';
        char choseong = hangeul.getChoseong();
        char jongseong = hangeul.getJongseong();
        char jungseong = hangeul.getJungseong();
        char gyeop = '\0';

        DoenSori jaeum = DoenSori.fromChar(choseong);
        if (jaeum != null) {
            doensori = jaeum.getJaeum();
            choseong = jaeum.getJaeum();
        }
        GyeopBatchim batchim = GyeopBatchim.fromChar(jongseong);
        if (batchim != null) {
            jongseong = batchim.getFirst();
            gyeop = batchim.getSecond();
        }

        return Hangeul.builder()
            .doensori(doensori)
            .choseong(choseong)
            .jungseong(jungseong)
            .jongseong(jongseong)
            .gyeopbatchim(gyeop)
            .build();
    }
}