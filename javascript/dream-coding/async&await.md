## async & await
`async & await`은 promise를 사용한 것을 좀 더 간결하게 해주고, 비동기적인 것들을 동기적으로 실행되는 것처럼 보이게 만들어준다.

- `Promise`도 역시 `then()` 같은 체이닝하고, 또 거기에 `new Promise()`로 체이닝을 하게 되면 조금 복잡하게 될 수도 있다. 
- 이를 간편하게 해주는 것이 바로 `async`와 `await`이다.
- `async`와 `await`은 새로 추가된 것이 아니라 기존에 존재한 `Promise` 위에 좀 더 간편한 API를 제공한다.
- 이렇게 기존에 존재하는 것 위에 좀 더 간편하게 API를 제공하는 것을 `syntactic sugar` 이라고 한다.
- `syntactic sugar`의 한 가지 좋은 예로 자바스크립트의 `class`있었다. 이것은 새로 추가된 것이 아니라 기존에 프로토타입을 베이스로 해서 제공한다.

#### 보통 함수

```javascript
function fetchUser() {
  //do Network request in 10 seconds...
  return 'minsu';
}
const user = fetchUser();
console.log(user);
```

#### 비동기 Promise

```javascript
//1. async
function fetchUser() {
  return new Promise((resolve, reject) => {
    //do Network request in 10 seconds...
    resolve('minsu');
  })
}
const user = fetchUser();
user.then(console.log);
console.log(user);
```

- `resolve()`와 `reject()`를 호출하지 않으면 `Promise`의 상태가 `pending` 상태가 되서 반드시 명시를 해주어야 한다. 명시를 해주어야 `fulfiiled` 상태가 된다.

#### async

```javascript
//1. async
async function fetchUser() {
  //do Network request in 10 seconds...
  return 'minsu';
}
const user = fetchUser();
user.then(console.log);
console.log(user);
```

- 이것을 실행시키면 바로 `Promise`를 리턴한다. 즉, 함수 앞에 `async`를 써주면 코드 블록을 `Promise`로 변환해준다.

#### await

```javascript
//2. await
function delay(ms) {
  return new Promise(resolve => setTimeout(resolve, ms));
}

async function getApple() {
  await delay(3000); //await: delay가 끝날 때까지 기다렸다가 🍎를 리턴한다.
  return '🍎';
}

async function getBanana() {
  await delay(3000);
  return '🍌';
}

/* function getBanana() { Promise 사용
  await delay(3000)
  .then(() => '🍌');
} */
```

- 동기적인 코드를 쓰는 것처럼 사용을 하는데 비동기적으로 처리를 해준다.

```javascript
function pickFruits() {
  return getApple()
    .then(apple => {
      return getBanana()
        .then(banana => `${apple} + ${banana}`);
    });
}
pickFruits().then(console.log);
```

- 이러면 사과와 바나나 함수 두개를 호출해준다.
- 하지만 이 코드는 연속된 체이닝으로 `콜백 지옥`을 연상케한다..

```javascript
async function pickFruits() {
  const apple = await getApple();
  const banana = await getBanana();
  return `${apple} + ${banana}`;
}
pickFruits().then(console.log); //총 6초 소요
```

- `async`와 `await`을 사용하면 정말 간편하게 사용을 할 수 있다.
- 다만 병렬 처리에서 보면 원래 3초가 걸려야 하지만 각각 기달려서 총 6초가 걸리는 문제가 생긴다.

```javascript
async function pickFruits() {
  const applePromise = getApple();
  const bananaPromise = getBanana();
  const apple = await applePromise;
  const banana = await bananaPromise;
  return `${apple} + ${banana}`;
}
pickFruits().then(console.log);
```

- 먼저 각각의 프로미스를 생성해주고, 그 다음에 생성한 프로미스 변수를 `await`을 붙여주면 병렬적으로 실행이 가능하다. 그래서 총 3초가 소요된다.
- 하지만 위 코드는 뭔가 조잡하다. (느낌이..)

```javascript
//3. useful Promise APIs
function pickAllFruits() {
  return Promise.all([getApple(), getBanana()])
    .then(fruits => fruits.join(' + ')); //배열을 string으로 변환
}
pickAllFruits().then(console.log);

function pickOnlyOne() {
  return Promise.race([getApple(), getBanana()]); //바나나가 1초만에 먼저 출력
}
pickOnlyOne().then(console.log);
```

- Promise의 API인 `all()` 사용하면 모든 프로미스들이 병렬적으로 다 받을 때까지 모아주는  역할을 해준다.
- Promise의 API인 `race()` 사용하면 배열에 전달된 프로미스 중에서 가장 먼저 값을 리턴한 것에만 전달이 되어진다.
