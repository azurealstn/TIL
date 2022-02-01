# 목표
자바의 예외 처리에 대해 학습하세요.

# 학습할 것 (필수)

- 자바에서 예외 처리 방법 (try, catch, throw, throws, finally)
- 자바가 제공하는 예외 계층 구조
- Exception과 Error의 차이는?
- RuntimeException과 RE가 아닌 것의 차이는?
- 커스텀한 예외 만드는 방법

# 자바에서 예외 처리 방법 (try, catch, throw, throws, finally)
우리가 자바 문법에 맞지 않게 코딩을 작성하고 컴파일하면 당연히 에러가 날 것이다.
또한 문법에 맞게 작성을 했더라도 어떤 환경 설정이나 라이브러리가 꼬인다거나 아니면 스택오버플로우 났다거나 해도 에러를 발생시킬 것이다.

이렇게 예상치 못한 에러가 발생이 나면 그에 대한 대처를 해주어야 한다.
예를 들어 에러가 났다면 왜 에러가 났는지 알아야 하며, 이를 위해서는 `로그`를 남겨야 한다.

즉, 예외가 발생할 것 같은 곳에 `return`시켜준다거나 아니면 `로그`를 남겨서 어떤 곳에서 에러가 났는지 알고, 그것을 대처 가능하게 해야할 것이다.

```java
예외 처리 문법
try {
	//기본적인 로직 수행
} catch(err1) {
	err1 //예외가 발생하여 처리한다.
}
...
finally {
	//예외가 발생했건 안했건 맨 마지막에 무조건 실행된다.
}
```

`catch`와 `finally` 블록은 선택적인 옵션으로 반드시 사용할 필요는 없다.

```java
일반적인 사용 예시
1. try / catch
2. try / finally
3. try / catch / ... / finally
```

# 자바가 제공하는 예외 계층 구조

![캡처](https://user-images.githubusercontent.com/55525868/108193886-4b0b6c80-7159-11eb-80f1-249332b87b82.PNG)

					[참고 - https://reference-m1.tistory.com/246]

# RuntimeException과 RE가 아닌 것의 차이는?

자바에서 예외는 두 가지로 나눌 수 있다. (checked:빨간색, unchecked:하늘색)
`RuntimeException`을 상속하지 않는 예외들을 말한다.
쳬크 예외가 발생할 수 있는 메소드를 사용할 경우에는, 반드시 예외 처리를 해주어야 하는데 `catch 문`이나 `throws`로 해주면 되겠다.

만약 이 때 해결해주지 않으면 컴파일 시에 `체크 예외`가 발생하게 된다.

> 체크 예외는 Java 컴파일러와 JVM이 규칙을 준수하는지 확인하기 때문에 Exception이 호출된다.
> Exception - IOException, SQLException

---

다음으로 언체크 예외는 `RuntimeException`을 상속한 예외들을 말하는데, 이 **예외 처리를 강제하지 않기 때문에** 따로 `catch 문`이나 `throws`로 처리하지 않아도 된다.

> 프로그램에 에러가 있을 때 이를 발생하도록 의도한 것이다.
> Exception - NullPointerException, IllegalArgumentException

- 런타임(JVM 구동)시 예외가 발생하는 것이 언체크 예외
- 실행하지 않고 예외가 발생하는 것이 체크 예외

```java
try {
	System.out.write(list); //에러 발생
} catch (Exception e) {
	e.printStackTrace();
} catch (IOException e) {
	e.printStackTrace();
}
```

위의 코드는 `try 문`에 에러가 발생하여 예외 처리를 하게 되는데 먼저 첫 번째 `catch 문`부터 수행을 하게 된다. 그런데 `IOException` 클래스는 `Exception`의 자식 클래스이므로, 첫 번째 블록에서도 `IOException`을 처리할 수 있다.
따라서 위의 코드는 예외 처리를 언제나 첫 번째 `catch 문`에서만 처리를 하게 된다.
(즉, 두 번째 catch 블록은 영원히 실행 불가상태다.)

이를 고치려면 아래와 같이 코드를 변경해주면 된다.

```java
try {
	System.out.write(list); //에러 발생
} catch (IOException e) {
	e.printStackTrace();
} catch (Exception e) {
	e.printStackTrace();
}
```

**먼저 자식 클래스를 실행**시켜주면 된다.
즉, 좁은 범위의 예외 처리를 먼저하고 그 다음에 넓은 범위의 예외 처리를 실행시켜주면 된다.

그리고, 위와 같이 예외 처리가 다중일때는 `|`으로 해결할 수 있다.

```java
try {
	System.out.write(list); //에러 발생
} catch (IOException | Exception e) { //이것도 순서 지켜줘야 한다.
	e.printStackTrace();
}
```

# Exception과 Error의 차이는?

- Exception: 컴퓨터 시스템의 동작중에 예기치 못한 상태가 발생하여 수행 중인 프로그램에 영향을 받는 것이다. 예를 들어 스택오버플로우 같은,...
- Error: 컴파일 시 문법적인 에러와 런타임 시 참조와 같은 에러로 프로세스에 영향이 크게 받아서 프로세스가 종료된다.

즉, **Error의 상황을 미리 방지하기 위해 Exception을 사용하는 것이다!**

위험도: Error > Exception

[참고 - https://drcarter.tistory.com/153]

# 커스텀한 예외 만드는 방법
자바에서는 Exception 클래스를 상속 받아서 자신만의 예외 클래스를 정의할 수도 있다.

```java
Exception 클래스 대신 예외 처리를 강제하지 않는 RuntimeException를 상속받아 작성하는 경우가 대부분.
class MyException extends RuntimeException {
	MyException(String errMsg) {
		super(errMsg);
	}
}
```

## try-with-resources 문

```java
Java 7부터 지원
try (파일을 열거나 자원을 할당하는 명령문) { ... }
```

위와 같이 작성하면 `try 문`이 끝나자마자 **자동을 파일을 닫거나 할당된 자원을 해제시켜준다.**

```java
static String readFile(String filePath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        try {
            return br.readLine();
        } finally {
            if (br != null) br.close();
        }
    }
```

원래는 위와 같이 `finally 문`까지 사용해서 **파일을 닫아주어야 한다.**
하지만, `try-with-resources 문`을 사용하면 **자동으로 파일을 닫아 준다.**

```java
static String readFile(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            return br.readLine();
        }
    }
```
