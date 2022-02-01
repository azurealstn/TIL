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

# doGet(), doPost

![캡처](https://user-images.githubusercontent.com/55525868/108073178-14771880-70ab-11eb-9b04-955a3664efed.PNG)

![캡처](https://user-images.githubusercontent.com/55525868/108073718-b39c1000-70ab-11eb-9c25-f0593d5f1261.PNG)

							[참고 - https://url.kr/tr23of]

form 태그에서 `method="get"`를 설정해주고 `submit` 버튼을 누르면 **User의 Data를 request 객체 묶어서 서버로 가는데** 이 때 `doGet()` 메소드가 받는다.
`doPost()` 역시 동일하다.

만약 `method=""`에 설정을 안해주면 default 값은 `get`이다.

## Get 방식, Post 방식

위 사진에서 URL을 보면 `?` 뒤에 데이터가 다 노출이 되어 있다. **이러한 노출된 상태로 서버로 보내는 것이 바로 `get` 방식이다.**
보다시피 이를 악용할 수도 있다면 보안에 대한 취약점이 드러난다. 또한 많은 데이터가 있다면 길이에 한계가 있어 문제가 있다.

반면에 `post` 방식은 **암호화되서 정보를 보내기 때문에 보안에 강하다.**
(ex. 로그인, 설문조사, 회원가입)

그럼에도 굳이 `doGet()` 메소드를 사용하는 이유는 `doPost()` 보다 빠르다는 점이다.
예를 들어, 사용자가 검색창에서 검색할 때는 정보가 노출되어도 상관없는 부분이니 `doGet()` 메소드를 사용하는 것이 적절할 것이다.

# form & 서버

![1](https://user-images.githubusercontent.com/55525868/108079343-10022e00-70b2-11eb-99e1-87bf3c391c0f.PNG)

먼저 위와 같은 form 양식을 `.html`로 만들어주고 `post` 방식으로 보내면

![2](https://user-images.githubusercontent.com/55525868/108079346-11335b00-70b2-11eb-9719-0fbc6b08ee02.PNG)

정상적으로 보내진걸 확인할 수 있다.
여기서 URL을 보면 알 수 있듯이 사용자 정보는 전혀 들어있지 않고 암호화되어 간결하게 변환되었다. (post 방식의 장점)

![3](https://user-images.githubusercontent.com/55525868/108079351-12648800-70b2-11eb-81c8-f3a265e37cbb.PNG)

마지막으로 로그를 확인하여 정보를 볼 수 있다. 

- `getParameter()`: input 태그의 속성 `name`의 속성값을 꺼낸다. (하나의 데이터)
- `getParameterValues()`: `hobby`같은 경우 `checkbox`이기 때문에 다중선택이 가능하다. 따라서 배열로 저장을 해야하는데 여러 개의 데이터를 받을 때 사용한다.
- `getParameterNames()`: 프론트쪽의 `name`의 속성값을 확인하고 싶을 때 사용한다.

```java
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println(" -- doGet() -- ");
		
		String m_name = request.getParameter("m_name");
		String m_pass = request.getParameter("m_pass");
		String m_gender = request.getParameter("m_gender");
		String[] m_hobbys = request.getParameterValues("m_hobby");
		String m_residence = request.getParameter("m_residence");
		
		Enumeration<String> names = request.getParameterNames();
		while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			System.out.println("name: " + name);
		}
	}
```
