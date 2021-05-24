## FQCN or QName

- 만약  JDBC 드라이버 클래스를 로딩하려면 다음과 같이 해야할 것입니다.

```java
Class.forName("");
```

- 매개변수에 문자열안에는 드라이버 클래스 이름이 들어가는데 이 때 중요한 것은 반드시 패키지 이름을 포함해야 합니다.
- 하지만 만약 서블릿 초기화 매개변수를 이용한다면 다음과 같이 설정합니다.

```java
Class.forName(this.getInitParameter("driver"));
```

- 이것은 `web.xml` 외부 파일에 설정해두어서 이것이 가능한 것인데요.
- 이렇게 `Class.forName()`의 매개변수에 클래스 이름은 물론 패키지 이름까지 포함하는 것을 바로 `Fully Qualified Name` 또는 `QName` 이라고 합니다.
- 또다른 말로 클래스가 속한 패키지명을 모두 포함한 이름 `FQCN(Fully Qualified Class Name)`이라고 합니다.
- 제가 생각하기엔 둘다 같은 말인 것 같습니다.

<br/>
<br/>
<br/>

### Reference

- https://dreamzelkova.tistory.com/entry/%EC%9E%90%EB%B0%94%EC%9D%98-%EA%B8%B0%EC%B4%88-FQCN-JAR
