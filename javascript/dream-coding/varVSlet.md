# let(es6) vs var(es5)
ES6이전에는 ES5인 `var`를 사용했다.
알다시피 자바스크립트는 매우 유연한 언어이기에 다음이 가능했다.

```javascript
console.log(age); //undefined
age = 5;
console.log(age); //5
var age;
```

- 이러면 변수를 선언하기도 전에 값을 할당하는 것이 가능하다. (Java로 개발하는 사람들은 좀 어이없을 듯 하다..)

```javascript
name = 'minsu';
let name;
```

- 위 경우에는 에러를 표시한다.
- 그래서 **var보다는 let을 사용해야 한다.**

## var hoisting
위에서 **var는 선언하기도 전에 값을 할당할 수 있다고 했다. 이것을 var hoisting이라고 한다.**

`var 호이스팅`은 var로 변수를 선언함과 동시에 이 변수를 파일 맨 위로 끌어올려준다.
자, var는 선언하기도 전에 값이 할당된 이유가 여기서 나온다.  
변수를 맨 위로 끌어올려주기 때문에 이러한 것이 가능한 것이다.

## var: has no block scope
var의 단점중 또 한가지는 **var는 블록 스코프를 철저하게 무시한다.**

```javascript
{
	name = 'minsu';
	var name;
}
console.log(name); //minsu
```

- 위 경우에 name이 정상적으로 출력되는 것을 확인할 수 있다.

## constants
**constants는 값을 절대로 변경할 수 없는 immutable 타입을 갖는다.**

```javascript
사용예시
const daysInWeek = 7;
const maxNumber = 5;
```

- 자바스크립트에서 변수를 선언할 때는 immutable 타입으로 선언하는 것을 선호하고 있는데 그 이유가 있다.
- 첫 번째는 보안상의 이유다. (다른 사람이 함부로 값을 변경할 수 없게 한다.)
- 두 번째는 thread safety하다. (한 프로세스에는 다양한 쓰레드가 동시에 돌아가는데 여기서 변수가 동시에 변경하게 되면 위험할 수 있다. )
- 만약 변수 선언시에 이 값이 변경할 이유가 없다면 왠만하면 `const`로 선언하자.
- 반대로 값이 주기적으로 바뀐다면 `let`을 사용하자.
- 간혹 var와 let, const를 같이 쓰는 경우가 있는데 이는 서로 다른 ES 버전이어서 var를 사용하려면 var만, 그게 아니라면 let, const로 구현하자.

## function
자바로 개발하다가 자바스크립트로 넘어갈 때 힘든 부분이 이 `함수`부분이다.

**자바스크립트에서 함수는 데이터 타입중 하나라서 변수에 함수를 할당하는 것이 가능하다.**
즉, 함수의 인자로 전달이 가능하고 리턴타입으로도 리턴하는 것이 가능하다.  
**이러한 개념을 `first-class function`이라고 한다.

## infinity

```javascript
'use strict';

const infinity = 1 / 0;
const negativeInfinity = -1 / 0;
const nAn = 'not a number' / 2;

console.log(infinity); //Infinity
console.log(negativeInfinity); //-Infinity
console.log(nAn); //NaN
```

## template literals (string)

```javascript
'use strict';

const char = 'c';
const brendan = 'brendan';
const greeting = 'hello ' + brendan;
console.log(`value: ${greeting}, type: ${typeof greeting}`); 
const helloBob = `hi ${brendan}`;
console.log(`value: ${helloBob}, type: ${typeof helloBob}`); 
```

## boolean

```javascript
//false를 외우면 되겠다.
false: 0, null, undefined, NaN, ''
true: false를 제외한 아무 값
```

## null & undefined

```javascript
let nothing = null; //null이라는 값을 할당

let x; //undefined (값이 들어있는지 없는지 알 수 없는 undefined)
```

## Runtime Error
자바스크립트의 경우를 보자.

```javascript
'use strict';

let text = 'hello';
console.log(`${text}, ${typeof text}`); //hello, string
console.log(text.charAt(0)); //h
text = '6' / '2';
console.log(`${text}, ${typeof text}`); //3, number
console.log(text.charAt(0)); //error
```

- 마지막에는 런타임 시에 에러가 발생하여 곤란함을 겪는다.
- 자바 같은 경우에는 컴파일 시에 바로 잡아주기 때문에 상관이 없다.
- 자바스크립트는 이를 극복하려고 `타입스크립트`가 나온 것이다.

## 프리미티브 타입 & 레퍼런스 타입

- 프리미티브 타입: Number, String, boolean, null, undefined
	- 프리미티브 타입은 데이터가 변수에 할당될 때! 메모리에 고정된 크기로 저장된다.
	- 자바에서는 스택 영역에 저장하게 된다.

- 레퍼런스 타입: Object, Array, function
	- 레퍼런스 타입은 힙 메모리 영역에 주소값을 저장한다.
	- 자바에서 역시 new 연산자로 객체를 만들면 힙 영역에 값이 저장되고 스택 영역에는 주소값이 저장된다.

*이 부분은 좀 더 자세하게 포스팅해서 정리할 필요가 있다.*
