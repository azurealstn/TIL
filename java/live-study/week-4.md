# 목표
자바가 제공하는 제어문 학습.

# 학습할 것 (필수)
선택문  
반복문  

## 선택문
솔직히 이 제어문만 제대로 알면 어느 언어를 써도 응용이 가능하다.
따라서 확실하게 아는 것이 중요하고, 개인적으로 알고리즘 공부를 하면 제어문을 잘 활용할 수 있을 것 같다.

먼저 선택문을 하기 전에 `조건문`은 말그대로 조건을 다는 것이다.

- `if() {}`, `if() {} else if() {} else{}`
- `()`안에는 조건식을 넣으면 되고 당연히 `true` 또는 `false`형태로 넣어야 된다.

선택문은 `switch문`을 말한다.
주사위의 예제를 보면 이해할 수 있다.

```java
package azurealstn;

public class Main {
    public static void main(String[] args) {
        int num = (int)(Math.random() * 6) + 1;
        switch (num) {
            case 1:
                System.out.println("1번 등장");
                break; //break;를 써주어야 한다.
            case 2:
                System.out.println("2번 등장");
                break; //break;를 써주어야 한다.
            case 3:
                System.out.println("3번 등장");
                break; //break;를 써주어야 한다.
            case 4:
                System.out.println("4번 등장");
                break; //break;를 써주어야 한다.
            case 5:
                System.out.println("5번 등장");
                break; //break;를 써주어야 한다.
            default:
                System.out.println("6번 등장");
                break; //break;를 써주어야 한다.
        }
    }
}
```

## 반복문
반복문에는 `for`, `while`, `do while`이 있다.  
1부터 10까지 더하는 프로그램을 각 반복문을 사용하는 예제를 통해 알아보자.

```java
package azurealstn;

public class Main {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}
```

- for문을 사용하는 예시이다.

```java
package azurealstn;

public class Main {
    public static void main(String[] args) {
        int sum = 0;
        int i = 1;
        while (i <= 10) {
            sum += i;
            i++;
        }
        System.out.println(sum);
    }
}
```

- while문을 사용하는 예시이다. while()에서 `()`안에는 조건을 달아주고 그 조건동안에 블록 안에 로직을 수행한다.

```java
package azurealstn;

public class Main {
    public static void main(String[] args) {
        int sum = 0;
        int i = 1;
        do {
            sum += i;
            i++;
        } while (i <= 10);
        System.out.println(sum);
    }
}
```

- do while문의 사용예시이다. 이는 먼저 `do {}`로직을 수행하고 그 다음에 조건(`while()`)을 확인한다.
