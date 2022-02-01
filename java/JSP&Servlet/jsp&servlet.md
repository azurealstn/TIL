# JSP

![캡처](https://user-images.githubusercontent.com/55525868/107953250-3a82b700-6fde-11eb-8380-d0223881a2f7.PNG)

​																[출처 - https://url.kr/z7ia48]

위 구조는 웹 컨테이너 구조이다. (JSP)
jsp 파일로 요청해서 결국 응답할 땐 html 파일로 된다는 것.
이러한 것을 `WAS(Web Application Server)`라고 한다.

즉, `JSP(Java Server Page)`는 html 코드에 java 코드를 넣어 동적 웹페이지를 생성하는 **웹 어플리케이션 도구**이다.

```java
웹 컨테이너한테 이 파일 어떤 파일(jsp파일)인지 지시를 해주는 지시어
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
```

JSP 같은 경우는 코드 수정을 하면 서버를 끄지 않아도 자동으로 수정된다.

소스 파일(.java) & 바이트코드(.class) 파일은 아래 경로에서 확인 가능하다.

> C:\Program Files\Java\apache-tomcat-8.5.63\work\Catalina\localhost\testProject\org\apache\jsp

# Servlet
JSP가 실행되면 **서블릿으로 변환되며** 웹 어플리케이션 서버에서 동작되면서 필요한 기능을 수행하고 클라이언트로 응답 메시지를 보낸다.

결국 JSP와 Servlet 둘 다 사용자의 요청에 의해 동적인 작업을 수행하고 응답을 하는 구조이다.
또한 바이트코드(.class)를 생성하여 사용자에게 응답한다.

- JSP: html 코드에 java 코드가 들어가서 확장자를 .jsp 확장자로 사용한다.
- Servlet: java 코드내에 html 코드가 있다. (읽고 쓰기가 불편하여 효율성이 떨어진다.)

[참고 - https://javacpro.tistory.com/43]

바이트코드(.class) 파일은 아래 경로에서 확인 가능하다.

> C:\Project\workspace\testPrj\build\classes\com\testPrj

- 추가적으로 Servlet `Hello World`를 출력하는데 1시간 반이 걸려버렸다...
- 뭔가 `build.path`가 잘못된 것 같은데(확실하진 않다..).. 다시 프로젝트를 삭제했다 실행해보니 이번엔 실행이 되었다.. (원인이 뭘까..;)
