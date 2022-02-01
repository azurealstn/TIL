# 최대공약수와 최소공배수

- [문제 보기](https://programmers.co.kr/learn/courses/30/lessons/12940?language=javascript)

## 문제 요약

- 두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환

## 코드

```javascript
'use strict';

function solution(n, m) {
    const minNum = Math.min(n, m); //3
    const maxNum = Math.max(n, m); //12
    //최대 공약수
    const gcd = (minNum, maxNum) => (minNum % maxNum) === 0 ? maxNum : gcd(maxNum, minNum % maxNum);

    //최소 공배수
    const lcm = (minNum, maxNum) => minNum * maxNum / gcd(minNum, maxNum);

    let answer = [];
    answer.push(gcd(minNum, maxNum));
    answer.push(lcm(minNum, maxNum));
    

    return answer;
}
console.log(solution(3, 12));
```

- 유클리드 호제법을 이해해야 풀 수 있는 문제

#### 참고
[tistory.com](https://swess.tistory.com/13)
[유클리드 호제법이란](https://ko.wikipedia.org/wiki/%EC%9C%A0%ED%81%B4%EB%A6%AC%EB%93%9C_%ED%98%B8%EC%A0%9C%EB%B2%95)
