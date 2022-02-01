# 2016년

- [문제 보기](https://programmers.co.kr/learn/courses/30/lessons/12901?language=javascript)

## 문제 요약

- 요일의 이름 `SUN,MON,TUE,WED,THU,FRI,SAT`이 주어질 때, 2016년 a월 b일이 무슨 요일인지 return

## 코드

```javascript
'use strict';

function solution(a, b) {
    let answer = '';
    let days = ['SUN', 'MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT'];
    const date = new Date(`2016-${a}-${b}`);
    answer = days[date.getDay()];
    return answer;
}
console.log(solution(5, 24));
```

- `Date` 생성자를 생성하고 `getDay()`를 사용하면 `0~6(일~토)`의 `index`가 리턴된다.
- 이를 이용하여 `days[]` 배열에 각각 순서에 맞게 요일을 넣어 해당 날짜에 맞는 요일을 return해주면 된다.

#### 시간 복잡도

- O(n)

#### 참고
[velog.io](https://velog.io/@michael00987/javascript%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-2016%EB%85%84)
