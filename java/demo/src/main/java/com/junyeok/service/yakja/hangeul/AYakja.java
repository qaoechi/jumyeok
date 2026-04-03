package com.junyeok.service.yakja.hangeul;

import com.junyeok.constants.hangeul.yakja.ASaengLyak;
import com.junyeok.model.braille.HanGeulContext;

public class AYakja {
    public static void apply(HanGeulContext context) {
        if (context.jungseong.equals("ㅏ")) {
            ASaengLyak cho = ASaengLyak.fromChar(context.choseong);
            if (cho != null) {
                context.choseong = cho.getBraille();
                context.jungseong = "";
                context.is = true;
            }
        }
    }
}