# 자연수 뒤집어 배열로 만들기

- [문제 보기](https://programmers.co.kr/learn/courses/30/lessons/12932?language=javascript)

## 문제 요약

- 자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴

## 코드

```javascript
'use strict';

function solution(n) {
    return String(n).split('').reverse().map(v => Number(v));
}
console.log(solution(12345));
```

- 숫자를 문자로 변환하고 배열로 변환해서 `map()`을 이용하여 각 요소(v)를 `number` 타입으로 변환한다.

#### 다른 사람 풀이

```javascript
'use strict';

function solution(n) {
    let answer = [];
    do {
        answer.push(n % 10);
        n = Math.floor(n / 10);
    } while (n > 0);
    return answer
}
console.log(solution(12345));
```

- 위에 코드는 문자로 푸는 방법이었다면 이 코드는 숫자 그대로 푸는 방법이다.

#### 참고
X
