입력은 문자열 리스트다.

출력은 Token 리스트다.

각 객체는 다음 구조 중 하나를 가진다:

1. 단일 문자 기반
{
    type: SUTJA | YEONGEO | BUHO | GONGBAEK
    data: char
}

2. 분해된 한글 기반
{
    type: HANGEUL
    data: {
        doensori: boolean
        choseong: char
        jungseong: char
        jongseong: char
        gyeopbatchim: char
    }
}