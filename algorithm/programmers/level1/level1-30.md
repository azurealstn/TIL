# 정수 제곱근 판별

- [문제 보기](https://programmers.co.kr/learn/courses/30/lessons/12934?language=javascript)

## 문제 요약

- n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴

## 처음 시도 실패

```javascript
'use strict';

function solution(n) {
    if (Math.sqrt(n) ** 2 !== n) return -1;
    else return (Math.sqrt(n) + 1) ** 2;
}
console.log(solution(3));
```

- 제곱근을 두 번 곱해서 `n` 아니면 `-1`을 리턴해버리고 아니면 제곱근에서 `+1`하고 두번 곱한 값을 리턴했다.

## 두번 시도 성공

```javascript
'use strict';

function solution(n) {
    if (Math.floor(Math.sqrt(n)) ** 2 !== n) return -1;
    else return (Math.sqrt(n) + 1) ** 2;
}
console.log(solution(3));
```

- 제곱근을 구하면 소수점이 나올 수 있다. 만약 소수점 아래가 길다면 두 번 곱했을 때 정확하게 그 값이 안나오고 근사치를 구하게 된다.
- 그래서 `Math.floor()`로 정수로 변환을 해주고 체크를 해야한다. 이 부분을 생각 못했다.

#### 참고
[medium.com](https://wooder2050.medium.com/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EC%A0%95%EC%88%98-%EC%A0%9C%EA%B3%B1%EA%B7%BC-%ED%8C%90%EB%B3%84-javascript-d03ce82340a8)
