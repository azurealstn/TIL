# 리다이렉트(Redirect)

![캡처](https://user-images.githubusercontent.com/55525868/109152477-e7172280-77ae-11eb-9260-7449fe5f6aff.PNG)

우리가 어떤 조건에 맞지 않아서 **특정 페이지로 이동시키고** 싶다면 `redirect`를 사용하면 된다. 말 그대로 리.다이렉트이다.

```java
사용법
if (member == null) { //로그아웃된 상태
	return "redirect:/main"; //redirect 키워드를 이용.
}
else { ... }
```

# 인터셉터(Interceptor)

만약에 회원 전용으로 수많은 서비스를 제공한다고 하자. 이 때 회원이 아니면 redirect를 써서 페이지 이동을 해주면 된다.
하지만 **서비스가 정말 많다던 100개 이상 이러면 매번 조건에 redirect를 써야할 것이다.
이런 번거로운 일을 해결하는 것이 인터셉터**이다.

![캡처](https://user-images.githubusercontent.com/55525868/109153961-f7c89800-77b0-11eb-98ed-3b96f8228417.PNG)

- DispatcherServlet에서 HandlerMapping, HandlerAdapter, Controller 이런식으로 진행되었는데 이 사이에 `HandlerInterceptor`라는 인터페이스를 중간에 둔다.

- `preHandle()` : 컨트롤러가 작업하기 전 단계
- `postHandle()` : 컨트롤러가 작업한 후 단계
- `afterCompletion()` : 컨트롤러와 뷰 모두 작업한 후 단계
- 가장 많이 쓰이는 것은 `preHandle()` 기능이다.
- 스프링에서 제공하는 `HandlerInterceptorAdapter` 클래스를 상속받아 사용한다.

> "그냥 중복해서라도 Redirect를 쓰면 되지 새로운 기능인 인터셉터를 써야하나" 할 수 있겠지만 우리가 개발자인 이상 중복은 최소한으로 줄이는 것이 좋다. 만약 redirect를 천개이러면 정말 보기 안좋을 것이다. 다만 redirect가 많지 않다면 redirect로 하는 것도 좋은 방법일 것이다.

# DataSource

JDBC의 단점은 매번 드라이버에 로딩하고 DB 연결하고 쿼리문을 작성하고 자원을 해제한다.
이렇게 되면 중복이 증가될 수 밖에 없다.

그래서 이를 대신해주는 **JdbcTemplate**이 있다. 이 모든 것을 대신해주는 템플릿이다.
즉, 개발자는 쿼리문만 작성해주면 된다.

![캡처](https://user-images.githubusercontent.com/55525868/109156118-d0bf9580-77b3-11eb-968d-2a9215fb579b.PNG)

이 템플릿을 사용하기 위해 **DataSource 클래스**를 이용한다.
이 DataSource는 DB에 연결하기 위한 정보들이 담겨있다.

![캡처](https://user-images.githubusercontent.com/55525868/109156284-ff3d7080-77b3-11eb-8596-3468dc514daf.PNG)

- 먼저 `oracle jdbc repository`부터 추가해주어야 한다. (오라클과 메이븐 호환성(?) 문제 때문인 것 같다.)
- `pom.xml` 파일에 `spring-jdbc`, `ojdbc8` 의존성을 추가해주어야 한다.(ojdbc: 오라클)
