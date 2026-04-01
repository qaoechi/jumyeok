import { JUMJA_CHOSEONG, JUMJA_JUNGSEONG, JUMJA_JONGSEONG, DOENSORI } from "../../constant/hangeul/hangeulJumja.js";
import { JUMJA_SUTJA } from "../../constant/otherBraille/sutjaJumja.js";
import { JUMJA_YEONGEO } from "../../constant/otherBraille/YeongEoJumja.js";
import { JUMJA_BUHO } from "../../constant/otherBraille/BuhoJumja.js";

export const jungja = (geul) => {
    switch (geul.type) {
        case "HANGEUL":
            geul.data = hangeulJungja(geul.data);
            return geul
        case "SUTJA":
            geul.data.vaule = JUMJA_SUTJA[geul.data.value] ?? '';
            return geul;
        case "GONGBEAK":
            return geul;
        case "SOMUNJA":
            geul.data.vaule = JUMJA_YEONGEO[geul.data.value] ?? '';
            return geul;
        case "DEAMUNJA":
            geul.data.vaule = JUMJA_YEONGEO[geul.data.value.toLowerCase()] ?? '';
            return geul;
        default:
            geul.data.vaule = JUMJA_BUHO[geul.data.value] ?? '';
            return geul;
    }
}

const hangeulJungja = (hangeul) => {
    return {
        doensori: hangeul.doensori ? DOENSORI : '',
        choseong: JUMJA_CHOSEONG[hangeul.choseong],
        choseong: JUMJA_JUNGSEONG[hangeul.jungseong],
        choseong: JUMJA_JONGSEONG[hangeul.jongseong],
        gyeopbatchim: JUMJA_JONGSEONG[hangeul.gyeopbatchim]
    }
}