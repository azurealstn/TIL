# 9주차 과제: 예외 처리

## 목표

자바의 예외 처리에 대해 학습하세요.

<br>

## 학습할 것

- 자바에서 예외 처리 방법 (try, catch, throw, throws, finally)
- 자바가 제공하는 예외 계층 구조
- Exception과 Error의 차이는?
- RuntimeException과 RuntimeException이 아닌 것의 차이는?
- 커스텀한 예외 만드는 방법

<br>
<br>
<br>

## 자바에서 예외 처리 방법 (try, catch, throw, throws, finally)

프로그램을 개발할 때 예외 처리는 필수적입니다. 프로그램이 돌다가 런타임 에러가 발생하면 프로그램이 죽을 수도 있습니다.  
그래서 이러한 에러를 미연에 방지하는 것이 목적입니다. 즉, 예외 처리를 통해 방지할 수 있습니다.

<br>

### try ~ catch ~ finally

가장 많이 사용한 예외문이 `try ~ catch ~ finally` 입니다.  
`try ~ catch ~ finally`문은 Jsp, db 연동할 때 정말 많이 사용했습니다.  
DB Connection 객체 연결해서 `Statement`나 `PreparedStatement`를 사용해서 쿼리문을 생성해서 마지막에는 이 객체들을 꼭 `close()` 해줬어야 했습니다.  
여기서 일어나는 예외들을 처리해주기 위해 `try ~ catch ~ finally`문을 사용했습니다.

<br>

`try ~ catch ~ finally`문은 `try` 블록 안에서 정상적인 로직을 수행하다가 에러가 발생하면 `catch` 블록 안에서 에러를 처리할 수 있습니다. 또한 `try` 블록 안에서 에러가 발생한다면 나머지 코드는 실행하지 않고 바로 `catch`로 넘어갑니다.

<br>

`finally` 블록은 `try-catch`문이 끝나고 마지막에 반드시 실행됩니다.

```java
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.endingWithSentence(null));
    }

    public boolean endingWithSentence(String sentence) {
        try {
            return sentence.endsWith(";");
        } catch (NullPointerException e) {
            System.out.println("예외 발생!");
        } finally {
            mustRun();
        }
        return false;
    }

    private void mustRun() {
        System.out.println("이 메소드는 무조건 실행되어야 합니다.");
    }
}
```

`endingWithSentence` 메소드는 `sentence` 파라미터 문장이 맨 끝에 `;`으로 끝나는지 boolean 타입으로 리턴해줍니다.

<br>

`endingWithSentence` 메소드의 파라미터에 "try문 실행;" 실행 결과

```
이 메소드는 무조건 실행되어야 합니다.
true
```

`endingWithSentence` 메소드의 파라미터에 null 실행 결과

```
예외 발생!
이 메소드는 무조건 실행되어야 합니다.
false
```

- 문장에 `;`로 끝나면 정상적으로 코드가 실행되므로 `try`문 블록안에서 끝나게 되며 `true`가 반환됩니다.
- 문장에 null을 넣으면 값을 제대로 알 수 없어 NullPointerException 예외가 발생합니다. 따라서 `catch`문 블록내에서 로직을 수행합니다.
- 마지막으로 정상적으로 실행되든 에러가 발생하든 `finally`문 블록 내의 로직이 수행됩니다.

<br>

또한 catch문을 여러 개를 작성할 수 있습니다. 예를 들어, 예외 클래스별로 다르게 수행되게 하고 싶다면 다중 catch를 작성하면 됩니다. catch문이 여러 개라 해도 해당되는 단 하나의 catch 블록만 실행이 됩니다. 여기서 주의할 점이 있습니다.

