# 목표
자바의 애노테이션에 대해 학습하세요.

# 학습할 것 (필수)

- 애노테이션 정의하는 방법
- @retention
- @target
- @documented
- 애노테이션 프로세서
# 애노테이션 정의하는 방법
자바 개발을 하다 보면 클래스 또는 메소드 또는 변수 앞에 @Override에서 @ 표시를 봐왔을 것이다. 이는 애노테이션이라고 불리는데 이로 인해 데이터의 유효성 검사 등을 쉽게 알 수 있고, 관련된 코드들이 깔끔해진다.

이 애노테이션의 용도 다양하게 있겠지만 먼저 `메타 데이터`의 비중이 가장 크다고 할 수 있다.

> 메타 데이터(Meta-Data) : 데이터를 위한 데이터를 의미하며 즉, 한 데이터에 대한 설명을 의미한다. (자신의 정보를 담고 있는 데이터, 데이터의 데이터)

#### 그 밖에 용도
- 코드 문법 에러 체크
- 코드 자동 생성 정보 제공
- 런타임시 특정 기능을 실행하는 정보 제공

먼저 사용방식은 사용자가 직접 정의할 수 있는 `Custom Annotaion`과 Java에서 제공하는 `Built-in-Annotation`이 있다.

```java
커스텀 애노테이션 정의
public @interface AnnotationName { ... }
```

위의 코드 방식으로 애노테이션을 선언하지만 컴파일러가 해당 코드를 읽지 못한다.
**런타임 시에 클래스의 메타 정보(애노테이션)를 읽어들이는 기능인 리플렉션(@Reflection)을 추가 선언**을 해주어야 한다.
이 리플렉션 기능으로 런타임시 애노테이션 정보를 얻으려면 `애노테이션 유지정책`을 **RUNTIME**으로 설정해야 한다.

> 애노테이션 유지정책 : 애노테이션 유지 범위를 설정하는 방법을 말한다. 소스상에서만 또는 컴파일된 클래스 또는 런타임 시에도 유지를 할 것인지를 정해야 한다.

# @Retention
@Retention은 애노테이션의 life-time 을 말한다.

애노테이션 유지정책은 `java.lang.annotation.RetentionPolicy` 열거 상수 세가지로 구성되어 있다.

- SOURCE : 소스상에서만 애노테이션 유지
- CLASS : 바이트코드 파일까지 애노테이션 유지
- RUNTIME : 바이트코드 파일까지 애노테이션 정보를 유지하며 런타임시에 애노테이션 정보를 얻을 수 있다.

```java
@Retention 사용법
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationName { ... }
```

애노테이션은 메타 데이터를 저장하기 위해 클래스처럼 멤버를 가질 수 있다.
애노테이션 내에 선언된 메소드를 `애노테이션 요소`라고 한다.

그리고 이 요소의 개수에 따라 **Marker, Single-value, Full 애노테이션**으로 분류할 수 있다.

- **Marker: **요소가 없으면 단순히 표식으로 사용하는 애노테이션
- **Single-value: **요소가 한가지이면 값만을 명시하여 데이터 전달
- **Full: **요소가 둘 이상의 변수를 갖는다면 데이터를 배열안에 `key-value` 형태로 전달한다.

```
정의
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationName {
	String name1();
	int name2() default 5;
}

사용
@AnnotationName(name1 = "값", name2 = 2) //String, int
@AnnotationName(name1 = "값") //단일 선언도 가능
```

`name1()` 같은 경우는 **default** 값이 없기 때문에 반드시 값을 넣어주어야 하고 `name2()`는 생략 가능하다.

# @target
애노테이션은 적용대상도 지정할 수 있는데 이 때 `@target`을 사용한다.

```java
@Target( { ElementType.METHOD, ElementType.FIELD })
public @interface MyAnnotation {
	String value();
}
```

> 애노테이션 적용 대상은 `java.lang.annotation.ElementType`의 열거 상수로 정의되어 있다.
> 그리고 자바에서 제공하는 Built-in-Anootation은 @Override, @Deprecated, @SupressWarning, @FunctionalInterface가 있다.

[참고 - https://simostory.tistory.com/32]

# @documented
다음으로 `@documented` 이 애노테이션은 javadoc으로 api 문서를 만들 때 애노테이션에 대한 설명도 포함하도록 지정해주는 것이다. 즉, 문서에 애노테이션의 정보가 표현된다.

```java
@Documented
@Rentention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyAnnotation {...}
```

# 애노테이션 프로세서
애노테이션 프로세싱은 **컴파일 타임에 애노테이션을 분석**한다. 그리고 나서 붙여진 애노테이션에 따라 클래스를 만들어 낸다.

1. 애노테이션 클래스 생성
2. 애노테이션 Parser 클래스를 생성
3. 애노테이션 사용
4. 컴파일하면 애노테이션 Parser가 애노테이션을 처리
5. 자동 생성된 클래스가 빌드 폴더에 추가

`Annotation Parser classes`는 오직 프로젝트를 컴파일 할 때만 필요하다. 빌드가 끝나면 쓰이지 않는다.

`source-level annotaion processing`은 개발자가 컴파일 단계에서 원하는 작업을 할 수 있도록 해주는 기능이다.

`Annotation Processor`를 이용하면 컴파일 단계에서 소스를 조작할 수 있는데 이와 관련된 라이브러리에는 `Anonotation Processor`을 사용한다고 생각하면 된다.
