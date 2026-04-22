package com.jumyeok.service.jungja;

import com.jumyeok.model.braille.BrailleToken;
import com.jumyeok.model.braille.TokenType;
import com.jumyeok.model.mukja.Geul;
import com.jumyeok.model.mukja.Hangeul;
import com.jumyeok.utils.transcriptor.ChoseongTranscription;
import com.jumyeok.utils.transcriptor.DoensoriTranscription;
import com.jumyeok.utils.transcriptor.JongseongTranscription;
import com.jumyeok.utils.transcriptor.JungseongTranscription;

public class HangeulStrategy implements JungjaStrategy {

    @Override
    public BrailleToken uncontracted(Geul geul) {
        StringBuilder result = new StringBuilder();
        Hangeul hanGeul = (Hangeul)geul;
        
        if (hanGeul.getDoensori() != '\0') result.append(DoensoriTranscription.getBraille(hanGeul.getDoensori()));
        result.append(ChoseongTranscription.getBraille(hanGeul.getChoseong()));
        result.append(JungseongTranscription.getBraille(hanGeul.getJungseong() + ""));
        if (hanGeul.getJongseong() != '\0') result.append(JongseongTranscription.getBraille(hanGeul.getJongseong()));
        if (hanGeul.getGyeopbatchim() != '\0') result.append(JongseongTranscription.getBraille(hanGeul.getGyeopbatchim()));
        
        return new BrailleToken(result.toString(), TokenType.HANGEUL, geul, false);
    }
}
