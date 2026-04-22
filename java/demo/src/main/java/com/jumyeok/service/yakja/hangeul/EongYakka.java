package com.jumyeok.service.yakja.hangeul;

import com.jumyeok.constants.hangeul.yakja.BatchimSaenglyak;
import com.jumyeok.constants.hangeul.yakja.Eong;
import com.jumyeok.model.braille.HanGeulContext;

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