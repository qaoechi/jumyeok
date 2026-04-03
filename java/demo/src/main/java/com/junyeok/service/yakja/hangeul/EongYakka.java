package com.junyeok.service.yakja.hangeul;

import com.junyeok.constants.hangeul.yakja.BatchimSaenglyak;
import com.junyeok.constants.hangeul.yakja.Eong;
import com.junyeok.model.braille.HanGeulContext;

public class EongYakka {
    public static void apply(HanGeulContext context) {
        if ((context.jungseong + context.jongseong).equals("ㅓㅇ")) {
            Eong eong = Eong.fromChar(context.choseong);
            if (eong != null) {
                context.jungseong = "";
                context.jongseong = BatchimSaenglyak.영.getBraille();
            }
        }
    }
}