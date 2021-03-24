# 모의고사

- [문제 보기](https://programmers.co.kr/learn/courses/30/lessons/42840?language=javascript)

## 문제 요약

- 수포자 3명이 정답을 찍는 방식이 각각 배열로 구성된다.
- 문제 정답 answers 배열이 주어질 때, 가장 많이 맞흰 수포자를 배열에 담아 return

## 코드

```javascript
'use strict';

function solution(answers) {
    let answer = [];
    const a = [1, 2, 3, 4, 5]; //1번 수포자
    const b = [2, 1, 2, 3, 2, 4, 2, 5]; //2번 수포자
    const c = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]; //3번 수포자
    let count = [0, 0, 0]; //1번, 2번, 3번 순서대로 맞힌 개수

    for (let i = 0; i < answers.length; i++) {
        if (a[i % 5] === answers[i]) count[0]++; //나머지 연산을 해주어야 다시 처음으로 돌아온다
        if (b[i % 8] === answers[i]) count[1]++;
        if (c[i % 10] === answers[i]) count[2]++;
    }
    //max 값
    const max = Math.max(...count);
    for (let i = 0; i < count.length; i++) {
        if (count[i] === max) answer.push(i + 1); //i는 0부터이므로 i+1 
    }
    return answer;
}
console.log(solution([1, 3, 2, 4, 2]));
```

- 먼저 각 수포자의 정답 방식을 배열로 담는다.
- 맞흰 개수를 세기 위해 `count`라는 배열을 선언한다.
- 반복문을 돌려 각각 맞흰 개수를 `count` 배열에 `++(후처리증감)` 해주고, max값을 구해 그 max값과 일치하면 `answer` 배열에 push해준다.
- 이미 오름차순 정렬이되어 있기에 따로 건드릴필요는 없다.

#### 시간 복잡도

- O(n)

#### 참고
[medium.com](https://medium.com/@760kry/%EC%9E%90%EB%B0%94%EC%8A%A4%ED%81%AC%EB%A6%BD%ED%8A%B8-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AA%A8%EC%9D%98%EA%B3%A0%EC%82%AC-c9da0802bcb4)

<br/>
<br/>
<br/>

### 다른 풀이

```javascript
'use strict';

function solution(answers) {
    let answer = [];
    const a1 = [1, 2, 3, 4, 5]; //1번 수포자
    const a2 = [2, 1, 2, 3, 2, 4, 2, 5]; //2번 수포자
    const a3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]; //3번 수포자
    
    let a1c = answers.filter((a, i) => a === a1[i % a1.length]).length;
    let a2c = answers.filter((a, i) => a === a2[i % a2.length]).length;
    let a3c = answers.filter((a, i) => a === a3[i % a3.length]).length;
    const max = Math.max(a1c, a2c, a3c);

    if (a1c === max) answer.push(1);
    if (a2c === max) answer.push(2);
    if (a3c === max) answer.push(3);

    return answer;
}
console.log(solution([1, 3, 2, 4, 2]));
```

- `filter()`를 이용하여 각각의 맞흰 개수를 구하고 `max`를 통해 `answer`에 push를 했다.
