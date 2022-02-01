# 같은 숫자는 싫어

- [문제 보기](https://programmers.co.kr/learn/courses/30/lessons/12906?language=javascript)

## 문제 요약

- 연속되는 숫자를 제거하여 return

## 코드

```javascript
'use strict';

function solution(arr)
{
    let answer = [];
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] !== arr[i + 1]) {
            answer.push(arr[i]);
        }
    }
    
    return answer;
}
console.log(solution([4,4,4,3,3]));
```

- 이렇게 간단한걸 다른 사람의 풀이를 보고야 말았다... (좀 복잡하게 생각해서 더 안됐던 것 같다..)

### 다른 풀이

```javascript
'use strict';

function solution(arr)
{
    return arr.filter((value, index) => value !== arr[index + 1]);
}
console.log(solution([4,4,4,3,3]));
```

- `filter()` 함수를 이용하여 한 줄로 표현했다. 조건은 위 코드와 동일하다.

#### 참고
[medium.com](https://medium.com/@760kry/%EC%9E%90%EB%B0%94%EC%8A%A4%ED%81%AC%EB%A6%BD%ED%8A%B8-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EA%B0%99%EC%9D%80-%EC%88%AB%EC%9E%90%EB%8A%94-%EC%8B%AB%EC%96%B4-9668f116f429)
