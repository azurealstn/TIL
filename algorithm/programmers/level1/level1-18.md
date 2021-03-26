# 문자열 다루기 기본

- [문제 보기](https://programmers.co.kr/learn/courses/30/lessons/12918?language=javascript)

## 문제 요약

- 문자열의 길이가 4 혹은 6이고 문자열에 숫자만 있으면 true, 섞여있으면 false를 리턴

## 코드

```javascript
'use strict';

function solution(s) {
    console.log(isNaN(Number(s)));
    if ((s.length === 4 || s.length === 6) && !isNaN(Number(s))) return true;
    else return false
}
console.log(solution("1234"));
```

- 테스트 케이스 11에서 통과 X

#### 테스트 통과 (다른 사람 코드 참고)

```javascript
'use strict';

function solution(s) {
    if (s.length === 4 || s.length === 6) {
        return s.split('').every(v => !isNaN(v));
    }
    return false
}
console.log(solution("1234"));
```

- `every()`를 생각못했다. `every()`는 모든 요소를 탐색해서 모두 조건이 다 맞아야 `true`를 리턴하고 아니면 `false`를 리턴한다.
- 비슷한 함수로 `some()`이 있는데 이것은 하나라도 조건에 맞으면 `true`를 리턴한다. 단어를 생각하면 `every`, `some` 차이를 알 수 있다.
- 두 함수 모두 콜백함수를 파라마터로 받는다.

#### 참고
[velog.io](https://velog.io/@dosanahnchangho/javascript-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4%EB%AC%B8%EC%9E%90%EC%97%B4-%EB%8B%A4%EB%A3%A8%EA%B8%B0-%EA%B8%B0%EB%B3%B8)
