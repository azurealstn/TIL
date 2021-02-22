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

- `dependencies`: 나의 프로젝트에 필요한 모듈들을 관리(의존성 관리라고 한다.)
- `build`: 나의 프로젝트가 빌드될 때 필요한 빌드 명령들이다.

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

# applicationContext.xml
스프링은 컨테이너 모든 객체를 모아놓는다고 했다. 스프링 컨테이너 즉, **IOC**라는 큰 그릇을 만들어 둔다.
그 큰 그릇안에다가 객체를 만들어놓고 필요할 때마다 가져다 사용하게 되는데, 이 때 스프링에서는 객체를 **빈(Bean)**이라고 했으며, **이 빈을 만들어주는 녀석이 바로 applicationContext.xml 파일**이다. 그 이 파일에 의해 객체가 생성이 되는 것이다. 메모리에 로딩이 되는것인데, 특별하게 관리되는 곳, 스프링 컨테이너에 로딩이 되는 것이다.


## applicationContext.xml 작성

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

	<bean id="tWalk" class="testPjt.TranspotatoinWalk" /> <!-- 이 bean 태그로인해 객체가 자동으로 생성이 된다. (new 연산자 없이 사용 가능) -->
</beans>
```

```java
컨테이너안에 생성된 객체를 메인 클래스에서 사용.
package testPjt;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
//		TranspotatoinWalk transpotatoinWalk = new TranspotatoinWalk();
//		transpotatoinWalk.move();
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath: applicationContext.xml"); //컨테이너
		TranspotatoinWalk transpotatoinWalk = ctx.getBean("tWalk", TranspotatoinWalk.class); //빈의 아이디와 클래스타입을 가져온다.
		transpotatoinWalk.move();
		ctx.close(); //외부 리소스 사용시 반드시 반환해주어야함.
	}
}
```

> 요즘은 **xml** 파일이 아닌 **annotation**을 많이 이용한다. (훨씬 간편)
> 모든 생성은 스프링 컨테이너가 담당하고 우리는 그것들을 가져다 쓰기만 하면 될 것이다.

## 실행 에러 발생

![캡처](https://user-images.githubusercontent.com/55525868/108708421-c784bd80-7554-11eb-83f7-b859113d3df9.PNG)

역시 쉽게 실행될리가 없지... 보아하니 뭔가 **class path resource**쪽 즉, 클래스 패스 경로가 좀 잘못된것 같다.. 그전에 버전을 바꿔보기도 하고 xml 파일을 다르게 수정해보기도 해봤지만 안됐다..

```java
메인클래스에서 클래스패스 설정할때 한칸 공백을 두면 에러가 난다.
"classpath: applicationContext.xml" -> "classpath:applicationContext.xml"
```
