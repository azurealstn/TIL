# 문자열 내 마음대로 정렬하기

- [문제 보기](https://programmers.co.kr/learn/courses/30/lessons/12915?language=javascript)

## 문제 요약

- 문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하여 리턴

## 코드

```javascript
'use strict';

function solution(strings, n) {
    let answer = [];
    answer = strings.sort((a, b) => {
        const first = a[n]; //문자열에서 n 인덱스 위치의 문자값
        const second = b[n];
        if (first === second) {
            return (a > b) - (a < b);
        } else {
            return (first > second) - (first < second);
        }
    })
    return answer;
}
console.log(solution(["abce", "abcd", "cdx"], 2));
```

- 처음에 `(a > b) - (a < b);`의 뜻을 이해를 못했다. 다른 사람의 설명글을 보고 이해했다.
- 먼저 `first`, `second` 값은 `n` 위치에 있는 문자값이다. `(first === second)` 이 두 개가 같은 경우는 문자열을 비교하여 정렬해야 한다. 이 때 문자열 전체를 비교하기 위해 `(a > b) - (a < b)`를 쓴다. 여기서 알아야 할 점은 **true: 1, false: 0**이라는 점이다.
- 만약 `first`와 `second`가 같지않다면 문자열이 아닌 지정된 문자 전체를 비교하면 된다. `(first > second) - (first < second)`


#### 참고
[medium.com](https://wooder2050.medium.com/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%9E%90%EC%97%B4-%EB%82%B4-%EB%A7%88%EC%9D%8C%EB%8C%80%EB%A1%9C-%EC%A0%95%EB%A0%AC%ED%95%98%EA%B8%B0-javascript-f8f431cedee7)
