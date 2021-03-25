# 두 정수 사이의 합

- [문제 보기](https://programmers.co.kr/learn/courses/30/lessons/12912?language=javascript)

## 문제 요약

- 두 수 a, b가 주어졌을 때 a, b 사이에 속한 모든 정수의 합을 리턴

## 코드

```javascript
'use strict';

function solution(a, b) {
    var answer = 0;
    if (a > b) {
        for (let i = b; i <= a; i++) {
            answer += i;
        }
    } else {
        for (let i = a; i <= b; i++) {
            answer += i;
        }
    }
    return answer;
}
console.log(solution(3, 5));
```

- `a > b`인 경우, 아닌 경우 for문을 돌린다.

### 다른 사람 풀이

```javascript
'use strict';

function solution(a, b) {
    var answer = 0;
    answer = (a + b) * (Math.abs(b - a) + 1) / 2;
    return answer;
}
console.log(solution(3, 5));
```

- 이런 생각을 할 줄 알아야하는데.. 갈 길이 아직 멀은 것 같다.

#### 참고
X
