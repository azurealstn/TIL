# 스프링 프로젝트

![캡처](https://user-images.githubusercontent.com/55525868/108700126-8044ff80-7549-11eb-9e16-e5e9bb9b3bb7.PNG)

`Maven` 프로젝트를 생성할 때 나오는 화면이다.

- `Group Id`: 전체 큰 프로젝트의 이름.
- `Artifact Id`: 현재 사용하고 있는 프로젝트 이름

스프링은 모듈로 이루어져있다. 이 모듈 하나하나는 `Artifact Id`라고 할 수 있고,
스프링 버전 `spring 2.0`, `spring 3.0`, `spring 4.0` ... 이러한 프로젝트들 감싸고 있는 큰 프로젝트를 `Group Id`라고 한다.

# pom.xml
스프링을 사용하기 위해서는 각 기능들인 모듈들을 사용할 것이다. (MVC, AOP 등..)
이러한 모듈들을 사용하기 위해 `pom.xml` 파일을 작성해야 한다.

```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>spring4</groupId>
  <artifactId>testPjt</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  
  <dependencies>
  	<dependency>
  		<groupId>org.springframework</groupId>
  		<artifactId>spring-context</artifactId>
  		<version>4.1.0.RELEASE</version>
  	</dependency>
  </dependencies>
  
  <build>
  	<plugins>
  		<plugin>
  			<artifactId>maven-compiler-plugin</artifactId>
  			<version>3.1</version>
  			<configuration>
  				<source>11</source>
  				<target>11</target>
  				<encoding>utf-8</encoding>
  			</configuration>
  		</plugin>
  	</plugins>
  </build>
</project>
```

다음과 같이 작성하고 저장을 누르면 아래와 같은 에러 내용이 뜬다.

![캡처](https://user-images.githubusercontent.com/55525868/108701741-aff50700-754b-11eb-8335-3335a4da3442.PNG)

현재 프로젝트의 자바 버전과 메이븐의 버전이 맞지 않아서 생기는 에러이다.
이 때는 메이븐의 버전을 **update해주면 된다**.

## pom.xml 파일의 이해

![캡처](https://user-images.githubusercontent.com/55525868/108702820-1e869480-754d-11eb-9914-d377dc204ac7.PNG)

[참고 - https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%ED%94%84%EB%A0%88%EC%9E%84%EC%9B%8C%ED%81%AC_renew#]

- `pom.xml` 파일의 역할은 외부의 저장소에 있는 라이브러리를 나의 프로젝트에 적용할 수 있도록 다운로드해주는 파일이다.
- 이 모듈들은 `Maven Dependencies` 폴더 안에 들어있다.

스프링의 단점이 장점은 스프링은 많은 사람들이 이러한 많은 설정이 있어 약간의 혼란을 느낄 수 있다. 하지만 한번만 제대로 설정을 해놓으면 그 다음부터는 그냥 가져다 쓰면 되기 때문에 훨씬 편하게 개발에 집중할 수 있다.

# 스프링 프로젝트 구조

![캡처](https://user-images.githubusercontent.com/55525868/108702375-84bee780-754c-11eb-826e-d16e80d25459.PNG)

여기서 중요한 파일은 `src/main/java`, `src/main/resources` 이 두 파일이 가장 많이 보고 또 중요하다.

- `java forder`: 자바의 폴더의 경우 우리가 실제로 프로그래밍을 하기 위해 필요한 자바 파일들이 관리들이 폴더이다.
- `resource forder`: 리소스 폴더의 경우 자원을 관리하는 폴더로 **스프링 설정 파일(XML), 프로퍼티 파일 등**이 관리된다. (사실상 스프링에서 가장 중요하다.)

이것이 스프링 프로젝트의 기본 구조이다.

