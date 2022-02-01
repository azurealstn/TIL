# 스프링 부트

## 스프링의 핵심

- IoC (Inversion of Control)
- DI (Dependency Injection)
- Spring Framework

#### IoC

- Inversion of Control (제어의 역전) 즉, 주도권을 스프링에 넘긴다는 뜻.
- Singleton으로 빈(객체)들을 관리하는 컨테이너

#### DI

- 인스턴스 생성시 IoC 컨테이너에서 singleton으로 관리하는 빈(객체)들을 변수에 주입하는 것.

#### Spring

- 스프링은 IoC 컨테이너를 통해 싱글톤으로 빈들을 관리해주고 필요에 따라 의존성 주입을 해주는 프레임워크이다.

### 필터 (Filter)

- 기본적으로 필터의 역할은 권한이 있는지 없는지 체크해준다.
- 스프링 컨테이너에는 필터(Filter)가 있는데 이 필터를 **인터셉터**라고 부른다. (AOP)

### MessageConverter

- MessageConverter는 스프링의 라이브러리로 default는 JSON이다.
- 중간 언어 역할을 수행해준다.
- 예를들어, 자바 오브젝트를 파이썬 오브젝트로 변환해주고 싶은데 이는 쉽지 않다. 하지만 JSON 형태로 변경해주고 그 JSON을 파이썬 오브젝트로 변환하는건 어렵지 않다. (자바 -> JSON -> 파이썬)
- 즉, MessageConverter는 JSON으로 변환해주는 역할을 해준다.

<br/>
<br/>
<br/>

## JPA

- Java Persistence API
- Persistence란 컴퓨터가 종료되도 RDB 또는 NoSQL DB 등에 데이터를 영구적으로 관리하는 것을 말한다.
- 즉, 자바로 데이터를 영구적으로 관리해주는 API란 것이다.

### ORM

- Object Relational Mapping
- 보통 DB를 다룰 때는 SQL을 많이 다룰 것이다. 하지만 자바는 객체지향 언어인데 주로 SQL만 조작한다는 것이 의문점이다.
- 그래서 객체를 데이터베이스에 매핑시키는 것이 ORM이다. SQL문으로 접근하는 것이 아닌 객체로 접근한다.
- DB는 객체로 저장할 수 없지만, JPA를 이용하면 객체로 저장이 가능하다.

### 영속성 컨텍스트

- 영속성: 데이터를 영구적으로 저장할 수 있는 방법 (ex. MySQL DB)
- 컨텍스트: 대상에 대한 모든 정보를 알고 있다는 뜻
- 즉, 영속성 컨텍스트란 데이터를 영구적으로 저장할 수 있는 모든 방법을 알고 있다.
- 자바 프로그래머는 DB에 있는 데이터들을 영속성 컨텍스트를 통해서 조회하거나 수정, 삭제 등을 조작한다.
- 만약 DB에 있는 데이터와 영속성에 있는 데이터가 서로 다를 경우, 영속성 컨텍스트는 `update`문을 수행하여 DB와 맞춰준다.

<br/>
<br/>
<br/>

## 아파치 vs 톰캣

#### 아파치

- 정적인 파일(html, css, js 등등)을 요청하게 되면 그에 대한 응답을 해준다.
- 만약 정적인 파일이 아닌 다른 파일(.jsp 등등)을 요청하게 되면 응답을 하지 못한다.

#### 톰캣

- 톰캣은 아파치가 하지 못한 일을 대신 수행해준다.
- .jsp 파일이 요청이 들어오게 되면 .jsp는 자바 코드로 되어있기 때문에 자바 코드를 컴파일하여 html 파일로 변환을 해준다. 그래서 변환된 html 파일은 아파치가 응답을 수행한다.

<br/>
<br/>
<br/>

## 서블릿 객체 생명주기

#### 서블릿

- 자바 코드로 웹을 구현할 수 있게 만든 것이 바로 서블릿이다.

#### 서블릿 컨테이너

- 자바 코드로 웹을 가능하게 한 것들을 모아놓은 것.
- 이것이 톰캣이다.

