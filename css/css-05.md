# CSS

CSS에 대한 기본적인 개념들을 익힙니다.

## Flexbox

Flexbox만 잘 알아도 웹사이트의 레이아웃을 쉽게 구성할 수 있습니다.

Flexbox를 잘 이해하기 위해 두 가지를 알아야 합니다.

1. Flexbox는 부모인 container 박스에 적용되는 속성값들이 존재하고 또한 container 박스의 자식인 item 박스에 적용되는 속성값들이 존재합니다.

- container 속성값: flex-direction, flex-wrap, justify-content ...
- item 속성값: flex-grow, flex-shrink, order ...

2. Flexbox는 중심축과 반대축이 있습니다.

![flexbox1](/images/css/flexbox1.png)

위 그림을 통해서 item 박스들의 위치에 따라 중심축과 반대축이 서로 바뀝니다.

## flex-grow, flex-shrink, flex-basis

- flex-grow: item들에 주는 속성값이며, 기본값은 0입니다.
    - flex-grow를 주면 고정된 item크기에 윈도우창이 늘어남에 따라 item도 같이 늘어납니다.
- flex-shrink: item들에 주는 속성값이며, 기본값은 0입니다.
    - flex-grow와 반대로 윈도우창이 줄어들 때 item도 같이 줄어듭니다.
- flex-basis: item들에 주는 속성값이며, 기본값은 auto입니다.
    - item들의 공간을 얼마나 차지할지 세부적으로 조절할 수 있습니다.
    - auto로 하게되면 `flex-grow`와 `flex-shrink`에 맞춰서 조절합니다.
    - 하지만 `flex-grow`와 `flex-shrink`를 사용하지 않는다면 auto가 아닌 `%` 단위로 공간 차지를 나눌 수 있습니다.

그리고 위 세 가지 속성을 한꺼번에 쓸 수 있도록 하는 `flex` 속성이 있습니다.

- `flex: 2 2 auto` : grow, shrink, basis 

## 공부하기 좋은 사이트

- https://css-tricks.com/snippets/css/a-guide-to-flexbox/
- https://flexboxfroggy.com/#ko