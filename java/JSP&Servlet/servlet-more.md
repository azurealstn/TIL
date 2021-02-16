# Servlet Mapping

![캡처](https://user-images.githubusercontent.com/55525868/108064093-88abbf00-709f-11eb-9cf1-106501b20345.PNG)

							[참고 - https://url.kr/tr23of]

브라우저가 요청(request)을 하면 요청이 들어온 수많은 서블릿들 중에 골라서 응답을 해준다.
이 서블릿들을 구분짓기 위해서는 먼저 `full path`를 이용한다.
하지만 **URL이 너무 길며, 보안이 취약하다**

그래서 `mapping path`를 이용한다. (훨씬 간결한 URL)

**mapping 하는 방법은 두 가지가 있다.**

- web.xml을 이용한 맵핑
- Annotation을 이용한 맵핑

```java
web.xml
  <servlet>
  	<servlet-name>servletEx</servlet-name>
  	<servlet-class>com.servlet.ServletEx</servlet-class>
  </servlet>
  <servlet-mapping>
  	<servlet-name>servletEx</servlet-name>
  	<url-pattern>/SE</url-pattern>
  </servlet-mapping>
  
						  -----------------------------
  
annotation
@WebServlet("/SE1")
public class ServletEx extends HttpServlet { ... }
```

> chrome 구동시 response.setContentType("text/html"); 추가

# Servlet request, response

![캡처](https://user-images.githubusercontent.com/55525868/108066238-6a938e00-70a2-11eb-883a-a1ffb021c8bc.PNG)

							[참고 - https://url.kr/tr23of]

`HttpServlet`라는 추상 클래스만 상속 받으면 사용이 가능하다.
필요한 메소드를 사용자가 재정의하여 사용한다.

> HttpServlet: public abstract class javax.servlet.http.HttpServlet extends javax.servlet.GenericServlet { ... }
> GenericServlet 추상 클래스는 Servlet이라는 인터페이스를 상속 받는다.

```java
Get 방식
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
```

요청과 응답할 때조차 객체 지향 프로그래밍으로 구현할 수 있도록 이를 객체화시켰다.
사용자 요청을 처리하는 `HttpServletRequest`객체와 사용자 요청에 대한 응답을 처리하는 `HttpServletResponse` 객체를 사용한다.

# Servlet Life-Cycle (서블릿 생명주기)

![캡처](https://user-images.githubusercontent.com/55525868/108069370-a4ff2a00-70a6-11eb-93a2-39d0b72b90d8.PNG)

							[참고 - https://url.kr/tr23of]

- `@PostConstruct`: 서블릿 준비 단계
- `init()`: 서블릿 생성 단계 (공통적인 업무에서 사용)
- `service`: 서블릿 서비스 단계 (service()보다는 보통 doGet() 또는 doPost() 메소드를 이용한다.)
- `destroy()`: 서블릿 종료 단계 (DB 자원 해제, 웹 서버 리소스 반납시 사용)
- `@PreDestroy()`: 서블릿 종료 준비 단계

```java
@WebServlet("/tsc")
public class TestServletClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//실행 (service는 보통 사용을 잘 안함)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println(" -- doGet() 메소드 -- ");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	@PostConstruct
	private void funPo() {
		System.out.println(" -- @PostConstruct -- ");
	}

	
	@Override
	public void init() throws ServletException {
		System.out.println(" -- init() 메소드 -- ");
	}
	
	@Override
	public void destroy() {
		System.out.println(" -- destroy() 메소드 -- ");
	}
	
	@PreDestroy
	private void funPd() {
		System.out.println(" -- @PreDestroy -- ");
	}
}
```

```
출력 결과:
 -- @PostConstruct -- 
 -- init() 메소드 -- 
 -- doGet() 메소드 -- 
[프로그램 종료시]
-- destroy() 메소드 --
-- @PreDestroy --
```

이러한 생명주기 메소드들은 바로 **웹 컨테이너가 이 메소들을 적절한 시점에 호출해준다.**
