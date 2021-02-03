*ES6 문법 사용*

# A -> \#
문자열 탐색 문제

```javascript
'use strict';

function solution(s){
  let answer="";
  for (let i = 0; i < s.length; i++) {
    if (s[i] === 'A') answer += '#';
    else answer += s[i];
  }
  return answer;
}

let str="BANANA";
console.log(solution(str));
```

- `replaceAll()` 메서드를 사용해도 된다.

# 문자 찾기

```javascript
'use strict';

function solution(s, t){
  let answer=0;
  for (let i = 0; i < s.length; i++) {
    if (s[i] === t) answer++;
  }
  return answer;
}

let str="RRRAAAARRR";
console.log(solution(str, 'R'));
```

- `split()` 메서드를 이용하여 해결 가능.

# 대문자 찾기
문자열 안에 대문자가 있는 문자를 셀려면 어떻게 해야할까?

```javascript
'use strict';

function solution(s){         
  let answer=0;
  for (let i = 0; i < s.length; i++) {
    if (s.charCodeAt(i) < 91) answer++; //유니코드 90: 'Z'
  }
  return answer;
}

let str="KoreaTimeGood";
console.log(solution(str));
```

- `charCodeAt()` 메서드는 리턴값이 0~65535 사이의 정수값
- `String.fromCharCode()` 메서드는 유니코드 정수값을 문자로 변환
- `toUpperCase()` 메서드를 이용해도 됨.

# 모두 대문자로~

```javascript
'use strict';

function solution(s){         
  let answer="";
  answer = s.toUpperCase(); //리턴값이 있기 때문에 할당을 해주어야 한다.
  return answer;
}

let str="ItisTimeToStudy";
console.log(solution(str));
```

- 설명 생략

# 대문자는 소문자, 소문자는 대문자로~

```javascript
'use strict';

function solution(s){         
  let answer = "";
  for (let i = 0; i < s.length; i++) {
    if (s[i] === s[i].toUpperCase()) answer += s[i].toLowerCase();
    else answer += s[i].toUpperCase();
  }
  return answer;
}
let str="ItisTimeToStudy";
console.log(solution(str));
```

# 가장 긴 문자열
배열 파라미터가 주어졌을 때 가장 긴 문자열은?

```javascript
'use strict';

function solution(arr){         
  let answer;
  let max = Number.MIN_SAFE_INTEGER;
  for (let i = 0; i < arr.length; i++) {
    if (arr[i].length > max) {
      max = arr[i].length;
      answer = arr[i];
    }
  }
  return answer;
}
let str=['teacher', 'time', 'student', 'beautiful', 'good'];
console.log(solution(str));
```

# 가운데 값
문자열 파라미터가 주어졌을 때 문자열의 길이가
짝수면 가운데 값 두 개, 홀수면 한 개를 출력한다.

```javascript
'use strict';

function solution(s){         
  let answer = '';
  let mock = parseInt(s.length / 2); //몫
  if (s.length % 2 === 0) { //짝수
    for (let i = mock - 1; i <= mock; i++) {
      answer += s[i];
    }
  } else { //홀수
    answer = s[mock];
  }
  
  return answer;
}
// Math.floor(), substring() 메서드 사용
function solution(s){         
  let answer = '';
  let mid = Math.floor(s.length / 2); //정수값 반환
  if (s.length % 2 === 1) answer = s.substring(mid, mid + 1); //substring: 시작 인덱스부터 끝 인덱스 전까지 출력
  else answer = s.substring(mid - 1, mid + 1);
  
  return answer;
}
console.log(solution("star"));
console.log(solution("str"));
```

# 중복문자제거

```javascript
'use strict';

function solution(s){         
  let answer = '';
  for (let i = 0; i < s.length; i++) {
    if (s.indexOf(s[i]) === i) answer += s[i] //indexOf() 메서드의 반환값은 해당 문자의 인덱스 값이다.
    // s.indexOf(s[i]) === i: 처음 나온 문자.
  }
  return answer;
}
console.log(solution("ksekkset"));

// 문자 'k'의 개수를 구하시오.
function solution(s){         
  let answer = 0;
  let pos = s.indexOf('k'); //0
  while(pos !== -1) {
    answer++;
    pos = s.indexOf('k', pos + 1)
  }
  return answer;
}
console.log(solution("ksekkset"));
```

# 중복단어제거

```javascript
'use strict';

function solution(arr){         
  let answer = arr.filter((v, i) => { //filter: 새로운 배열을 반환
    if (arr.indexOf(v) === i) return v;
  })
  return answer;
}
console.log(solution(['good', 'time', 'good', 'time', 'student']));
```

# 큰 수 출력
자기 바로 앞에보다 크면 그냥 출력한다.

```javascript
'use strict';

function solution(arr){         
  let answer=[];
  answer.push(arr[0]);
  for (let i = 0; i < arr.length; i++) {
    if (arr[i] < arr[i + 1]) answer.push(arr[i + 1]);
  }
  return answer;
}

let arr=[7, 3, 9, 5, 6, 12];
console.log(solution(arr));
```

# 보이는 학생
앞의 문제와 매우 유사하다.

```javascript
'use strict';

function solution(arr){         
  let answer = 1;
  let max = arr[0];
  for (let i = 1; i < arr.length; i++) {
    if (max < arr[i]) {
      max = arr[i];
      answer++;
    }
  }
  
  return answer;
}

let arr=[130, 135, 148, 140, 145, 150, 150, 153];
console.log(solution(arr));
```
