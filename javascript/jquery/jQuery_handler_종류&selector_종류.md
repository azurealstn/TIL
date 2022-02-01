# jQuery 이벤트 메소드 종류

<table>
    <thead>
        <tr>
            <th>구분</th>
            <th>종류</th>
            <th>설명</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td rowspan=9>마우스 이벤트</td>
            <td>click()</td>
            <td>선택한 요소를 클릭했을 때 이벤트 발생</td>
        </tr>
        <tr>
        	<td>dblclick()</td>
            <td>선택한 요소를 연속해서 두 번 클릭했을 때 이벤트 발생</td>
        </tr>
        <tr>
            <td>contextmenu()</td>
            <td>마우스 오른쪽 버튼을 클릭했을 때 이벤트 발생</td>
        </tr>
        <tr>
            <td>hover()</td>
            <td>두 핸들러를 인자로 받아 마우스를 올렸을 때 첫 번째 핸들러, 마우스를 내렸을 때 두 번째 핸들러 이벤트 발생</td>
        </tr>
                <tr>
            <td>mousedown()</td>
            <td>마우스로 떼지 않고 클릭하는 그 순간 이벤트 발생</td>
        </tr>
        <tr>
            <td>mouseenter, mouseover</td>
            <td>마우스가 해당 요소에 올려져있을 때 (가리키고 있을 때) 이벤트 발생</td>
        </tr>
        <tr>
            <td>mouseleave, mouseout</td>
            <td>마우스가 해당 요소에 올려져있을 때 마우스를 떼면 이벤트 발생</td>
        </tr>
        <tr>
            <td>mousemove</td>
            <td>마우스가 해당 요소에 범위 내에서 움직이면 이벤트 발생</td>
        </tr>
        <tr>
            <td>mouseup</td>
            <td>마우스를 클릭하고 뗄 때 이벤트 발생</td>
        </tr>
    </tbody>
</table>

<br>
<br>
<br>

#### click()

```javascript
'use strict';

$('#event__btn').on("click", function() {
    alert('버튼을 클릭하였습니다.');
});
```

#### dblclick()

```javascript
$('#event__btn').on("dblclick", function() {
    alert('버튼을 두번 클릭하였습니다.');
});
```

#### contextmenu()

```javascript
$('#event__btn').on("contextmenu", function() {
    alert('버튼을 마우스 우클릭하였습니다.');
});
```

#### hover()

```javascript
$('#event__btn').hover( 
    function() {
        console.log('handler In');
    },
    function() {
        console.log('handler Out');
    }
);

$('#event__btn').mouseenter( 
    function() {
        console.log('handler In');
    }
).mouseleave(function() {
    console.log('handler Out');
});
```

- 주의할 점은 on("hover" ...) 이처럼 on 메소드는 동작하지 않습니다.
- 또 다른 방법으로는 `mouseenter`, `mouseleave`를 사용할 수도 있습니다.

#### mousedown()

```javascript
$('#event__btn').on('mousedown', function() {
    console.log('mousedown occur!');
});
```

#### mouseenter()

```javascript
$('#event__btn').on('mouseenter', function() {
    console.log('mouseEnter occur!');
});
```

#### mouseleave()

```javascript
$('#event__btn').on('mouseleave', function() {
    console.log('mouseLeave occur!');
});
```

#### mousemove()

```javascript
$('#event__btn').on('mousemove', function() {
    console.log('mouseMove occur!');
});
```

> mouseover와 mouseout 이 있습니다. 이 두 이벤트는  
> mouseenter와 mouseleave의 기능과 서로 동일합니다.  
> 하지만 차이점이 있습니다. 그것은 버블링 여부입니다.  
> mouseover와 mouseout은 버블링이 발생합니다.  
> 반면에 mouseenter와 mouseleave는 버블링이 발생하지 않습니다.  
> 즉, 버블링을 막고자 한다면 딱 그 요소에만 적용하고 싶다면 mouseenter와 mouseleave를 사용하면 됩니다.

#### mouseup()

```javascript
$('#event__btn').on('mouseup', function() {
    console.log('mouseUp occur!');
});
```

<br>
<br>
<br>

<table>
    <thead>
        <tr>
            <th>구분</th>
            <th>종류</th>
            <th>설명</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td rowspan=3>키보드 이벤트</td>
            <td>keydown()</td>
            <td>키보드를 눌렀을 때 이벤트 발생</td>
        </tr>
        <tr>
        	<td>keypress()</td>
            <td>키보드를 눌르고 글자가 입력되었을 때 이벤트 발생</td>
        </tr>
        <tr>
            <td>keyup()</td>
            <td>키보드에서 손을 뗐을 때 이벤트 발생</td>
        </tr>

    </tbody>
