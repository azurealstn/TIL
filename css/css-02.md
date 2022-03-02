# CSS

아래 내용은 모두 [포이마웹](https://poiemaweb.com/)을 통해 정리하였습니다.

CSS에 대해 알아보자.

## CSS

CSS(Cascading Style Sheets)는 HTML의 각 요소의 style을 정의하여 화면 등에 어떻게 렌더링하면 되는지 브라우저에게 설명하기 위한 언어이다.

> HTML5에서는 HTML은 정보와 구조화, CSS는 styling 정의라는 본연의 임무에 충실한 명확한 구분이 가능해졌다.

## 셀렉터 (Selector, 선택자)

스타일을 적용하고자 하는 HTML 요소를 선택할 수 있다.

### Rule Set

```css
h1 {
    color: blue;
    font-size: 10px;
}
```

위와 같은 구문을 `RuleSet`이라 하며 셀렉터에 의해 선택된 특정 HTML 요소를 어떻게 렌더링할 것인지 브라우저에 지시하는 역할을 한다.

위 구문에서 모든 h1 태그는 스타일을 적용하여 렌더링된다.

이와 같이 Rule Set의 집합을 스타일시트(Style Sheet)라 한다.

### id VS class

- #id : id 어트리뷰트 값은 중복될 수 없는 유일한 값이다.
- .class : class 어트리뷰트 값은 중복될 수 있다.
    - 또한 공백으로 구분하여 여러 개를 지정할 수 있어서 이미 정의되어 있는 클래스를 가져다가 공백으로 여러 개를 사용할 수 있다.
    - 이는 곧 재사용의 측면에서 유용하다.

    