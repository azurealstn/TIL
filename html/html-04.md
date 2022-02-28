# HTML

아래 내용은 모두 [포이마웹](https://poiemaweb.com/)을 통해 정리하였습니다.

hyperlink에 대해 알아봅니다. (+ target)

HyperText에서 Hyper는 컴퓨터 용어로서 텍스트 등의 정보가 **다중으로 연결되어 있는 상태**를 의미합니다.

사실상 HTML에서 정말로 중요한 특징이 바로 `link`입니다. 단순히 고정성의 제약에서 벗어나 **사용자가 원하는 순서대로 정보를 취득**할 수 있는 기능을 제공합니다.

한 텍스트에서 다른 텍스트로 건너뛰어 읽을 수 있는 이 기능을 **하이퍼링크(hyper link)**라 합니다.

> a 태그의 href 속성이 있죠!

그렇다면 href 속성에 경로를 지정하는 것도 매우 중요합니다.

```plain/text
현재 디렉토리
- ./

부모 디렉토리
- ../

절대 경로 -> 현재 디렉토리와 관계없이 루트 디렉토리를 기준으로 파일의 위치를 나타냄
- https://www.naver.com
- C:\Projects\VSCode\algorithm
- /index.html

상대 경로 -> 현재 디렉토리를 기준으로 상대적인 위치를 나타냄
- ./index.html
- ../dist/index.js
- html/index.html
```

### target 속성

target 속성은 링크를 클릭했을 때 새 창으로 열지 현재 창에서 열지를 결정합니다.

- _self : 현재 창에서 열립니다. (디폴트)
- _blank : 새 창에서 열립니다.

```html
<a href="https://www.naver.com" target="_blank"></a> 새창
<a href="https://www.naver.com" target="_self"></a> 현재창
```

#### 💥 주의!

`target="_blank"`를 사용해서 이동한 새 창에서 자바스크립트 코드를 사용해 악의적인 페이지로 리다이렉트시킬 수도 있습니다.  
이를 Tabnabbing 피싱 공격이라고 합니다.

그래서 `rel="noopener noreferrer"`를 추가해서 이 공격을 막을 수 있습니다. (권장)

> 참고로 noopener 속성을 성능상 이점도 있습니다.