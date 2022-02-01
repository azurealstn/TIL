# 폰켓몬

- [문제 보기](https://programmers.co.kr/learn/courses/30/lessons/1845?language=javascript)

## 문제 요약

- 폰켓몬 종류 개수의 최댓값을 리턴

## 코드

```javascript
'use strict';

function solution(nums) {
    let answer = 0;
    let result = [];
    let max = nums.length / 2; //가장 많이 뽑을 수 있는 수
    for (let i = 0; i < nums.length; i++) {
        if (result.indexOf(nums[i]) < 0) {
            result.push(nums[i]);
        }
    }
    answer = result.length;
    if (max < answer) answer = max;
    return answer;
}
console.log(solution([3,1,2,3]));
```

- 먼저 최대로 많이 뽑을 수 있는 개수는 `nums.length / 2`이 된다.
- `result`이라는 새 배열을 만들고, 각기 다른 종류의 폰켓몬을 집어넣는다. (중복 체크)
- `answer`에 폰켓몬 종류의 최대 개수를 넣는다. 만약 최대로 뽑을 수 있는 수(max)보다 최대 종류의 수(answer)가 더 많다면 `answer`을 `max`로 바꿔준다.

#### 참고
X
