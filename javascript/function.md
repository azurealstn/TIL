## JS에서의 function

`function`을 선언할 때는 다른 언어와 비슷하다.

```javascript
function name(param1, param2) { body... return; }
```

- 다만, JS에서의 `function`은 `Object` 즉, 객체이다.
- 즉, `function`을 변수에 할당할 수도 있고
- `function`을 리턴할 수도 있고
- `function`을 파라미터로 받을 수도 있는 것이다.
- (저는 이 부분에서 조금 많이 혼돈이 왔었습니다.😂)

## Parameters

```javascript
'use strict';

//primitive parameters: 값(value)를 전달
//object parameters: 레퍼런스(reference)를 전달
function changeName(obj) { //object parameter
  obj.name = 'coder';
}
const minsu = { name: 'minsu' }; //object
changeName(minsu); //object의 reference를 전달
console.log(minsu);
```

- Primitive 파라미터들은 값을 전달하고, Object 파라미터들은 레퍼런스를 전달한다는 점을 긱억하자.

```javascript
'use strict';

//Default parameters
function showMessage(message, from = 'unknown') {
  /* if (from === undefined) {
    from = 'unknown';
  } */
  console.log(`${message} by ${from}`);
}
showMessage('Hi!');
```

- 이번엔 Default 파라미터들이다. 기존에는 두 파라미터를 전달해야하는데 하나만 전달할 경우 `undefined`가 출력된다. 그래서 `if문`으로 조건을 단다.
- 하지만 ES6에서는 `if문`을 사용하지 않아도 파라미터에다가 직접 값을 넣을 수도 있다.

```javascript
'use strict';

//Rest parameters
function printAll(...args) {
  for (let i = 0; i < args.length; i++) {
    console.log(args[i]);
  }
}
printAll('hello', 'minsu', '!');
```

- 그 다음으로는 Rest 파라미터이다. 이것 역시 ES6에 추가된 것이며 `...args`로 전달하게 되면 바로 **배열** 형태로 전달을 하게 된다. 그래서 함수를 호출할 때는 

```
printAll('hello', 'minsu', '!');
```

이와 같이 호출하면 된다.

- 위 코드에서 `for문`을 아래와 같이도 표현이 가능하다는 점.

```javascript
//for...of
  for (const arg of args) {
    console.log(arg);
  }
//forEach
  args.forEach((arg) => console.log(arg));

//출력 결과는 동일하다.
```

## Return
함수에서 중요한 `Return`이다.

```javascript
'use strict';

//Return a value
function sum(a, b) {
  return a + b;
}
const result = sum(1, 2); //3
console.log(`sum: ${sum(1, 2)}`);
```

- 리턴된 값을 `result`라는 변수에 담을 수도 있고
- 직접 출력을 할 수도 있다.

```javascript
'use strict';

//no Return
function print() {
  console.log('hello');
  //return undefined;
}
print();
```

- `return`이 없는 함수도 있는데 이 때는 `return undefined;`가 들어가 있는 거와 동일하며 이는 생략이 가능하다.

### Early return, early exit

```javascript
'use strict';

//bad
function upgradeUser(user) {
  if (user.point > 10) {
    //long upgrade logic...
  }
}
```

- 나쁜 경우를 먼저 보면 `if문` 안에 긴 로직을 먼저 수행하게 되는데 이러면 효율성이 떨어진다.

```javascript
'use strict';

//good
function upgradeUser(user) {
  if (user.point <= 10) {
    return;
  }
  //long upgrade logic...
}
```

- 좋은 경우는 조건이 맞지 않을 경우에 빠르게 `return`을 해주어 함수를 빠져나오는 것이다. 그렇지 않을 때 그 때는 upgrade logic을 수행해주면 된다. (좋은 코드의 예)

## 함수 표현식

```javascript
'use strict';

const print = function () { //anonymous function
  console.log('hello');
}
print();
```

