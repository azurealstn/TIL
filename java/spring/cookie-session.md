# 세션과 쿠키

![캡처](https://user-images.githubusercontent.com/55525868/109148303-70c3f180-77a9-11eb-98bc-02b128b743f8.PNG)

HTTP 프로토콜은 웹 서비스를 가능하게하는데, 클라이언트가 요청을 보내고 서버가 그에 대한 응답을 하고 **연결(상태)를 유지하지 않는 Stateful한** 특징이 있다.

이렇게 한번 요청하고 응답한 후에 연결을 끊는 이후는 수많은 요청을 서버가 계속 유지한채로 받아들인다고 부하가 걸릴 것이다. 그래서 이를 효율적으로 그리고 빠르게 하기 위해 **한번 요청-응답을 해주면 바로 연결을 끊는다.**

만약 쇼핑몰에서 로그인을 하고 다른 페이지로 요청을 하면 또 로그인을 해야 한다. 왜냐하면 HTTP는 Stateful한 특징이 있다고 했다. 이를 방지하기 위해 **세션과 쿠키**가 나온 것이다.
이 둘은 **클라이언트-서버 상태를 계속 유지시켜주는 역할**을 한다.

- 쿠키
	- 클라이언트에서 연결 유지 정보를 관리
	- 보안 취약
	- 속도가 빠름

- 세션
	- 서버에서 연결 유지 정보를 관리
	- 보안에 강함
	- 서버에 부하가 걸리 수 있음

```java
//Create Session use HttpServletRequest
@RequestMapping(value="/login", method = RequestMethod.POST)
public String memLogin(Member member, HttpServletRequest request) {
	Member mem = service.memberSearch(member);
	
	HttpSession session = request.getSession(); //세션 생성
	session.setAttribute("member", mem);
	return "/member/loginOk";
	
//Create Session use HttpSession
@RequestMapping(value="/login", method = RequestMethod.POST)
public String memLogin(Member member, HttpSession session) { //세션 생성
	Member mem = service.memberSearch(member);
	
	session.setAttribute("member", mem);
	return "/member/loginOk";
}
```

- 로그아웃, 회원탈퇴
	- `session.invalidate()` : 세션 삭제

```java
//Create Cookie use HttpServletResponse
@ReqeustMapping("/main")
public String mallMain(Mall mall, HttpServletResponse response) {
	Cookie cookie = new Cookie("gender", mall.getGender()); //첫번째 파라미터: 쿠키이름, 두번째 파라미터: 쿠키값
	if (mall.isCookieDel()) { //쿠키 삭제 메소드
		cookie.setMaxAge(0);
		mall.setGender(null);
	} else {
		cookie.setMaxAge(60*60*24*30);
	}
	response.addCookie(cookie); //클라이언트에 쿠키 정보를 담는다.
	return "/mall/main";
}
```

- `HttpServletResponse`에 쿠키를 담는다.
- 쿠키를 생성 및 설정 코드

```java
@RequestMapping("/index")
public String mallIndex(Mall mall, @CookieValue(value="gender", required=false) Cookie cookie, HttpServletRequest request) {
	if (cookie != null) mall.setGender(cookie.getValue());
	return "/mall/index";
}
```

- 생성된 쿠키를 사용하는데 이 때 `@CookieValue`를 사용한다. (value : 쿠키 이름)
- `required=false` : Exception을 무시한다. (쿠키가 없을 경우 Exception 발생)
