# 4주차 과제: 제어문

## 목표

자바가 제공하는 제어문을 학습하세요.

<br>

## 학습할 것

- 선택문
- 반복문

<br>
<br>
<br>

## 선택문

Java에서 코드는 위에서 아래로 쭉 읽고 실행됩니다. 모든 일을 순차적으로 수행하면 문제가 없지만, 어떤 코드는 반복을 해야하고 어떤 코드는 건너뛰어야 하는 등의 순서를 변경해야 되는 일이 발생합니다. 이럴 때, 제어문을 사용하여 코드의 흐름을 제어할 수 있습니다. 이러한 제어문은 선택문(if-else, switch)과 반복문(for, while, do-while), 분기문(break, continue, return)으로 나뉩니다.

<br>

### if-else

if-else문은 가장 기본적인 제어문 중 하나로 조건이 만족할 시에 지정한 `if()` 블록안에 있는 코드를 실행시킵니다. 만약 만족하지 못할시에는 `else` 블록안에 있는 코드를 실행시킵니다.

#### 문법

```java
if (조건식) { //조건식이 참일 경우
	//logic
} else { //조건식이 거짓일 경우
	//logic
}
```

#### 예제

```java
public class Main {
    public static void main(String[] args) {
        boolean isCheck = true;
        if (isCheck) {
            System.out.println("중복체크되었습니다.");
        } else {
            System.out.println("중복체크를 해주세요.");
        }
    }
}
```

여기서 여러 조건을 달고 싶다면 `else if`문을 사용할 수 있습니다. `if`문이 거짓이면 다음 `else if`문을 수행하고 그런식으로 진행이 됩니다. 마지막으로 `else`문은 위의 `if`문들이 모두 거짓일 때 수행됩니다.

```java
public class Main {
    public static void main(String[] args) {
        int score = 78;
        if (score >= 60 && score < 70) {
            System.out.println("D학점");
        } else if (score >= 70 && score < 80) {
            System.out.println("C학점");
        } else if (score >= 80 && score < 90) {
            System.out.println("B학점");
        } else {
            System.out.println("A학점");
        }
    }
}
```

만약 위 코드처럼 수많은 조건들이 있을다면 가독성이 떨어질 수 있습니다. `else if`문으로 도배되는 코드는 그리 좋은 코드는 아니라고 생각됩니다. 그래서 `if`문을 좀 더 깔끔하게 쓸 수 있는 `switch`문이 있습니다. 바로 예제를 보죠.

```java
public class Main {
    public static void main(String[] args) {
        int score = 70;
        switch (score) {
            case 60:
                System.out.println("D학점");
                break;
            case 70:
                System.out.println("C학점");
                break;
            case 80:
                System.out.println("B학점");
                break;
            case 90:
                System.out.println("A학점");
                break;
            default:
                System.out.println("10단위로 입력해주세요.");
        }
    }
}
```

switch 괄호안에 해당 변수를 넣어주고, 각 case 마다 맞으면 로직을 수행합니다. 이 때 주의할 점은 반드시 각 case마다 `break`문을 써주어야 한다는 점입니다. 쓰지 않으면 `switch`문에서 빠져나오지 못하고 계속 다음 case 로직이 수행됩니다.

```java
public class Main {
    public static void main(String[] args) {
        int score = 70;
        switch (score) {
            case 60:
                System.out.println("D학점");
            case 70:
                System.out.println("C학점");
            case 80:
                System.out.println("B학점");
            case 90:
                System.out.println("A학점");
            default:
                System.out.println("10단위로 입력해주세요.");
        }
    }
}
```

결과가 어떻게 나오는지 한번 코드를 직접 따라해보세요! 참고로 마지막 default에는 break문을 작성하지 않아도 됩니다. 이유는 어차피 위의 case문이 다 맞지 않으니 마지막 default가 수행되기 때문에 굳이 break가 필요가 없는 것이죠. 하지만 `else if`와 `switch` 코드를 보면 `else if`에는 부등호가 들어가는데 `switch`에는 부등호가 없습니다. 그래서 `switch` case문에는 부등호를 쓸 수는 없습니다.

<br>
<br>
<br>

## 반복문

반복문이란 똑같은 명령을 일정 횟수만큼 반복하여 수행하도록 제어하는 명령문입니다. 이 반복문은 정말 많이 사용됩니다.

