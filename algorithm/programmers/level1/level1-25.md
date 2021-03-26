# 약수의 합

- [문제 보기](https://programmers.co.kr/learn/courses/30/lessons/12928?language=javascript)

## 문제 요약

-  정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴

## 코드

```javascript
'use strict';

function solution(n) {
    let arr = [];
    for (let i = 1; i <= n; i++) {
        if (n % i === 0) arr.push(i);
    }
    return arr.reduce((acc, cur) => acc + cur, 0);
}
console.log(solution(12));
```

- 약수를 구하려면 `n`만큼 반복문을 돌려 빈 배열에 집어넣고 총 합을 구한다.

#### 참고
X
