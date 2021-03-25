# 문자열 내 p와 y의 개수

- [문제 보기](https://programmers.co.kr/learn/courses/30/lessons/12916?language=javascript)

## 문제 요약

- s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True, 다르면 False를 return

## 코드

```javascript
'use strict';

function solution(s) {
    const lowerS = s.toLowerCase(); //소문자로 변환
    let pCount = 0; //'p'의 개수
    let yCount = 0; //'y'의 개수
    for (let i = 0; i < s.length; i++) {
        if (lowerS[i] === 'p') {
            pCount++;
        } else if (lowerS[i] === 'y') {
            yCount++;
        }
    }
    if (!lowerS.includes('p') && !lowerS.includes('y')) return true;
    if (pCount === yCount) return true;
    else return false;
}
console.log(solution("Pyy"));
```

- 먼저 문자열 길이만큼 반복문을 돌려 `'p'`가 있으면 `pCount`, `'y'`가 있으면 `yCount`의 개수를 증가시킨다.
- `'p'`나 `'y'`가 없다면 바로 `true`를 리턴해준다.
- `pCount`의 개수와 `yCount`의 개수가 같으면 `true`를 리턴해준다.

### 다른 사람 풀이

```javascript
function solution(s) {
    return s.toLowerCase().split('p').length === s.toLowerCase().split('y').length;
}
```

- 리턴하기 전에 어떤 값이 나올지 `console.log`로 한번 찍어보자.

#### 참고
X
