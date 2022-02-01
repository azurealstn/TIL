# 정수 내림차순으로 배치하기

- [문제 보기](https://programmers.co.kr/learn/courses/30/lessons/12933?language=javascript)

## 문제 요약

- n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴

## 코드

```javascript
'use strict';

function solution(n) {
    return Number(String(n).split('').sort((a, b) => b - a).join(''));
}
console.log(solution(118372));
```

- 숫자를 문자로 변환하고 배열로 변환해서 정렬 `sort()`을 해주면 된다.

#### 참고
X
