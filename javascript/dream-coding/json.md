## HTTP
우리가 브라우저 위에서 동작하고 있는 웹사이트 또는 웹어플리케이션 같은 클라이언트와 서버가 어떻게 통신하고 있는 것일까?

`HTTP`는 `Hypertext Transfer Protocol`의 약자로, **Hypertext를 어떻게 서로 주고 받을 수 있는지를 규약한 프로토콜**중 하나이다.

클라이언트는 서버에게 요청하고 서버는 요청에 대한 응답을 해주는 방식이다.

> Hypertext: 하이퍼링크 뿐만이 아니라 문서나 이미지 등 리소스를 포함하고 있는 것을 말한다.

## AJAX
서버에게 데이터를 요청해서 받아올 수 있는 방법으로 `AJAX(Asynchronous JavaScript And XML)`를 사용했다.  
AJAX는 동적으로 서버에게 데이터를 주고 받을 수 있는 기술을 말한다.

대표적으로 `XHR(XMLHttpRequest)`라는 오브젝트가 있다. XMLHttpRequest는 브라우저 API에서 제공하는 API 중 하나로 서버에게 데이터를 요청하고 받아올 수 있다.

최근에는 `fetch() API`를 이용하여 주고 받을 수 있지만 `IE`에서는 제공하지 않는다..

#### XML
HTML과 같은 마크업 언어중 하나로, 데이터를 표현할 수 있는 방법중 한 가지이다.  
이런 XML 뿐만 아니라 다양한 데이터를 표현할 수 있는 파일 포맷이 있는데 요즘은 `JSON`을 많이 쓴다.

#### XML 단점
불필요한 태그들이 많아 파일의 사이즈가 커질 뿐 아니라 가독성도 떨어진다.

## JSON
JSON은 **JavaScript Object Notation**의 약자로, 자바스크립트와 연관이 있다. `ECMAScript 3rd`에서 영감을 받아 나타났다.

```javascript
Object { key : value }
```

- 오브젝트는 `key`와 `value`로 이루어져있는데, JSON 역시 `key`와 `value`로 이루어져 있다.

#### JSON 장점

- 아주 간단한 데이터 포맷
- 가벼운 텍스트 구조
- 좋은 가독성
- 키와 값 한 쌍
- 직렬화와 데이터를 전송할 때 사용
- 프로그래밍 언어와 플랫폼에 상관없이 사용이 가능하다. (막강한 장점)

## 예제 코드

```javascript
'use strict';

//1. Object to JSON (serializer)
//stringfy(obj)
const rabbit = {
  name: 'troy',
  color: 'black',
  size: null,
  birthDate: new Date(),
  jump: () => {
    console.log(`${name} can jump`);
  },
};
let json = JSON.stringify(rabbit);
console.log(json);

json = JSON.stringify(rabbit, ["name"]); //해당하는 property만 출력한다.
console.log(json);

json = JSON.stringify(rabbit, (key, value) => {
  console.log(`key: ${key}, value: ${value}`);
  return key === 'name' ? 'minsu' : value; //이름 변경
});
console.log(json);
//2. JSON to Object (deserializer)
//parse(json)
console.clear();
json = JSON.stringify(rabbit);
const obj = JSON.parse(json, (key, value) => {
  console.log(`key: ${key}, value: ${value}`);
  return key === 'birthDate' ? new Date(value) : value;
});
console.log(obj);
rabbit.jump(); //정상 출력
//obj.jump(); 에러 발생

console.log(rabbit.birthDate.getDate()); //정상출력
console.log(obj.birthDate.getDate()); //에러 발생
```

- 함수는 JSON에 포함되지 않는다. 그래서 `stringify`로 JSON으로 변환해서 다시 `parse`로 오브젝트 형태로 변환한다해도 rabbit의 함수 `jump()` 함수는 다시 생기지 않는다.
- 오브젝트 `obj`의 날짜를 받을 때 에러가 나는 이유는 `string`형태이기 때문이다. 오브젝트 `rabbit`에는 `new` 키워드를 이용한 생성자 오브젝트 형태이기에 맞지 않는 것이다.

```javascript
console.log(obj.birthDate.getDate()); //에러 발생
```

- 에러 해결을 하기 위해

```javascript
const obj = JSON.parse(json, (key, value) => {
  console.log(`key: ${key}, value: ${value}`);
  return key === 'birthDate' ? new Date(value) : value;
});
```

- `key`가 `birthDate`이면 `Date` 생성자를 생성해주는 것이다.
