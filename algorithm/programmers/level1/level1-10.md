# 가운데 글자 가져오기

- [문제 보기](https://programmers.co.kr/learn/courses/30/lessons/12903?language=javascript)

## 문제 요약

- string s의 가운데 글자를 return. 짝수의 경우 가운데 두 글자 return

## 코드

```javascript
'use strict';

function solution(s) {
    let answer = '';

    const a = parseInt(s.length / 2); //정수로 변환
    if (s.length % 2 !== 0) {
        answer += s[a];
    } else {
        answer += s[a - 1];
        answer += s[a];
    }
    return answer;
}
console.log(solution("qwer"));
```

- 설명이 따로 필요없을 것 같다.

### 다른 풀이

```javascript
'use strict';

function solution(s) {
    let answer = '';
    answer = s.substring(Math.ceil(s.length / 2) - 1, Math.floor(s.length / 2) + 1);
    return answer;
}
console.log(solution("abde"));
```

#### 참고
X
