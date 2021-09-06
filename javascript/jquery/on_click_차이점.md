# on('click')과 click()의 차이점

- 우리가 click 이벤트를 발생시키기 위해서 다음 두 가지 메소드로 보통 실행을 시킵니다.
- `on('click')`, `click()`
- 하지만 이 두 메소드는 서로 차이점이 있습니다.

|on('click')|click()|
|---|---|
|동적으로 이벤트 바인딩을 할 수 있음|최초에 선언된 element에만 동작함|
|메모리 사용량 ⬇|메모리 사용량 ⬆|

<br/>

- **가장 중요한 차이점은 동적으로 이벤트를 바인딩할 수 있는지 없는지입니다.** 그 이유는 click() 이벤트는 최초에 페이지를 로딩할 때 선언되어 있던 element에 이벤트를 바인딩하고 나서는 더 이상 동적으로 바인딩하지 않기 때문입니다.
- click() 메소드를 많이 쓰면 메모리 사용량이 증가됩니다.
- **메모리 사용량이 적고 동적으로 이벤트를 바인딩할 수 있는 `on('click')`을 사용하는 것이 더 좋습니다.**

<br>

## on('click')과 click()의 예제

```html
<body>
    <h1>jQuery Study</h1>
    <div class="btnBox">
        <button type="button" id="btn1">버튼 1번</button>
    </div>
</body>
```

<br>
<br>


```javascript
'use strict';

$('#btn1').click(function() {
    $('.btnBox').append('<button type="button" id="btn2">버튼 2번</button>');
});

$('#btn2').click(function() {
    alert('동적 생성 클릭 이벤트');
});
```

- 버튼 1번을 click 했을 때 `btnBox` class 안에다가 `button` tag를 추가시켰습니다.
- 이렇게 정적 페이지인 `html`안에다가 tag를 추가하는 것이 아닌 `javascript`로 tag를 추가하는 것을 동적으로 추가한다고 말합니다.
- 만약 `click()` 메소드를 실행시킨다면 처음 click 이벤트는 발생하겠지만 동적으로 생성된 tag는 클릭 이벤트에 바인딩되지 않습니다. 따라서 위 코드는 동작하지 않습니다.
- 그래서 이렇게 동적으로 생성될 때는 `on()` 메소드를 사용하시면 됩니다.

```javascript
'use strict';

$('#btn1').click(function() {
    $('.btnBox').append('<button type="button" id="btn2">버튼 2번</button>');
});

$(document).on('click', '#btn2', function() {
    alert('동적 생성 클릭 이벤트');
});
```

- 그렇다면 아래 코드는 안되는 것인가?
- 안된다면 왜 안되는지 살펴봐야 합니다.

```javascript
'use strict';

$('#btn1').click(function() {
    $('.btnBox').append('<button type="button" id="btn2">버튼 2번</button>');
});

$('#btn2').on('click', function() {
    alert('동적 생성 클릭 이벤트');
});
```

<br/>
<br/>
<br/>

# $(document).on('click', '#id')과 $('#id').on('click')의 차이점

- 위 코드는 동작하지 않습니다.
- 이유는 간단합니다.
- 먼저 **버튼 1번 같은 경우는** `html` 문서 앞에서 태그로 선언해두었기 때문에 해당 요소를 읽고 click 이벤트가 정상 동작합니다.
- 하지만 **버튼 2번 같은 경우는** `javascript`로 동적으로 생성한 태그입니다.

```javascript
$('#btn2').on('click', function() {
    alert('동적 생성 클릭 이벤트');
});
```

- 이 예시는 이벤트 핸들러를 `html`에 있는 요소에 직접 바인딩합니다. 따라서 동적으로 생성된 데이터에는 바인딩되지 않습니다.

```javascript
$(document).on('click', '#btn2', function() {
    alert('동적 생성 클릭 이벤트');
});
```

- 다음으로 정상 동작하는 코드를 보겠습니다.
- 이 코드가 가능한 것은 **DOM Tree를 버블링하기 때문입니다.**
- 버블링이란 한 요소에 이벤트가 발생하면, 이 요소에 할당된 핸들러가 동작하고, 이이서 부모 요소의 핸들러가 동작합니다. 이렇게 가장 최상단의 조상 요소를 만들 때까지 과정이 반복됩니다.
- 만약 바로 **$('#btn2')**로 접근하게 된다면 버블링이 딱 그 해당하는 id까지만 버블링하기 때문에 **$(document)** 설정하는 것입니다.

<br>
<br>
<br>

# $(document).ready

- 먼저 html 문서가 client(사용자)로 렌더링되기까지 과정들이 있습니다.

![캡처](https://user-images.githubusercontent.com/55525868/132159469-747714bf-c45b-470c-856d-2ccf27d1c975.JPG)

<span style="color:#d3d3d3">(출처: https://docu94.tistory.com/37)</span>

- 즉, `$(document).ready`는 **DOM 트리 구성이 모두 끝나면 함수를 실행한다는 의미입니다.**
- 즉, DOM 트리 구성이 끝난다는 얘기는 document를 모두 읽었다는 의미입니다.
- 만약에 DOM 트리가 생성되기도 전에 javascript로 이벤트 바인딩 처리를 하려고 하면 해당하는 element를 찾지 못할 수도 있어서 이벤트 처리가 동작하지 않을 수 있습니다.
- 이러한 우려를 고려하여 **$(document).ready**를 사용합니다.

<br/>
<br/>
<br/>

## 예시

```html
<body>
    <script src="main.js"></script>
    <h1>jQuery Study</h1>
    <div class="btnBox">
        <button type="button" id="btn1">버튼 1번</button>
    </div>
</body>
```

- 만약에 script를 위와같이 element를 읽기도 전에 실행한다면 해당 요소를 찾지 못하니까 이벤트가 정상적으로 동작하지 않습니다.
- 하지만 **$(document).ready**를 사용한다면 정상 동작할 것입니다.

```javascript
'use strict';

$(document).ready(function() {
    $('#btn1').click(function() {
        $('.btnBox').append('<button type="button" id="btn2">버튼 2번</button>');
    });
    
    $(document).on('click', '#btn2', function() {
        alert('동적 생성 클릭 이벤트');
    });
});
```

- 이러면 정상 동작하네요~!

<br/>
<br/>
<br/>

## 결론

- **\.click()** 보다는 **\.on('click')**을 더 많이 사용할 것! (Vanilla Javascript 에서는 addEventListener를 사용.)
- **$(document).ready** 말고 다른 방법이 있다면 **defer** 사용하는 것도 하나의 방법인 것 같습니다. (defer은 Vanilla JS에서 사용.)

```html
<script src="main.js" defer></script>
```

- **\$(document).on('click', '#id')**과 **\$('#id').on('click')**의 차이는 document로 먼저 접근해서 해당 id를 적용시키느냐 아니면 해당하는 **id에만** 적용시키느냐 차이입니다. (예제를 직접 만들어보세요!!)

<br/>
<br/>
<br/>

## References

- http://webpaper.kr/show/89
- https://dev-jones.tistory.com/97
- https://myhappyman.tistory.com/123
- https://aueyoo.tistory.com/3
- https://stackoverflow.com/questions/14879168/document-onclick-id-function-vs-id-onclick-function
- https://ko.javascript.info/bubbling-and-capturing
