## Promise
`Promise`는 비동기를 간단하게 처리해줄 수 있는 자바스크립트에서 제공하는 오브젝트이다.
프로미스는 정해진 긴 시간이 지나고 정상적으로 그 로직이 수행이 되었다면 `성공의 메시지`를, 기능을 수행하다가 에러가 발생했다면 `실패의 메시지`를 전달해준다.

이것을 예로 들면, 우리가 강사님의 강좌가 언제나올지 모르겠지만 `알림`을 받고 싶은데, 이 때 `Promise`로 구현을 하게 되면 강좌가 딱 생기면 `Promise`가 메일로 강좌가 올려졌다는 성공의 메시지를 보내주게 된다. 이것이 비동기다.  
만약 강좌가 오픈된지 지나고 뒤늦게 강좌 알림을 신청했다면 바로 성공의 메시지를 보내주게 된다.

### 프로미스의 2가지 포인트

- State(상태) : 프로세스가 무거운 작동을 하고 있는지, 기능이 수행이 완료가 되어 성공했는지 실패했는지의 상태 (만약 프로세스가 수행중일 때는 `pending 상태`, 모든 수행이 완료되었을 때는 `fulfilled 상태`가 된다. 에러는 `rejected 상태`가 된다. )
- Producer : 우리가 원하는 데이터를 제공하는 사람, Consumer : 제공된 데이터를 필요료 하는 사람

### Promise 생성
**이 Promise를 생성하게 되는 순간 `executor`가 바로 실행이 된다.** (알고 넘어가기!)

```javascript
//1. Producer
const promise = new Promise((resolve, reject) => { //promise 객체 생성
  //doing hard work (network, read files -> asynchronous 처리)
  console.log('doing something...');
  setTimeout(() => {
    //resolve('minsu');
    reject(new Error('no network')) //Error 클래스: JavaScript에서 제공하는 클래스
  }, 2000);
});

//2. Consumer: then, catch, finally
//Chaining Structure
promise
  .then(value => {
    console.log(value); //2초후 minsu라는 성공의 메시지 뜬다. (then())
  })
  .catch(error => {
    console.log(error); //2초후 에러 메시지가 뜬다. (catch())
  })
  .finally(() => {
    console.log('finally'); //2초후 성공과 실패와 상관없이 맨 마지막에 출력된다. (finally())
  });
```

- `resolve()` : 성공의 메시지를 수행하는 콜백함수 (Success)
- `reject()` : 실패의 메시지를 수행하는 콜백함수 (Error)
- `then()` : 정상적으로 수행이 된다면 -> 다음 로직 수행
- `catch()` : 에러가 뜰 때 처리하는 함수
- `finally()` : 성공과 에러에 상관없이 마지막에 출력

### Promise Chaining

```javascript
//3. Promise Chaining
const fetchNumber = new Promise((resolve, reject) => {
  setTimeout(() => resolve(1), 1000);
});

fetchNumber
  .then(num => num * 2) //2
  .then(num => num * 3) //6
  .then(num => {
    return new Promise((resolve, reject) => { //또 새로운 Promise 객체 생성
      setTimeout(() => resolve(num - 1), 1000); //1초후 num - 1(5)
    })
  })
  .then(num => console.log(num)); //최종적으로 num을 출력 (총 2초가 걸린다.)
```

- 위 구조처럼 수많은 다른 비동기적인 것들을 묶어서 처리할 수도 있다.

### Error Handling

```javascript
//4. Error Handling
//🐓, 닭을 리턴하는 함수
const getHen = () => new Promise((resolve, reject) => {
  setTimeout(() => resolve('🐓'), 1000);
});

//🥚, 닭으로 부터 달걀을 리턴하는 함수
const getEgg = hen => new Promise((resolve, reject) => {
  setTimeout(() => resolve(`${hen} => 🥚`), 1000);
});

//🍳, 달걀로부터 후라이를 만드는 함수
const cook = egg => new Promise((resolve, reject) => {
  setTimeout(() => resolve(`${egg} => 🍳`), 1000);
});
```

- 위와 같은 프로미스를 생성한 3개의 함수가 있다.

<br/>
<br/>

```javascript
getHen()
  .then(hen => getEgg(hen))
  .then(egg => cook(egg))
  .then(meal => console.log(meal));
```

- 위에서 생성한 프로미스를 사용할 수가 있다.
- 여기서 콜백함수를 전달할 때 받아온 value를 다음 함수를 바로 하나를 호출하는 경우에 생략이 가능하다. (아래 코드)

```javascript
getHen()
  .then(getEgg)
  .then(cook)
  .then(console.log);
```

---

```javascript
//4. Error Handling
//🐓, 닭을 리턴하는 함수
const getHen = () => new Promise((resolve, reject) => {
  setTimeout(() => resolve('🐓'), 1000);
});

//🥚, 닭으로 부터 달걀을 리턴하는 함수, 에러 발생!!
const getEgg = hen => new Promise((resolve, reject) => {
  setTimeout(() => reject(new Error(`error ! ${hen} => 🥚`)), 1000);
});

//🍳, 달걀로부터 후라이를 만드는 함수
const cook = egg => new Promise((resolve, reject) => {
  setTimeout(() => resolve(`${egg} => 🍳`), 1000);
});

getHen()
  .then(getEgg)
  .catch(error => { //달걀을 받아올 때 에러가 생기면 다른 것으로 대체할 수도 있다.
    return '🍕';
  })
  .then(cook)
  .then(console.log)
  .catch(console.log);
```

- 위 코드에서 달걀을 받아오는 과정에서 에러가 발생했다고 가정하면 `then()`이 수행되다가 바로바로 에러를 `catch()`해서 에러를 바로 처리할 수도 있다.
- 이렇게하면 에러가 발생하게 되면 해당 함수에서 바로 에러 처리가 가능하며, 이를 대체하여 다른 것으로 리턴이 가능하다.
