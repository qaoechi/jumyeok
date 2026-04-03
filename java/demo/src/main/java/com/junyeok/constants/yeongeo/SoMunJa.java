package com.junyeok.constants.yeongeo;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SoMunja {
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
    private static final Map<Character, SoMunja> MAP =
        Arrays.stream(values())
            .collect((Collectors.toMap(s -> s.name().charAt(0), s -> s)));

    public static SoMunja fromChar(char a) {
        return MAP.get(a);
    }
}