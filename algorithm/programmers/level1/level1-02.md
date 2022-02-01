# 크레인 인형뽑기 게임

- [문제 보기](https://programmers.co.kr/learn/courses/30/lessons/64061?language=javascript)

## 문제 요약

- 2차원 배열 board안에는 다양한 인형들이 들어있고, 모든 인형은 "1 x 1" 크기의 격자 한 칸을 차지하며 **격자의 가장 아래칸부터 차곡차곡 쌓여있다.**
- 사용자는 가장 위에 있는 인형부터 집어올릴 수 있고, 이 때는 인형을 집기 위해 크레인을 작동시킨 위치가 담긴 배열 moves가 있다.
- 집어올린 인형은 바구니에 담아 같은 인형이 연속해서 쌓이게 되면 두 인형은 사라지게 된다.
- 사라진 인형의 개수를 return.

## 코드

```javascript
'use strict';

function solution(board, moves) {
    let answer = 0;
    let result = []; //바구니
    let removeSame = 0; //중복 선택을 막기 위한 변수
    //board 2차원 배열 모든 탐색
    for (let i = 0; i < moves.length; i++) {
        for (let j = 0; j < board.length; j++) {
            //뽑으려는 인형이 0이 아니고 중복 선택 막기
            if (board[j][moves[i] - 1] !== 0 && removeSame === i) {
                removeSame++;
                //두 개의 인형이 같으면 pop() 해주고, answer에 +2를 해준다.
                //아니면 push()를 해준다.
                if (result[result.length - 1] === board[j][moves[i] - 1]) {
                    result.pop();
                    answer += 2;
                } else {
                    result.push(board[j][moves[i] - 1]);
                }
                board[j][moves[i] - 1] = 0;
            }
        }
    }
    return answer;
  }
console.log(solution([[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]], [1,5,3,5,1,2,1,4]));
```

- result 배열은 `Stack 구조`로 되어있다.
- moves에 따라 result에 인형을 집어넣어서 처음 반복문은 moves.length
- 두 번째 반복문은 board.length를 수행한다.
- 뽑으려는 인형이 0이 아니고 중복 선택을 막기 위해 removeSame 변수를 사용했다.
- 만약 result에 가장 위에 있는 인형과 방금 집어넣은 인형이 같으면 pop()을 해주고 answer에 +2를 해준다.
- 그렇지 않으면 result에 push() 해준다.

## 다른 방식

```javascript
'use strict';

function solution(board, moves) {
    let answer = 0;
    let result = []; //바구니
    //board 2차원 배열 모든 탐색
    for (let i = 0; i < moves.length; i++) {
        for (let j = 0; j < board.length; j++) {
            //뽑으려는 인형이 0이 아니고 중복 선택 막기
            if (board[j][moves[i] - 1] !== 0) {
                //두 개의 인형이 같으면 pop() 해주고, answer에 +2를 해준다.
                //아니면 push()를 해준다.
                if (result[result.length - 1] === board[j][moves[i] - 1]) {
                    result.pop();
                    answer += 2;
                } else {
                    result.push(board[j][moves[i] - 1]);
                }
                board[j][moves[i] - 1] = 0;
                break;
            }
        }
    }
    return answer;
  }
console.log(solution([[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]], [1,5,3,5,1,2,1,4]));
```

- 위와 비슷한 코드이지만 `removeSame`이라는 변수를 사용하지 않고 구현했다.
- 솔직히 removeSame이 조금 헷갈렸는데 `break문`을 사용하여 반복문을 빠져나오게 할수도 있었다. 

#### 시간 복잡도

- O(n^2)
- 이 문제는 알고리즘 초보인 나한테 꽤나 까다로운 문제였다.. (level 1인데도 😢)

#### 참고

[medium.com](https://wooder2050.medium.com/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EC%B9%B4%EC%B9%B4%EC%98%A4-%ED%81%AC%EB%A0%88%EC%9D%B8-%EC%9D%B8%ED%98%95%EB%BD%91%EA%B8%B0-javascript-790aee0bebc0)
