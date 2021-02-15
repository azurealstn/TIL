# 목표
자바의 패키지에 대해 학습하세요.

# 학습할 것 (필수)

- package 키워드
- import 키워드
- 클래스패스
- CLASSPATH 환경변수
- -classpath 옵션
- 접근지시자

# package 키워드
자바에서 패키지란 클래스와 인터페이스의 집합을 의미한다.
서로 관련 있는 클래스나 인터페이스끼리 묶어서 파일을 효율적으로 관리한다.

또한 협업하는 과정에서 각자 코딩을 할텐데 이 때 나중에 합칠 때 겹치면 충돌이 발생하니까 패키지를 이용하면 이를 방지할 수 있다.

다음 예제는 자바에서 가장 많이 사용되는 패키지중 하나 `String 클래스`의 패키지 이름이다.

```java
java.lang.String //java.lang 패키지에 속한 String 클래스
```

## 패키지 선언
```java
package 패키지이름; //맨 상단에
```

자바의 모든 클래스는 기본적으로 패키지 하나 이상은 있는데 만약 패키지가 포함되어 있지 않으면, 이를 **이름 없는 패키지(unnamed package)**에 포함해 컴파일한다.

# import 키워드

## import 선언
```java
1. import 패키지이름.클래스이름; //특정 클래스만 사용
2. import 패키지이름.* //모든 클래스 사용
```

## import 특징
다음은 문법상 에러가 난다.

```java
import java.util.* (O)
import java.*(X)
```

- import 문을 선언할 때 별표(\*)를 사용하는 것이 다른 모든 하위 패키지의 클래스까지 포함시켜주는 것이 아니다. (예제 참고.)
- **java.lang 패키지**에 대해서는 import 문을 사용하지 않아도 클래스 이름만으로도 사용가능하다. (아주 많이 사용되기 때문에.)

# 클래스패스
클래스패스란 말 그대로 클래스를 찾기 위한 경로이다.
JVM이 프로그램을 실행할 때 클래스 파일을 찾는데 기준이 되는 파일 경로를 말한다.

소스 코드(.java)를 컴파일하면 바이트코드(.class)가 생성되는데, 이 바이트코드를 가지고 JVM이 실행하려면 먼저 `.class`인 파일을 찾아야 한다.
즉, `.class` 파일을 찾을 때 `classpath`에 지정된 경로를 사용한다는 것이다.

클래스패스는 `.class` 파일이 포함된 디렉토리와 파일을 콜론(:)으로 구분한 목록이다.

이 클래스패스를 지정할 수 있는 두 가지 방법이 있다.

- 환변 변수 CLASSPATH를 사용하는 방법
- -classpath 플래그를 사용하는 방법

# CLASSPATH 환경변수
`/example/home/user`이 현재 작업 경로라고 가정하자.
그러면 이 파일에 `/example/home/user/test.java`, test라는 java파일을 하나 생성해주고, 컴파일하면 `test.class`라는 파일이 `/example/home/user` 이 경로에 생성될 것이다. 이 때 **CLASSPATH**는 다음과 같이 지정해주어야 한다.

> CLASSPATH=/example/home/user

그리고 만약 `/example/home/user/another` 이라는 폴더 안에 `.class`파일이 더 있다면 다음과 같이 지정한다.

> CLASSPATH=/example/home/user:/example/home/user/another [콜론(:)으로 구분.]

[참고 - https://url.kr/h3j7al]

# -classpath 옵션
javac의 경우 컴파일하려는 클래스와 관련된 클래스 혹은 jar 파일의 경로를 설정해줘야 제대로 된 컴파일이 수행된다.
그렇지 않으면 에러가 난다.

## 옵션
1. -classpath:

컴파일 하기 위한 클래스 파일들을 찾아 컴파일 시 파일 경로를 지정해주는 옵션.

- java –classpath %JAVAPATH%\bin;. HelloWorld

2. -d:

생성한 클래스의 위치를 설정하는 옵션.

# 접근지시자
객체 지향에서 **정보 은닉**이라는 말이 있다. 왜 정보를 숨겨야하는가?
그것을 외부로부터 마음대로 조작할 수 없게 만들기 위해 우리는 접근을 제한하여야 한다.

- private: 선언된 클래스 멤버는 외부에 절대 공개되지 않으며, 접근 또한 불가능하다.
- public: 선언된 클래스 멤버는 외부로 공개되며, 어디서나 접근이 가능하다.
- protected: 같은 패키지, 이 멤버를 선언한 클래스를 상속받은 자식 클래스의 멤버는 접근이 가능하다. 여기서 다른 패키지에 속하는 자식 클래스까지 허용한다.
- default: 위 3개 모두 해당되지 않으면 default를 사용하게 되는데, 자바에서 클래스 및 클래스 멤버 접근 제어의 기본값으로 `default`를 명시하고 있다. 즉, 접근 제어를 지정하지 않으면 자동적으로 default 접근 제어를 가지게 된다.

|접근 제어자|같은 클래스의 멤버|같은 패키지의 멤버|자식 클래스의 멤버|그 외 영역|
|-|-|-|-|-|
|public|O|O|O|O|
|protected|O|O|O|X|
|default|O|O|X|X|
|private|O|X|X|X|

[참고 - http://www.tcpschool.com/java/java_modifier_accessModifier]
