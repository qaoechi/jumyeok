입력은 객체 리스트다.

각 객체는 다음 구조 중 하나를 가진다:

1. 단일 문자 기반
{
    type: HANGEUL | SUTJA | YEONGEO | BUHO | GONGBAEK
    value: string
}

2. 분해된 한글 기반
{
    type: HANGEUL
    data: {
        doensori: boolean
        choseong: string
        jungseong: string
        jongseong: string
        gyeopbatchim: string
    }
}

출력은 Token 리스트이다.