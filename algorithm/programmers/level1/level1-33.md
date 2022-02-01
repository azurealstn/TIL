# 키패드 누르기

- [문제 보기](https://programmers.co.kr/learn/courses/30/lessons/67256?language=javascript)

## 문제 요약

- 순서대로 누를 번호가 담긴 배열 numbers, 왼손잡이인지 오른손잡이인 지를 나타내는 문자열 hand가 매개변수로 주어질 때, 각 번호를 누른 엄지손가락이 왼손인 지 오른손인 지를 나타내는 연속된 문자열 형태로 return

## 코드

```javascript
'use strict';

function solution(numbers, hand) {
    //방향 정하기
    const direction = {
        left: [1, 4, 7],
        right: [3, 6, 9],
    }
    //각 키패드 포지션
    const keyPadPos = {
        1: [0, 0],
        2: [0, 1],
        3: [0, 2],
        4: [1, 0],
        5: [1, 1],
        6: [1, 2],
        7: [2, 0],
        8: [2, 1],
        9: [2, 2],
        '*': [3, 0],
        0: [3, 1],
        '#': [3, 2],
    };
    //left, right의 현재 위치
    let left = keyPadPos['*'];
    let right = keyPadPos['#'];
    let result = '';

    //numbers 배열 모든 탐색
    numbers.forEach(num => {
        //1, 4, 7을 누를시
        if (direction.left.includes(num)) {
            result += 'L';
            //이동시 위치 변경
            left = keyPadPos[num];
        } else if (direction.right.includes(num)) {
            result += 'R';
            //이동시 위치 변경
            right = keyPadPos[num];
        } else {
            let pos = keyPadPos[num]; //현재 위치
            let leftDistance = Math.abs(pos[0] - left[0]) + Math.abs(pos[1] - left[1]);
            let rightDistance = Math.abs(pos[0] - right[0]) + Math.abs(pos[1] - right[1]);
            if (leftDistance > rightDistance) {
                right = pos;
                result += 'R';
            } else if (leftDistance < rightDistance) {
                left = pos;
                result += 'L';
            } else {
                if (hand === 'right') {
                    right = pos;
                    result += 'R';
                } else {
                    left = pos;
                    result += 'L';
                }
            }
        }
    });
    return result;
}
console.log(solution([1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5], "right"));
```

- 2020 카카오 인턴십 문제답게 나로서는 도저히 혼자서 풀 힘이 없었다..
- 처음에 `left`, `right`의 각 방향을 정한다. 그 다음에는 키패드의 2차원 배열을 선언한다.
- 배열 `numbers`를 모두 탐색하면서 진행을 시작한다.
- `direction.left.includes(num)`로 `1, 4, 7`의 위치에 있으면 `L`, `3, 6, 9`의 위치에 있으면 `R`을 추가한 후 각각 위치를 변경한다. 여기까지는 큰 어려움이 없을 것이다.
- 이제 `2, 5, 8, 0`을 확인할 차례이다. 현재 위치를 선언해주고, `leftDistance`, `rightDistance` 즉, 왼쪽 손이 더 가까운지 오른쪽 손이 더 가까운지를 계산한다.
- 왼쪽 손에 가깝다면 `L`, 오른쪽 손에 가깝다면 `R`
- 그것도 아니라면 `hand` 파라미터 값에 따라 추가해준다.
- 이런 문제는 반복해서 풀어보는 수밖에는 없을 것 같다..

#### 참고
[tistory.com](https://kimyang-sun.tistory.com/114?category=779570)
