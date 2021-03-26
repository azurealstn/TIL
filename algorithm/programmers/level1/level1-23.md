# 시저 암호

- [문제 보기](https://programmers.co.kr/learn/courses/30/lessons/12926?language=javascript)

## 문제 요약

- 문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문 리턴

## 코드

```javascript
'use strict';

function solution(s, n) {
    let answer = '';
    for (let i = 0; i < s.length; i++) {
        if (s[i] === ' ') answer += ' ';
        else {
            answer += String.fromCharCode( (s.charCodeAt(i) > 90)
                ? (s.charCodeAt(i) + n - 97) % 26 + 97
                : (s.charCodeAt(i) + n -65) % 26 + 65 );
        }
    }
    return answer;
}
console.log(solution("AB", 1));
```

- `charCodeAt()`은 `index`를 파라미터로 받아서 `index` 위치에 있는 문자를 아스키 코드로 변환해준다.
- `String.fromCharCode()`를 사용하면 아스키코드를 문자열로 변환해준다.
- 대문자 소문자를 기준으로 `s.charCodeAt(i) > 90`

#### 참고
[velog.io](https://velog.io/@marcus/%EC%9E%90%EB%B0%94%EC%8A%A4%ED%81%AC%EB%A6%BD%ED%8A%B8-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EC%8B%9C%EC%A0%80-%EC%95%94%ED%98%B8-hdjq6b9q8i)
