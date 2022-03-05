# CSS

CSS에 대한 기본적인 개념들을 익힙니다.

## 셀렉터 우선순위

```css
* {
    color: red;
}

li {
    color: blue;
}
```

위와같이 폰트색을 전체적으로 `*` 셀렉터를 이용해서 red로 설정했다가 `li` 태그에는 blue로 색을 변경했을 때 좀 더 구체적인 셀렉터를 설정하면 구체화된 것에 먼저 우선 순위를 갖습니다.

## padding VS margin

- padding : 컨텐츠 안에 들어가는 spacing
- margin : 컨텐츠 밖에 들어가는 spacing

![box-model1](/images/css/box-model1.png)

padding이나 margin top과 right에만 spacing을 주고 싶으면 일반적으로 `padding-top`, `margin-top`.. 이런식으로 적지만 한 줄에 한꺼번에 적을 수도 있다.

- padding: 5px 10px 15px 20px;
- margin: 5px 10px 15px 20px;

padding과 margin 모두 12시부터 시계방향으로 적으면 됩니다.

- 5px: top
- 10px: right
- 15px: bottom
- 20px: left

```css
margin: 0 auto
```

위의 css 코드는 `top`, `bottom`을 0으로 주고 `left`, `right`를 auto로 주겠다는 뜻입니다.

auto는 left, right 사이에 공백을 균등하게 배분해주겠다는 뜻입니다. 그래서 되게 많이 쓰입니다.

## CSS 셀렉터 게임하기

- https://flukeout.github.io/