## object

```javascript
'use strict';

const name = 'minsu';
const age = 27;
print(name, age);
function print(name, age) {
  console.log(name);
  console.log(age);
}
```

- 위 코드에서 만약에 정보를 `name`과 `age` 말고 또 다른 주소나 핸드폰 번호나 등등 계속 추가해야 한다면 `print()` 함수에 파라미터들을 계속 추가해야할 것이다. 이러면 가독성이 떨어진다.
- 그래서 오브젝트를 사용한다.

```javascript
'use strict';

function print(person) {
  console.log(person.name);
  console.log(person.age);
}
const minsu = { name: 'minsu', age: 27 };
print(minsu);
```

- object를 사용하면 `person`이라는 오브젝트만 넘겨주고, `minsu`라는 오브젝트에 필요한 데이터만 추가해주면 된다.
- (주의) 자바스크립트는 동적으로 타입이 `런타임`때 결정되는데 오브젝트에 이미 데이터들을 다 선언해놓았는데 뒤늦게 추가하는 것이 가능하다는 것이다.

> 런타임: 프로그램이 동작하고 있을 때

```javascript
minsu.hasJob = true;
```

- 유연하다는 특징이 있어 금방금방 로직을 처리할 수는 있지만 규모가 커지면 유지보수하기가 굉장히 힘들어진다.
- 또한 데이터들을 삭제할 수도 있다.

```javascript
delete minsu.hasJob;
```

- (중요)
- **object = { key : value}** 형태라는 점.

### 오브젝트 선언

```javascript
const obj1 = {}; //'object literal' syntax 라고 하고,
const obj2 = new Ojbect(); //'object constructor' syntax 라고 한다.
//첫번째는 리터럴,
//두번째는 'new' 연산자를 이용한 생성자 문법이다.
```

### Computed properties

```javascript
console.log(minsu.name); //.(점)을 이용한 방법
console.log(minsu['name']); //[](괄호)를 이용한 방법
```

- []를 이용할 것은 키는 반드시 `'name'` **string 타입**으로 해야된다.

#### 언제 .(점)을 사용하고, 언제 \[](괄호)를 사용할까

- 보통의 경우에는 키에 해당하는 값을 가져올 때는 .(점)을 사용하고,
- \[](괄호)를 쓸 때는 어떤 키가 필요한지를 모를 때 즉, 런타임에서 결정될 때 사용한다. (실시간으로 원하는 키의 값을 받아오고 싶다면 사용)


```javascript
function printValue(obj, key) {
  console.log(obj[key]);
}
printValue(minsu, 'name');
printValue(minsu, 'age');
```

- 위 코드에서처럼 `key`는 어떤 것을 출력할지 우리는 알 수가 없다. 이 때 Computed Properties를 사용한다.
- 역시 `'name'`처럼 **string**으로 사용해야 하는 것을 주의하자.
- 동적으로 key에 관련된 value를 받아와야 할 때 유용하게 쓸 수 있겠다.

#### shorthand

```javascript
const person1 = { name: 'bob', age: 2 };
const person2 = { name: 'steve', age: 3 };
const person3 = { name: 'dev', age: 4 };
const person4 = infoPerson('minsu', 27);
console.log(person4);

//좋은 방법
function infoPerson(name, age) {
  return {
    /* name: name,
    age: age, */
    name,
    age,
  }
}
```

- 번거롭게 person의 정보를 계속 생성하지 않아도 `infoPerson()`이라는 함수를 만들어 데이터들을 인자로 받고 그 데이터들을 return해주면 된다.
- 이 때 `name: name,`과 같이 key와 value의 값이 동일하면 `name,`으로 생략이 가능하다.

### Constructor Function
위에서 `infoPerson()`이라는 함수를 만들어 사용했는데, 클래스처럼 만들어 사용할 수도 있다.

```javascript
const person1 = { name: 'bob', age: 2 };
const person2 = { name: 'steve', age: 3 };
const person3 = { name: 'dev', age: 4 };
const person4 = new Person('minsu', 27);
console.log(person4);

//Constructor Function
function Person(name, age) {
  //this = {};
  this.name = name;
  this.age = age;
  // return this;
}
```

- 이러면 자바스크립트 엔진이 알아서 오브젝트를 생성해준다.
- 여기서 생략된 것은 `this = {};`처럼 새로운 오브젝트를 만들고, 결국엔 `return this` this를 리턴하는 것이 생략되었다. 이것을 `Constructor Function`이라고 한다.

### in operator (키가 있는 없는지 체크)

```javascript
console.log('name' in minsu); //true
console.log('age' in minsu); //true
console.log('random' in minsu); //false
```

### for in, for of

```javascript
//모든 키들을 받아올 때
for (let key in minsu) {
  console.log(key);
}
const arr = [1, 2, 3];
for (let a of arr) {
  console.log(a);
}
```

- for in : Object 타입일 때
- for of : Array 타입일 때

### Function Cloning

```javascript
//함수 복제
const user = { name: 'minsu', age: 27 };
const user2 = user; //복사
user2.name = 'babo';
console.log(user.name); //babo
```

`user2 = user`를 하게 되면 같은 reference가 메모리에 생기게 되고 같은 reference이기 때문에 value도 같은 곳을 바라보게 된다. 그래서 `user.name`에도 변경이 된다.

#### 완전히 복제

```javascript
//old way
const user3 = {};
for (let key in user) {
  user3[key] = user[key];
}
user3.name = 'babo';
console.log(user3); //babo
console.log(user); //minsu
```

- 예전 방식으로는 빈 객체를 생성하여 `for in`을 이용하여 하나하나 다 넣는 것이다.

```javascript
//another way
const user4 = {};
Object.assign(user4, user);
//const user4 = Object.assign({} ,user);
console.log(user4);
```

- 다른 방식으로는 `Object.assign()`을 이용하는 것이다.
- 첫번째 인자로는 복사를 당하는 target과 두번째 인자는 복사를 하는 source를 넣어주면 된다.
