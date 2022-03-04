## 박스 모델

HTML 구조를 짤 때 여러분들은 어떻게 짜시나요?

HTML 마크업을 할 때 중요한 것은 바로 **박스 모델을 볼 수 있는 안경**을 장착하는 것입니다.

큰 하나의 웹 사이트를 박스로 잘게 잘게 잘라서 나누다 보면 어떤 식으로 마크업을 해야할지 감이 잡힙니다.

그래서 이 박스 모델을 볼 수 있는 안목(?)이 참 중요합니다.

![box-model.PNG](/images/html/box-model.PNG)

인프런 메인 사이트를 박스 모델로 잘게 나누어보았습니다.ㅎㅎ  
(제가 한 방법이 정답이 아닙니다.)

이렇게 잘게 나누는 것은 백엔드에도 적용이 됩니다.

가령 API 를 개발할 때 한 서비스로직 안에다가 모든 기능을 집어 넣으면 코드를 알아보기 참 어렵습니다.

그래서 한 클래스 안에 들어있는 모든 기능들이 있으면 어떻게 하면 더 세분화해서 다른 클래스를 만들 수 있는지

또는 한 함수 안에 많은 기능들이 있어서 어떻게 하면 하나의 함수 안에 한가지의 기능만 들어있게 할 수 있는지 고민하는 것이 개발자의 기본 마인드셋입니다.

> TIP. 또한 어떠한 것을 배우든 너무 한가지에 집착하지 말고 먼저 큰 그림을 볼 수 있도록 하자!

## BOX & ITEM

BOX는 눈에 보이지 않는 태그를 말합니다.  
(Ex. header, footer, nav, main, section, aside ...)

반면에 ITEM은 우리 눈에 보이는 태그들을 말합니다.  
(Ex. a, button, video, map, input ...)

![html-structure.PNG](/images/html/html-structure.PNG)

(출처: https://developer.mozilla.org/en-US/docs/Learn/HTML/Introduction_to_HTML/Structuring_a_page_of_content)

위 그림에서 `main` 태그안에 `section` 태그를 사용하고 또 `section` 태그 안에 `article` 태그를 사용합니다.

이 article 태그는 주로 반복적인 컨텐츠에서 사용합니다.

예를 들어, 페이스북에서 반복적인 박스모양의 컨텐츠가 있는데 이를 article로 하면 되겠죠. 