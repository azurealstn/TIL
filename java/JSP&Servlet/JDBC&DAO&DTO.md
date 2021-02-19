# JDBC

![캡처](https://user-images.githubusercontent.com/55525868/108510026-5bf6e200-7301-11eb-87a0-13694b6b2f12.PNG)

[참고 - https://url.kr/nguato]

JDBC(Java Database Connectivity)란 Java와 DB가 통신할 수 있게 해주는 하나의 API이다.
지금 오라클 DB를 사용하고 있으므로 오라플 JDBC가 있어야 한다.

> C:\app\azure\product\18.0.0\dbhomeXE\jdbc\lib 폴더안에 오라클 JDBC jar파일이 있다. (ojdbc8_g.jar)
> 이 파일과 eclipse와 연동을 해주어야만 IDE와 함께 사용이 가능하다.

![캡처](https://user-images.githubusercontent.com/55525868/108511010-9c0a9480-7302-11eb-884c-4049acb7e088.PNG)

[참고 - https://url.kr/nguato]

### JDBC 실행 순서

1. 오라클 드라이버를 메모리에 로딩
2. Java와 Oracle 연동
3. 자바에서는 쿼리문을 쓰기 위한 객체 생성
4. 생성한 객체를 가지고 직접 쿼리문을 작성 (String 타입)
5. 마지막으로 쿼리문을 실행

### PreparedStatement

![캡처](https://user-images.githubusercontent.com/55525868/108512618-d5dc9a80-7304-11eb-8474-34add013cb52.PNG)

[참고 - https://url.kr/nguato]

3.번에서 쿼리문을 생성하기 위한 Statement 객체를 만들고, 4.번에서 String 타입으로 쿼리문을 작성한다고 했다.

여기서 쿼리문을 보면 알겠지만 조금 보기에 불편하고 번잡하다.

이를 해결하기 위해 쿼리문을 작성하대 값에 `?`로 넣고,
나중에 conn.preparedStatement 객체의 `setString()` 메소드에다가 그 값을 대신 넣어준다. 이러면 그래도 조금은 타입 세이프하게 작성할 수 있게 된다.
즉, 개발자의 실수를 줄여줄 수 있다.

# DAO & DTO
자바에서 기능을 모듈화 & 세분화 그리고 기능을 분리화시키기 위해 사용하는 것이 `DAO(Data Access Object)`, `DTO(Data Transfer Object)`이다.

![캡처](https://user-images.githubusercontent.com/55525868/108514145-d9712100-7306-11eb-9cc4-01388fac7692.PNG)

[참고 - https://url.kr/nguato]

먼저 `DAO`는 DB에 접근하는 기능을 객체로 모듈화해 놓은 것이다.
그리고 DB에서 정의해놓은 데이터와 Java에서 정의해놓은 데이터는 다를 것이다.
DB에서 정의한 데이터를 Java 형태로 변환해주는 것이 바로 `DTO`라고 한다. 또는 `VO`라고도 한다.
