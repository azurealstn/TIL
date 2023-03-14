# String, StringBuilder, StringBuffer의 차이

Java에서 흔히 문자열을 선언할 때는 아래와 같이 String 타입을 사용한다.

```java
String str = "Hi!";
str = str + " MinSu?"; //연산 작업
```

또한 처음에는 `Hi!`만 할당했지만 추가적으로 뒤에 문자열을 추가하려면 `+ " MinSu?"` 처럼 연산 작업을 수행해야 한다. 이게 많지 않을 때는 크게 이슈가 없어서 상관이 없지만 연산 작업이 많아지면 String 클래스는 치명적인 단점을 가지고 있다. 이 단점을 보완한 것이 바로 StringBuilder와 StringBuffer이다.



## String

먼저 String과 (StringBuilder, StringBuffer)의 가장 큰 차이점은 String은 불변성 특징을 가지고 StringBuilder, StringBuffer는 가변성 특징을 가진다.

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

## StringBuilder와 StringBuffer

앞에서 String은 멀티쓰레드 환경에서 동시성 문제를 신경쓰지 않아도 되는 장점이 있지만 불변의 특징을 가지고 있기 때문에 연산 작업이 빈번하게 발생하면 성능에 치명적인 영향을 끼치게 되는 단점도 존재한다. 따라서 이러한 단점을 극복하기 위해 나온 것이 StringBuilder와 StringBuffer이다.

String은 **불변성**을 가진다면 StringBuilder와 StringBuffer는 **가변성**을 갖는다.

```java
public class StringTest {
    public static void main(String[] args) {
        StringBuilder sbd = new StringBuilder("real");
        sbd.append(" world!");
        System.out.println("sbd = " + sbd); //real world!

        StringBuffer sbf = new StringBuffer("real");
        sbf.append(" world!");
        System.out.println("sbf = " + sbf); //real world!
    }
}
```

![string2](https://user-images.githubusercontent.com/55525868/225041646-4351d85e-252f-4ec3-828a-dce7a83e3ae3.png)

String은 `+` 연산자를 사용하여 문자열을 더했지만 StringBuilder와 StringBuffer는 문자열을 더하려면 StringBuilder 또는 StringBuffer 클래스를 생성하여 `append()` 메서드를 사용하면 된다. 여기서 중요한 점은 연산 작업이 일어날 때 **새로운 메모리 영역에 생성하는 것이 아닌 기존에 참조했던 문자열 값을 변경시킨다.** 따라서 새로운 주소가 아닌 기존 주소를 바라보고 있기 때문에 메모리 낭비가 되지 않는다는 장점이 생긴다. 이를 가변적이라고 한다.

**🎇 문자열 연산작업이 많이 발생하면 String보다는 StringBuilder나 StringBuffer를 사용하자!**

### StringBuilder vs StringBuffer

지금까지 StringBuilder와 StringBuffer 클래스는 같은 기능을 갖는 것 같은데 왜 2개를 구분지을까 고민할 수 있다. StringBuilder와 StringBuffer 클래스의 가장 큰 차이점은 바로 **동시성(동기화) 유무**에 있다.

- StringBuilder : 동시성 문제를 야기시킬 수 있기 때문에 멀티쓰레드 환경에서는 사용하지 않는 것이 바람직하다.
- StringBuffer : 동시성 문제를 해결하기 때문에 멀티쓰레드 환경에서 사용해도 안전하다. (Thread-safe)

**그렇다면 무조건 StringBuffer를 쓰는 것이 더 좋다고 할 수 있겠지만 동시성 문제를 고려하지 않기 때문에 단일쓰레드 환경에서는 StringBuffer보다는 StringBuilder를 사용하는 것이 성능이 더 뛰어난다.**

### 정리

- String : 문자열 연산이 적고, 멀티쓰레드 환경에서 사용
- StringBuilder : 문자열 연산이 많고, 단일쓰레드 환경에서 사용
- StringBuffer: 문자열 연산이 많고, 멀티쓰레드 환경에서 사용

## References

- https://ifuwanna.tistory.com/221