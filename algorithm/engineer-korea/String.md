# String, StringBuilder, StringBuffer의 차이

Java에서 흔히 문자열을 선언할 때는 아래와 같이 String 타입을 사용한다.

```java
String str = "Hi!";
str = str + " MinSu?"; //연산 작업
```

또한 처음에는 `Hi!`만 할당했지만 추가적으로 뒤에 문자열을 추가하려면 `+ " MinSu?"` 처럼 연산 작업을 수행해야 한다. 이게 많지 않을 때는 크게 이슈가 없어서 상관이 없지만 연산 작업이 많아지면 String 클래스는 치명적인 단점을 가지고 있다. 이 단점을 보완한 것이 바로 StringBuilder와 StringBuffer이다.



## String vs StringBuilder, StringBuffer

먼저 (String)과 (StringBuilder, StringBuffer)의 가장 큰 차이점은 String은 불변성 특징을 가지고 StringBuilder, StringBuffer는 가변성 특징을 가진다.

```java
public class StringTest {
    public static void main(String[] args) {
        String str = "real";
        str = str + " world!";
        System.out.println("str = " + str);
    }
}
```

- String 타입의 str 변수에 "real"을 할당한다.
- str 변수에 문자열 " world!" 를 더한다.

위 작업에서 기존에 str 변수의 문자열인 "real"에다가 " world!" 문자열을 더해서 "real world!"로 변경된 것으로 착각할 수 있다. 하지만 변경된 것이 아닌 새로운 메모리 공간에 생성된 것이다. (아래 그림을 보자.)

![string1](https://user-images.githubusercontent.com/55525868/224702689-a98cbf0e-e72c-4d7f-86be-5e8e88155488.png)

처음에는 `String str = "real";`에 의해 Stack에 str 변수가 저장이 되고, str 변수는 Heap에 있는 "real" 이라는 문자열을 참조하고 있다. 하지만 `str = str + " world!";`에 의해 더 이상 "real" 문자열을 참조하지 않고 새로운 메모리 영역에 "real world!" 문자열을 생성하고 이를 참조하도록 변경했다. 그리고 "real" 문자열을 참조했던 것은 Garbage Collector에 의해 제거 대상이 된다.

String은 `+` 연산 작업이 일어나면 기존에 레퍼런스 하고 있는 값을 바꾸는 것이 아닌 **새로운 메모리 영역에 생성하여 참조한다.**이다. 그래서 String을 불변(immutable)성 특징을 가지고 있다. 따라서 멀티쓰레드 환경에서 동시성 문제를 신경쓰지 않아도 되는 이점이 있다. (**Thread-Safe**) 하지만 위에서 살펴보았듯이 연산 작업이 빈번하게 발생하면 Heap 영역에서 많은 임시 가비지 객체들이 생성되어 힙 메모리 부족으로 웹어플리케이션의 성능에 영향을 끼치게 된다.