# .on (events [, selector], [,data], handler) 반환 값 : jQuery

- `on` 메소드에는 파라미터마다 각 기능이 다릅니다.

<br>
<br>
<br>

## events (type: PlainObject)

- 필수값
- 하나 이상의 공백으로 구분된 이벤트 유형
- Example
	
```javascript
.on('keypress keyup blur') //각 이벤트들이 공백으로 구분되었습니다.
```

> focusout과 blur의 차이
> 둘 다 포커스를 잃었을 때 발생되는 이벤트입니다.
> 차이점은 바로 **버블링 여부**입니다.
> 버블링이란, 이벤트가 발생한 요소부터 window까지 이벤트를 전파하는 것을 말합니다.
> 본론으로 들어가서 focusout은 버블링이 일어나고, blur는 버블링이 일어나지 않습니다.

<br>
<br>
<br>

## selector (type: String)

- 선택사항
- 이벤트를 적용할 `tag`나 `id`, `class`, `name`을 선택합니다.
- 이 때도 selector를 여러 개를 지정할 수 있습니다.
- Example

```javascript
.on('focusout', '#btn, input[name=code]', ...)
```

<br>
<br>
<br>

## data (type: anything)

- 선택사항
- 이벤트가 발생할 때 `event.data`에서 Handler로 전달될 데이터입니다.
- 즉 이벤트 발생시 호출되는 함수에 정보를 추가로 전달할 수 있다는 뜻입니다.
- Example

```javascript
'use strict';

const color = 'blue';
$(document).on('click', '#btn', {param_color : color}, function(event) {
    alert(event.data.param_color);
});
```

- `click` : events
- `#btn` : selector
- `{param_color : color}` : data
- `function(event)` {} : handler

<br>
<br>
<br>

## handler (type: function)

- 이벤트가 트리거 될 때 실행할 함수입니다.

> 이벤트 트리거란,
> 방아쇠를 당기면 총알이 나가는 것처럼 어떠한 행위(클릭 등)을 했을 때 해당 이벤트에 대한 함수를 호출하는 것을 말합니다.

- Example

```javascript
.on('focusout', '#btn, input[name=code]', function() {
});
```

<br>
<br>
<br>

## References

- https://runebook.dev/ko/docs/jquery/on
- https://kcmschool.com/204
- https://www.codeit.kr/community/threads/3745
- http://blog.freezner.com/archives/1311
