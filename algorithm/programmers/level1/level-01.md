# 두 개 뽑아서 더하기

- [문제 보기](https://programmers.co.kr/learn/courses/30/lessons/68644?language=javascript)

## 문제 요약

- 정수 배열 numbers가 주어지고, 이 배열에서 서로 다른 인덱스 두 개를 뽑아 더해서 만들 수 있는 모든 수를 answer 배열에 담아 return.
- 중복된 수는 배열에 담으면 안된다.

## 코드

```javascript
'use strict';

function solution(numbers) {
    var answer = [];
    //모든 경우의 수 탐색
    for (let i = 0; i < numbers.length - 1; i++) {
        for (let j = i + 1; j < numbers.length; j++) {
            let sum = numbers[i] + numbers[j];
            //중복을 제거하기 위해 존재하지 않으면 push
            if (answer.indexOf(sum) < 0) {
                answer.push(sum);
            }
        }
    }
    answer.sort((a, b) => a - b);
    return answer;
}
console.log(solution([2,1,3,4,1]));
```

- 중복 제거를 위해 `indexOf()` 사용
- 이중 for문을 사용하여 **시간복잡도는 O(n^2)**
- 다른 사람의 코드를 보니 `includes()` 사용해 중복체크를 하였다.

#### 참고

[velog.io](https://velog.io/@dosanahnchangho/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%91%90-%EA%B0%9C-%EB%BD%91%EC%95%84%EC%84%9C-%EB%8D%94%ED%95%98%EA%B8%B0-JavaScript)
