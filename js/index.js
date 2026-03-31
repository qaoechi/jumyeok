import { createToken } from "./core/tokenize.js";

const input = ["101 강의실", "B102-1 뿕"];

const output = createToken(input);
console.log(output);