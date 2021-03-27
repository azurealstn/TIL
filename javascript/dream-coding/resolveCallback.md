```javascript
'use strict';

//콜백 지옥
class UserStorage {
  //로그인 정보
  loginUser(id, password) {
    return new Promise((resolve, reject) => {
      setTimeout(() => {
        if (
          (id === 'minsu' && password === '1234') ||
          (id === 'coder' && password === '5678')
        ) {
          resolve(id); //성공
        } else {
          reject(new Error('not found!')); //실패
        }
      }, 2000);
    });
  }
  //로그인 권한
  getRoles(user) {
    return new Promise((resolve, reject) => {
      setTimeout(() => {
        if (user === 'minsu') {
          resolve({ name: 'minsu', role: 'admin' });
        } else {
          reject(new Error('no access'));
        }
      }, 1000);
    });
  }
}

const userStorage = new UserStorage();
const id = prompt('enter your id');
const password = prompt('enter your password');
userStorage
  .loginUser(id, password)
  .then(user => userStorage.getRoles(user))
  .then(user => alert(`Hello, ${user.name}, and ${user.role} role`))
  .catch(error => console.log(error));

```
