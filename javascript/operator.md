## OR 연산자

```javascript
'use strict';

const value1 = false;
const value2 = 4 < 2; //false
console.log(`or: ${value1 || value2 || check()}`); //true
console.log(`and: ${value1 && value2 && check()}`); //false

function check() {
  for (let i = 0; i < 10; i++) {
  	//wasting time
    console.log('😅');
  }
  return true; //true 리턴
}
```

- 위의 예제를 보면 결국엔 `true`를 리턴하여 true값이 출력된다.
- `console.log(or: ${value1 || value2 || check()});`에서 만약 `value1`이 `true`이면 그 즉시 계산을 멈춘다. 그 이유는 `OR 연산자`는 하나라도 `true`이면 결국엔 그 출력되는 값은 `true`가 되기 때문이다.
- 예를 들어, `console.log(or: ${ check() || value1 || value2});` 이렇게 `check()`와 같이 연산이 많은 함수가 맨 앞으로 오게 되면 그 연산을 하는데 시간이 꽤나 걸리고 나서 그 뒤에 `value1`, `value2`를 확인할 것이다. 그래서 먼저 연산이 가벼운 간단한 `value1`, `value2`를 앞에 두어 `true`이면 바로 멈추고, `false`라면 마지막으로 무거운 함수를 확인하면 베스트다.
- `AND 연산자` 역시 헤비한 함수를 맨 뒤에 배치하는 것이 옳다. 그래서 맨 앞이 `false`라면 어차피 `false`이므로 빠르게 출력하는 것이다.

## ==, ===

```javascript
'use strict';

const minsu1 = { name: 'minsu1' };
const minsu2 = { name: 'minsu2' };
const minsu3 = minsu1;
console.log(minsu1 == minsu2); //false
console.log(minsu1 === minsu2); //false
console.log(minsu1 === minsu3); //true
console.log(minsu1 == minsu3); //true
```

- Object의 경우, 각각 생성하면 서로 다른 레퍼런스 값을 갖기 때문에 서로 다르다.
- `==`와 `===`의 차이점은 **Type을 확인하고 안하고의 차이**이다. 즉, 좀 더 정확한 비교를 위해서는(Type까지) `===`을 사용한다.


```javascript
'use strict';

console.log(0 == false); //true
console.log(0 === false); //false, 0은 boolean 타입이 아닌 number이기에 false이다.
console.log('' == false); //true
console.log('' === false); //false, ''은 boolean 타입이 아닌 string이기에 false이다.
console.log(null == undefined); //true
console.log(null === undefined); //false, null은 undefined 타입이 아닌 object이기에 false이다.
```

## break, continue

```javascript
'use strict';

//0부터 10까지 짝수만 출력(continue 이용할 것)
for (let i = 0; i < 11; i++) {
  if (i % 2 === 1) continue;
  console.log(i);
}

//0부터 10까지 8을 제외하여 출력(break 이용할 것)
for (let i = 0; i < 11; i++) {
  if (i === 8) break;
  console.log(i);
}
```

- `continue`는 반복문에서 조건에 맞지 않으면 그 반복문은 건너띄고 다음 반복문을 실행한다.
- `break`는 반복문에 조건에 맞지 않으면 바로 그 반복문 자체를 아에 빠져나간다.
