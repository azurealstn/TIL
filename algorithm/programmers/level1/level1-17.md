# 문자열 내림차순으로 배치하기

- [문제 보기](https://programmers.co.kr/learn/courses/30/lessons/12917?language=javascript)

## 문제 요약

- 문자를 큰 것부터 작은 순으로 정렬해 리턴

## 코드

```javascript
'use strict';

function solution(s) {
    return s.split('').sort().reverse().join('');
}
console.log(solution("Zbcdefg"));
```

- `split()`으로 배열로 변환
- `sort()`로 내림차순 정렬
- `reverse()`로 거꾸로 전환
- `join()`으로 문자열 변환

#### 참고
X
