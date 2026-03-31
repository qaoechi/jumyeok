package com.junyeok;

import java.util.ArrayList;
import java.util.List;

import com.junyeok.model.Geul;
import com.junyeok.model.HanGeul;
import com.junyeok.service.HanGeulBunHae;

public class Main {
    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        input.add("asd");
        input.add("쀍");

        HanGeul asd = HanGeulBunHae.bunhae("쀍");
        Geul qwe = HanGeulBunHae.splitGyeop(asd);
        System.out.println(qwe.render());
        
        // for (Geul geul : createToken(input)) {
        //     System.out.println(geul.render());
        // }
    }
}