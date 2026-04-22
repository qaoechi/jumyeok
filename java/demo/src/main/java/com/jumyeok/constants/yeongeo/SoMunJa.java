package com.jumyeok.constants.yeongeo;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SoMunJa {
    a("⠁"),
    b("⠃"),
    c("⠉"),
    d("⠙"),
    e("⠑"),
    f("⠋"),
    g("⠛"),
    h("⠓"),
    i("⠊"),
    j("⠚"),
    k("⠅"),
    l("⠇"),
    m("⠍"),
    n("⠝"),
    o("⠕"),
    p("⠏"),
    q("⠟"),
    r("⠗"),
    s("⠎"),
    t("⠞"),
    u("⠥"),
    v("⠧"),
    w("⠺"),
    x("⠭"),
    y("⠽"),
    z("⠵");

    private final String braille;
    private static final Map<String, SoMunJa> MAP =
        Arrays.stream(values())
            .collect((Collectors.toMap(s -> s.name(), s -> s)));

    public static SoMunJa fromChar(String a) {
        return MAP.get(a);
    }
}