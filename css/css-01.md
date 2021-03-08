# CSS란?
`CSS(Cascading Style Sheets)`는 웹페이지를 꾸미기 위해 작성하는 코디이다.
HTML처럼 프로그래밍 언어가 아니고 그렇다고 *마크업 언어*도 아니다. **Style Sheet 언어**이다.

- cascading : 작은 폭포, 흐르다, 연속화, 직렬 ...
- cascading이란 세부적인 정의되어 있는 것이 있다면 그것을 쓰고, 정의되어 있는 것이 없다면 다음 기본적으로 지정된 것으로 넘어가는 것을 말한다.

### Author Style
우리가 작성하는 css 파일

### User Style
사용자가 다크모드를 사용할 것인지 글자크기를 조정하고 싶은지 사용자의 취향에 맞게 스타일링

### Browser
브라우저에 기본적으로 지정된 스타일

- 위 3가지 중 우선순위는 Author Style > User Style > Browser 순으로 된다.
- 이런식으로 위에서부터 흐른다, 연속된다, 다음것으로 넘어가는 것을 `Cascading`이라고 한다.
- `!important`를 사용하면 이러한 흐름에 상관없이 그것을 강제적으로 사용하겠다는 의미이다. 왠만하면 !important는 사용하지 말자.

**HTML 문서에 있는 요소들을 선택적으로(Selector) 스타일을 적용할 수 있다.**

HTML 문서에 스타일을 넣어주려면 다음 코드를 추가시켜주어야 한다.

```html
<link href="style.css" rel="stylesheet">
```

- `href` : 경로를 나타낸다.
	- 현재 파일 : style.css
	- 현재 폴더 : ./style/style.css
	- 상위 폴더 : ../root/style.css

- `rel` : rel 속성은 현재 문서와 외부 리소스 사이의 연관 관계를 명시한다.

## Box

*Box를 보는 시야가 생기면 CSS 짜기가  수월해질 것이다.*

- 참고 : https://azurealstn.tistory.com/60

## references

- [Mozilla](https://developer.mozilla.org/ko/docs/Learn/Getting_started_with_the_web/CSS_basics)
- [TCP school](http://tcpschool.com/html-tag-attrs/link-rel)
