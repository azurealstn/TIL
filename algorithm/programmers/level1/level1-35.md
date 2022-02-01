# 콜라츠 추측

- [문제 보기](https://programmers.co.kr/learn/courses/30/lessons/12943?language=javascript)

## 문제 요약

- 작업을 몇 번이나 반복해야하는지 반환

## 코드

```javascript
'use strict';

function solution(num) {
    let count = 0;
    for (let i = 0; i < 500; i++) {
        if (num === 1) return count;
        if (num % 2 === 0) {
            num /= 2;
            count++;
        } else {
            num = num * 3 + 1;
            count++;
        }
    }
    return -1;
}
console.log(solution(6));
```

- 500번이 넘어가면 `-1`을 반환하면 되니까 반복문은 500번까지 돌린다.
- 값이 `1`이 되면 `count`를 반환해준다.
- 그리고 짝수, 홀수 나누어서 각각 로직을 수행해준다.

#### 참고
X
