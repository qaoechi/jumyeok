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
import java.util.stream.Collectors;

import com.junyeok.model.Buho;
import com.junyeok.model.DeaMunJa;
import com.junyeok.model.Geul;
import com.junyeok.model.GongBaek;
import com.junyeok.model.HanGeul;
import com.junyeok.model.SoMunJa;
import com.junyeok.model.SutJa;
import com.junyeok.model.braille.BrailleToken;
import com.junyeok.model.braille.TokenType;
import com.junyeok.service.jungja.BuHoStrategy;
import com.junyeok.service.jungja.DeaMunJaStrategy;
import com.junyeok.service.jungja.GongBaekStrategy;
import com.junyeok.service.jungja.HanGeulStrategy;
import com.junyeok.service.jungja.JungJaStrategy;
import com.junyeok.service.jungja.SoMunJaStrategy;
import com.junyeok.service.jungja.SutJaStrategy;
import com.junyeok.service.tokenize.GeulTypeResolver;
import com.junyeok.service.yakja.HanGeulYakJa;

public class Main {
    public static void main(String[] args) {
        Map<Class<? extends Geul>, JungJaStrategy> startegies = Map.of(
            HanGeul.class, new HanGeulStrategy(),
            SutJa.class, new SutJaStrategy(),
            GongBaek.class, new GongBaekStrategy(),
            SoMunJa.class, new SoMunJaStrategy(),
            DeaMunJa.class, new DeaMunJaStrategy(),
            Buho.class, new BuHoStrategy()
        );

        List<String> input = new ArrayList<>();
        input.add("아 그 냥 쫌 빍 쮋\n");
        input.add("가 나 라 사 방 까 싺\n");
        input.add("았 갔 쩠\n");
        input.add("엷 옥 늘 쑬\n");
        input.add("영엉 성정쩡청썽 경겅");
        // input.add("아아-1\n2");
        
        List<Geul> result = input.stream()
            .flatMap(in -> in.chars().mapToObj(c -> (char) c))
            .map(c -> GeulTypeResolver.resolve(c).create(c))
            .toList();

        String output = result.stream()
            .map(geul -> {
                return startegies.get(geul.getClass()).uncontracted(geul);
            })
            .map(geul -> {
                if (geul.getType() == TokenType.HANGEUL) return HanGeulYakJa.contraction(geul); 
                return geul;
            })
            .map(BrailleToken::toString)
            .map(s -> s.replace("\0", ""))
            .collect(Collectors.joining());
            
        try (Writer writer = new BufferedWriter(
            new OutputStreamWriter(new FileOutputStream("java/demo/target/ouput.txt"), StandardCharsets.UTF_8)
        )) {
            writer.write(output);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}