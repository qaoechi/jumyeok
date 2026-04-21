package com.junyeok.constants.rule;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BRFMap {
    public static final Map<Character, Character> BRF = Map.ofEntries(
        Map.entry('⠁', 'a'),
        Map.entry('⠂', '1'),
        Map.entry('⠃', 'b'),
        Map.entry('⠄', '\''),
        Map.entry('⠅', 'k'),
        Map.entry('⠆', '2'),
        Map.entry('⠇', 'l'),
        Map.entry('⠈', '@'),
        Map.entry('⠉', 'c'),
        Map.entry('⠊', 'i'),
        Map.entry('⠋', 'f'),
        Map.entry('⠌', '/'),
        Map.entry('⠍', 'm'),
        Map.entry('⠎', 's'),
        Map.entry('⠏', 'p'),
        Map.entry('⠐', '\"'),
        Map.entry('⠑', 'e'),
        Map.entry('⠒', '3'),
        Map.entry('⠓', 'h'),
        Map.entry('⠔', '9'),
        Map.entry('⠕', 'o'),
        Map.entry('⠖', '6'),
        Map.entry('⠗', 'r'),
        Map.entry('⠘', '^'),
        Map.entry('⠙', 'd'),
        Map.entry('⠚', 'j'),
        Map.entry('⠛', 'g'),
        Map.entry('⠜', '>'),
        Map.entry('⠝', 'n'),
        Map.entry('⠞', 't'),
        Map.entry('⠟', 'q'),
        Map.entry('⠠', ','),
        Map.entry('⠡', '*'),
        Map.entry('⠢', '5'),
        Map.entry('⠣', '<'),
        Map.entry('⠤', '-'),
        Map.entry('⠥', 'u'),
        Map.entry('⠦', '8'),
        Map.entry('⠧', 'v'),
        Map.entry('⠨', '.'),
        Map.entry('⠩', '%'),
        Map.entry('⠪', '['),
        Map.entry('⠫', '$'),
        Map.entry('⠬', '+'),
        Map.entry('⠭', 'x'),
        Map.entry('⠮', '!'),
        Map.entry('⠯', '&'),
        Map.entry('⠰', ';'),
        Map.entry('⠱', ':'),
        Map.entry('⠲', '4'),
        Map.entry('⠳', '\\'),
        Map.entry('⠴', '0'),
        Map.entry('⠵', 'z'),
        Map.entry('⠶', '7'),
        Map.entry('⠷', '('),
        Map.entry('⠸', '_'),
        Map.entry('⠹', '?'),
        Map.entry('⠺', 'w'),
        Map.entry('⠻', ']'),
        Map.entry('⠼', '#'),
        Map.entry('⠽', 'y'),
        Map.entry('⠾', ')'),
        Map.entry('⠿', '=')
    );
    
    public static char get(char c) {
        return BRF.getOrDefault(c, c);
    }
}