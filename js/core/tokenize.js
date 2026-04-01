import { hanGeulBunHae } from "./hanGeulBunHae.js";
import { TYPE } from "../constant/brailleType.js";

export const createToken = (list) => 
    list.flatMap(element =>
        [...element].map(char => ({
            type: setType(char),
            data: hanGeulBunHae(char) ?? {value: char},
        }))
    );

function setType(char) {
    if (/[가-힣]/.test(char)) return TYPE.HANGEUL
    if (/[0-9]/.test(char)) return TYPE.SUTJA;
    if (/[a-z]/.test(char)) return TYPE.SOMUNJASUTJA;
    if (/[A-Z]/.test(char)) return TYPE.DEAMUNJASUTJA;
    if (char == " " || char == "\n") return TYPE.GONGBAEKSUTJA;
    return TYPE.BUHO;
}