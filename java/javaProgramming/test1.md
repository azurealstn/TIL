# 7주차 과제: 패키지

## 목표

자바의 패키지에 대해 학습하세요.

<br>

## 학습할 것

- package 키워드
- import 키워드
- 클래스패스
- CLASSPATH 환경변수
- -classpath 옵션
- 접근지시자

<br>
<br>
<br>

## package 키워드

자바에서 패키지란 클래스들의 모음집입니다.  
패키지를 통해서 라이브러리끼리 구분이 가능합니다.

<br>

**패키지를 사용하는 이유는 간단합니다.**  
클래스명의 고유성을 보장하기 위해서 사용합니다.

<br>

간혹 같은 클래스명이 있을 수도 있습니다. 이를 방지하기 위해 패키지를 사용합니다. `intellij`에서는 애초에 같은 패키지 내의 같은 클래스를 선언이 불가능하며 같은 클래스를 사용할 경우에는 다른 패키지에서 생성해주면 됩니다.

```java
package com.azurealstn.sociallogin.another; <--- 패키지

public class SameClass {
}

package com.azurealstn.sociallogin; <--- 패키지

public class SameClass {
}
```

코드를 보시면 서로 다른 패키지를 사용하고 있어서 같은 클래스 정의가 가능한 것입니다.  
또한 라이브러리를 도입할 때 클래스 이름이 겹치는 것을 방지할 수도 있습니다.

<br>
<br>
<br>

## References

- https://mozi.tistory.com/548
