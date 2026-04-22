package com.jumyeok.service.yakja.hangeul;

import com.jumyeok.constants.hangeul.yakja.BatchimSaenglyak;
import com.jumyeok.model.braille.HanGeulContext;

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