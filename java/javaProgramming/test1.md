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

## import 키워드

만약 다른 패키지 안의 클래스를 사용하려고 하면 클래스 이름 앞에 패키지를 붙여야 합니다.  

```java
package com.azurealstn.sociallogin;

public class Parent {

    com.azurealstn.sociallogin.another.Child child = new com.azurealstn.sociallogin.another.Child();
}
```

`com.azurealstn.sociallogin.another.Child` 처럼 클래스가 속한 패키지명을 모두 포함한 이름을 `FQCN(Fully Qualified Class Name)`이라고 합니다.

<br>

위 코드처럼 다른 패키지에 있는 클래스를 사용하려고 매번 클래스 앞에 풀패키지명을 입력하면 가독성도 떨어지고 매우 번거로운 작업이 될 것입니다. 그래서 앞에 패키지명을 없애기 위해 `import`라는 키워드를 사용합니다.

```java
package com.azurealstn.sociallogin;

import com.azurealstn.sociallogin.another.Child; <--- import 사용

public class Parent {

    Child child = new Child();
}
```

`package` 키워드 아래에 `import` 키워드를 적고 `FQCN`을 적어주시면 됩니다. 그러면 다른 패키지의 클래스 객체를 생성할 때도 앞에 패키지를 적지 않아도 됩니다. 훨씬 간결해졌습니다.

<br>
<br>
<br>

## 클래스패스

클래스패스란 클래스를 찾기 위한 경로를 말합니다. 자바에서 클래스패스란 **JVM이 프로그램을 실행할 때, 클래스파일을 찾는데 기준이 되는 파일 경로를 말합니다.** 자바 런타임이 classpath에 지정된 경로를 모두 검색해서 `.class` 파일을 찾습니다.  

<br>

클래스패스를 지정할 수 있는 방법이 두 가지가 있습니다.

- 환경변수 CLASSPATH
- 자바 런타임에 `-classpath` 옵션 사용

<br>
<br>
<br>

## CLASSPATH 환경변수

환경변수는 프로세스가 컴퓨터에서 동작하는 방식에 영향을 미치는 동적인 값들을 말합니다. OS상에서 동작하는 응용프로그램들이 참조하기 위한 설정이 기록됩니다. 환경변수에는 두 가지가 있습니다.

- 사용자 변수 - OS내의 사용자별로 다르게 설정 가능한 환경변수
- 시스템 변수 - 시스템 전체에 모두 적용되는 환경변수

### Path

cmd 명령프롬프트 창에서 `ipconfig` 명령어를 사용할 수 있는 이유 `C:\Windows\System32` 경로가 `Path 환경변수`에 저장되어 있기 때문에 사용할 수 있는 것입니다. **따라서 자주쓰는 프로그램의 경로를 Path에 등록시켜두면 그 경로에 존재하는 프로그램을 어떠한 장소에서든 실행시킬 수 있도록 해주는 것입니다.**

<br>

자바에서는 자바 컴파일러나 클래스 파일 로더 등을 아무 위치에서나 사용하고 싶다면 Path에 이 프로그램들이 있는 경로를 지정해줘야 합니다.

<br>

### CLASSPATH

```
CLASSPATH=.;C:\Program Files\Java\jdk-10.0.1\lib\tools.jar
```

JVM이 시작될 때 JVM의 클래스 로더는 CLASSPATH 환경변수를 호출합니다. 환경변수에 설정되어 있는 디렉토리가 호출되면 그 디렉토리에 있는 클래스들을 먼저 JVM에 로드합니다. 따라서 CLASSPATH 환경변수에는 필수 클래스들이 위치한 디렉토리를 등록하도록 해야 합니다.

<br>
<br>
<br>

## -classpath 옵션

CLASSPATH 환경변수 말고도 java runtime에 `-classpath` 옵션을 사용할 수도 있습니다.

<br>

-classpath 옵션이란 컴파일러가 컴파일 하기 위해서 필요로 하는 참조할 클래스 파일들을 찾기 위해서 컴파일시 파일 경로를 지정해주는 옵션입니다.

<br>

`javaByteCodeDisplay.java` 파일이 `D:\notepad` 디렉토리에 있고 클래스 파일(.class) 또한 `D:\notepad` 디렉토리에 있다면

```java
javac -classpath D:\notepad D:\notepad\javaByteCodeDisplay.java
```

위 명령어를 실행해주면 됩니다.

<br>

만약 참조할 클래스 파일들이 그 외의 다른 디렉토리, 현 디렉토리에도 있다면

```java
javac -classpath.;D:\notepad\MinSu;D:\notepad\test D:\notepad\javaByteCodeDisplay.java
```

위 명령어와 같이 `;`로 디렉토리를 구분지을 수 있습니다.  
`-classpath` 대신에 `-cp`를 사용해도 됩니다.

<br>
<br>
<br>

## 접근지시자

객체지향 프로그래밍의 특징에서 **정보 은닉화, 캡슐화**에 대해서 이해하려면 **접근지시자**부터 알아야 합니다.  
접근지시자는 말 그대로 클래스나 필드나 메소드의 접근을 **제한**하기 위해서 사용합니다.  
클래스는 `private`과 `protected` 접근지시자는 적용되지 않습니다.

- private : 선언된 클래스 멤버는 외부에 절대 공개되지 않으며, 접근 또한 불가능합니다.
- public : 선언된 클래스 멤버는 외부로 공개되며, 어디서나 접근이 가능합니다.
- protected : 같은 패키지면 접근이 가능하고, 멤버를 선언한 클래스를 상속받은 자식 클래스의 멤버는 접근이 가능합니다. 여기서 추가로 다른 패키지에 속하는 자식 클래스까지 허용합니다.
- default : 위 3개 모두 해당되지 않으면 default를 사용하게 되는데, 자바에서 클래스 멤버 접근 제어의 기본값으로 `default`를 명시하고 있습니다. 즉, 접근 제어를 지정하지 않으면 자동적으로 default 접근 제어를 가지게 됩니다.

|접근제어자|같은 클래스의 멤버|같은 패키지의 멤버|자식 클래스의 멤버|그 외 영역|
|---|---|---|---|---|
|public|O|O|O|O|
|protected|O|O|O|X|
|default|O|O|X|X|
|private|O|X|X|X|

<br>

필드나 메소드를 `private` 접근지시자를 사용하여 외부에서 함부로 수정할 수 없도록 정보를 은닉화시킵니다.

<br>

값을 가져오고 싶으면 `getter`를 사용하면 되고, `setter` 사용도 왠만하면 피하는 것이 좋습니다. `setter`로 값을 함부로 변경했다가 로직이 돌아가지 않을 수도 있는 위험이 있습니다. 그래서 `setter`는 정말로 필요할 때만 사용하는 것이 좋습니다.

<br>
<br>
<br>

## References

- https://mozi.tistory.com/548
- https://mozi.tistory.com/549
- [https://effectivesquid.tistory.com](https://effectivesquid.tistory.com/entry/%EC%9E%90%EB%B0%94-%ED%81%B4%EB%9E%98%EC%8A%A4%ED%8C%A8%EC%8A%A4classpath%EB%9E%80)
- https://hyoje420.tistory.com/7
- https://kils-log-of-develop.tistory.com/430
