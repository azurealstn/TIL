# 신규아이디 추천

- [문제 보기](https://programmers.co.kr/learn/courses/30/lessons/42576?language=javascript)

## 문제 요약

- 아이디를 가지고 여러 조건에 맞게 추천해주는 프로그램을 개발하는 것
- 즉, 각 조건에 맞는 아이디를 return

## 코드

```javascript
'use strict';

function solution(new_id) {
    let answer = new_id
        .toLowerCase() //1
        .replace(/[^\w-_.]/g, '') //2
        .replace(/\.{2,}/g, '.') //3
        .replace(/^\.|\.$/g, '') //4
        .replace(/^$/, 'a') //5
        .slice(0, 15).replace(/\.$/, ''); //6
    const len = answer.length;
    answer = len > 2 ? answer : answer + answer.charAt(len - 1).repeat(3 - len);
    return answer;
}
console.log(solution("...!@BaT#*..y.abcdefghijklm"));
```

- 체이닝을 이용.
- 마지막 7번째는 삼항연산자를 이용하여 마지막 문자를 `charAt()`으로 찾고, 반복은 `repeat()`를 사용
- 정규식 표현 이용

#### 시간 복잡도

- O(n)

#### 참고
[velog.io](https://velog.io/@freedom625/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%8B%A0%EA%B7%9C-%EC%95%84%EC%9D%B4%EB%94%94-%EC%B6%94%EC%B2%9C)