```java
public class Main {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i < 11; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}
```

먼저 `for`문을 이용한 반복문입니다. 1부터 10까지의 숫자를 모두 더한 값이 출력이 되는 코드입니다. 이처럼 반복문을 사용하지 않으면 한 줄 한 줄마다 더하는 로직을 작성해주어야 하는데 이렇게 반복문을 사용하면 굉장히 편리하죠. 마찬가지로 `while`문과 `do-while`문을 코드를 보겠습니다.

```java
public class Main {
    public static void main(String[] args) {
        int sum = 0;
        int i = 1;
        while (i < 11) {
            sum += i;
            i++;
        }
        System.out.println(sum);
    }
}
```

```java
public class Main {
    public static void main(String[] args) {
        int sum = 0;
        int i = 1;
        do {
            sum += i;
            i++;
        } while (i < 11);
        System.out.println(sum);
    }
}
```

여기서 `while`문과 `do-while`문의 차이는 `do-while`문은 조건에 맞든 안맞든 먼저 1회는 수행한다는 것입니다. 사실 `while`문을 가장 많이 사용합니다.

<br>
<br>
<br>

## 분기문

우리가 반복문을 사용할 때 이 분기문을 써야할 때가 있습니다. 예를 들어, 1부터 10까지의 숫자중 짝수만 가져오고 싶다던가. 반복문을 수행하다가 일정 숫자가 되면 반복문을 빠져나오게 하고 싶다던가. 여기서 `break`와 `continue`를 사용할 수 있습니다.

### break

`break`문은 반복문을 아에 빠져나오는 것으로 생각하시면 됩니다. 예제를 보도록 하죠.

```java
public class Main {
    public static void main(String[] args) {
        int treeCnt = 1;
        while (treeCnt > 0) {
            System.out.println("나무" + treeCnt + "그루를 얻었습니다.");
            if (treeCnt == 10) break;
            treeCnt++;
        }
    }
}
```

위 코드를 보면 `treeCnt`는 항상 0보다 크므로 계속 true가 됩니다. 그러면 무한 루프에 빠지게 되어 결국 스택오버플로우 현상이 발생하게 되죠. 이것을 방지하려면 무한 루프에서 빠져나와야 하는데 `treeCnt`가 10일 때 조건을 줘서 빠져나오게 하는 것입니다.

<br>

### continue

`break`문은 반복문을 완전히 빠져나오는 거라면 `continue`는 반복문 중에서 한 단계만 건너뛰는 것을 말합니다.

```java
public class Main {
    public static void main(String[] args) {
        for (int i = 1; i < 11; i++) {
            if (i % 2 == 0) continue;
            System.out.println(i);
        }
    }
}
```

1부터 10까지 반복문을 수행하는데 `i`를 2로 나누었을 때 나머지가 0일 경우에만 `continue`해서 건너뛰는 것입니다. 이러면 짝수 숫자들은 건너뛰고 홀수 숫자만 남게 되겠죠. 둘의 차이점을 명확하게 알고 쓰면 좋습니다.

<br>
<br>
<br>

## JUnit5

JUnit이란 Java의 단위 테스트를 작성할 수 있는 도구를 말합니다. 그럼 왜 테스트 코드를 작성해야하는지 다음과 같이 설명합니다.

- 개발단계 초기에 문제를 발견하게 도와줍니다.
- 개발자가 나중에 코드를 리팩토링하거나 라이브러리 업그레이드 등에서 기존 기능이 올바르게 작동하는지 확인할 수 있습니다.
- 기능에 대한 불확실성을 감소시킬 수 있습니다.
- 단위 테스트 자체가 문서로 사용할 수 있습니다.

쉽게 얘기해서 테스트 코드를 작성하지 않는다면 어플리케이션을 실행하고 요청 결과값을 확인하고 다시 코드를 수정하면 재실행하고 이런 것들이 나중에는 시간을 잡아먹습니다. 그래서 테스트 코드를 탄탄하게 짜면 좀 더 견고한 어플리케이션이 된다고 합니다. 최근에는 JUnit5를 많이 사용하는 것 같습니다.

<br>

#### JUnit5 = JUnit Platform + JUnit Jupiter + JUnit Vintage

<br>

