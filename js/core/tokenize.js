import { hanGeulBunHae } from "./hanGeulBunHae.js";

export const createToken = (list) => 
    list.flatMap(element =>
        [...element].map(char => ({
            data: hanGeulBunHae(char) ?? char,
        }))
    );