*ES6 문법 사용*

*이 문제는 강의에 사용된 문제라서  공개하지 않습니다.*

# 가위바위보
1: 가위 
2: 바위
3: 보

```javascript
'use strict';

function solution(a, b){         
  let answer="";
  for (let i = 0; i < a.length; i++) {
    if (a[i] === b[i]) answer += 'D';
    else if ((a[i] - b[i] === 1) || (a[i] - b[i] === -2)) answer += 'A'; //A가 이기는 경우
    else if (a[i] - b[i] === -1 || (a[i] - b[i] === 2)) answer += 'B'; //B가 이기는 경우
  }
  
  return answer;
}

let a=[2, 3, 3, 1, 3];
let b=[1, 1, 2, 2, 3];
console.log(solution(a, b));
```
# 점수 계산
1: 정답
0: 오답

```javascript
'use strict';

function solution(arr){         
  let answer = 0;
  let count = 0;
  let score = [];
  for (let i = 0; i < arr.length; i++) {
    if (arr[i] === 1) {
      count++;
      score.push(count);
    }
    else {
      count = 0;
      score.push(count);
    }
  }
  answer = score.reduce((acc, cur) => acc + cur, 0); //총합
  return answer;
}

let arr=[1, 0, 1, 1, 1, 0, 0, 1, 1, 0];
console.log(solution(arr));
```

# 등수구하기
이 문제의 핵심은  배열 `answer`을 `1`로 초기화 한 다음에 `이중 for문`을 사용하여 앞의 있는 점수와 비교하여 `answer[i]++`로 카운팅해준다.

```javascript
'use strict';

function solution(arr){
  let answer = [];
  for (let i = 0; i < arr.length; i++) {
    answer.push(1); //1로 초기화
    for (let j = 0; j < arr.length; j++) {
      if (arr[j] > arr[i]) {
        answer[i]++; //나보다 큰 수가 있다면 점수 증감
      }
    }

  }

  return answer;
}

let arr=[92, 92, 92, 100, 76];
console.log(solution(arr));
```

- 배열 `answer`을 1로 초기화하는 방법은 아래 코드에서도 가능하다.

```javascript
let n = arr.length;
let answer = Array.from({length: n}, () => 1); //[1, 1, 1, 1, 1]
```

- 이는 `얕게 복사`하여 새로운 `Array 객체`를 생성한다.
- 아무래도 이중 for문을 사용하기 때문에 시간 복잡도는 `O(n^2)`이기에 좋지는 않다.

# 격자판 최대한
각 행의 합, 열의 합, 대각선의 합 중 가장 큰 값은?

```javascript
'use strict';

function solution(arr){  
  let answer = Number.MIN_SAFE_INTEGER; //answer 초기화
  let rowResult = 0;
  let columnResult = 0;

  for (let i = 0; i < arr.length; i++) {
    rowResult = columnResult = 0; //초기화
    for (let j = 0; j < arr.length; j++) {
      rowResult += arr[i][j]; //행의 합
      columnResult += arr[j][i]; //열의 합
    }
    answer = Math.max(answer, rowResult, columnResult);
  }
  let sum1 = 0, sum2 = 0; //초기화
  for (let i = 0; i < arr.length; i++) {
    sum1 += arr[i][i]; //왼쪽 대각선의 합
    sum2 += arr[i][(arr.length - 1) - i]; //오른쪽 대각선의 합
  }
  answer = Math.max(answer, sum1, sum2)
  return answer;
}

let arr=[[10, 13, 10, 12, 15], 
       [12, 39, 30, 23, 11],
       [11, 25, 50, 53, 15],
       [19, 27, 29, 37, 27],
       [19, 13, 30, 13, 19]];
console.log(solution(arr));
```

# 봉우리
N\*N 격자판에서 상하좌우의 크기보다 큰 것들은 총 몇 개가 있을까?
이 문제의 핵심은 `dx`, `dy`를 먼저 초기화 시켜주는 것이다.

```javascript
'use strict';

function solution(arr){  
  let answer=0;
  let n = arr.length;
  //방향 초기화
  let dx = [-1, 0, 1, 0];
  let dy = [0, 1, 0, -1];

  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
      let flag = 1;
      for (let k = 0; k < 4; k++) {
        let nx = i + dx[k]; //i의 상하좌우 이동 후 방향
        let ny = j + dy[k]; //j의 상하좌우 이동 후 방향
        if (nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] >= arr[i][j]) { //자신보다 주위의 숫자가 더 크다.
          flag = 0;
          break;
        }
      }
      //네 방향 모두 확인한 후
      if (flag) answer++;
    }
  }
    
  return answer;
}

let arr=[[5, 3, 7, 2, 3], 
       [3, 7, 1, 6, 1],
       [7, 2, 5, 3, 4],
       [4, 3, 6, 4, 1],
       [8, 7, 3, 5, 2]];
console.log(solution(arr));
```

- 대표적인 방향 탐색 문제로 많이 안풀어보면 많이 헷갈릴 문제이다.
- 즉, 많이 풀어봐야 한다.
