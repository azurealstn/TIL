# K번째수

- [문제 보기](https://programmers.co.kr/learn/courses/30/lessons/42840?language=javascript)

## 문제 요약

- 배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구한다.
- 문제 자체는 직관적이라 어렵지 않게 풀었다.

## 코드

```javascript
'use strict';

function solution(array, commands) {
    let answer = [];
    for (let i = 0; i < commands.length; i++) {
        let arr = array.slice(commands[i][0] - 1, commands[i][1]).sort((a, b) => a - b);
        answer.push(arr[commands[i][2] - 1]);
    }
    return answer;
}
console.log(solution([1, 5, 2, 6, 3, 7, 4], [[2, 5, 3], [4, 4, 1], [1, 7, 3]]));
```

- i번째 숫자부터 j번째 숫자까지 자르기 위해 `slice()` 함수를 이용했다.
- 그리고나서 `sort()`로 정렬하여 `answer`에 push한 것이다.

#### 시간 복잡도

- O(n)

#### 참고
X

