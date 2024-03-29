이미 `HTTP (첫 번째 요약)`, `HTTP (두 번째 요약)` 글을 쓰면서 정리하였지만 제대로 알지 못하고 막 정리한 것 같아서 다시 정리를 해보았습니다.ㅎㅎ;

# HTTP

본문의 내용들은 [모든 개발자를 위한 HTTP 웹 기본 지식](https://www.inflearn.com/course/http-%EC%9B%B9-%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC#) 강의를 보고 정리하였습니다.

아래 내용은 제가 공부할 수 있도록 정리한 것이라 이해하기 어려울 수 있으므로 꼭 위 강의를 들어보시는 것을 추천드립니다.

<br>
<br>
<br>

## IP(Internet Protocol)의 역할

- 지정한 IP 주소에 데이터를 전달한다.
- 통신 단위인 패킷을 전달한다.

## IP 패킷의 목적

![ip](https://user-images.githubusercontent.com/55525868/158522136-8eb1318f-d47e-46f0-8b37-785872441e0c.PNG)

- IP 패킷에는 출발지 IP와 목적지 IP가 있다.
- 출발지 IP와 목적지 IP를 통해 데이터를 전송한다.

> 패킷 : package와 bucket의 합친 말로, 네트워크상에서 전송하는 데이터의 형식화된 블록이다.
> 참고: https://ko.wikipedia.org/wiki/%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC_%ED%8C%A8%ED%82%B7

## IP 프로토콜의 한계

- 비연결성
    - 만약 패킷을 받을 상대가 인터넷이 끊겨도 즉, 서비스 불능 상태여도 패킷은 그대로 전송
- 비신뢰성
    - 패킷을 전송했는데 중간에 패킷이 사라지거나 패킷이 순서대로 오지 않은 경우
- 프로그램 구분
    - 한 IP로 여러 애플리케이션을 돌릴 경우

**이러한 IP 프로토콜의 한계를 TCP 프로토콜이 해결**

<br>
<br>
<br>

## 인터넷 프로토콜 4계층

![stack](https://user-images.githubusercontent.com/55525868/158523007-ce2b9ad7-e082-4fdf-8079-9fcfe0ddc7e0.PNG)

참고 : https://hahahoho5915.tistory.com/15

- 1계층 `네트워크 인터페이스 계층` : 물리적인 주소로 MAC을 사용하고 LAN, 패킷망 등에 사용
- 2계층 `인터넷 계층` : 통신 노드간의 IP패킷을 전송하는 기능과 라우팅 기능을 담당
- 3계층 `전송 계층` : 통신 노드간의 연결을 제어하고, 신뢰성 있는 데이터 전송을 담당
- 4계층 `어플리케이션 계층` : TCP/UDP 기반의 응용 프로그램을 구현할 때 사용

**인터넷 계층인 `IP` 위에 전송 계층인 `TCP`를 씌움으로서 IP의 한계를 극복**

![tcp2](https://user-images.githubusercontent.com/55525868/158523906-c81513d4-06a9-4572-b2f2-77dd0f84252b.PNG)

1. 만약 펜팔친구에게 `잘 지내니`라는 메시지를 보낸다고 가정하자. 이 때 IP 패킷을 두 개로 나누어서 보낸다. `잘` 패킷과 `지내니` 패킷 -> IP는 순서가 보장되지 않기 때문
2. 메시지를 보낼 때 어플리케이션 계층인 `Socket 라이브러리`를 통해 데이터를 전송한다.
3. 그리고나서 OS 계층에서 `IP 패킷`에다가 `TCP`를 씌운다.
4. LAN 카드를 통해 패킷을 서버로 전송합니다.

## TCP

![tcp3](https://user-images.githubusercontent.com/55525868/159257091-0f6d2e26-3b3a-4d77-be60-8a596ad85372.PNG)

- TCP는 IP패킷 안에 TCP 정보가 들어간다.
- TCP에는 출발지 PORT, 목적지 PORT, 전송 제어, 순서, 검증 등의 정보가 들어있다.

## TCP 특징

- TCP란 전송 제어 프로토콜(Transmission Control Protocol)
- 연결지향 - TCP 3 way handshake
- 데이터 전달 보증
    - 중간에 패킷이 누락되어도 알 수 있음
- 순서 보장
- 신뢰성 있는 프로토콜 -> 대부분 TCP를 사용

### TCP 3 way handshake

![tcp4](https://user-images.githubusercontent.com/55525868/159257095-6e66b076-7381-41dd-8ccb-4aa7f692451c.PNG)

1. 클라이언트 -> 서버로 `SYN`이라는 메시지를 보내서 접속을 요청한다.
2. 서버 -> 클라이언트로 `ACK`라는 메시지를 통해 접속 요청에 대한 응답을 해주고 다시 서버쪽에서 요청을 하기 위해 `SYN`을 보낸다. 즉, 이때는 `SYN+ACK` 이렇게 메시지를 보냅니다.
3. 클라이언트 -> 서버로 서버에 대한 요청을 응답해주기 위한 `ACK` 메시지를 보낸다.

위 세 과정을 하게 되면 클라이언트와 서버간에 신뢰할 수 있게 되어 연결을 할 수 있게 된다.  
이것이 **3 way handshake**

### 3 way handshake 의 장점

예를 들어, 클라이언트쪽에서 `SYN`을 보냈는데 서버쪽에서 `ACK`를 못받으면 문제가 있는 것으로 판별할 수 있음.

기존에 `IP 프로토콜`만 있을 때는 `비연결성`이기 때문에 클라이언트쪽에서 패킷을 보내도 정상적으로 데이터가 전송이 되었는지 누락이 되었는지 알 수 없었지만 `TCP 프로토콜`이 생기면서 이러한 점을 보완할 수 있음.
  
> 여기서 알아야 할 점은 3 way handshake는 물리적으로 서로 연결된 것이 아니라 논리적으로 연결된 것을 말한다.
> 즉, "아, 서로 연결이 잘됐나 보다~" 하고 판단을 내린 가상 연결을 의미합니다.

<br>
<br>

### 데이터 전달 보증

1. 클라이언트에서 서버로 데이터를 전송
2. 서버에서 클라이언트로 데이터를 잘 받았다고 전송

위 과정이 이루어져야 신뢰성 있는 통신이 가능합니다.  
만약 데이터를 전송했는데 그에 대한 응답이 없으면 정상적으로 연결이 되지 않은 것임

### 순서 보장

1. 클라이언트에서 서버로 패킷1, 패킷2, 패킷3 ... 순서로 전송한다.
2. 만약 서버에서 패킷1, 패킷3, 패킷2 ... 순서로 받았다면 순서가 맞지 않으므로 서버에서 클라이언트로 다시 패킷2부터 보내라고 요청 -> ✨ 순서가 보장!!

이렇게 순서가 보장이 될 수 있는 이유는 TCP의 전송 제어, 검증 등의 정보 때문에 가능

**그래서 TCP는 신뢰성 있는 프로토콜이라고도 불림**

<br>
<br>
<br>

## UDP

UDP는 TCP과 같은 전송 계층에 있음

## UDP 특징

- 사용자 데이터그램 프로토콜 (User Datagram Protocol)
- 기능이 거의 없음
- 비연결지향 - TCP 3 way handshake X
- 데이터 전달 보증 X
- 순서 보장 X
- 데이터 전달 및 순서를 보장하지 않지만 **그 만큼 속도가 빠르다는 장점이 있음**

즉 이는 IP와 거의 같지만 여기에 PORT와 체크섬(검증)이 추가됨.

IP는 한 IP에 여러 애플리케이션이 돌아갈 경우에 패킷을 구분할 수가 없는 것이 IP의 한계

만약 여기에 PORT가 추가되면 한 IP에 각각의 애플리케이션마다 패킷 구분이 가능

<br>

#### 결국 TCP와 UDP의 결정적 차이는 '속도'

TCP는 3 way handshake라는 과정을 거쳐야 하기 때문에 속도가 UDP보다 느릴 수 밖에 없음

UDP는 그런 과정이 없는 하얀 도화지이기 때문에 속도가 더 빠름

<br>
<br>
<br>

## PORT

만약 내 pc 에 여러 어플리케이션을 돌리고 있다고 가정해보자. (게임, 화상 통화, 웹 브라우저 요청 ...)  
이 경우에는 여러 서버랑 통신하게 된다.  
여기서 서버쪽에서 각각의 어플리케이션의 패킷들이 내 pc로 올텐데 ❗ 이 때!! 패킷들이 게임 패킷인지, 화상통화 패킷인지, 웹 브라우저 응답 패킷인지 구분을 할 수가 없다.

그래서 한 IP안에 여러 어플리케이션 패킷을 구분 지을 수 있도록 'PORT' 를 사용한다.

<br>

즉, IP는 어떤 출발지와 목적지를 구분하기 위해 출발지 IP, 목적지 IP가 있고,

PORT는 한 IP 내에 여러 어플리케이션이 돌고 있을 때 각 패킷을 구분짓기 위해 사용한다.

> 게임: 8000포트
> 화상 통화: 10000포트
> 웹 브라우저 요청: 8080포트

- PORT는 0 ~ 65535 할당 가능
- 0 ~ 1023 은 잘 알려진 포트이므로 사용하지 않는 것이 좋다.
    - FTP : 20, 21
    - TELNET : 23
    - HTTP : 80
    - HTTPS : 443

> IP와 PORT를 구분하는 예시
> 아파트가 있을 때 한 아파트는 IP,
> 한 아파트의 몇동, 몇호는 PORT
  
<br>

## DNS

내 PC와 상대 PC를 구분짓기 위해 출발지 IP와 목적지 IP 라는 것을 사용했다.  

하지만 IP는 `100.100.100.1` 처럼 숫자로 되어 있기 때문에 외우기가 쉽지 않다.

<br>

그래서 사람들이 외우기 쉽게 하기 위해 IP에 이름을 짓는다.

이것이 바로 **도메인명**

예를 들어 구글이면 구글 사이트가 만약 IP가 `123.456.673.2` 이렇게 되어 있으면 사람들이 굉장히 구글 사이트에 들어가기가 힘들 것입니다.  

하지만 구글 이라는 타이틀로 도메인을 설정하면 사람들이 쉽게 접근할 수 있다. (ex. [www.google.com](http://www.google.com))

또 한 가지 `DNS 서버`를 사용하게 되면 다음과 같은 key, value 형태로 값이 저장하게 되는데,

|도메인명|IP|
|:---:|:---:|
|google.com|123.456.673.2|

- 여기서 만약 구글의 IP가 변경된다고 해도 사용자는 그대로 도메인명인 `google.com`을 사용하면 된다.
- 왜냐하면 value인 IP만 변경하면 되므로 도메인명은 그대로 사용

<br>
<br>
<br>
  
## 💨 여기까지 정리해보기.

### IP (Internet Protocol address)

- IP는 각 컴퓨터의 주소이고, 역할은 상대 IP 주소로 데이터를 전송한다.
- 다만, IP는 비신뢰성이고, 비연결성이고, 순서가 없고, 프로그램 구분을 할 수가 없다.

### TCP (Transmission Control Protocol)

- 위 IP의 한계를 보완한 것이 TCP 프로토콜
- TCP는 신뢰성 있고(데이터 전달 보장), 연결지향인 3 way handshake를 사용하고, 순서도 보장
- 다만, 3 way handshake 통신으로 인해 속도가 느림

### UDP (User Datagram Protocol)

- TCP와 거의 반대로 기능이 거의 없고, 3 way handshake를 사용하지 않고, 순서를 보장하지 않고, 신뢰성이 없다.
- 다만, 3 way handshake를 사용하지 않아 TCP보다 속도가 빠르다.
- 또한 TCP와 다르게 사용자가 직접 커스터마이징할 수 있다.

### PORT

- 사용하는 애플리케이션을 구분하기 위해서 사용

### DNS

- IP는 외우기 어렵고 변경되면 골치아픈데 그러한 문제를 해결해주는 것이 `DNS`이다.
- 또한 IP가 변경되도 도메인명은 그대로 이므로 상관없다.

<br>
<br>
<br>

## URI

- URI(Uniform Resource Identifier)는 로케이터(Locator), 이름(Name) 또는 둘 다 추가로 분류

> URI는 통합 자원 식별자의 줄임말이다.
> 결론은 URI라는 개념은 어떤 형식이 있다기 보다는 특정 자원을 식별하는 문자열을 의미한다. 그래서 URL이 아니고 URN도 아니면 그냥 URI가 된다.
> 참고 : https://hanamon.kr/%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC-%EA%B8%B0%EB%B3%B8-url-uri-urn-%EC%B0%A8%EC%9D%B4%EC%A0%90/
  
- URI 안에 URL과 URN이 있다.  
- **URL**은 `https://www.naver.com` 처럼 웹 브라우저에 주소 적는 것이 URL
    - Locator, 리소스가 있는 위치 조정
- **URN**은 `urn:example:animal:ferret:nose` 처럼 주소처럼 이름을 부여하는 것이 URN
    - URN의 단점은 중간에 이름을 넣으면 찾기 매우 어려움 -> 거의 URL만 사용

URL과 URN의 차이점은 URL은 위치(Locator)로서 변할 수 있지만 이름(Name)은 변하지 않는다.

<br>

### ❕ query string

쿼리 스트링은 URL에 **파라미터 정보를 받기 위해서 사용**

즉, GET 방식에서 사용되고 `key=value` 형태로 되어있다.  

그리고 쿼리 스트링을 사용할 때는 `?`로 시작을 해서 여러 파라미터를 받기 위해서는 `&`로 구분한다.

- ex) https://www.google.com/search?q=bye&sxsrf=APq
- 여기서 ? 뒤부터 쿼리 스트링이며,
- key는 q, sxsrf 그리고 value는 bye, Apq

그리고 쿼리 스트링에서 `string`인 이유는 파라미터 타입이 모두 문자열이기 때문.

<br>
<br>
<br>

## 웹 브라우저 주소를 검색했을 때 무슨 일이 벌어질까?

면접에서도 나올만한 질문인 `https://www.naver.com` 이 주소를 쳤을 때 어떤 일이 벌어질까요?

<br>  

1. 가장 먼저 DNS서버를 조회한다. ([www.naver.com](http://www.naver.com))
2. DNS를 조회해서 도메인명이 `www.naver.com`인 IP와 PORT를 찾아낸다.
3. **HTTP 요청 메시지를 생성**하고 TCP/IP 패킷을 씌운다. 이 패킷에는 IP, PORT 정보가 들어있고 전송데이터에는 HTTP 요청 메시지가 포함하고 있다.
4. HTTP 요청 메시지가 포함된 요청 패킷을 `네이버서버`로 보낸다.
5. 서버는 받은 패킷 안에 있는 **HTTP 요청 메시지를 해석**해서 데이터를 찾는다. (HTTP 메소드, 쿼리스트링, host 등등..)
6. 해석한 후에 네이버 서버에서 **HTTP 응답 메시지를 생성**해서 응답 패킷에 담아서 클라이언트로 보낸다.
7. 클라이언트는 HTTP 응답 메시지를 보면 Body안에 데이터를 `Content-Type`에 따라 웹 브라우저에 렌더링되어 화면에 보여지게 된다.

### HTTP 요청 메시지

```
GET /search?name=minsu&lan=ko HTTP/1.1
Host: www.naver.com
```

> Host란?
> IP를 가지고 있고 양방향 통신이 가능한 컴퓨터를 말한다.
> ex) www.google.com
> 참고: https://hihighlinux.tistory.com/73

### HTTP 응답 메시지

```
HTTP/1.1 200 OK
Content-Type: text/html;charset=UTF-8
Content-Length: 3423

<html>
    <body>...</body>
</html>
```

<br>
<br>
<br>

## HTTP

HTTP(HyperText Transfer Protocol)는 하이퍼 텍스트, 즉 문서 간에 정보를 주고 받을 수 있는 프로토콜

현재는 모든 것을 HTTP 프로토콜에 담아서 전송한다. (html, text, json, xml, image, 오디오, 영상 ...)  

또한 HTTP 에도 버전이 있는데 가장 많이 사용하는 버전이 `HTTP/1.1`  
따라서 `HTTP/1.1` 을 공부하는 것이 중요

> 👌 잠깐!
> TCP기반으로 사용되는 어플리케이션 계층에서 사용하는 HTTP 버전은 `HTTP/1.1`, `HTTP/2`를 사용하고,
> UDP기반은 `HTTP/3` 버전을 사용한다.

<br>

## HTTP 특징

- 클라이언트 - 서버 구조
    - 클라이언트가 서버에 요청을 하고, 서버는 요청에 대한 응답하는 구조
- Stateless(무상태) Protocol, 비연결성
- HTTP 메시지를 통해 통신
- 단순하고, 확장 가능

### 무상태 (Stateless)

- Stateless란, 서버가 클라이언트의 상태를 보존하지 않는다는 뜻
- 반대로 Stateful은, 서버가 클라이언트의 상태를 보존한다는 뜻

![UI drawio (2)](https://user-images.githubusercontent.com/55525868/158754777-ff011bfe-c3f1-44e1-8c31-75c094ddc2ae.png)

#### Stateful인 경우

- 클라이언트와 서버1과 서로 통신하고 있을 때 에러가 발생하면 어떻게 될까?

서버1은 클라이언트의 상태를 유지한다. **예를 들어, 어떤 상품을 100만원에 구매한다고 하면 그 상품을 구매하기 위한 필요한 정보들을 서버1이 가지고 있다는 의미**  
(필요한 정보: 상품명, 상품가격, 결제방법 등..)

만약에 서버1이 다운된다면 서버1은 클라이언트의 정보를 다 잃게 된다.

그러면 클라이언트는 구매하려던 상품을 처음부터 다시 구매하기를 해야한다. (불편.. 😢)

#### Stateless인 경우

- 하지만 Stateless인 경우에는 어떻게 될까?

서버1은 클라이언트의 상태를 유지하지 않는다. **예를 들어, 어떤 상품을 100만원에 구매한다고 하면 그 정보를 서버1은 유지하지 않는다. 따라서 클라이언트는 처음 요청할 때 필요한 데이터를 모두 넘겨야 한다.**  
ex)아이패드 신형을 네이버페이로 100만원에 구매하겠습니다. (구체적 👍)

만약에 서버1이 다운된다해도 클라이언트 입장에서는 전혀 문제가 없다.

그 이유는, 서버2라는 대체 서버가 존재하기 때문입니다. Stateful도 대체 서버가 존재하는데 왜 Stateless만 문제가 없을까?

Stateless의 경우 클라이언트는 처음 요청할 때 필요한 데이터를 모두 넘겨야 한다고 했다. 그래서 데이터 안에 필요한 정보가 다 들어있기때문에 다른 서버와 통신해도 전혀 문제가 발생하지 않는다.

> 그래서 Stateless는 서버를 scale-out, 무한히 확장가능한 것입니다.
  
### Stateless의 한계

하지만 모든 것을 Stateless하게 설계할 수는 없다.

예를 들어, 로그인이 대표적인 예!

로그인을 했을 때 상태를 유지하지 않는다면 다른 페이지로 요청했을 때 또 로그인을 해야한다.

그래서 이를 해결하기 위해 나온 것이 `쿠키와 세션`
  
또 한 가지의 단점은,

Stateless는 필요한 데이터를 모두 넘겨야하기 때문에 데이터를 많이 보낸다.

> 결론은 애플리케이션을 설계할 때는 최대한 무상태로 설계하고, 어쩔 수 없는 경우에만 상태를 유지한다.

<br>

## 비연결성 (connectionless)

![UI drawio (3)](https://user-images.githubusercontent.com/55525868/158755016-ed57fa0d-338f-4d49-bb9f-7b2fcf43eb93.png)

### 연결성

비연결성에 대해 알아보기 전에 먼저 '연결성 모델'에 대해 알아보자.

1. 클라이언트A는 서버1과 통신한다.
2. 클라이언트B도 서버1과 통신한다.
3. 클라이언트C도 서버1과 통신하고 있을 때 클라이언트A와 클라이언트B는 서버1과 계속 연결을 유지하고 있다. (통신을 계속 하고 있다는 의미)

이 때 문제점은 클라이언트C와 서버1과 통신하고 있을 때 필요하지 않는 통신(클라이언트A, 클라이언트B)도 계속 유지하고 있기 때문에 서버1 입장에서는 자원을 계속 소비하게 된다.

클라이언트가 적을 때는 상관없지만 클라이언트가 갑자기 급증하게 된다면 서버에 과부하가 걸려서 서버가 다운될 것이다.

---

### 비연결성

반면에 비연결성은 간단하다.

1. 클라이언트A와 서버1과 통신하고 연결을 끊는다.
2. 클라이언트B와 서버1과 통신하고 연결을 끊는다.
3. 클라이언트C와 서버1과 통신하고 연결을 끊는다.

각각의 클라이언트가 서버1과 통신하고 바로바로 연결을 끊기 때문에 낭비되는 서버 자원을 줄일 수 있다.

**비연결성: 요청이 필요할 때마다 그때그때 연결해서 바로 끊는 형태**

### 결론

HTTP의 큰 장점인 비연결성은 클라이언트가 요청하고 서버가 응답하면 연결을 끊기 때문에 서버 자원을 효율적으로 사용할 수 있고, 특정 시간동안 수천명의 사용자가 서비스를 사용해도 실제로 동시에 요청하는 건수는 수십개 밖에 안되므로 비연결성 모델을 사용하는 것이 좋다.

### 비연결성의 단점

HTTP 통신은 대부분이 TCP/IP를 사용한다. 하지만 TCP/IP는 바로 `3 way handshake`를 사용한다. 이는 즉 신뢰성 있는 데이터 전달을 위해 **시간이 추가**된다는 의미

그리고 또 다른 단점은 많은 자원을 다시 다운로드해야 된다.

웹 브라우저를 요청하게 되면 html, css, js, image... 등등 필요한 자원을 다운로드하게 되는데 그러면 요청할 때마다 수많은 자원들을 다시 다운로드해야하는 단점이 있다.

- 하지만 지금은 HTTP 지속 연결(Persistent Connections)로 문제를 해결함.
- 그리고 HTTP/2, HTTP/3로 이러한 단점들이 많이 보완되었음.

### HTTP 지속 연결

자, HTTP는 TCP/IP 기반으로 돌아간다. 그리고 TCP/IP는 `3-way-hankshake`를 사용한다. (이것만 기억하고 다음을 읽어보자.)

HTTP는 문서 간에 정보를 주고받을 수 있는 프로토콜이라고 했다. (현재는 모든 정보를 HTTP를 통해서 주고받는다.)

(가정) HTTP를 통해 html 자원을 받고싶다면 시간이 얼마나 걸릴까?

먼저 TCP/IP의 **3-way-hankshake로 연결확인**하고 **html 요청/응답 확인**하고 **TCP/IP 연결을 종료**한다. 이게 하나의 리소스(html)를 다운받는데 일련의 과정인데 이 과정을 0.3초 걸린다고 가정해보자.
  
![UI drawio (4)](https://user-images.githubusercontent.com/55525868/158779319-e73b1507-6ba9-4756-9d91-f2157bc4f135.png)

그러면 만약에 필요한 리소스가 html, css ,js 총 3개라고 한다면 `0.3 * 3 = 0.9초`가 걸린다.

하지만 HTTP 지속 연결을 사용한다면 시간이 더 단축된다.

![UI drawio (5)](https://user-images.githubusercontent.com/55525868/158780043-5fc7ea7b-57c3-4d33-9ce6-62832b6578e9.png)

차이점은

HTTP 지속 연결을 사용하지 않는다면 일련의 과정마다 매번 연결하고 종료를 해줘야 했지만

HTTP 지속 연결을 사용하면 **한번 연결**하고 **리소스(html,css,js) 요청/응답받고** **한번 종료**시키기 때문에 시간이 훨씬 단축된다.

### 💫 참고!!!

#### 서버개발자들은 반드시 Stateless를 꼭 기억하자

- 같은 시간에 발생하는 대용량 트래픽
- 이벤트가 생길 때 사용자가 급증할 때

**이를 해결하기 위해서는 어떻게든 머리를 짜서 반드시 Stateless하게 설계를 해야 한다.**

> 간단한 해결법은 일단은 정적 페이지하나 생성해서 일단 그 페이지를 보게 한 다음에 이벤트 페이지로 들어가게 만드는 방법.
> 최대한 동시 요청을 적게 한다.

## HTTP 메시지 구조

![http](https://user-images.githubusercontent.com/55525868/144202391-d37c87e6-0bbf-44e7-8673-2b88628b601c.PNG)

### HTTP 요청 메시지

```
GET /search?name=minsu&lan=ko HTTP/1.1 -> 시작 라인
Host: www.naver.com -> 헤더
    -> 공백 라인
```

### HTTP 응답 메시지

```
HTTP/1.1 200 OK -> 시작 라인
Content-Type: text/html;charset=UTF-8
Content-Length: 3423 -> 헤더
    -> 공백 라인
<html>
    <body>...</body>
</html> -> 메시지 바디
```

<br>
<br>
<br>

## URI 설계

API를 만들 때는 URI 설계가 굉장히 중요하다.

여기서 URI를 잘 설계하기 위해서는 알아야 하는 것이 **리소스 식별**이다.

그리고 이 리소스에 대한 동작을 담당하는 **행위**가 있다.

이 부분은 [REST API](https://gmlwjd9405.github.io/2018/09/21/rest-and-restful.html)를 참고할 것!!

너무 좋은 글이고, 간단하게 REST API는 리소스와 행위를 분리해서 **리소스를 식별**하고 **식별한 리소스에 대한 행위(CRUD)를 적용**한다.

또한 REST API는 HTTP 프로토콜을 그대로 활용한 것으로 별도의 인프라를 구성할 필요가 없다.

- [restfulapi_naming](https://restfulapi.net/resource-naming/)도 보면 좋을 것 같다.

## HTTP 메소드

- GET, POST, PATCH, PUT, DELETE에 대해 알아보자.
- 참고: https://developer.mozilla.org/ko/docs/Web/HTTP/Methods
- 멱등: 같은 데이터를 한번 호출하든 100번 호출하든 결과가 똑같다.

> 멱등이 필요한 이유
> 서버가 timeout으로 응답을 못주었을 때, 클라이언트가 같은 요청을 다시 해도 되는지 -> 자동 복구 메커니즘에 필요하다.

### GET

- 특정한 리소스를 가져오도록 요청한다.
- GET 요청은 데이터를 가져올 때만 사용해야 한다.
- 서버에 전달하고 싶은 데이터는 `query string`을 통해 전달
- GET 요청에 메시지 바디에 데이터를 담을 수도 있지만 이는 권장하지 않으므로 사용하지 말자.
- 캐시가 가능하다.
- 멱등하다.

```json
GET /members/100 HTTP/1.1
Host: example.com
```

### POST

- 데이터 처리를 담당.
- `메시지 바디`를 통해 서버로 데이터 전달한다.
    - 서버는 넘어온 데이터를 처리한다.
    - 메시지 바디 타입(html, json..)은 `Content-Type`에 나타낸다.
- **멱등 아니다.**
    - 결제를 생각해보면 한번 호출하고 두번 호출하는 것은 다르다.

```json
POST /members HTTP/1.1
Host: example.com
Content-type: application/json

{
    "name": "minsu",
    "age": 30
}
```

### POST 기능

- 새 리소스 생성(등록)
    - POST는 리소스의 URI를 모르지만 서버가 새로 등록된 리소스 URI를 생성해준다.
    - 이렇게 서버가 리소스 URI를 생성하고 관리하는 것을 `컬렉션(Collection)`이라고 하며, 컬레션은 `/members`를 말한다.

- 데이터 처리 -> 프로세스의 상태 변경
    - **컨트롤 URI**

- 다른 메서드로 처리하기 애매한 경우
    - `ajax`를 통해 데이터를 조회할 때 메시지 바디에 담고싶어서 POST를 사용할 수도 있다.
    - 하지만 조회할 때는 왠만하면 `GET`을 사용하자.
        - 그 이유는 `캐싱!`

### PUT

- 리소스가 없으면 새로운 리소스를 생성하고, 리소스가 있으면 리소스를 완전히 대체한다. (덮어버린다.)
- POST와의 유일한 차이점은 PUT은 클라이언트가 리소스의 위치를 알고 URI를 딱 지정한다. ex) /members/100
    - 이처럼 클라이언트가 리소스 URI를 알고 관리하는 것을 `스토어(Store)`라고 하며, 스토어는 `/members`가 된다.
- 하지만 POST는 클라이언트가 리소스의 위치를 알지 못하고 자동으로 만들어준다. ex) /members
- 멱등하다.

```json
PUT /members/100 HTTP/1.1
Host: example.com
Content-type: application/json

{
    "name": "minsu",
    "age": 20
}
```

#### ❗ 잠깐 !

리소스를 완전히 대체한다는게 무슨 말일까?

만약 기존 데이터가 아래와 같다고 가정해보자.

```json
{
    "name": "minsu",
    "age": 20
}
```

여기서 PUT 메서드를 사용해서 `age`만 30으로 변경한다면 어떤 일이 벌어질까?

```json
PUT /members/100 HTTP/1.1
Host: example.com
Content-type: application/json

{
    "age": 30
}
```

age만 수정하면 되기 때문에 json 데이터는 age만 넘겨서 30으로 변경했다.

그러면 PUT의 완전히 대체된다는 특징 때문에 `name`이라는 필드는 없어지고 `age`만 남게됩니다.

만약 내가 회원가입을 하고 회원수정을 나이만 수정하고 싶은데 PUT 메서드를 사용하게 되면 나의 아이디, 비밀번호, 이메일... 이러한 중요한 정보들을 모두 잃을 수 있다. 😨

### PATCH

내가 의도한대로 리소스의 부분만 수정되게 하려면 바로 `PATCH`를 사용하면 된다.

```json
PATCH /members/100 HTTP/1.1
Host: example.com
Content-type: application/json

{
    "age": 30
}
```

그러면 위와 같이 age만 30으로 변경해도 데이터는 `name`과 `age` 모두 그대로 남게된다.

- **PATCH는 멱등이 되도록 할 수 있고, 멱등이 안되게 할 수도 있다.**
- 예를 들어보자.
- 참고: https://www.inflearn.com/questions/110644

```json
{
    "age": 22
}
```

이것은 멱등이다.

하지만 아래는 멱등이 아니다.

```json
{
    "age": 22,
    "calc": add,
    "plusNumber": 1
}
```

이것은 계속 메서드를 수행할 때마다 `+1` 더하는 수행을 한다고 했을 때 age의 값이 변한다.

### DELETE

- 지정한 리소스를 삭제
- 멱등하다.

```json
DELETE /members/100 HTTP/1.1
Host: example.com
```

### 정리 (POST, PUT, PATCH)

- POST는 리소스의 위치를 알지 못해도 자동으로 생성해준다.
- PUT은 리소스의 위치를 알고 있고, 기존 리소스를 삭제하고 완전히 대체하기 때문에 중요한 데이터는 PUT을 사용하면 안된다.
- 중요한 데이터를 부분 수정하려면 PATCH를 사용한다.

<br>
<br>
<br>

## 클라이언트에서 서버로 데이터 전송

클라이언트에서 서버로 데이터를 전송하는데 크게 두 가지가 있다.

- 쿼리스트링을 통한 데이터 전송
    - GET
- 메시지 바디를 통한 데이터 전송
    - POST, PUT, PATCH

-> 자세한 내용은 [강의](https://www.inflearn.com/course/http-%EC%9B%B9-%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC#)에서 `HTTP 메서드 활용편`을 보도록 하자.

<br>
<br>
<br>

## 상태코드

```
HTTP/1.1 200 OK
Content-Type: text/html;charset=UTF-8
    
...
```

HTTP 응답 메시지를 보며 `200 OK`라는 것이 있다. 이게 바로 **상태코드**다.

상태코드란 클라이언트가 보낸 요청에 서버가 응답할 때 성공하는 경우, 실패하는 경우를 상태코드로 확인이 가능하다.

## 2xx

클라이언트의 요청이 성공할 때

- 200 OK : 클라이언트의 요청이 정상적으로 처리되었음
- 201 Created : POST로 요청을 보내면 리소스 URI를 서버에서 생성됨
- 204 No Content : 서버가 클라이언트로부터 요청을 받고 응답할 때 메시지 바디에 보낼 데이터가 없음

## 3xx

클라이언트의 요청이 완료되려면 브라우저에서 별도로 추가 조치를 해주어야 한다. -> 리다이렉션

### 301 Moved Permanently (영구적으로)

사용자가 이벤트 페이지로 이동하기 위해 `GET /event/open`를 요청해야 한다고 가정하자.

하지만 기존 이벤트 페이지 리소스가 `GET /event/new-open`로 바뀌면서 사용자는 새로운 이벤트 페이지 위치는 모르고 전에 있던 이벤트 페이지를 접속하려고 하니 접속이 안된다.

하지만 `301` 상태코드가 있으면 `GET /event/open`로 요청할 때 `GET /event/new-open` 이 리소스로 리다이렉트 시켜준다. 이는 이전 리소스 URI를 사용하면 안된다는 의미이다.

이것을 **영구 리다이렉션**이라고 한다. 

> 301로 인해 새로운 리소스 URI로 리다이렉트될 때 이 때는 GET 요청을 하게 된다. (그리고 메시지 바디에 있는 데이터도 없어진다.)

### 302 Found

리다이렉트시에 요청 메서드가 GET으로 변경되고 메시지 바디의 데이터가 없어진다.

이를 **일시적인 리다이렉션**이라고 한다.

영구 리다이렉션과 차이점이 없는 것 같지만 영구 리다이렉션은 영구적으로 새로운 URI로 리다이렉트되는거고, 일시 리다이렉션은 내가 게시글 작성을 완료한 후에 상세화면으로 일시적으로 리다이렉트될 때 사용한다. 

일시 리다이렉션의 대표적인 예로 **PRG(Post/Redirect/Get)**가 있다.

흔한 예제로 게시글 등록 화면으로 가서 게시글을 POST로 등록을 완료했다고 가정하자.

```json
POST /save HTTP/1.1
Host: localhost:8080

{
    "content": "HI",
    "author": "minsu"
}
```

만약에 리다이렉트를 안하고 등록이 완료된 상태에서 **새로고침**을 누르면 또 POST로 게시글이 등록이 된다.(중복발생❗) URI에 그대로 남기 때문이다.

그래서 `302 Found`로 일시적인 리다이렉션을 해주는 것이 좋다. (상세화면 또는 목록화면으로 리다이렉트되면 해결!)

### 304 Not Modified

`304 Not Modified`는 **캐시 목적**으로 사용한다.

클라이언트가 요청했을 때 리소스가 이전에 사용했던거랑 동일하다면 로컬 브라우저에 저장된 캐시를 재사용한다. (**캐시로 리다이렉트한다** 라고 말한다.)

> 304 응답은 로컬 브라우저에 저장된 캐시를 사용하기 때문에 응답 메시지에 메시지 바디를 보내면 안된다.

## 4xx

클라이언트 오류 ❗

- 400 Bad Request : 클라이언트가 잘못된 요청을 하고 있기 때문에 발생하는 상태코드
- 401 Unauthorized : 클라이언트는 특정 리소스에 대한 **인증이 필요**
- 403 Forbidden : 서버가 요청을 이해했지만 **권한으로 인해 거부**
- 404 Not Found : 리소스 자체가 없음

## 5xx

서버 오류 ❗

- 503 Service Unavailable : 서버가 과부하로 다운되서 서비스 이용 불가 될 때

## 4xx 오류와 5xx 결정적 차이

4xx 오류는 클라이언트의 잘못된 요청으로, 클라이언트가 계속 다시 요청을 해도 똑같이 4xx 오류가 발생한다. -> 복구가 불가능하다.

하지만 5xx 오류는 서버 내부 원인 문제라 클라이언트가 재요청을 여러번 했을 때 성공할 가능성이 있다. -> 복구가 가능하다.

그리고 5xx 오류는 서버가 과부하가 된다거나 쿼리에 문제가 생기거나 그럴 때 5xx 오류를 내야지,

자판기에 동전을 넣을 때 `+` 되야하는데 갑자기 `-` 된다고 이를 5xx 오류로 내면 안된다. 즉, 비즈니스 로직으로 된 예외는 5xx 오류를 내지 말자.

<br>
<br>
<br>

## 쿠키

참고: https://developer.mozilla.org/ko/docs/Web/HTTP/Cookies

쿠키는 서버가 사용자의 웹브라우저에 전송하는 **작은 데이터 조각(=쿠키)**을 말한다.

> HTTP의 특징인 Stateless, 즉 무상태 때문에 쿠키를 사용하여 로그인 같은 상태를 유지할 수 있다.

### 쿠키의 문제점

1. 모든 요청에 쿠키가 포함되도록 개발해야 되는 수고로움
2. 브라우저가 완전히 종료되면 쿠키가 사라짐

### 해결

이러한 쿠키의 문제점을 해결하기 위해 **쿠키 헤더**를 사용한다.

1. 클라이언트의 로그인 요청에 서버는 `Set-Cookie` 헤더를 포함해서 응답한다.

```
HTTP/1.1 200 OK
Content-type: text/html
Set-Cookie: username=minsu

<p>minsu 환영!</p>
```

- Set-Cookie : \<cookie-name>=\<cookie-value>
    - 쿠키는 `Key-Value` 형태로 시작한다.
    - 서버에서 클라이언트로 쿠키를 전송하기 위해 사용한다.

2. 클라이언트는 서버로부터 받은 쿠키를 웹브라우저에 있는 **쿠키 저장소**에 저장한다.

![note drawio](https://user-images.githubusercontent.com/55525868/159922091-58931fb9-dad6-43a9-accf-0d7a6a2f0296.png)

3. 이제 클라이언트가 **동일한 서버**에 로그인 요청을 다시 하게 되면 웹브라우저에 저장된 `username=minsu`라는 정보를 `Cookie` 헤더에 담아서 요청하게 된다.

```
GET /sample_page.html HTTP/1.1
Host: www.example.org
Cookie: username=minsu
```

- Cookie: name=value
    - Cookie 헤더 역시 `Key-Value` 형태이고,
    - `Set-Cookie` 헤더와 함께 서버에 의해 이전에 전송되어 저장된 정보이다.

이렇게 쿠키를 사용하게 되면 모든 요청에 쿠키 정보를 자동으로 포함하게 된다. -> 로그인 유지

하지만 모든 요청에 쿠키 정보를 넣게 되면 **보안에 문제**가 발생할 수 있다.

그래서 해결 방법은 `Set-Cookie`에 추가적인 정보를 더 전달한다.

```
Set-Cookie: sessionId=a3fWa; Expires=Wed, 21 Oct 2015 07:28:00 GMT; path=/; domain=.google.com; Secure
```

- Expires: 만료일이 지나면 쿠키는 삭제된다.
    - 세션 쿠키: 만료 날짜를 생략하면 웹브라우저 완전히 종료시까지만 유지
    - 영속 쿠키: 만료 날짜를 입력하면 해당 날짜까지 유지
- domain: 쿠키의 스코프 정의. 어떤 URL에 쿠키를 보내야 하는지.
    - 생략시 현재 문서 위치의 호스트 일부를 기본값으로 지정
- path: 쿠키의 스코프 정의. path는 `Cookie` 헤더를 전송하기 위해 요청되는 URL내에 반드시 존재해야 하는 **URL 경로**를 말한다. (일반적으로 `path=/` 루트로 지정)
- Secure: HTTPS 프로토콜에서만 전송이 가능하다.

> 쿠키를 사용하게 되면 쿠키 정보가 무조건 서버에 전송되기 때문에 최소한으로 사용해야 한다. (트래픽 발생 주의!)
> 만약 서버에 전송되기를 원하지 않는다면 웹 스토리지 (localStorage, sessionStorage)를 사용하되 민감한 정보는 절대 넣지 않길!

<br>
<br>
<br>

## 캐시

참고: https://developer.mozilla.org/ko/docs/Web/HTTP/Caching

웹사이트와 애플리케이션 성능은 이전에 가져온 리소스들을 재사용함으로써 향상될 수 있다. 이러한 역할을 해주는 것이 `캐시`이고, 웹 캐시는 네트워크 트래픽을 줄여줌으로써 리소스를 보여주는데 필요한 시간을 단축시킨다.

### 캐시 기본 동작

![note drawio (1)](https://user-images.githubusercontent.com/55525868/160111868-26ac59c3-6f65-4cd7-adfa-760792f7324b.png)

**먼저 클라이언트가 서버에 처음 요청을 하게 되면 서버로부터 필요한 리소스들은 무조건 다운로드 받아야됨을 인지하자.**

1. 클라이언트가 새로운 리소스를 서버에 요청한다.
2. 서버는 응답할 때 헤더에 `cache-control`을 추가해서 요청에 대한 리소스 `style.css`를 응답해준다.

```
GET HTTP/1.1 200 OK
Content-Type: text/css
cache-control: max-age=60

style.css
```

3. 웹브라우저 캐시에 `style.css`를 저장하고, `max-age`가 60이면 웹브라우저에 저장된 캐시 60초동안 유효하다는 뜻이다.
4. 이제 클라이언트가 같은 리소스를 재요청하게 되면 일단 브라우저 캐시부터 찾은 후에 있으면 그 리소스를 바로 띄우는 형태다.

하지만 `max-age`의 시간이 끝나면 다시 요청해서 다운로드 받아야된다.

만약 같은 리소스를 요청했는데 유효 시간이 만료되었다고 또 다운로드받는 것이 과연 효율적인가?

이것을 해결하기 위해 HTTP 응답 메시지에 **검증 헤더**인 `Last-Modified`가 추가된다.

### Last-Modified

영어 그대로 마지막으로(최근에) 수정된 날짜와 시각을 말한다. 이는 저장된 리소스가 이전과 같은지 **유효성 검사자**로 사용된다. 

```
GET HTTP/1.1 200 OK
Content-Type: text/css
cache-control: max-age=60
Last-Modified: Fri, 25 Mar 2022 07:28:00 GMT

style.css
```

그러면 브라우저에 저장된 데이터(style.css)의 최종 수정일은 **2022년 3월 25일 금요일 7시 28분**이다.

자, 이제 `max-age`의 유효시간이 지나고 똑같은 요청을 한다고 가정해보자. 요청할 때 브라우저 캐시를 찾아서 `Last-Modified`가 있는지 확인하고 있으면 요청할 때 다음과 같이 요청 메시지를 보낸다.

```
GET style.css
if-modified-since: Fri, 25 Mar 2022 07:28:00 GMT
```

요청할 때 위와 같은 HTTP 요청 메시지에 `if-modified-since`라는 헤더를 같이 보내준다.

그래서 **Last-Modified의 날짜와 if-modified-since의 날짜를 서로 비교**해서 같으면 서버는 다음과 같이 응답 메시지를 보낸다.

```
GET HTTP/1.1 304 Not Modified
Content-Type: text/css
cache-control: max-age=60
Last-Modified: Fri, 25 Mar 2022 07:28:00 GMT

(없음)
```

**수정되지 않았다고 상태코드를 `304 Not Modified`로 보낸다.**

**그리고 중요한 것은 HTTP 메시지 바디를 보내지 않는다는 것이다.** 이러면 네트워크의 부하를 크게 줄일 수 있는 것이다.

## 캐시 제어

### Cache-Control 헤더

- Cache-Control: max-age -> 캐시 유효 시간, 초 단위
- Cache-Control: no-cache -> 데이터는 캐시하지만 유효성을 확인하기 위해 **원 서버(origin)**로 요청한다.
    - 유효성이란, `if-modified-since` 같은 **조건부 요청**을 해서 **검증 헤더**인 `Last-Modified`의 날짜를 서로 비교하고 같으면 `304 Not Modified` 상태코드를 응답한다.
- Cache-Control: no-store -> 데이터에 민감한 정보가 있으므로 저장하면 안된다. 따라서 요청시 매번 리소스를 다시 다운로드 받아야 한다.

> 원 서버(origin): 원래의, 진짜 서버를 의미한다.
> 예를 들어, 원서버가 호주에 있고, 한국에 있는 내가 요청하려고 하면 중간에 **프록시 캐시 서버**가 있다.
> 그러면 프록시 캐시 서버에 한국 어딘가에 요청 리소스를 저장해놓고 내가(웹브라우저) 요청하면 원서버에서 응답을 받는 것이 아니라 프록시 캐시 서버에서 응답을 받는다. 이러면 사용자는 빠르게 응답받을 수 있게 된다.

### Pragma

- Pragma: no-cache -> HTTP/1.0의 하위호환으로 `Cache-Control: no-cache`와 동일한 역할을 수행하고 HTTP/1.0에 대응할 수 있도록 사용한다.

## 캐시 무효화

만약 어떤 페이지는 절대 ❗ **캐시되면 안돼!** 라고 하면 확실하게 캐시를 무효화시켜야 한다.

예를 들어, 내 통장잔고를 보여주는 페이지 -> 통장잔고처럼 중요한 정보는 캐시되면 안된다.

다음 2가지 헤더를 쓰면 캐시 무효화가 된다.

- Cache-Control: no-cache, no-store, must-revalidate
- Pragma: no-cache

통장잔고가 왜 캐시되면 안되는지 보면 `must-revalidate`의 특징을 보면 알 수 있다.

`no-cache`의 경우는 원서버로 요청해서 검증을 한다고 했다. 여기서 한가지 더 특징은 원서버로 요청할 때 먼저 중간에 **프록시 캐시 서버**가 있다고 했는데,

![note drawio (2)](https://user-images.githubusercontent.com/55525868/160122201-08359eb5-59c9-4d50-a63b-ab093abe052d.png)

위 그림처럼 프록시 캐시 서버와 원 서버에 네트워크가 단절이 되면 프록시 캐시 서버는 그래도 전에 있던 데이터를 찾아서 `200 OK` 응답을 내린다.

하지만 **must-revalidate** 같은 경우는 no-cache와 비슷하게 원서버로 요청해서 검증을 하지만 이 때 네트워크가 단절이 되면 아에 그냥 `504 Gateway timeout`이라는 오류 상태코드를 보낸다.

![note drawio (3)](https://user-images.githubusercontent.com/55525868/160122214-0b8d0fcd-6f1e-45e5-b2a1-7b648d6e6688.png)

이러면 오류가 발생해도 통장잔고같은 중요한 데이터를 아에 보내지 않는다. 그래서 `must-revalidate`까지 꼭 추가해주어야 한다.

<br>

## 끝으로

강의를 들으면서 뭔가 항상 어려웠던 HTTP에 대해서 많이 이해가 되었고, 알듯말듯한 REST API에 대해서도 도움이 많이 되었다. [HTTP 완벽가이드](http://www.yes24.com/Product/Goods/15381085)란 책도 구매해서 공부해봐야겠다!

<br>
<br>
<br>

## References

- https://www.inflearn.com/course/http-%EC%9B%B9-%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC#
- *https://ko.wikipedia.org/wiki/%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC_%ED%8C%A8%ED%82%B7*
- [https://hahahoho5915.tistory.com/15](https://hahahoho5915.tistory.com/15)
- *https://hanamon.kr/%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC-%EA%B8%B0%EB%B3%B8-url-uri-urn-%EC%B0%A8%EC%9D%B4%EC%A0%90/*
- *https://hihighlinux.tistory.com/73*
- [https://gmlwjd9405.github.io/2018/09/21/rest-and-restful.html](https://gmlwjd9405.github.io/2018/09/21/rest-and-restful.html)
- [https://restfulapi.net/resource-naming/](https://restfulapi.net/resource-naming/)
- [https://developer.mozilla.org/ko/docs/Web/HTTP/Methods](https://developer.mozilla.org/ko/docs/Web/HTTP/Methods)
- [https://www.inflearn.com/questions/110644](https://www.inflearn.com/questions/110644)
- [https://developer.mozilla.org/ko/docs/Web/HTTP/Cookies](https://developer.mozilla.org/ko/docs/Web/HTTP/Cookies)
- [https://developer.mozilla.org/ko/docs/Web/HTTP/Caching](https://developer.mozilla.org/ko/docs/Web/HTTP/Caching)