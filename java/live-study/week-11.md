# 목표
자바의 열거형에 대해 학습하세요.

# 학습할 것 (필수)

- enum 정의하는 방법
- enum이 제공하는 메소드 (values()와 valueOf())
- java.lang.Enum
- EnumSet

# enum 정의하는 방법

### 열거체 (enumeration type)
JDK 1.5부터 열거체를 정의한 `Enum` 클래스를 사용할 수 있게 됩니다.

열거체의 장점

- 열거체를 비교할 때 실제 값뿐만 아니라 타입까지도 체크한다.
- 열거체의 상수값이 재정의되더라도 다시 컴파일할 필요가 없다.

---

자바에서는 `enum`이라는 키워드를 이용하여 열거체를 정의할 수 있다.

```java
문법
enum 열거체이름 { 상수1이름, 상수2이름, ... }

예제
enum Rainbow {RED, ORANGE, YELLOW, BLUE, VIOLET}

이렇게 정의된 열거체를 사용하는 방법이다.
문법
열거체이름.상수이름

예제
Rainbow.RED
```

위와 같이 정의된 열거체의 첫 번째 상수값은 0부터 설정되며, 그 다음부터는 1씩 증가된다.

또한 불규칙한 상수값을 설정하고 싶다면 다음과 같이 설정이 가능하다.
다만, 불규칙한 값을 설정하기 위해서는 이 값을 저장할 수 있는 인스턴스 변수와 생성자를 추가해야만 한다.

```java
enum Rainbow {
	RED(3), ORANGE(10), YELLOW(21), GREEN(5), BLUE(1), VIOLET(-11);
	
	private final int value;
	Rainbow(int value) { this.value = value; }
	public int getValue { return value; }
}
```

# java.lang.Enum
Enum 클래스는 모든 자바 열거체의 공통된 조상 클래스다.
Enum 클래스에는 열거체를 조작하기 위한 다양한 메소드가 있다.

# enum이 제공하는 메소드 (values()와 valueOf())

### values() 메소드
해당 열거체의 모든 상수를 저장한 배열을 생성하여 반환한다.
이 메소드는 자바의 모든 열거체에 컴파일러가 자동으로 추가해주는 메소드이다.

```java
package azurealstn;

enum Rainbow { RED, ORANGE, YELLOW, GREEN, BLUE, VIOLET }

public class Enum01 {
    public static void main(String[] args) {
        Rainbow[] arr = Rainbow.values(); //배열을 반환한다.
        for (Rainbow bow : arr) {
            System.out.println(bow);
        }
    }
}
```

```
실행결과
RED
ORANGE
YELLOW
GREEN
BLUE
VIOLET
```

### valueOf() 메소드
전달된 문자열과 일치하는 해당 열거체의 상수를 반환한다.

```java
package azurealstn;

enum Rainbow { RED, ORANGE, YELLOW, GREEN, BLUE, VIOLET }

public class Enum01 {
    public static void main(String[] args) {
        Rainbow bow = Rainbow.valueOf("ORANGE");
        System.out.println(bow);
    }
}
```

```
실행결과
ORANGE
```

### ordinal() 메소드
해당 열거체의 상수가 열거체 정의에서 정의된 순서(0부터 시작)를 반환한다.
이 때 반환되는 값은 열거체 정의에서 해당 열거체 상수가 정의된 순서이며, 상수값 자체가 아님을 잘 알아야 한다.

```java
package azurealstn;

enum Rainbow { RED, ORANGE, YELLOW, GREEN, BLUE, VIOLET }

public class Enum01 {
    public static void main(String[] args) {
        int idx = Rainbow.BLUE.ordinal();
        System.out.println(idx);
    }
}
//인덱스를 생각하면 이해하기 쉬울 것이다.
```

다음은 불규칙 상수값을 가지는 예제이다.

```java
package azurealstn;

enum Rainbow {
    RED(3), ORANGE(10), YELLOW(21), GREEN(5), BLUE(1), VIOLET(-11);

    private final int value;
    Rainbow(int value) { this.value = value; }
    public int getValue() { return value; }
}

public class Enum01 {
    public static void main(String[] args) {
        System.out.println(Rainbow.YELLOW.ordinal());
    }
}
```

```java
실행결과
2 //상수값과 무관하게 출력된다.
```

# EnumSet
자바의 `EnumSet`은 Set 인터페이스를 기반으로 enum 열거 요소들을 이용하여 더 빠르게 결과를 낼 수 있는 녀석이다.

즉, EnumSet은 말 그대로 열거형 타입으로 지정해놓은 요소들을 쉽고 빠르게 배열처럼 다룰 수 있는 기능을 제공하는 녀석이다.

```java
package azurealstn;

import java.util.EnumSet;

enum Rainbow {
    RED, ORANGE, YELLOW, GREEN, BLUE, VIOLET;
}

public class Enum01 {
    public static void main(String[] args) {
        EnumSet es = EnumSet.allOf(Rainbow.class); //Rainbow 요소들을 모두 가져온다.
        EnumSet es2 = EnumSet.copyOf(es); //복사(es와 같은 값)
        System.out.println("EnumSet Rainbow: " + es2);
        es2 = EnumSet.noneOf(Rainbow.class); //값 비우기(비어 있음)
        System.out.println("EnumSet Rainbow: " + es2);

        es = EnumSet.of(Rainbow.RED, Rainbow.VIOLET);
        System.out.println("es: " + es); //of() 메소드에서 받은 요소 출력
        es2 = EnumSet.complementOf(es); //()안의 값을 제외하고 나머지 출력
        System.out.println("es2: " + es2);
        es2 = EnumSet.range(Rainbow.GREEN, Rainbow.VIOLET);
        System.out.println("es2: " + es2);
    }
}
```

```
출력결과
EnumSet Rainbow: [RED, ORANGE, YELLOW, GREEN, BLUE, VIOLET]
EnumSet Rainbow: []
es: [RED, VIOLET]
es2: [ORANGE, YELLOW, GREEN, BLUE]
es2: [GREEN, BLUE, VIOLET]
```

[참고 - http://alecture.blogspot.com/2012/11/enumset.html]

### reference

- http://www.tcpschool.com/java/intro
