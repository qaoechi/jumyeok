package com.junyeok;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.junyeok.model.mukja.Buho;
import com.junyeok.model.mukja.Geul;
import com.junyeok.model.mukja.Gongbaek;
import com.junyeok.model.mukja.Hangeul;
import com.junyeok.model.mukja.Yeongeo;
import com.junyeok.model.mukja.Sutja;
import com.junyeok.service.jungja.BuhoStrategy;
import com.junyeok.service.jungja.GongbaekStrategy;
import com.junyeok.service.jungja.HangeulStrategy;
import com.junyeok.service.jungja.JungjaStrategy;
import com.junyeok.service.jungja.YeongeoStrategy;
import com.junyeok.service.rule.BRFEngine;
import com.junyeok.service.rule.RuleEngine;
import com.junyeok.service.jungja.SutjaStrategy;
import com.junyeok.service.tokenize.GeulTypeResolver;
import com.junyeok.service.yakja.BuhoYakja;
import com.junyeok.service.yakja.GongbaekYakja;
import com.junyeok.service.yakja.HangeulYakja;
import com.junyeok.service.yakja.SutjaYakja;
import com.junyeok.service.yakja.YakjaStrategy;
import com.junyeok.service.yakja.YeongeoYakja;

public class Main {
    public static void main(String[] args) {
        Map<Class<? extends Geul>, JungjaStrategy> jungjaMapper = Map.of(
            Hangeul.class, new HangeulStrategy(),
            Sutja.class, new SutjaStrategy(),
            Gongbaek.class, new GongbaekStrategy(),
            Yeongeo.class, new YeongeoStrategy(),
            Buho.class, new BuhoStrategy()
        );
        Map<Class<? extends Geul>, YakjaStrategy> yakjaMapper = Map.of(
            Hangeul.class, new HangeulYakja(),
            Yeongeo.class, new YeongeoYakja(),
            Sutja.class, new SutjaYakja(),
            Buho.class, new BuhoYakja(),
            Gongbaek.class, new GongbaekYakja()
        );
        RuleEngine engine = new RuleEngine();

        List<String> input = new ArrayList<>();
        input.add("혜당207 이공칠렂 학생쉼터→ 혜당207 이공칠 학생쉼터");
        input.add("아이m 청jo");
        input.add("마음이 라음 녜 났 나예 와앤 와인");
        input.add("감 겳 운");
        input.add("123-1운동");

        String output = BRFEngine.toBRF(
            engine.process(
                input.stream().flatMap(in -> 
                    (in + "\n").chars().mapToObj(c -> (char) c))
                .map(c -> GeulTypeResolver.resolve(c).create(c))
                .map(geul -> {
                    // return jungjaMapper.get(geul.getClass()).uncontracted(geul);
                    return yakjaMapper.get(geul.getClass()).contraction(geul);
                })
                .toList()
        ));
            
        try (Writer writer = new BufferedWriter(
            new OutputStreamWriter(new FileOutputStream("java/demo/target/ouput.brf"), StandardCharsets.UTF_8)
        )) {
            writer.write(output);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}