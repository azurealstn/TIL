# 서울에서 김서방 찾기

- [문제 보기](https://programmers.co.kr/learn/courses/30/lessons/12919?language=javascript)

## 문제 요약

- "김서방은 index에 있다" 형태로 리턴

## 코드

```javascript
'use strict';

function solution(seoul) {
    return `김서방은 ${seoul.indexOf("Kim")}에 있다`;
}
console.log(solution(["Jane", "Kim"]));
```

- Template literal을 사용하면 한 줄로 해결할 수 있다.
- `indexOf()`로 `"Kim"`의 index를 구한다.

#### 참고
X
