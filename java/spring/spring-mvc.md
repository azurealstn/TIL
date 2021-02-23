# 웹 프로그래밍 구조

## Model1

![캡처](https://user-images.githubusercontent.com/55525868/108852776-5b27be00-7629-11eb-87b7-a1def82e6685.PNG)

웹 프로그래밍을 할 때 두 가지 모델이 있다. -> Model1, Model2

그림에서 보면 **클라이언트 - 서버**의 기본 구조를 확인할 수 있다. 클라이언트가 어떤 요청을 하게 되면 **WAS(웹 어플리케이션 서버)**라는 곳에서 이 요청에 대한 응답해준다. 이 때 반환을 **html** 파일로 변환해준다. 응답을 해줄 때 필요한 데이터들 **DB**에 가져온다.

여기서 **Model1의 방식은 html + java + <tag>들이 짬뽕되서 하나의 파일에서 작성한다.**

- Model1의 장점
	- 하나의 파일에서 구현하기 때문에 빠르게 구현할 수 있다.

- Model1의 단점
	- 이렇게 하나의 파일에 작성하게 되면 유지보수 차원에서 어려움이 있고, 복잡성이 증가할 것이다. 이것은 굉장히 큰 단점이라고 할 수 있다. 협업하는 입장에서는 쓰면 안될 것이다.

## Model2

![캡처](https://user-images.githubusercontent.com/55525868/108854246-0127f800-762b-11eb-9f83-f06224ea359d.PNG)

Model2는 Model1의 단점을 보완을 위해 나왔다.

1. 클라이언트가 WAS에 요청을 하게 되면 처음에는 **Controller**가 받는다. **이 Controller는 어떤 Service(기능)한테 다음 작업을 시킬지 컨트롤하는 것을 말한다.**
2. 그 다음으로 Service를 만든다. **이 Service에는 다양한 기능들이 있다.**
3. DB의 접근이 필요하면 이번에는 **DAO** 라는 모듈을 만든다. **DAO는 Model이라는 객체를 이용하여 DB와 서로 통신을 한다.**
4. 그리고 서버에서 요청에 대한 응답을 Controller가 해주어야 한다. 이를 위해 **View**라는 객체를 만들며 자바에서는 주로 JSP를 만들어 사용한다.

**Model2 방식은 Controller, Service, DAO, View .. 각각의 기능들을 모듈화시키는 것을 말한다.  이 Model2 방식은 MVC(Model View Controller) 기본으로 한다.**

- Model2의 장점
	- 유지보수가 훨씬 수월해진다. 왜냐하면 기능들을 나누었기 때문에 각각 필요한 부분만 수정하면 되기 때문이고, 코드가 보기에도 훨씬 편하다.

## 스프링 MVC 구조

![캡처](https://user-images.githubusercontent.com/55525868/108855539-747e3980-762c-11eb-8840-32dd8b91131c.PNG)

1. 역시 먼저 클라이언트가 요청을 하면 `DispatcherServlet`이라는 객체가 요청을 받는다.
2. 그리고 `DispatcherServlet`은 가장 먼저 `HandlerMapping`한테 주고, `HandlerMapping` 많은 `Controller` 중에 가장 적합한 Controller를 선택해준다.
3. `HandlerMapping`은 다시 `DispatcherServlet`한테 오고, `DispatcherServlet`은 `HandlerAdapter`한테 간다. `HandlerAdapter`의 역할은 Controller안에 있는 메소드 중에 적합한 것을 찾는다. 찾은 후에는 **Model, View라는 데이터를 가져온다.**
4. 다시 `DispatcherServlet`으로 돌아와서 이번엔 가져온 데이터를 `ViewResolver`한테 보낸다. `ViewResolver`는 그냥 View(뷰)를 말한다. 이 데이터는 Model과 View 정보가 들어있는데 **View의 정보를 `ViewResolver`한테 보내는 것이다.** 여기서 뷰는 JSP이다. `ViewResolver`는 가장 적합한 View를 선택해준다.
5. 그 다음 `DispatcherServlet`은 그 적합한 View에 대한 응답을 생성해준다. 이 응답(JSP)은 클라이언트로 다시 전달한다.

---

이렇게 사용하기 위해서는 먼저 설정을 해주어야 한다.

- 서블릿에 DispatcherServlet을 설정해준다.
- 서블릿의 init-param에는 스프링 설정을 해준다.(servlet-context.xml) -> 스프링 컨테이너가 만들어지고, HandlerMapping, HandlerAdapter, ViewResolver는 스프링 컨테이너 안에 자동으로 생성해준다. 즉, 개발자는 **Controller, View**만 작성해주면 된다.
- 만약 DispatcherServlet 설정만 해주고 스프링 설정을 안해주어도 스프링에서 자동으로 설정을 해준다. (일반적으로는 스프링 설정 파일을 명시해준다.)

### @Controller

![캡처](https://user-images.githubusercontent.com/55525868/108858601-b066ce00-762f-11eb-8509-81aa1a991d13.PNG)

- Controller는 개발자가 직접 만들어주어야 한다.
- 스프링 설정 파일(servlet-context.xml)에 `<annotation-driven />태그를 넣어야 한다..

```java
@Controller //Controller 객체로 사용할 클래스 정의
public class Hello() { ... }
```

#### @RequestMapping
HandlerAdapter가 Controller의 메소드 중에 가장 적합한 메소드를 찾는다고 했다.
이 기능을 `@RequestMapping`이라는 어노테이션으로 이용한다.

```java
@RequestMapping(/success) //사용자로부터 들어오는 요청을 매핑시켜준다.
public String success(**Model model**) { return "success"; }
```

#### Model 타입
Controller에서 Model과 View 데이터를 가져왔다. 이 가져온 Model과 View를 받을 수 있어 하느데 위의 코드처럼 객체로 받을 수 있다. 또한 값을 설정할 수도 있다.

```java
model.setAttribute("temp", "Hi!");
```

### 전체적인 구조

![캡처](https://user-images.githubusercontent.com/55525868/108860072-359eb280-7631-11eb-9414-714d19c1ae5b.PNG)
