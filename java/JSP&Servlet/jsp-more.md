# JSP request, response
원리는 서블릿과 동일하다.

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="mSignUp.jsp" method="get">
		name : <input type="text" name="m_name"> <br/>
		password : <input type="password" name="m_pass"> <br/>
		hobby : sport<input type="checkbox" name="m_hobby" value="sport">,
				cooking<input type="checkbox" name="m_hobby" value="cooking">,
				travel<input type="checkbox" name="m_hobby" value="travel"><br/>
				<input type="submit" value="sign up">
	</form>
</body>
</html>
```

```jsp
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%!
	String m_name;
	String m_pass;
	String[] m_hobby;
	%>
	
	<%
	m_name = request.getParameter("m_name");
	m_pass = request.getParameter("m_pass");
	m_hobby = request.getParameterValues("m_hobby");
	%>
	
	m_name : <%= m_name %><br/>
	m_pass : <%= m_pass %><br/>
	m_hobby :
	<%
	for (int i = 0; i < m_hobby.length; i++) {
	%>
	<%= m_hobby[i] %>
	<%
	}
	%> <br/>
</body>
</html>
```

위 코드처럼 form 태그안에 `action`에는 jsp 파일을 넣어주면 된다.
나머지 jsp 문법으로 각각의 정보를 출력해본다.

- `response.sendRedirect("example.jsp")`: sendRedirect를 쓰면 (".jsp") 페이지로 Redirect 즉, 바로 넘어간다.
- request: 브라우저에서 요청할 때
- response: 서버에서 어떤 동작(?) 응답을 해줄 때

# JSP 내장 객체

- **config:** web.xml에서 `<init-param>`을 이용하여 데이터를 초기화해주고 `getInitParameter()`라는 메소드를 이용하여 **JSP에서 데이터를 공유하는 것을 말한다.**
- **application:** web.xml에서 `<context-param>`을 이용하여 데이터를 초기화해주고 `getInitParameter()`라는 메소드를 이용하여  **프로젝트 전체에 데이터를 공유하는 것을 말한다.**
또한 application 객체에서 `setAttribute()` & `getAttribute()` 메소드를 이용하여 값을 저장하고 가져올 수도 있다.
- **out:** out 객체에서 `print()` 메소드를 이용해 `html` 코드를 작성해줄 수 있다.
- **exception:** `getMessage()` 메소드를 이용해 에러 메시지를 출력한다.
