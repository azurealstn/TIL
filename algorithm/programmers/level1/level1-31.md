# 제일 작은 수 제거하기

- [문제 보기](https://programmers.co.kr/learn/courses/30/lessons/12935?language=javascript)

## 문제 요약

- 정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴
- 단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1 리턴

## 코드

```javascript
'use strict';

function solution(arr) {
    let max = Number.MAX_SAFE_INTEGER;
    let minIndex;
    if (arr.length === 1) return [-1];
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] < max) {
            max = arr[i];
            minIndex = i;
        }
    }
    arr.splice(minIndex, 1);
    return arr;
}
console.log(solution([4,3,2,1]));
```

- 처음에 비교해서 가장 작은 수의 `index`를 구한다.
- `splice()`로 값을 삭제시킨 후에 `arr`을 리턴

#### 다른 사람 풀이

```javascript
'use strict';

function solution(arr) {
    if (arr.length === 1) return [-1];
    arr.splice(arr.indexOf(Math.min(...arr)), 1);
    return arr;
}
console.log(solution([4,3,2,1]));
```

- 최소값을 구하는 `Math.min()`과 `indexOf`로 `index`를 구하여 풀었다.
- 여기서 깨알 팁이 있다면 로직이 짧은 즉, 금방 끝내는 로직이면 빠르게 먼저 리턴하는 것이 좋다. (리턴할 수 있다면) 그러면 시간을 더 단축시킬 수 있다.

#### 참고
X