**JUnit Platform**은 JVM에서 테스트 프레임워크를 시작하기 위한 기반 역할을 합니다.  
**JUnit Jupiter**는 JUnit5에서 테스트 및 확장을 작성하기 위한 새로운 프로그래밍 모델과 확장 모델의 조합입니다.
**JUnit Vingtage**는 플랫폼에서 JUnit3 및 JUnit4 기반 테스트를 실행하기 위한 TestEngine을 제공합니다.

<br>

간단하게 비교하는 테스트 코드를 작성해보도록 하겠습니다. 지금 테스트 개발환경은 Spring Boot + Maven 입니다.

### Person

```java
package com.azurealstn.sociallogin;

public class Person {

    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
```

### Calculator

```java
package com.azurealstn.sociallogin;

public class Calculator {

    public int add(int x, int y) {
        return x + y;
    }

    public int multiply(int x, int y) {
        return x * y;
    }
}
```

### MainTest

```java
package com.azurealstn.sociallogin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    private final Calculator calculator = new Calculator();
    private final Person person = new Person("Jane", "Doe");

    @Test
    @DisplayName("calculator 메소드 검증")
    void standardAssertions() {
        assertEquals(2, calculator.add(1, 1));
        assertEquals(4, calculator.multiply(2, 2));
    }

    @Test
    @DisplayName("person 메소드 검증")
    void standardAssertions2() {

        assertThat(person.getFirstName()).isEqualTo("Jane");
        assertThat(person.getLastName()).isEqualTo("Doe");
    }
}
```

- 첫 번째 테스트는 `junit`을 이용했습니다. 간단하게 두 값을 비교 검증하는 코드입니다.
- 두 번째 테스트는 `assertj`를 이용했습니다. 역시 두 값을 서로 비교 검증하는 코드입니다.

사실 더 복잡한 테스트 코드가 있지만 일단 예제는 여기서 마치겠습니다. 지금은 대충 어떻게 사용한다는 점만 알면 좋을 것 같습니다.

<br>

그리고 실무에서는 `junit`보다는 `assertj`를 더 많이 사용하는 것 같습니다. `junit`은 Matchers를 통해 검증을 진행하는데 검증 메소드를 찾는데 어려움이 있습니다. (자동 완성 에러)  
그에 비해 `assertj`은 자동 완성이 잘되어 있습니다. 자세한 내용을 보시려면 https://www.youtube.com/watch?v=zLx_fI24UXM 이 영상을 꼭보세요!

<br>
<br>
<br>

## live-study 대시보드 만들기

코드를 구현하는데 사실 남의 코드를 보며 따라쳤습니다.. 아직 스스로 이 API를 보고 적용해서 출력해내기까지가 쉽지 않네요 ㅠ.ㅠ

```java
import org.kohsuke.github.*;
import java.util.*;

public class GitHubApplication {

    private static final String MY_PERSONAL_TOKEN = "TOKEN";
    public static void main(String[] args) throws Exception {
        //Personal access token 연결
        GitHub gitHub = new GitHubBuilder().withOAuthToken(MY_PERSONAL_TOKEN).build();

        //Repository 연결
        GHRepository repository = gitHub.getRepository("whiteship/live-study");

        //IssueState
        List<GHIssue> issues = repository.getIssues(GHIssueState.ALL);
        Map<String, Integer> participant = new HashMap<>();

        //1-18개 이슈
        for (GHIssue issue : issues) {
            Set<String> onlyOneParticipant = new HashSet<>();

            //댓글 한 개 이상인 경우 유저이름 중복 제거
            for (GHIssueComment comment : issue.getComments()) {
                onlyOneParticipant.add(comment.getUser().getName());
            }

            //카운트증가
            for (String name : onlyOneParticipant) {
                if (participant.containsKey(name)) {
                    participant.replace(name, participant.get(name) + 1);
                    continue;
                }
                participant.put(name, 1);
            }

            //참여율 출력
            for (String name : participant.keySet()) {
                double rate = (double) (participant.get(name) * 100) / issues.size();
                System.out.println(String.format("%.2f", rate) + "%");
            }
        }
    }
}
```

<br>
<br>
<br>

## LinkedList 구현



<br>
<br>
<br>

## References

- https://juntcom.tistory.com/118
- http://tcpschool.com/java/java_control_loop
- 스프링부트와 AWS로 혼자 구현하는 웹 서비스
- https://junit.org/junit5/docs/current/user-guide/#writing-tests-assertions
