# HTML

아래 내용은 모두 [포이마웹](https://poiemaweb.com/)을 통해 정리하였습니다.

form 태그에 대해 알아보자.

## Form

form 태그는 사용자가 입력한 데이터를 수집하기 위해 사용된다.

form 태그에서 정말로 중요한 속성 2가지는 꼭 외우자.

- action : form data가 전달될 URL 지정
- method : form data 전달 방식 지정
    - get, post

### GET VS POST

GET과 POST는 HTTP 프로토콜을 이용해서 사용자 Form data를 서버에 전달하는 방식이며, HTTP request method라 한다.

GET

- GET 방식은 전송 URL에 입력 데이터를 쿼리스트링으로 보내는 방식
- URL에 데이터가 노출되기 때문에 보안에 문제가 있으며 전송할 수 있는 데이터의 길이 제한이 있다. (최대 255자)
- GET 요청 데이터는 캐시된다.

POST

- POST 방식은 HTTP Request Body에 데이터를 담아서 보내기 때문에 길이 제한이 없다.
- GET 방식과는 달리 Body에 담아서 보내기 때문에 보안에 더 좋지만 속도는 GET 방식보다 느리다.

### button 태그 VS input button

`<input type="button">`은 input 태그이므로 빈 태그이다.  
하지만 `<button type="button"></button>`은 빈 태그가 아니기 때문에 텍스트나 이미지 같은 콘텐츠를 사용할 수 있다는 장점이 있다.

type 어트리뷰트는 반드시 지정해주는 것이 좋다.