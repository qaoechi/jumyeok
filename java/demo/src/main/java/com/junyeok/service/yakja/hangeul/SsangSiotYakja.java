package com.junyeok.service.yakja.hangeul;

import com.junyeok.constants.hangeul.yakja.SsangSiot;
import com.junyeok.model.braille.HanGeulContext;

public class SsangSiotYakja {
    public static void apply(HanGeulContext context) {
        if (context.gyeopbatchim == 'ㅅ' && context.jongseong == 'ㅅ') {
            context.jongseong = SsangSiot.약자.getBraille();
            context.gyeopbatchim = '\0';
        }
    }
}