</table>

<br>
<br>
<br>

#### keydown()

```javascript
$('#input').on('keydown', function() {
    console.log('keydown 발생');
});
```

#### keypress()

```javascript
$('#input').on('keypress', function() {
    console.log('keypress 발생');
});
```

#### keyup()

```javascript
$('#input').on('keyup', function() {
    console.log('keyup 발생');
});
```

<br>
<br>
<br>

<table>
    <thead>
        <tr>
            <th>구분</th>
            <th>종류</th>
            <th>설명</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td rowspan=5>Form 이벤트</td>
            <td>focus(), focusin</td>
            <td>주로 input 태그에서 사용하며, focus 되었을 때 이벤트가 발생</td>
        </tr>
        <tr>
        	<td>blur(), focusout</td>
            <td>focus()와 완전히 반대되는 개념. focus 되었을 때 이 focus를 없애면 이벤트 발생</td>
        </tr>
        <tr>
            <td>change()</td>
            <td>요소에 값이 바뀔 때 이벤트 발생</td>
        </tr>
        <tr>
            <td>select()</td>
            <td>input 또는 textarea에서만 사용이 가능하며, 텍스트를 입력하고 드래그해서 텍스트를 선택했을 때 이벤트 발생</td>
        </tr>
        <tr>
            <td>submit()</td>
            <td>form 태그에서 submit을 동작시키면 이벤트 발생</td>
        </tr>

    </tbody>
</table>

<br>
<br>
<br>

#### focus()

```javascript
$('#input').on('focus', function() {
    console.log('focus 발생');
});
```

#### blur()

```javascript
$('#input').on('focus', function() {
    console.log('focus 발생');
});

$('#input').on('blur', function() {
    console.log('blur 발생');
});
```

> focus()와 blur()의 기능과 동일한 이벤트가  
> focusin()과 focusout() 입니다.  
> 그럼 이 둘의 차이점 역시 버블링 여부입니다.  
> focus()와 blur()는 버블링이 발생하지 않지만, focusin()과 focusout()은 버블링이 발생합니다.
> 즉, 부모 요소에도 이벤트를 발생시키고자 한다면 focusin()과 focusout()을 사용하시면 됩니다.

#### change()

```javascript
$('#select').on('change', function() {
    chageTest(this); //select에서 값이 바뀌면 input 태그에 출력해주는 함수 호출
});

function chageTest(e) {
    let value = $(':selected', e).val();
    $('#input').val(value);
}
```

#### select()

```javascript
$('#input').on('select', function() {
    console.log('select 발생');
});
```

#### submit()

```javascript
$('#form').on('submit', function(e) {
    e.preventDefault();
    console.log('submit 발생');
});
```
<br>
<br>
<br>

<table>
    <thead>
        <tr>
            <th>구분</th>
            <th>종류</th>
            <th>설명</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td rowspan=5>browser 이벤트</td>
            <td>resize()</td>
            <td>브라우저 크기를 늘리거나 줄일 때 이벤트 발생</td>
        </tr>
        <tr>
        	<td>scroll()</td>
            <td>브라우저 스크롤을 발생시키면 이벤트 발생</td>
        </tr>

    </tbody>
</table>

<br>
<br>
<br>

#### resize()

```javascript
$(window).on('resize', function() {
    let height = window.outerHeight;
    console.log(height);
});
```

#### scroll()

```javascript
$(window).on('scroll', function() {
    console.log('scroll 발생!');
});
```

<br>
<br>
<br>
<br>
<br>
<br>

# jQuery 이벤트 셀렉터 종류

