package com.jumyeok;

import java.util.List;
import java.util.Map;

import com.jumyeok.model.mukja.Buho;
import com.jumyeok.model.mukja.Geul;
import com.jumyeok.model.mukja.Gongbaek;
import com.jumyeok.model.mukja.Hangeul;
import com.jumyeok.model.mukja.Sutja;
import com.jumyeok.model.mukja.Yeongeo;
import com.jumyeok.service.rule.BRFEngine;
import com.jumyeok.service.rule.RuleEngine;
import com.jumyeok.service.tokenize.GeulTypeResolver;
import com.jumyeok.service.yakja.BuhoYakja;
import com.jumyeok.service.yakja.GongbaekYakja;
import com.jumyeok.service.yakja.HangeulYakja;
import com.jumyeok.service.yakja.SutjaYakja;
import com.jumyeok.service.yakja.YakjaStrategy;
import com.jumyeok.service.yakja.YeongeoYakja;

public class ClassroomJumyeok {
    private Map<Class<? extends Geul>, YakjaStrategy> yakjaMapper = Map.of(
        Hangeul.class, new HangeulYakja(),
        Yeongeo.class, new YeongeoYakja(),
        Sutja.class, new SutjaYakja(),
        Buho.class, new BuhoYakja(),
        Gongbaek.class, new GongbaekYakja()
    );
    private RuleEngine engine = new RuleEngine();
    private List<String> input;

    public String classroomSign() {
        return BRFEngine.toBRF(
            engine.process(
                this.input.stream().flatMap(in -> 
                    (in + "\n").chars().mapToObj(c -> (char) c))
                .map(c -> GeulTypeResolver.resolve(c).create(c))
                .map(geul -> {
                    return this.yakjaMapper.get(geul.getClass()).contraction(geul);
                })
                .toList()
        ));
    }

    public void setInput(List<String> input) {
        this.input = input;
    }
}