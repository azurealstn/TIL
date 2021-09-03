# $("").on('click')과 $("").click()의 차이점

- click 이벤트를 발생시키는 방법은 여러 가지가 있습니다. 그 중에 **click()**에 대해 알아보겠습니다.

<br>

## click()

- 단순히 정적 페이지에 로드된 요소에 click 이벤트를 처리하고자 할 때 `click()` 메소드를 자주 사용합니다.
- `click()` 메소드는 동적처리가 불가능합니다. 즉, 최초에 선언된 element에만 동작합니다.
- 아래는 예제 소스입니다.

```html
<body>
    <h1>jQuery Study</h1>
    <ul id="myTask">
        <li>Coding</li>
        <li>Answering</li>
        <li>Getting Paid</li>
    </ul>
</body>
```

<br>
<br>


```javascript
'use strict';

$('#myTask').children().click(function() {
    $(this).remove();
});
```

- 위 코드는 클릭한 li 태그에 바이딩된 click 이벤트가 실행되어 해당 li 태그가 remove() 됩니다.

# $(document).on과 $(document).ready

- $(document).on과 $(document).ready의 차이점과 각각 어떻게 동작하는지 알아보겠습니다.

<br>
<br>
<br>

## $(document).on

- 보통 jQuery로 클릭 이벤트를 발생시키려면 아래와 같은 코드로 작성했습니다.

```javascript
'use strict';

$('#input-btn').on('click', function() {
    alert('동작 확인');
});
```

- 이렇게 element로 접근해서 이벤트를 발생시킵니다.
- 하지만 이러면 문제가 발생할 수 있습니다. element가 나중에 생긴 경우에는 click 이벤트가 발생하지 않습니다.
- 그래서 이에 대한 대안으로 나온 것이 `document 객체`로 접근하는 것입니다.

```javascript
'use strict';

$(document).on('click', function() {
    alert('document 접근');
});
```

- 이 예시는 **이벤트 위임**입니다. 이벤트 핸들러는 DOM 트리의 상위 요소에 바인딩됩니다. (상위 요소: document)

<br>
<br>
<br>

## References


'use strict';

$('#myTask').children().click(function() {
    $('#myTask').append('<li> New li tag </li>');
    $(this).remove();
});

//각각 차이점
// $(document).ready(function() {} 안에 있을 때와 없을 때 차이점
// 위 두 가지 정리할 것!
// $(document).on('click','#listBtn', function() {
	
// });

// $('#listBtn').on('click', function() {
    
// });

// $('#listBtn2').click(function() {
    
// });
