package com.junyeok.service.yakja.hangeul;

import com.junyeok.constants.hangeul.yakja.BatchimSaenglyak;
import com.junyeok.model.braille.HanGeulContext;

public class BatchimYakja {
    public static void apply(HanGeulContext context) {
        BatchimSaenglyak batchim = BatchimSaenglyak.fromChar(context.jungseong + "" + context.jongseong);
        if (batchim != null) {
            context.jungseong = "";
            context.jongseong = batchim.getBraille();
            context.is = true;
        }
    }
}