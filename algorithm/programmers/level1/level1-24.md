# 내적

- [문제 보기](https://programmers.co.kr/learn/courses/30/lessons/70128?language=javascript)

## 문제 요약

-  a와 b의 내적을 return (a, b의 길이는 동일)
-  a와 b의 내적은 1\*(-3) + 2\*(-1) + 3\*0 + 4\*2 = 3 입니다.

## 코드

```javascript
'use strict';

function solution(a, b) {
    let answer = 0;
    for (let i = 0; i < a.length; i++) {
        answer += a[i] * b[i];
    }
    return answer;
}
console.log(solution([1,2,3,4], [-3,-1,0,2]	));
```

- 단순하게 이렇게 풀 수 있다.

#### 다른 사람 풀이

```javascript
'use strict';

function solution(a, b) {
    return a.reduce((acc, cur, index) => acc += cur * b[index], 0);
}
console.log(solution([1,2,3,4], [-3,-1,0,2]	));
```

- `reduce()`를 이용하여 축적하는 데이터 `acc`, 현재 데이터 `cur`, 인덱스 `index`를 파라미터로 받고 현재 데이터는 `cur * b[index]`를 해주면 된다.

#### 참고
X
