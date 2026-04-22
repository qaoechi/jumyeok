package com.jumyeok.service.yakja;

import com.jumyeok.model.braille.BrailleToken;
import com.jumyeok.model.braille.HanGeulContext;
import com.jumyeok.model.braille.TokenType;
import com.jumyeok.model.mukja.Geul;
import com.jumyeok.model.mukja.Hangeul;
import com.jumyeok.service.yakja.hangeul.AYakja;
import com.jumyeok.service.yakja.hangeul.BatchimYakja;
import com.jumyeok.service.yakja.hangeul.EongYakka;
import com.jumyeok.service.yakja.hangeul.GeotYakja;
import com.jumyeok.service.yakja.hangeul.SsangSiotYakja;
import com.jumyeok.utils.transcriptor.ChoseongTranscription;
import com.jumyeok.utils.transcriptor.DoensoriTranscription;
import com.jumyeok.utils.transcriptor.JongseongTranscription;
import com.jumyeok.utils.transcriptor.JungseongTranscription;

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