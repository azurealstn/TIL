# 의존객체 자동 주입
우리는 스프링 컨테이너에 객체를 생성하기 위해 빈을 만들었습니다. (XML 파일 작성)

이번에는 따로 `XML` 파일을 작성하지 않아도 자동으로 객체를 주입해주는 `annotation`이 있다.

그래서 의존객체 자동 주입이란 <constructor-arg> 또는 <property> 태그로 의존 대상 객체를 명시하지 않아도 스프링 컨테이너가 알아서 자동으로 객체를 주입해준다.  구현 방법은 `@Autowired`와 `@Resource` 어노테이션을 이용한다.

![캡처](https://user-images.githubusercontent.com/55525868/108726202-7ed7ff00-756a-11eb-9e32-03fccd4146f0.PNG)

## @Autowired

![캡처](https://user-images.githubusercontent.com/55525868/108726361-ac24ad00-756a-11eb-8f4f-fb04357fe29d.PNG)

이 `@Autowired`를 주면 스프링 컨테이너에 있는 빈들 중에 객체 타입을 본다.
즉, @Autowired란 객체의 타입을 보고 타입에 맞는 빈을 자동으로 주입해준다.

```java
@Autowired
public WordRegisterService(WordDao wordDao) {
	this.wordDao = wordDao;
}
```

- 위와 같이 설정을 해주면 자동주입이 되기 때문에 따로 XML 파일에서 작성을 안해도 된다.
- 대신에 XML 파일에 `<context:annotation-config />`라는 태그를 추가하여 애노테이션을 사용하겠다고 명시를 해주어야 한다.

### @Autowired 사용 조건

- 생성자에다가 사용시에는 그냥 사용하면 된다.
- 메소드나 인스턴스 선언시에는 @Autowired를 사용하기 전에 반드시 디폴트 생성자를 명시해주어야 한다. 기본적으로 객체가 생성이 되야 인스턴스를 사용할 수 있고, 메소드에도 인스턴스 파라미터를 사용할 수 있겠다.

## @Resource

@Autowired의 구조와 비슷한데, @Autowired가 객체의 타입을 비교했다면, @Resource는 객체의 이름을 비교한다. 또한 @Resource는 생성자에는 사용하지 못한다. (메소드나 인스턴스에는 사용 가능하다.)
그리고, 디폴트 생성자는 꼭 명시를 해주자.

