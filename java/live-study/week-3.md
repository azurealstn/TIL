# 목표
자바가 제공하는 다양한 연산자를 학습할 것.

## 학습할 것

- 산술 연산자
- 비트 연산자
- 관계 연산자
- 논리 연산자
- instanceof
- assignment(=) operator
- 화살표(->) 연산자
- 3항 연산자
- 연산자 우선 순위
- (optional) Java 13. switch 연산자

## 산술 연산자
산술 연산자는 수학적인 계산에 사용되는 연산자다.

```java
public class Variable {
    public static void main(String[] args) {
        int result = 2 + 3; //5
        result = result - 1 //4
        result = result * 2 //8
        result = result / 2 //4
        result = result % 3 //1
    }
}
```

## 비트 연산자
비트 연산자는 데이터를 비트 단위로 연산한다.
따라서 0과 1로 표현이 가능한 정수 타입이나 정수형으로 캐스팅이 가능한 자료형만 비트 연산이 가능하다.

| 식      | 설명                                                      |
| ---- | ------------------------------------------------------------ |
| x<<y | 정수 x의 각 비트를 y만큼 왼쪽으로 이동 (빈자리는 0으로 채워짐) |
| x>>y  | 정수 x의 각 비트를 y만큼 오른쪽으로 이동 (빈자리는 정수 a의 최상위 부호비트와 같은 값으로 채워짐) |
| x>>>y | 정수 x의 각 비트를 y만큼 오른쪽으로 이동 (빈자리는 0으로 채워짐) |

## 관계 연산자
어렵지 않다. ==, !== 등등이 있다.
리턴값은 `true`, `false`

## 논리 연산자
AND(&&), OR(||), NOT(!) 세 가지의 연산자가 있다.
리턴값은 `true`, `false`

## assignment(=) operator
우리말로 대입 연산자라고 한다.
수학에서 `=`은 같다 이지만, 컴퓨터 세상에선 `=`은 오른쪽의 있는 값을 왼쪽에 다가 `대입한다` 또는 `할당한다`라고 한다. 여기서 중요한 것은 절대 서로 같은 값이 아니다!

## 화살표(->) 연산자
람다 표현식 (lambda expression)이라고도 하며, 간단히 메서드를 하나의 식으로 표현한 것.

```java
public class Variable {
    public static void main(String[] args) {
        //메서드
        int min(int x, int y) {
            return x < y ? x : y;
        }
        //람다
        (x, y) -> x < y ? x : y;
    }
}
```

- javascript 함수 표현식에 익숙한 사람은 어떤 느낌인지 알 것이다.

## 삼항 연산자
조건식 ? 결과1 : 결과2

삼항 연산자는 `if문`을 한 줄로 쓸 수 있는 아주 유용한 녀석인데,
조건식에서 `true`면 결과1을 반환하고 `false`이면 결과2를 반환한다.

## 연산자 우선 순위
당연히 표를 보면 되겠지만.. (구글에서) 솔직히 다 외울사람은 아무도 없을 것이다. (아마도..)
수학하고 비슷하게 생각하면 된다.
애매할 땐 먼저 연산해야 할 것은 `()` 괄호 먼저 해준다. 그 다음에 연산을 하든 비교를 하든 연산식을 그렇게 만들어가면 된다.
길게 설명은 생략.

- 이번 수업은 "자바에서는 이런 연산자들이 있구나" 하고 넘어가는 것이 좋을 것 같다. (너무 파고 들지 않아도 충분히 알 수 있는 내용들이다.)

## (optional) Java 13. switch 연산자
기존 switch문이 사라진 것이 아니라 switch 연산자라는 것이 추가가 되었다고 한다.

### 기존 swtich문

```java
package azurealstn;

public class Main {
    public static void main(String[] args) {
        int day = 1;
        switch (day) {
            case 1:
                System.out.println("1일");
                break;
            case 2:
                System.out.println("2일");
                break;
            default:
                System.out.println("몰라");
                break;
        }
    }
}

```

### java 13 swtich 연산자 (yield)

```java
package azurealstn;

public class Main {
    public static void main(String[] args) {
        int day = 1;
        String result = switch(day) {
            case 1: 
            	yield "1일";
            default: 
            	yield "몰라";
        };
        System.out.println(result);
    }
}

```

이런 식으로 쓰는 것 같다... (Java 13을 쓰질 않아서 테스트는 넘어가겠다 ㅠ.ㅠ)
