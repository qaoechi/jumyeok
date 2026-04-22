package com.jumyeok.service.yakja.hangeul;

import com.jumyeok.constants.hangeul.yakja.ASaengLyak;
import com.jumyeok.model.braille.HanGeulContext;

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