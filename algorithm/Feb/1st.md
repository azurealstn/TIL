*ES6 문법 사용*

# 가장 작은 수
3개의 파라미터가 주어졌을 때 가장 작은 수를 어떻게 출력할까?
(`if문`만으로 해결이 가능하다)

```javascript
'use strict';

function solution(a, b, c){
  let answer;
  if (a > b) answer = b;
  else answer = a;
  if (c < answer) answer = c;
  return answer;
}

console.log(solution(5, 4, 76));
```

- 설명은 생략

# 삼각형 조건?
역시 3개의 파라미터가 주어졌을 때 어떻게하면 삼각형이 되기 위한 조건을 만족할 수 있을까?
(`삼각형`: 가장 긴 변의 길이는 다른 두 변의 길이의 합보다 작아야 한다.)

```javascript
'use strict';

function solution(a, b, c){
  let answer, max;
  let sum = a + b + c;
  if (a > b) max = a;
  else max = b;
  if (c > max) max = c; //가장 긴 변
  if (max < (sum - max)) answer = "YES";
  else answer = "NO";
  return answer;
}

console.log(solution(6, 7, 11));
```

- 역시 설명은 생략

# 연필
1다스 = 12 연필자루, N명의 학생 수가 주어졌을 때 과연 몇 다스가 필요할까?
(`몫`을 구하면 된다.)

```javascript
'use strict';

function solution(n){
  let answer;
  if (n % 12 > 0) answer = parseInt(n / 12) + 1;
  else answer = parseInt(n / 12);
  return answer;
}

console.log(solution(25));
```

- parseInt() 메서드의 리턴값은 `정수값`
- Math.ceil() 이용하면 더 간단해진다.

# 총 합
초보 알고리즘 단골 문제

```javascript
'use strict';

function solution(n){
  let answer = 0;
  for (let i = 1; i <= n; i++) answer += i;
    
  return answer;
}
console.log(solution(10));
```

- 파라미터 n이 배열일 경우 `reduce`에 대해 알아볼 것.

# 최솟값

```javascript
'use strict';

function solution(arr){         
  let answer, min=Number.MAX_SAFE_INTEGER; //가장 큰 수로 초기화(int)
  /* console.log(min); */
  for (let i = 0; i < arr.length; i++) {
    if (arr[i] < min) min = arr[i];
    answer = min;
  }
  return answer;

}

let arr=[5, 7, 1, 3, 2, 9, 11];
console.log(solution(arr));
```

- `Number.MAX_SAFE_INTEGER` API 사용
- Math.min(...arr)

# 홀수

```javascript
'use strict';

function solution(arr){
  let answer = [];
  let min = Number.MAX_SAFE_INTEGER, sum = 0;;
  for (let i = 0; i < arr.length; i++) {
    if (arr[i] % 2 === 1) {
      sum += arr[i]; //총합
      if (arr[i] < min) min = arr[i]; //최솟값
    }
  }
  answer.push(sum, min); //홀수 총합, 최솟값 출력
  return answer;
}

let arr=[12, 77, 38, 41, 53, 92, 85];
console.log(solution(arr));
```

- 어렵지 않다.

# 10부제
이 문제는 `일의 자리`를 구해서 단순히 비교하면 된다.

```javascript
'use strict';

function solution(day, arr){
  let answer=0;
  for (let i = 0; i < arr.length; i++) {
    if ((arr[i] % 10) === (day % 10)) { //각각 일의 자리
      answer++;
    }
  }
  return answer;
}

let arr=[12, 20, 54, 30, 87, 91, 30];
console.log(solution(0, arr));
```

# 일곱난쟁이 찾기
이 문제의 핵심은 결국 총합에서 100을 빼서 나머지 난쟁이가 아닌 두 명을 찾아내는 것이다.

```javascript
'use strict';

function solution(arr){
  let answer=arr; //얕은 복사

  let sum = arr.reduce((acc, cur) => acc + cur);
  let result = sum - 100; //난쟁이가 아닌 둘의 합
  for (let i = 0; i < arr.length - 1; i++) {
    for (let j = i + 1; j < arr.length; j++) {
      if ((arr[i] + arr[j]) === result) {
        arr.splice(i, 1);
        arr.splice(j - 1, 1); // -1을 한 이유는 삭제를 하게 되면 인덱스는 땡겨(?)진다. or 뒤에꺼(j)부터 먼저 지워도 상관X
      }
    }
  }
  return answer;
}

let arr=[20, 7, 23, 19, 10, 15, 25, 8, 13];
console.log(solution(arr));
```

- 나 같은 경우는 지금 `선택 정렬`을 선택했는데 이는 시간 복잡도가 `O(n^2)`이라서 그렇게 좋진 않은 것 같다.
- `reduce`와 `splice`는 아주 유용하다.
- `얕은 복사`는 똑같은 주소를 참조하기 때문에 `arr`을 조작해도 `answer`는 `arr`와 같은 같이 출력된다.
