package com.junyeok.service.yakja;

import com.junyeok.model.braille.BrailleToken;
import com.junyeok.model.braille.HanGeulContext;
import com.junyeok.model.braille.TokenType;
import com.junyeok.model.mukja.Geul;
import com.junyeok.model.mukja.Hangeul;
import com.junyeok.service.yakja.hangeul.AYakja;
import com.junyeok.service.yakja.hangeul.BatchimYakja;
import com.junyeok.service.yakja.hangeul.EongYakka;
import com.junyeok.service.yakja.hangeul.GeotYakja;
import com.junyeok.service.yakja.hangeul.SsangSiotYakja;
import com.junyeok.utils.transcriptor.ChoseongTranscription;
import com.junyeok.utils.transcriptor.DoensoriTranscription;
import com.junyeok.utils.transcriptor.JongseongTranscription;
import com.junyeok.utils.transcriptor.JungseongTranscription;

public class HangeulYakja implements YakjaStrategy {

    @Override
    public BrailleToken contraction(Geul geul) {
        Hangeul hangeul = (Hangeul) geul;
        HanGeulContext context = new HanGeulContext(hangeul);

        SsangSiotYakja.apply(context);
        if (!context.is) AYakja.apply(context);
        if (!context.is) BatchimYakja.apply(context);
        if (!context.is) EongYakka.apply(context);
        if (!context.is) GeotYakja.apply(context);

        StringBuilder result = new StringBuilder();
        result.append(DoensoriTranscription.getBraille(hangeul.getDoensori()))
            .append(ChoseongTranscription.getBraille(context.choseong))
            .append(JungseongTranscription.getBraille(context.jungseong))
            .append(JongseongTranscription.getBraille(context.jongseong))
            .append(JongseongTranscription.getBraille(context.gyeopbatchim));

        return new BrailleToken(result.toString(), TokenType.HANGEUL, hangeul, context.is);
    }
}