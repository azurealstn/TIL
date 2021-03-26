# 짝수와 홀수

- [문제 보기](https://programmers.co.kr/learn/courses/30/lessons/12937?language=javascript)

## 문제 요약

- 정수 num이 짝수일 경우 "Even"을 반환하고 홀수인 경우 "Odd"를 리턴

## 코드

```javascript
'use strict';

function solution(num) {
    if (num % 2 === 0) return "Even";
    else return "Odd";
}
console.log(solution([4,3,2,1]));
```

- 이 문제는 딱히 설명이 필요없을 것 같다.

#### 다른 사람 풀이

```javascript
'use strict';

function solution(num) {
    return num % 2 ? "Odd" : "Even";
}
console.log(solution([4,3,2,1]));
```

- num % 2가 `0`이면 `false`가 된다.

#### 참고
X
