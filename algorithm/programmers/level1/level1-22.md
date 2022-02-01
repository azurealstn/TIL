# 문자열을 정수로 바꾸기

- [문제 보기](https://programmers.co.kr/learn/courses/30/lessons/12925?language=javascript)

## 문제 요약

- 문자열 s를 숫자로 변환한 결과를 리턴

## 코드

```javascript
'use strict';

function solution(s) {
    return s * 1
}
console.log(solution("1234"));
```

- 허...

#### 다른 풀이

```javascript
'use strict';

function solution(s) {
    if (!isNaN(Number(s))) {
        return Number(s);
    }
}
console.log(solution("1234"));
```

- `isNaN()`을 이용하여 풀어볼 수도 있다. (방법은 다양)

#### 참고
X