[출처: https://hjzzin.tistory.com/120]
![캡처](https://user-images.githubusercontent.com/55525868/132468665-f10dec91-4ffd-4c1e-83d3-a5ee9eb46724.JPG)

- 블로그에 친절히 테이블로 정리를 해주셨네요 ㅎㅎ;
- 이 중에서 자주 사용하는 것과 중요한(?) 것들 위주로 알아보도록 하겠습니다. (사실 자주 사용하는 것이 중요한 것이겠죠 ㅋㅋ;)

<br>
<br>
<br>

#### #id

```javascript
$('#event__btn').on('click', function() {
    console.log('id로 접근!!');
});
```

#### .class

```javascript
$('.event__btn').on('click', function() {
    console.log('class로 접근!!');
});
```

#### element 태그

```javascript
$('button').on('click', function() {
    console.log('tag로 접근!!');
});
```

- 태그 이름으로 접근하는 것도 가능하죠!

#### selector multi - 여러개 선택

```javascript
$('#event__btn--sub, .event__btn').on('click', function() {
    console.log('multi로 접근!!');
});
```

#### 가짜 선택자 - :가짜 선택자 이런식으로 :를 붙입니다.

```javascript
$(':header').on('click', function() {
    console.log('Header 접근!!');
});

$(':button').on('click', function(e) {
    console.log('type이 button 또는 <button> 태그를 선택');
});

$('#event__btn').on('click', function(e) {
    console.log($(':selected').val());
});

$('input:nth-child(1)').on('click', function(e) {
    console.log('input 태그의 첫번째 요소 선택');
});
```

- 말고도 더 많습니다.

```javascript
$(':input'), $(':button'), $(':image'), $(':checkbox'), $(':radio'), $(':text') //각각 인풋, 버튼, 이미지, 체크박스, 라디오, 텍스트 인풋 태그를 선택합니다.

$(':odd'), $(':even'), $(':gt(순서)'), $(':lt(순서)'), $(':last') // 각각 홀수/짝수 번째 태그, 주어진 순서보다 순서가 큰 태그, 순서가 작은 태그, 선택된 것들 중 가장 마지막 태그를 선택합니다.

$(':focus'), $(':parent'), $(':empty');, $(':disabled'), $(':enabled'), $(':visible'), $(':hidden') //각각 포커스된 태그, 자식이 하나라도 있는 태그, 자식이 없는 태그, disabled된 태그, enabled된 태그, visible된 태그, hidden된 태그를 선택합니다.

$(':checked'), $(':selected'), $(':only-child');, $(':first-child'), $(':last-child') //각각 체크된 태그, 선택된 태그, 부모의 유일한 자식 태그, 첫번째 자식 태그, 마지막 자식 태그를 선택합니다.

$(':nth-child(순서)'), $(':nth-of-type(순서)'), $(':eq(순서)') //각각 순서번째 자식 태그, 해당 타입중 순서 번째 자식 태그, eq는 0부터 시작해서 순서번째 태그를 선택합니다.

$(':has(선택자)'), $(':contains(텍스트)') //각각 선택자를 가지고 있는 태그, 텍스트를 포함하고 있는 태그를 선택합니다.
```

#### type 속성

```javascript
$('#form :submit').on('click', function(e) {
    e.preventDefault();
    console.log('type 접근!!');
});

$('input[type=text]').on('click', function(e) {
    console.log('type 접근!!');
});
```

- type 접근하는 방법이 위 코드처럼 두 가지 방법이 됩니다.
- 일반적으로 쓰이는 경우는 후자겠네요.

#### name 속성

```javascript
$('button[name=event__btn]').on('click', function(e) {
    e.preventDefault();
    console.log('name 접근!!');
});
```

#### value 속성

```javascript
$('input[value=토르]').on('click', function(e) {
    console.log('value 접근!!');
});
```

#### data 속성

```javascript
$('input[data-test=test]').on('click', function(e) {
    console.log('data 접근!!');
});
```

- 그 밖에 속성 선택을 할 경우에는 $('element[속성=값]') 이런식으로 쓰면 됩니다.

#### 자손 선택자

```javascript
$('#form #input').on('click', function(e) {
    console.log('자손 접근!!');
});
```

#### 조건 선택자

```javascript
$('input[value!=토르]').on('click', function(e) {
    console.log('input value가 토르가 아닌 것 접근!!');
});

$('input[value^=토르]').on('click', function(e) {
    console.log('input value가 토르로 시작하는 것 접근!!');
});

$('input[value$=틴]').on('click', function(e) {
    console.log('input value가 틴으로 끝나는 것 접근!!');
});

$('input[value$=틴][value^=캡]').on('click', function(e) {
    console.log('input value가 틴으로 끝나고 캡으로 시작하는 것 접근!!');
}); //이런식으로 멀티로 조건을 달 수도 있습니다.
```

#### prev(), next() - 다음 요소 선택, 이전 요소 선택

```javascript
$('#event__btn').on('click', function() {
    $(this).next().css('color', 'red');
});

$('#event__btn--sub').on('click', function() {
    $(this).prev().css('color', 'blue');
});
```

<br>
<br>
<br>

## 결론

- jQuery 선택자가 너무 많아서 필요한 것만 구글에 검색해서 알아보자!

<br>
<br>
<br>

## References

- https://api.jquery.com/
- https://hjzzin.tistory.com/120
- https://www.zerocho.com/category/jQuery/post/57a9a371e4bc011500624ba3
