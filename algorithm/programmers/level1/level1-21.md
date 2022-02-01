# 수박수박수박수박수박수?

- [문제 보기](https://programmers.co.kr/learn/courses/30/lessons/12922?language=javascript)

## 문제 요약

- 길이가 n이고, "수박수박수박수...."와 같은 패턴을 유지하는 문자열을 리턴

## 코드

```javascript
'use strict';

function solution(n) {
    let answer = '';
    const arr = ['수', '박'];
    for (let i = 0; i < n; i++) {
        answer += arr[i % 2];
    }
    return answer
}
console.log(solution(4));
```

- '수'와 '박'이 반복되니까 배열을 만들어주면 된다.

#### 참고
X
