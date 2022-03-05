# CSS

CSS에 대한 기본적인 개념들을 익힙니다.

## display

inline, block, inline-block에 대해 알아봅니다.

- inline : span 태그의 기본값이 inline입니다.
    - inline은 태그 안에 컨텐츠가 꽉차게 보입니다.
    - inline은 한 줄에 쭉 나타납니다.
- block : div 태그의 기본값이 block입니다.
    - block은 컨텐츠의 내용에 상관없이 박스 모양으로 보입니다.
    - block은 한 줄에 하나씩만 나타납니다.
- inline-block : block처럼 안에 컨텐츠가 있어도 박스 모양으로 보이며, inline처럼 한 줄에 쭉 나타납니다.

![inline-block](/images/css/inline-block.PNG)

## position

css에서 정말 중요한 `position`에 대해 알아봅니다.

- static : 먼저 position의 기본값은 static입니다. 따라서 left, top를 변경시켜줘도 아무런 변화가 없습니다.
- relative : '상대적인' 이라는 뜻으로 현재 자기가 위치하고 있는 상태에서 left, top만큼 움직입니다. 즉, 자기 자신을 기준으로 상대적으로 움직입니다.
- absolute : relative는 자기 자신을 기준으로 한 반면에 absolute는 자신의 한 단계위인 부모 태그를 기준으로 움직입니다.

```html
<div class="container">
    <div class="box">
</div>
```

위와 같이 box 클래스를 움직이려고 할 때 `position: absolute`를 주게 되면 `.container`를 기준으로 left, top가 움직이게 되는 것이죠.
- fixed : fixed는 바로 `Window`를 기준으로 즉, 뷰포트를 기준으로 left, top 만큼 움직입니다.
- stick : sticky는 원래 있는 위치에 있으면서 스크롤을 하게 되면 자신의 위치가 고정되어 움직입니다.