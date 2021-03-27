## 동기와 비동기

- 자바스크립트는 동기적인 특징을 가지고 있다.
- 호이스팅이 된 이 후부터 코딩을 위에서부터 하나하나 읽어나가는 것을 **동기**라고 이해하면 된다.

```javascript
'use strict';

//JavaScript is synchronous
console.log('1');
console.log('2');
console.log('3');
```

- 비동기의 대표적인 예는 `setTimeout()`을 사용하는 것이다.

```javascript
'use strict';

//JavaScript is synchronous
console.log('1');
setTimeout(() => { //asynchronous
  console.log('2');
}, 3000);
console.log('3');
```

- '1'을 출력하고 '3'을 출력하고 그 다음에 마지막에 '2'를 출력한다.
- 즉, 동기적으로 실행하다가 `setTimeout()`을 만나면 브라우저에게 3초뒤에 콜백해달라고 요청을 하는 것이다.
- `setTimeout()`같은 브라우저 API는 무조건 브라우저에게 요청을 보내게 된다.
- 이것이 **비동적인 실행 방법이다.**
- setTimeout에 있는 콜백함수는 지금 당장은 아닌 3초뒤에 다시 불러줘해서 `Callback`이라고 해서 콜백함수라고 부른다.

```javascript
//Synchronous callback
function printImmediately(print) {
  print();
}
printImmediately(() => console.log('hello'));
//Asynchronous callback
function printWithDelay(print, timeout) {
  setTimeout(print, timeout);
}
printWithDelay(() => console.log('async callback'), 2000);
```

## 콜백 지옥

```javascript
//콜백 지옥
class UserStorage {
  //로그인 정보
  loginUser(id, password, onSuccess, onError) {
    setTimeout(() => {
      if (
        (id === 'minsu' && password === '1234') ||
        (id === 'coder' && password === '5678')
      ) {
        onSuccess(id); //성공
      } else {
        onError(new Error('not found!')); //실패
      }
    }, 2000);
  }
  //로그인 권한
  getRoles(user, onSuccess, onError) {
    setTimeout(() => {
      if (user === 'minsu') {
        onSuccess({ name: 'minsu', role: 'admin' });
      } else {
        onError(new Error('no access'));
      }
    }, 1000);
  }
}
```

- 위와 같은 클래스 정보가 있다.
- 보면은 `loginUser` 로그인하기 위한 정보들이 있고, `getRole` 로그인의 권한 정보들이 있다.

```javascript
const userStorage = new UserStorage();
const id = prompt('enter your id');
const password = prompt('enter your password');
userStorage.loginUser(id, password, user => {
  userStorage.getRoles(user, userWithRole => {
    alert(`Hello, ${userWithRole.name}, and ${userWithRole.role} role`);
  }, error => {
    console.log(error);
  })
}, (error) => {
  console.log(error);
})
```

- 이것이 콜백 지옥이다. 콜백함수로 계속 쓰게 되면 가독성이 너무 떨어져서 정말 알아보기가 힘들다. 당연히 유지보수하기에도 어려울 것이다.

### 콜백 지옥 해결 (Promise)

[코드 보기](https://github.com/azurealstn/TIL/blob/main/javascript/dream-coding/resolveCallback.md)