- JS에서 함수는 변수에 할당하는 것이 가능하다고 했다. 그래서 위와 같이 함수를 변수에 할당하고 함수에 이름이 없는 것을 `anonymous(익명의) function`이라고 한다.

## function hoisting

- 앞서 우리는 var hoisting을 알아봤다. var 변수를 선언과 동시에 가장 위로 끌어올리는 것을 의미하는데, 이 function도 선언과 동시에 끌어올린다.

```javascript
//function hoisting(함수 호이스팅)
console.log(sum(1, 2));
function sum(a, b) {
  return a + b;
}
```

## Callback function

- 이것도 JS 배우면서 혼란스러운 부분이었다.

```javascript
'use strict';

//Callback Function
function randomQuiz(answer, printYes, printNo) {
  if (answer === 'love you') {
    printYes();
  } else {
    printNo();
  }
}
const printYes = function () { //anonymous function
  console.log('yes!');
};
const printNo = function print() { //named function
  console.log('No..');
};
randomQuiz('wrong', printYes, printNo);
randomQuiz('love you', printYes, printNo);
```

- `randomQuiz` 함수에는 3 파라미터들이 있다. 그 중에 `printYes`와 `printNo`는 함수인데, 이 두 함수를 전달해서 각 상황에 맞으면 이 함수들을 불르는 것을 바로 `Callback Function(콜백 함수)`이라고 한다.
- 즉, 두 가지의 콜백 함수들이 파라미터로 전달되면서 `if문`에서 `answer === 'love you'`이면 `printYes()`를 호출하게되고, 그렇지 않으면 `printNo()`를 호출하게 된다.

## Arrow Function

- Arrow Function은 함수를 아주 간결하게 만들어주는 아주 편리한 함수이다.
- 또한 `anonymous function`이다.

```javascript
'use strict';

const hello = function () {
  console.log('hello');
}
const hello1 = () => {
  console.log('hello1');
}
hello();
hello1();
```

- `function`을 지워주고 `()` 다음에 `=>`를 붙여준다.
- 또한 `=>` 다음 블록 라인이 한 줄일 경우에는 `{}`도 생략이 가능하다.

```javascript
const hello1 = () => console.log('hello1');
```

### Arrow Function (return 생략)

```javascript
'use strict';

const sum = function (a, b) {
  return a + b;
}
const sum1 = (a, b) => a + b;
console.log(sum(1, 2));
console.log(sum1(1, 2));
```

- return이 있는 함수도 위와 같이 arrow로 표현이 가능하다.
- 만약 멀티라인일 경우에는 `return`을 생략하지 말고 꼭 명시를 해주어야 한다. (아래 코드)

```javascript
'use strict';

const sum = (a, b) => {
  //do something...
  return a + b;
}
```

## IIFE

- **IIFE는 Immediately Invoked(호출된) Function Expression**이다.

```javascript
'use strict';

function hello() {
  console.log('IIFE');
}
hello(); //함수 호출
```

- 보통은 위 코드처럼 함수를 호출할 것이다.
- 하지만 함수를 선언함과 동시에 바로 호출하는 것이 가능하다. (아래 코드)

```javascript
'use strict';

(function hello() {
  console.log('IIFE');
})(); //바로 호출
```

### 간단한 계산 퀴즈

```javascript
'use strict';

function calculate(command, a, b) {
  switch (command) {
    case add:
      return a + b;
    case substract:
      return a - b;
    case divide:
      return a / b;
    case multiply:
      return a * b;
    case remainder:
      return a % b;
  }
}
const add = (a, b) => a + b;
const substract = (a, b) => a - b;
const divide = (a, b) => a / b;
const multiply = (a, b) => a * b;
const remainder = (a, b) => a % b;
console.log(calculate(add, 1, 2));
console.log(calculate(substract, 1, 2));
console.log(calculate(divide, 1, 2));
console.log(calculate(multiply, 1, 2));
console.log(calculate(remainder, 1, 2));
```
