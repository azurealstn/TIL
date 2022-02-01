# 나누어 떨어지는 숫자 배열

- [문제 보기](https://programmers.co.kr/learn/courses/30/lessons/12910?language=javascript)

## 문제 요약

- 자연수를 담은 배열 arr을 자연수 divisor로 나누었을 때 나누어 떨어지는 arr의 요소들을 리턴
- 만약 아무것도 나누어 떨어지는 게 없다면 -1을 리턴

## 코드

```javascript
'use strict';

function solution(arr, divisor) {
    let answer = [];
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] % divisor === 0) {
            answer.push(arr[i]);
        }
    }
    if (answer.length === 0) answer.push(-1);
    answer.sort((a, b) => a - b);
    return answer;
}
console.log(solution([3,2,6], 10));
```

- 조건문을 달아 `arr[i] % divisor === 0`와 빈 배열일 경우인 `answer.length === 0`만 체크해주면 된다.

### 다른 풀이

```javascript
'use strict';

function solution(arr, divisor) {
    let answer = arr.filter(v => v % divisor === 0);
    return answer.length === 0 ? [-1] : answer.sort((a, b) => a - b);
}
console.log(solution([3,2,6], 10));
```

- 조건에 맞는 새로운 배열을 만들어주는 `filter()`를 이용했다.

#### 참고
X
