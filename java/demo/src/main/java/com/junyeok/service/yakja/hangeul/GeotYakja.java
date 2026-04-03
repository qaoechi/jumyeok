package com.junyeok.service.yakja.hangeul;

import com.junyeok.constants.hangeul.yakja.Geot;
import com.junyeok.model.braille.HanGeulContext;

public class GeotYakja {
    public static void apply(HanGeulContext context) {
        if (context.choseong == 'ㄱ' && context.jungseong.equals("ㅓ") && context.jongseong == 'ㅅ') {
            if (context.gyeopbatchim == '\0') {
                context.choseong = '\0';
                context.jungseong = Geot.약자.getBraille();
                context.jongseong = '\0';
                context.is = true;
            }
        }
    }
}