import { hanGeulBunHae } from "./hanGeulBunHae.js";
import { TYPE } from "../constant/brailleType.js";

export const createToken = (list) => 
    list.flatMap(element =>
        [...element].map(char => ({
            data: hanGeulBunHae(char) ?? createObject(char),
        }))
    );

function createObject(char) {
    if (/[0-9]/.test(char)) return {type: TYPE.SUTJA, vaule: char}
    if (/[a-z]/.test(char)) return {type: TYPE.SOMUNJA, vaule: char}
    if (/[A-Z]/.test(char)) return {type: TYPE.DEAMUNJA, vaule: char}
    if (char == " " || char == "\n") return {type: TYPE.GONGBAEK, value: char}
    return {type: TYPE.BUHO, vaule: char}
}