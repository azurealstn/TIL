# 완주하지 못한 선수

- [문제 보기](https://programmers.co.kr/learn/courses/30/lessons/42576?language=javascript)

## 문제 요약

- 마라톤에 참여한 선수들의 이름이 담긴 배열 participant
- 완주한 선수들의 이름이 담긴 배열 completion
- 완주하지 못한 선수의 이름을 return

## 코드

```javascript
'use strict';

function solution(participant, completion) {
    var answer = '';
    participant.sort();
    completion.sort();
    for (let i = 0; i < participant.length; i++) {
        if (participant[i] !== completion[i]) {
            answer += participant[i];
            break;
        }
    }
    return answer;
}
console.log(solution(["leo", "kiki", "eden"], ["eden", "kiki"]));
```

- 먼저 participant, completion 모두 오름차순 정렬을 해준다.
- 길이가 가장 긴 `participant.length`로 반복문을 돌려 같지 않은 경우에 answer에 추가해준다.
- 그리고 그 즉시 반복문을 빠져나온다.

#### 시간 복잡도

- O(n)

#### 참고
X
