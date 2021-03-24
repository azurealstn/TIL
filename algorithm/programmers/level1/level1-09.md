# 3진법 뒤집기

- [문제 보기](https://programmers.co.kr/learn/courses/30/lessons/68935?language=javascript)

## 문제 요약

- 주어진 n을 3진법으로 나타내고 reverse해서 다시 10진법으로 return해라.

## 코드

```javascript
'use strict';

function solution(n) {
    var answer = 0;
    answer = n.toString(3).split('').reverse().join('');
    answer = parseInt(answer, 3);
    return answer;
}
console.log(solution(45));
```

- `toString(3)`으로 3진법 변환
- `split('').reverse().join('');`은 배열로 전환했다가 reverse해주고 다시 문자열로 변환해준 것이다.
- `parseInt(answer, 3);`를 사용하면 다시 10진법으로 나타내진다.

#### 시간 복잡도

#### 참고
[tistory.com](https://kimyang-sun.tistory.com/m/113)
