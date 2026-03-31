import { HANGEUL_CHOSEONG, HANGEUL_JUNGSEONG, HANGEUL_JONGSEONG, SSANGJAEUM, GYEOPBATCHIM } from "../constant/hangeul/hangeul-mukja.js";

export const hanGeulBunHae = (char) => {
    const base = char.charCodeAt(0) - 0xAC00;
    if (base < 0 || base >= 0x2BA3) return null;

    const cho = Math.floor(base / (21 * 28));
    const jung = Math.floor((base % (21 * 28)) / 28);
    const jong = base % 28;

    const choseong = HANGEUL_CHOSEONG[cho];
    const jungseong = HANGEUL_JUNGSEONG[jung];
    const jongseong = HANGEUL_JONGSEONG[jong];

    return decompose({choseong, jungseong, jongseong});
}

function decompose({choseong, jungseong, jongseong}) {
    let doensori, gyeopbatchim;
    
    let cho = SSANGJAEUM.get(choseong) ?? choseong;
    if (SSANGJAEUM.get(choseong)) doensori = true;
    
    let jong = GYEOPBATCHIM.get(jongseong) ?? jongseong;
    if (GYEOPBATCHIM.get(jongseong)) {
        jongseong = jong.at(0);
        gyeopbatchim = jong.at(-1);
    }

    return {
            doensori,
            choseong: cho,
            jungseong,
            jongseong: jongseong,
            gyeopbatchim
    }
}