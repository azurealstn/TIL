# 9주차 과제: 예외 처리

## 목표

자바의 예외 처리에 대해 학습하세요.

<br>

## 학습할 것

- 자바에서 예외 처리 방법 (try, catch, throw, throws, finally)
- 자바가 제공하는 예외 계층 구조
- Exception과 Error의 차이는?
- RuntimeException과 RE가 아닌 것의 차이는?
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
<br>
<br>

## References

- https://imasoftwareengineer.tistory.com/86
