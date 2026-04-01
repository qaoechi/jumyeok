import { jungja } from "./core/jungja/toJungJa.js";
import { createToken } from "./core/tokenize.js";

const input = ["101 강의실", "B\n102-1 뿕"];

const output = createToken(input)
    .map(jungja)
;
console.log(output);