```java
package com.azurealstn.sociallogin;

public class Main {
    public static void main(String[] args) {
        try {
            String[] fruit = {"apple", "banana"};
            System.out.println(fruit[4]);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

위 코드에서 주의할 점은 catch문의 순서입니다. 만약 다중 catch를 사용한다고 하면 반드시 상위 예외 클래스가 하위 예외 클래스보다 아래쪽에 위치해야 한다는 점입니다.  
그 이유는 가장 먼저 첫 번째 catch문부터 읽게 되는데 이때 첫 번째에 최상위인 Exception 클래스를 사용하게 되면 나머지 catch문은 무시됩니다.  
하지만 다행히도(?) 상위 예외 클래스를 위에다가 작성할 때는 컴파일 에러를 발생하니 수정하시면 됩니다.

<br>

### try ~ catch ~ resource

원래 try문에서 자원 객체를 전달하면 반드시 finally해서 자원을 해제 해줘야 메모리 낭비가 나지 않습니다. 하지만 매번 finally문을 사용하는 것도 번거로운 일입니다.

<br>

Java 7부터 추가된 `try-catch-resource`를 쓰면 자동으로 자원을 해주는 역할을 수행합니다.  
즉, 따로 finally문을 작성하지 않아도 됩니다.

```java
package com.azurealstn.sociallogin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(System.in);
            int num = sc.nextInt();
            for (int i = 0; i < num; i++) {
                if (num % 2 == 0) {
                    System.out.println(num);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sc != null) sc.close();
        }
    }
}
```

위 코드는 `try-catch-finally`를 이용하여 작성한 코드입니다. 만약 자원을 해제해야 할 객체가 여러 개가 있다면 모두 해제시키는 코드를 일일이 작성해주어야 합니다. 하지만 `try-catch-resources`를 사용하면 코드가 좀 더 깔끔하게 보일 수 있습니다.

```java
public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int num = sc.nextInt();
            for (int i = 0; i < num; i++) {
                if (num % 2 == 0) {
                    System.out.println(num);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

try 괄호() 안에 자원을 할당할 객체를 선언만 해주면 됩니다. 그러면 자동으로 자원을 해제할 수 있습니다.

<br>

### throw & throws

`throw`와 `throws` 키워드 둘 다 Exception을 발생시킨다는 공통점이 있습니다.  
잠시 코드를 보겠습니다.

### FoolException Class

```java
package com.azurealstn.sociallogin.Exception;

public class FoolException extends RuntimeException {
}
```

<br>

### Main Class

```java
package com.azurealstn.sociallogin;

import com.azurealstn.sociallogin.Exception.FoolException;

public class Main {
    public void sayNick(String nick) {
        if ("fool".equals(nick)) {
            throw new FoolException();
        }
        System.out.println("저의 별명은 " + nick + "입니다.");
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.sayNick("fool");
        main.sayNick("genius");
    }
}
```

위 코드를 실행하면 `throw` 키워드로 예외를 던졌기 때문에  `FoolException` 예외가 발생합니다. `throw` 위에 보는 것처럼 `throw new` 해서 예외 객체를 생성하면 됩니다. 또한 `FoolException` 클래스는 `RuntimeException` 클래스를 상속받았습니다.

<br>

Exception 클래스는 크게 두 가지로 구분됩니다.

- RuntimeException : 실행 시 발생하는 예외
- Exception : 컴파일 시 발생하는 예외

즉, Exception은 프로그램 작성 시 이미 예측가능한 예외를 작성할 때 사용하고 RuntimeException은 발생할 수도 발생 안 할 수도 있는 경우에 사용합니다. 또한 Exception을 Checked Exception, RuntimeException을 Unchecked Exception이라고도 합니다. 이는 예외 계층 구조에서 좀 더 살펴봐야할 문제입니다.

<br>

이번에는 `Exception`을 상속받도록 하겠습니다.

### FoolException Class

```java
package com.azurealstn.sociallogin.Exception;

public class FoolException extends Exception {
}
```

그러면 `Main` 클래스에서 컴파일 에러가 발생합니다. `Exception`은 예측 가능한 `Checked Exception`이기 때문에 예외처리를 컴파일러가 강제하기 때문입니다. 예측 가능하기 때문에 `try-catch`문으로 변경해줘야 합니다.

### Main Class

```java
package com.azurealstn.sociallogin;

import com.azurealstn.sociallogin.Exception.FoolException;

public class Main {
    public void sayNick(String nick) {
        try {
            if ("fool".equals(nick)) {
                throw new FoolException();
            }
            System.out.println("저의 별명은 " + nick + "입니다.");
        } catch (Exception e) {
            System.err.println("FoolException 발생!!");
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.sayNick("fool");
        main.sayNick("genius");
    }
}
```

<br>

`try-catch`를 사용하지 않고 메소드에 `throws` 키워드로 예외를 던지는 방법이 있습니다.

### Main Class

```java
public void sayNick(String nick) throws Exception {
if ("fool".equals(nick)) {
throw new FoolException();
}
System.out.println("저의 별명은 " + nick + "입니다.");
}
```

위 코드처럼 호출하는 메소드명 옆에 `throws 예외클래스`를 작성하면 에러가 사라집니다.  
하지만 `main` 메소드에서 컴파일 에러가 발생할 것입니다. 그 이유는`throws` 키워드 때문에 예외를 처리해야 하는 대상이 `sayNick()`에서 `main()`으로 변경되었기 때문입니다.

```java
public static void main(String[] args) throws Exception { //컴파일 에러 해결
    Main main = new Main();
    main.sayNick("fool");
    main.sayNick("genius");
}
```

<br>

여기서 만약 `try-catch`문을 `sayNick()` 여기서 처리하는 것이 좋을 것인가.  
아니면 `main()`에서 처리하는 것이 좋을 것인가.  

<br>

둘 의 차이는 있습니다.

만약 `sayNick()`에서 처리를 하게 된다면 아래 코드가 모두 실행이 됩니다.

```java
main.sayNick("fool"); //예외 발생
main.sayNick("genius");
```

하지만 `main()`에서 처리를 하게 된다면 위 코드에서 `main.sayNick("fool");` 여기서 예외가 발생하므로 그대로 `catch`문이 실행됩니다.

<br>

예외를 처리하는 위치에 따라 실행결과도 달라지기 때문에 매우 중요합니다. 이는 `transaction`과도 밀접한 관련이 있기 때문에 매우 중요합니다.

<br>

위에서 설명한 **자바에서 예외 처리 방법 (try, catch, throw, throws, finally)**을 좀 더 자세히 알고 싶으시다면 https://wikidocs.net/229 여기를 꼭 보세요! 위의 예제는 모두 이 사이트에서 확인을 했답니다.

<br>
<br>
<br>

## 자바가 제공하는 예외 계층 구조

![예외계층구조](https://user-images.githubusercontent.com/55525868/136878755-c34eb502-2a96-4e79-8f58-4b887d08ccf6.JPG)

자바에서의 예외 계층 구조는 위의 사진처럼 되어있습니다.  
보통 많이 사용하는 것이 `Exception`이고, 그 밑에 자식 클래스로 좀 더 세부적인 예외 클래스들이 있습니다. 예를 들어 `RuntimeException`에 속한 예외 클래스들은 주로 프로그래머의 실수로 인해 발생하는 예외들입니다. (배열의 인덱스가 벗어났을 때 `IndexOutOfBoundsException` 예외가 발생한다던가, 정수를 0으로 나누려 했을 때 `ArithmeticException` 예외가 발생한다던가 등등..) 그 외의 예외 클래스들은 주로 외부의 영향으로 발생할 수 있는 것들로서, 프로그램을 사용하는 사용자들의 동작에 의해 발생하는 경우가 많습니다.

- RuntimeException : 주로 프로그래머의 실수로 인해 발생
- 그 외의 Exception : 주로 사용자의 실수와 같은 외적인 요소에 의해 발생

### Checked & Unchecked

위에서 잠깐 언급했지만 Exception은 `checked`와 `unchecked`로 구분됩니다.  
빨간색 : checked Exception  
파란색 : unchecked Exception

<br>

#### Checked Exception

Checked Exception은 RuntimeException을 상속받지 않은 예외들을 말하며, 예측 가능한 예외들을 말합니다. 예측이 가능하다는 건 런타임이 아닌 컴파일타임에 에러를 발생시킨다는 의미입니다.  
즉, Checked Exception은 `catch`문으로 예외를 잡거나 `throws`로 예외를 자신을 호출한 클래스로 던지는 방법으로 해결해야 합니다. 그래야 컴파일 에러가 발생하지 않습니다.

<br>

#### UnChecked Exception

UnChecked Exception은 Checked Exception과 반대로 RuntimeException을 상속받은 예외들을 말하며, 발생할 수도 안 할 수도 있기 때문에 컴파일타임이 아닌 런타임에 에러를 발생시킵니다. 이것이 가능한 이유는 명시적으로 예외 처리를 강제하지 않기 때문입니다. 즉, UnChecked Exception은 `catch`나 `throws`를 선언하지 않아도 됩니다.

<br>

우리가 프로그램을 작성할 때 NullPointerException이나 IndexOutOfBoundsException와 같은 에러가 자주 발생하는 이유는 Null값이나 배열의 인덱스 범위를 고려안하고 프로그래밍하기 때문에 런타임시에 이런 에러를 자주 만나게 됩니다.

<br>
<br>
<br>

## Exception과 Error의 차이는?

위 그림에서 상위 클래스에서 Exception은 알겠는데 Error와 차이는 무엇인지 궁금할 수 있습니다.

### 오류(Error)

흔히 에러는 프로그램을 사용하다가 프로그램이 비정상적으로 종료되는 결과를 초래하는 원인을 말합니다.

<br>

오류가 발생했을 경우에는 개발자가 따로 할 수 있는 것이 없습니다.  
메모리 부족, 스택오버플로우 같은 JVM이나 하드웨어 등의 기반 시스템의 문제로 발생하는 것이기 때문이죠.

<br>

### 예외(Exception)

위의 오류와 반대로 개발자가 미리 적절하게 예외 처리 코드를 작성해서 비정상적으로 종료되지 않게 예방할 수 있는 게 핸들링 해주는 것이 예외입니다.

<br>
<br>
<br>

## RuntimeException과 RuntimeException이 아닌 것의 차이는?

이 부분은 앞에서 이미 설명한 부분입니다.  
다시 한번 정리하자면 RuntimeException과 RuntimeException이 아닌 것의 차이는 Checked Exception과 UnChecked Exception 입니다.

- RuntimeException과 그 하위 예외 클래스들은 모두 Unchecked Exception 입니다. 런타임에 발생하는 에러입니다. 개발하면서 예외가 발생하지 않도록 주의하는 것이 좋습니다. 만약 예외가 발생하면 트랜잭션 rollback을 수행합니다.
- 반대로 RuntimeException이 아닌 것은 Checked Exception 입니다. 컴파일타임에 발생하는 에러입니다. 이 때는 `try-catch`문을 이용하여 예외처리를 작성할 수 있습니다. 만약 예외가 발생하면 트랜잭션 rollback을 수행하지 않습니다.

<br>
<br>
<br>

## 커스텀한 예외 만드는 방법

위에서 커스텀한 예외를 만들었습니다. 바로 `FoolException` 클래스 입니다.  
이처럼 `Exception`, `RuntimeException` 등등의 클래스를 상속받고 나만의 예외 클래스를 커스텀하면 그게 커스텀한 예외 클래스입니다.

```java
package com.azurealstn.sociallogin.Exception;

public class FoolException extends Exception {

    public FoolException(String s) {
        super(s);
    }
}
```

<br>
<br>
<br>

## References

- https://imasoftwareengineer.tistory.com/86
- https://wikidocs.net/229
- https://reference-m1.tistory.com/246
- https://finewoo.tistory.com/22
- https://wisdom-and-record.tistory.com/46
- https://soozl91.tistory.com/52
