# 자바스크립트의 역사
1. Mosaic Web Browser가 1993년에 처음 출신된다.  
이후 Netscape라는 회사를 차려 정적인 웹사이트를 만들기 위해 Netscape Navigator를 개발하여 1994년에 출시하게 된다.
2. 동적인 웹사이트를 만들기 위해 `Mocha`라는 언어가 탄생하고 이 후 `LiveScript`로 이름을 바꾸어 이 언어를 이해하고 실행할 수 있는 엔진인 `Interpreter`도 포함하고 있다.
3. 이 후에 '자바 언어'의 인기를 얻고자 이름을 `Javascript`로 변경하게 된다.

---

1996년, MS에서도 `Internet Explorer`를 출시하게 되는데 서로 다르게 동작되는 두 브라우저를 모두 지원이 될 수 있도록 개발을 해야해서 개발자들이 온갖 고생을 다했다.
그리고 Netscape의 제안으로 Javascript의 표준을 만들기 위해 1997, 7월 `ECMAScript 1`이 출시가 되었다.

![캡처](https://user-images.githubusercontent.com/55525868/110785784-afc86b80-82ae-11eb-895d-c43fae17d863.PNG)

4. 이 후 `Firefox`는 다시 표준안을 만들기 위해 다시 제안을 한다.
5. 2004년, `AJAX(Asynchronous JavaScript and XML)` 비동기적으로 데이터를 서버에서 받아오고 처리할 수있는 도구를 만들어낸다.
6. 이 후에도 오페라 등등 여러 브라우저가 나와서 개발하기가 굉장히 힘들었는데 이 때 `jQuery`가 등장하여 **제이쿼리의 역할은 개발자들이 제이쿼리에서 제공하는 APIs를 사용하면 동작은 제이쿼리가 맡아준다는 점이다.**

---

그리고 2008년 `크롬(Chrome)` 브라우저가 탄생하게 된다. 이는 `JIT 엔진` 포함되어 속도 성능이 급격히 좋아졌다.  
대망의 2009년 `ECMAScript 5`가 출시되고, 이 후에 2015년에 `ECMAScript 6`가 출시된다. 이 후에는 `ES6+` 라고 부르게 된다.

![캡처](https://user-images.githubusercontent.com/55525868/110787423-a3451280-82b0-11eb-9ba0-55e39cf1e523.PNG)

# async vs defer
*브라우저 코드는 한줄 한줄씩 읽어나간다.*

보통 <script>는 \<head>에 넣지 않고, <body>  **끝부분에 넣는다.**

```html
<head>
	<title>Javascript</title>
	<script src="main.js"></script>
</head>
```

**이 방법은 `main.js`의 크기가 엄청 크다면 로딩하는데 시간을 다보내기에 좋지않는 방법이다.**

```html
<body>
	<h1>Test</h1>
	<script src="main.js"></script>
</body>
```

**미리 페이지를 보여줄순 있지만 자바스크립트에 굉장히 의존적이라면 좋진 않을 것이다.**  
(역시 기다려야 한다.)

* 그래서 나온 것이 `async`와 `defer`이다.

## async

```html
<head>
	<title>Javascript</title>
	<script async  src="main.js"></script>
</head>
```

**HTML 코드를 읽다가 <script>를 만나면 **main.js를 다운받고 다 받아지면 그때서야 HTML 파싱을 한다.**

![캡처](https://user-images.githubusercontent.com/55525868/110795691-785fbc00-82ba-11eb-9cf3-fe52a7c6151d.PNG)

위 사진을 보면 역시 단점은 HTML 모두 파싱되기도 전에 `excuting js`가 실행되어 시간이 지연된다.

## defer

```html
<head>
	<title>Javascript</title>
	<script defer  src="main.js"></script>
</head>
```

**가장 큰 장점은 HTML 파싱을 진행하는 동안 **main.js를 다운받고 다 다운받아지면 HTML 파싱을 먼저 하고 그 다음에 js를 실행한다.**

![캡처](https://user-images.githubusercontent.com/55525868/110796076-e99f6f00-82ba-11eb-8a2c-e99a283c3492.PNG)

이러면 위 단점들을 극복할 수 있다.

## 'use strict';
자바스크립트를 작성할 때 제일 위에 `'use strict';`를 쓰는 것이 좋다.
왜냐하면 자바스크립트는 굉장히 유연한 언어이다. 이는 좋으면서도 위험하다.

규칙이 없기 때문에 코드가 중구난방할 수 있기 때문이다.
예를 들어, 

- 선언하지도 않았는데 변수를 사용할 수 있다든가.
- 다른 사람들이 코드를 참고하기가 매우 어려워진다.

# 자바스크립트 공식사이트
- [ecma-international.org](https://www.ecma-international.org/)
- 그외 [MDN](https://developer.mozilla.org/ko/) -> 영어로 보는 연습을 하자.
