package com.junyeok.constants.otherBraille;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SoMunJa {
    a('⠁'),
    b('⠃'),
    c('⠉'),
    d('⠙'),
    e('⠑'),
    f('⠋'),
    g('⠛'),
    h('⠓'),
    i('⠊'),
    j('⠚'),
    k('⠅'),
    l('⠇'),
    m('⠍'),
    n('⠝'),
    o('⠕'),
    p('⠏'),
    q('⠟'),
    r('⠗'),
    s('⠎'),
    t('⠞'),
    u('⠥'),
    v('⠧'),
    w('⠺'),
    x('⠭'),
    y('⠽'),
    z('⠵');

    private final char braille;
    private static final Map<Character, SoMunJa> alphabet =
        Arrays.stream(values())
            .collect((Collectors.toMap(s -> s.braille, s -> s)));

    public static SoMunJa fromChar(char a) {
        return alphabet.get(a);
    }
}