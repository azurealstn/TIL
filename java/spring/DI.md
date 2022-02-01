# DI(Dependency Injection)
먼저 스프링을 배우려면 기본 지식을 알아야 한다.

간단히 설명하면

- **스프링 컨테이너(IOC) : **객체(빈)들을 모아놓은 큰 메모리 공간
- **DI : **의존성 주입.

---

![캡처](https://user-images.githubusercontent.com/55525868/108712100-a4104180-7559-11eb-9a69-1a307fa05395.PNG)

[참고 - http://asq.kr/nyKIRw7ZmS4O1P]

위 사진에서 **배터리 일체형 vs 배터리 분리형**을 비교할 때 당연히 배터리 분리형이 이득일 것이다. 왜나하면 일체형은 배터리가 떨어지면 다시 장난감을 사야하기 때문이다.

### 프로그램 측면
예를 들어, 간단한 계산기 프로그램을 구현했다.
여기서 나눗셈에서 **소수점 둘째자리까지** 객체를 이미 구현했다고 가정하자.
클라이언트는 **소수점 열째자리까지** 표현해달라고 요청을 합니다. 하지만 그 객체는 독립적으로 사용할 수가 없고, 또 다른 객체에 영향을 미칠 수 있는 종속적이라고 가정하면 결국 이 기능을 다시 만들어야하는 수고가 들 것이다.

하지만 배터리 분리형은 기존에 프로젝트 구조를 바꾸지 않아도 그 객체만 수정을 하면 되기 때문에 빠르게 구현하고 더 정확하게 할 수 있다.
좀 더 유연성 있고, 확장성이 좋다고 할 수 있다. (필요없으면 삭제, 수정이 손쉽게)

배터리에 비유한다면 배터리라는 객체에 **의존을 해서 ** 완전한 장난감이 만들어지는 것,
이것을 배터리에 의존한다고 한다. 배터리에 의존해서 주입하는 것, 이를 `DI`라고 할 수 있다.

우리는 알게 모르게 객체 지향 프로그래밍 중 이미 `DI`를 사용하고 있다.
(생성자에서 주입(new), getter & setter 주입 등...)
생성자 주입 같은 경우가 바로 배터리 일체형에 속한다. 객체 안에 객체를 주입하는 것이 `DI`다.

## 생성자를 이용한 의존 객체 주입

```java
public StudentRegisterService(StudentDao studentDao) {
	this.studentDao = studentDao;
}

applicationContext.xml
<bean id="studentDao" class="lec.member.service.studentDao"></bean>
<bean id="registerService" class="lec.member.service.StudentRegisterService">
	<constructor-arg ref="studentDao"></constructor-arg>
</bean>
```

생성자를 이용한 객체 주입은 `constructor-arg` 태그를 이용하면 된다.
`ref` 속성에 해당하는 객체의 `id`값만 넣어주면 된다. 그러면 객체가 스프링 컨테이너에서 생성이 될 때 바로 주입이 되면서 생성된다.

## setter를 이용한 의존 객체 주입

```java
public void setUserId(String userId) {
	this.userId = userId;
}

applicationContext.xml
<bean id="dataBaseConnectionInfoDev" class="lec.member.service.DataBaseConnectionInfo">
	<property name="userId" value="scott"/>
</bean>
```

setter를 이용한 객체 주입은 `property` 태그를 이용하면 된다.

## List타입 의존 객체 주입

```java
public void setDevelopers(List<String> developers) {
	this.developers = developers;
}

applicationContext.xml
<property name="developers">
	<list>
		<value>minsu</value>
		<value>minsu2</value>
		<value>minsu3</value>
	</list>
</property>
```

## Map타입 객체 주입

```java
public void setAdministrators(Map<String, String> administrators) {
	this.administrators = administrators;
}

applicationContext.xml
<property name="administrators">
	<map>
		<entry>
			<key>
				<value>minsu</value>
			</key>
				<value>minsu.org</value>
		</entry>
	</map>
</property>
```
