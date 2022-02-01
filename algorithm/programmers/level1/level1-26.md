# 이상한 문자 만들기

- [문제 보기](https://programmers.co.kr/learn/courses/30/lessons/12928?language=javascript)

## 문제 요약

- 각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴

## 코드

```javascript
'use strict';

function solution(s) {
    return s.split(' ').map(e => {
        let answer = '';
        for (let i = 0; i < e.length; i++) {
            if (i % 2 === 0) answer += e[i].toUpperCase();
            else answer += e[i].toLowerCase();
        }
        return answer;
    }).join(' ');
}
console.log(solution("try hello world"));
```

- 문자열 `s`를 `split()`을 사용하여 배열로 변환해서 `map()`을 사용하여 새로운 배열을 리턴해줄 것이다.
- 그 새로운 배열은 단어 `e`를 돌면서 짝수인 경우, `i % 2 === 0`에는 그 위치에 대문자로 아니면 소문자로 변경한다.
- 이 때 `answer`는 빈 문자열로 초기화 해주어야 하며, return은 `answer`을 해주면 된다.

#### 참고
[tistory.com](https://bolob.tistory.com/entry/Level-1-%EC%9D%B4%EC%83%81%ED%95%9C-%EB%AC%B8%EC%9E%90-%EB%A7%8C%EB%93%A4%EA%B8%B0JavaScript)