![캡처](https://user-images.githubusercontent.com/55525868/117819898-f7ff0c80-b2a4-11eb-803a-74ceed9c79bd.PNG)

#### 생명주기

- 요청이 들어오게 되면 스레드가 생성되고 서블릿 객체가 생성된다. (요청은 한 명이 하는 것이 아닌 여러 명이 하기 때문에 동시 처리를 위해 스레드를 생성한다.)
- 최종적으로 HttpServletRequest, HttpServletResponse 객체가 생성이 된다.

<br/>
<br/>
<br/>

## DispatcherServlet (디스패처 서블릿)

- FrontController + RequestDispatcher = DispatcherServlet
- 만약 `a.jsp`라는 파일이 요청이 들어왔다면 `a.html`로 응답을 해줄 것이다.
- `a.html`에서 또 다시 버튼을 눌러 이번엔 `b.jsp` 파일이 요청이 들어와 `b.html`로 응답을 해줄 것이다.
- 처음에 `a.jsp`로 요청할 때 그 데이터가 있을 것이다. 알다시피 HTTP 프로토콜은 `Stateless`한 특징을 가지기 때문에 `a.jsp`에서 `b.jsp`를 요청하게 되면 `a.jsp`에 있는 데이터들은 다 사라진다. 왜냐하면 request, response 과정을 딱 한번만 수행하고 끊기 때문이다.
- 그래서 이 데이터를 그대로 유지시키는 방법이 `RequestDispatcher`를 쓰면 해결이 된다.
- 즉, 데이터를 들고 페이지간 이동이 가능하게 한 기법이 `RequestDispatcher`이다.

#### DispatcherServlet 역할

- 첫 번째. 컴포넌트 스캔을 수행한다.
- 두 번째. 주소 분배 (요청이 들어올 때 어디로 이동할지 다 안내를 해준다.)

<br/>
<br/>
<br/>

## ApplicationContext

![캡처](https://user-images.githubusercontent.com/55525868/117828482-cc802000-b2ac-11eb-807b-c4685ede584d.PNG)

- 1. 서버가 켜지게 되면 `web.xml`이 로딩이되고, (톰캣 실행시)
- 2. 그 다음에 `ContextLoaderListener`가 로딩이 되고,
- 3. 그 때 `root-context.xml`이 실행이 된다. 서블릿은 요청이 들어오면 스레드를 생성한다고 했는데 이 때 공통적인 것들 즉, 모든 스레드들이 공유해서 사용해도 되는 것들을 `ContextLoaderListener` 메모리에 띄운다. 매번 스레드를 `new`하는 것을 방지하기 위해.
- 4. `root-context.xml`이 실행될 때 DB와 관련된 객체들이 ComponentScan으로 메모리에 올려 DB 관련된 것들이 실행이 된다.
- 5. 클라이언트로부터 요청이 들어온다. (서버가 준비된 상태)
- 6 ~ 8. `servlet-context.xml`에 의해 DispatcherServlet이 실행이 되고, DispatcherServlet이 컨트롤로 주소 분배를 해준다.
- 마지막으로는 리턴할 때 `Data`로 리턴할지 혹은 `html`로 리턴할지 결정을 하고 마무리한다.

#### ApplicationContext 정의

- `DispatcherServlet`이 ComponentScan할 때 수 많은 객체들이 `ApplicationContext`에 등록된다. 이것을 `IoC(Inversion of Control)`이라고 한다.
- 즉, 매번 new를 통해 객체를 생성하게 되면 관리하기 어렵기에 스프링이 직접 해당 객체를 관리를 한다.
- 이 때 주소는 몰라되는데, `DI(Dependency Injection)`으로 하면 된다.
- 이 `AppllicationContext`는 싱글톤으로 관리되기 때문에 어디에서 접근하든 동일한 객체라는 것을 보장해준다.

#### ApplicationContext 종류

- root-ApplicationContext
- servlet-ApplicationContext

![캡처](https://user-images.githubusercontent.com/55525868/117830677-d30f9700-b2ae-11eb-995f-9444e120f7f0.PNG)

## Reference

- https://www.youtube.com/watch?v=XBG6CUtVCIg&list=PL93mKxaRDidG_OIfRQ4nztPQ13y74lCYg
- https://getinthere.tistory.com/11
- https://asfirstalways.tistory.com/334
