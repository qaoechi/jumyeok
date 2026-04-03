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

import com.junyeok.model.braille.BrailleToken;
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

        List<String> input = new ArrayList<>();
        input.add("아 그 냥 쫌 빍 쮋\n");
        input.add("가 나 라 사 방 까 싺\n");
        input.add("았 갔 쩠\n");
        input.add("엷 옥 늘 쑬\n");
        input.add("영엉 성정쩡청썽 경겅\n");
        input.add("aA sd-1\n2");
        
        List<Geul> result = input.stream()
            .flatMap(in -> in.chars().mapToObj(c -> (char) c))
            .map(c -> GeulTypeResolver.resolve(c).create(c))
            .toList();

        List<BrailleToken> jungja = result.stream()
            .map(geul -> {
                return jungjaMapper.get(geul.getClass()).uncontracted(geul);
            })
            .toList();
        List<BrailleToken> yakja = result.stream()
            .map(geul -> {
                return yakjaMapper.get(geul.getClass()).contraction(geul);
            }).toList();

        String output = 
            // jungja
            yakja
            .stream()
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