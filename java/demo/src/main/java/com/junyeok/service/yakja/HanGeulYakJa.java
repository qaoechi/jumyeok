package com.junyeok.service.yakja;

import com.junyeok.constants.hangeulJumja.DoenSoRi;
import com.junyeok.constants.yakja.ASaengLyak;
import com.junyeok.constants.yakja.BatChimSaengLyak;
import com.junyeok.constants.yakja.Eong;
import com.junyeok.constants.yakja.Geot;
import com.junyeok.constants.yakja.SsangSiOt;
import com.junyeok.model.HanGeul;
import com.junyeok.model.braille.BrailleToken;
import com.junyeok.utils.transcriptor.ChoseongTranscription;
import com.junyeok.utils.transcriptor.JongseongTranscription;
import com.junyeok.utils.transcriptor.JungseongTranscription;

public class HanGeulYakJa {
    public static BrailleToken contraction(BrailleToken geul) {
        HanGeul hangeul = (HanGeul) geul.getOrigin();
        HanGeulContext context = new HanGeulContext(hangeul);

        applySsangSiOt(context);
        if (!context.is) applyASaengLyak(context);
        if (!context.is) applyBatChimSaengLyak(context);
        if (!context.is) applyEong(context);
        if (!context.is) applyGeot(context);

        StringBuilder result = new StringBuilder();
        result.append(hangeul.getDoensori() != '\0' ? DoenSoRi.쌍.getDoen() : hangeul.getDoensori())
            .append(ChoseongTranscription.getChoseongBraille(context.choseong))
            .append(JungseongTranscription.getJungseongBraille(context.jungseong.charAt(0)))
            .append(JongseongTranscription.getJongseongBraille(context.jongseong))
            .append(JongseongTranscription.getJongseongBraille(context.gyeopbatchim));

        return new BrailleToken(result.toString(), geul.getType(), hangeul, context.is);
    }

    private static void applySsangSiOt(HanGeulContext context) {
        if (context.gyeopbatchim == 'ㅅ' && context.jongseong == 'ㅅ') {
            context.jongseong = SsangSiOt.ㅆ.getSs();
            context.gyeopbatchim = '\0';
        }
    }
    private static void applyASaengLyak(HanGeulContext context) {
        if (context.jungseong.equals("ㅏ")) {
            ASaengLyak cho = ASaengLyak.fromChar(context.choseong);
            if (cho != null) {
                context.choseong = cho.getASaengLyak();
                context.jungseong = "a";
                context.is = true;
            }
        }
    }
    private static void applyBatChimSaengLyak(HanGeulContext context) {
        BatChimSaengLyak batchim = BatChimSaengLyak.fromChar(context.jungseong + "" + context.jongseong);
        if (batchim != null) {
            context.jungseong = "a";
            context.jongseong = batchim.getBatChimSaengLyak();
            context.is = true;
        }
    }
    private static void applyEong(HanGeulContext context) {
        if ((context.jungseong + context.jongseong).equals("ㅓㅇ")) {
            Eong eong = Eong.fromChar(context.choseong);
            if (eong != null) {
                context.jungseong = "a";
                context.jongseong = BatChimSaengLyak.영.getBatChimSaengLyak();
            }

        }
    }
    private static void applyGeot(HanGeulContext context) {
        if (context.choseong == 'ㄱ' && context.jungseong.equals("ㅓ") && context.jongseong == 'ㅅ') {
            if (context.gyeopbatchim == '\0') {
                context.choseong = '\0';
                context.jungseong = Geot.것.getThing();
                context.jongseong = '\0';
                context.is = true;
            }
        }
    }
}