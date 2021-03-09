*ES6 문법 사용*

# 회문 문자열
회문 문자열이란 앞에서 읽으나 뒤에서 읽으나 같은 것을 말한다.

```javascript
'use strict';

function solution(s){
  let answer="YES";
  s = s.toLowerCase();
  let len = s.length;
  for (let i = 0; i < parseInt(len / 2); i++) {
    if (s[i] !== s[len - i - 1]) return 'NO';
  }
  return answer;
}

let str="gooog";
console.log(solution(str));

// ----------------- reverse() -----------------
let result = s.split('').reverse().join('');
if (s !== result) return 'NO';
```

- `split()` 메서드로 배열화시킨 후 `reverse()`를 이용하여 같은지 비교해도 된다.
- 비교할 때 다시 문자열로 만들기 위해 `join()`을 사용한다.

# 팰린드롬
팰린드롬 앞에서 설명한 회문 문자열을 영어로 팰린드롬이라 한다.

```javascript
'use strict';

function solution(s){
  let answer="YES";
  s = s.toLowerCase().replace(/[^a-z]/g, ''); //^: 부정, 정규표현식으로 기호들은 다 제거한다.
  let result = s.split('').reverse().join('');
  if (s !== result) return 'NO';
  return answer;
}

let str="found7, time: study; Yduts; emit, 7Dnuof";
console.log(solution(str));
```

- `replace()` 메서드 이용 (앞의 파라미터는 정규식 객체 또는 리터럴이 온다.)

# 숫자만 추출
문자와 숫자 사이에 숫자만 추출해라.

```javascript
'use strict';

function solution(str){
  let answer="";
  for (let i = 0; i < str.length; i++) {
    if (!isNaN(str[i])) answer += str[i]; //ex. isNaN("123") return: false,
  }
  return Number(answer);
}

let str="g0en2T0s8eSoft";
console.log(solution(str));
```

# 가장 짧은 문자거리

```javascript
'use strict';

function solution(s, t){
  let answer=[]; //짧은 거리
  let p = 100;
  for (let i = 0; i < s.length; i++) { //정방향
    if (s[i] !== t) {
      p++; //t가 아닐 경우 증가
      answer.push(p);
    }
    else {
      p = 0; //t일 경우 0으로 초기화
      answer.push(p);
    }
  }
  p = 100;
  for (let i = s.length - 1; i >= 0; i--) { //반대 방향
    if (s[i] !== t) {
      p++;
      answer[i] = Math.min(answer[i], p);
    } else {
      p = 0;
      
    }
  }
  
  return answer;
}

let str="teachermode";
console.log(solution(str, 'e'));
```

- `for문` 2개로 정방향과 반대 방향을 탐색하여 비교해서 더 작은 값을 `answer[i]`값을 변경해준다.
- 반대 방향 같은 경우는 `push`를 하면 안되고 비교해서 값을 바꿔주면 된다.

# 문자열 압축
이 문제의 핵심은 `count`를 `1`로 초기화해주고, 옆의 있는 값과 비교해나간다.

```javascript
'use strict';

function solution(s){
  let answer="";
  let count = 1;
  for (let i = 0; i < s.length; i++) {
    if (s[i] === s[i + 1]) { //옆에 있는 값과 비교하여 같으면
      count++; //count 증가
    } else { //다르면
      answer += s[i]; //answer에 새로 추가하고,
      if (count > 1) answer += String(count); //count가 1보다 클 경우에만 answer에다가 String형 count를 추가
      count = 1; //다시 count = 1로 초기화
    }
  }
  return answer; 
}

let str="KKHSSSSSSSE";
console.log(solution(str));
```

몰라도 좋다. 어려워도 좋다.  
대신에 포기만 하지 말고, 꾸준히 하자.
