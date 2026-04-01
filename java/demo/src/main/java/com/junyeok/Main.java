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

import com.junyeok.model.Geul;
import com.junyeok.service.jungja.HanGeulStrategy;
import com.junyeok.service.jungja.JunJaStrategy;
import com.junyeok.service.tokenize.GeulTypeResolver;

public class Main {
    public static void main(String[] args) {
        List<JunJaStrategy> jungja = List.of(new HanGeulStrategy());
        List<String> input = new ArrayList<>();
        input.add("as\nd");
        input.add("쀍");
        input.add(" 강의실");
        
        List<Geul> result = input.stream()
            .flatMap(in -> in.chars().mapToObj(c -> (char) c))
            .map(c -> GeulTypeResolver.resolve(c).create(c))
            .toList();

        try (Writer writer = new BufferedWriter(
            new OutputStreamWriter(new FileOutputStream("java/demo/target/ouput.txt"), StandardCharsets.UTF_8)
        )) {
            writer.write("a");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}