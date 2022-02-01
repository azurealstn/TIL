# Service & Dao 객체

![캡처](https://user-images.githubusercontent.com/55525868/108999520-c2a34380-76e5-11eb-9ae4-fb4ce7425255.PNG)

먼저 위 사진은 스프링에서의 전체적인 웹 구조를 나타낸다.

![캡처](https://user-images.githubusercontent.com/55525868/109002927-30516e80-76ea-11eb-9286-b7d75b6b9abb.PNG)

- new 연산자를 이용해 service 객체를 참조한다.

```java
MemberService service = new MemberService(0;)
```

- 스프링 설정파일(servlet-context.xml)을 이용하여 service 객체를 생성하여 의존 객체를 자동 주입한다.

```java
<beans: bean id="service" class="com.test.member.service.MemberService"></beans:bean>

//이런식으로 xml 파일 작성하고 어노테이션으로 간단하게 사용할 수 있다.
@Autowired
MemberService memberService;
```

- 이번엔 가장 간단하면서도 강력한 방법이다.
- service 객체에다가 `@Service` 라는 애노테이션만 붙여주면 따로 xml 파일 작성을 안해줘도 된다. @Service만 써주면 자동으로 스프링 컨테이너에 담겨진다. 그러므로 바로 @Autowired를 사용할 수 있는 것이다.
- 또한 @Service 대신 `@Component` 또는 `@Repository` 애노테이션을 써도 무방하다.
- 하지만 이름답게 Service 객체에는 @Service 애노테이션을 쓰면 좋겠다.
- DAO 객체를 사용할 때 역시 `@Component` 또는 `@Repository` 애노테이션을 써주면 다른 객체에서 `@Autowired`로 사용하여 자동으로 주입이 된다.

```java
@Service
public MemberService {...}

//@Service을 사용 후에 바로 @Autowired로 자동주입
@Autowired
MemberService memberService;
```

---

- 첫번째 방법은 순수 자바 개발
- 두번째 방법은 스프링 설정 파일을 이용한 개발
- 세번째 방법은 애노테이션을 이용한 개발

---

DAO 객체 구현할 때 역시 Service 객체를 구현할 때와 동일하다.
@Service 대신에 `@Component` 또는 `@Repository` 애노테이션을 써주면 된다는 점.

# Controller 객체

- `@RequestMapping을 이용한 URL 매핑

![캡처](https://user-images.githubusercontent.com/55525868/109009008-5595ab00-76f1-11eb-9b8f-8f51503d34eb.PNG)

```java
//사용법
@RequestMapping("/member", method=RequestMethod.GET)
public class MemberController {...}
```

- 각 기능에 따라서 Controller 클래스를 생성한다.
- Controller 클래스 내부에는 세부적인 기능들인 메소드들이 있다.
- `<form>` 태그에서 `method="post"`이면 `method=RequestMethod.POST`를 찾아가고, `method="get"`이면 `method=RequestMethod.GET`을 찾아간다.

## 요청 파라미터

![캡처](https://user-images.githubusercontent.com/55525868/109009454-e9677700-76f1-11eb-819d-6a4e55360577.PNG)

`HttpServletRequest` 객체를 이용하여 사용자의 정보, ID, PW 등의 정보를 얻을 때 사용한다.

```java
public String memLogin(Model model, HttpServletRequest request) {
	String memId = request.getParameter("memId");
	String memPw = request.getParameter("memPw");
	//위와 같이 사용자의 ID, PW 파라미터를 얻을 수 있다.
	
//애노테이션을 이용한 방법도 있다.
public String memLogin(Model model, @RequestParam("memId") String memId, @RequestParam("memPw") String memPw) {...}

//이렇게 사용하면
//String memId = request.getParameter("memId");
//String memPw = request.getParameter("memPw");
//이 부분이 필요없어진다.
```

또 한가지 방법이 있다.

```java
public String memLogin(Member member) {...}
```

- Member 객체를 파라미터로 받으면 된다. 이 Member 객체는 DAO 객체 형태로 되어 있으며 이게 가능한 이유는 `getter`와 `setter`가 있기 때문에 값을 가져오고 지정까지 가능하다.

## @ModelAttribute

![캡처](https://user-images.githubusercontent.com/55525868/109013284-4bc27680-76f6-11eb-8069-0ec0786542a5.PNG)

그림에서 보면 알 수 있듯이 `@ModelAttribute`를 사용하면 객체의 이름 변경할 수 있고, 이 변경된 이름으로 객체를 참조할 때 사용된다.
만약 객체의 이름이 `memberLoginIsOk` 이러면 너무 길수가 있으니 줄일 수 있는 것이다.

```java
//mem 이라는 객체 이름으로 사용할 수 있다.
public String memLogin(@ModelAttribute("mem") Member member) {...}
```

## Model과 ModelAndView의 차이

![캡처](https://user-images.githubusercontent.com/55525868/109016429-8548b100-76f9-11eb-853e-b62f5ce3c870.PNG)
