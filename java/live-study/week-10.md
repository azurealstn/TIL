# 목표
자바의 멀티쓰레드 프로그래밍에 대해 학습하세요.

# 학습할 것 (필수)

- Thread 클래스와 Runnable 인터페이스
- 쓰레드의 상태
- 쓰레드의 우선순위
- Main 쓰레드
- 동기화
- 데드락

# Thread 클래스와 Runnable 인터페이스
먼저 프로세스(process)란 실행중인 프로그램(program)을 말한다.
즉, 사용자가 작성한 프로그램(코드)이 OS에 의해 메모리 공간을 할당받아 실행중인 것을 말한다.
이러한 프로세스는 프로그램에서 사용되는 **데이터, 메모리 등의 자원 그리고 스레드로 구성**된다.

---

**스레드(thread)**란 프로세스 내에서 실제로 작업을 수행하는 **주체**를 말한다.
그러므로 프로세스에는 적어도 한 개 이상의 스레드가 존재하는 것이다.
그리고 두 개 이상인 것을 **멀티스레드(multi-thread)**라고 한다.

---

자바에서는 스레드를 생성하는 방법이 두 가지가 있다.

- Runnable 인터페이스를 구현하는 방법
- Thread 클래스를 상속받는 방법

이 두 스레드 모두 `run()` 메소드에 작업 로직을 작성하면 실행이 되는 것이다.

```java
package azurealstn;

class ThreadWithClass extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(getName()); //현재 실행중인 스레드 이름 반환
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ThreadWithRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()); //현재 실행중인 스레드 이름 반환
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Thread01 {
    public static void main(String[] args) {
        ThreadWithClass thread1 = new ThreadWithClass(); //Thread 클래스 구현
        Thread thread2 = new Thread(new ThreadWithRunnable()); //Runnable 인터페이스 구현
        thread1.run();
        thread2.run();
    }
}
```

Thread 클래스를 상속받으면 다른 클래스를 상속 받을 수 없으므로, Runnable 인터페이스를 구현하는 방법으로 스레드를 생성한다.

> Runnable 인터페이스는 몸체가 없는 메소드인 run() 메소드 단 하나만을 가지는 인터페이스이다.

# 쓰레드의 상태

![캡처](https://user-images.githubusercontent.com/55525868/108344762-e0256880-7220-11eb-9607-9f784cba8bd2.PNG)

[참고 - https://url.kr/rztbsi]

**스레드 스케줄링: ** 스레드의 개수가 코어(CPU)보다 많을 경우, 스레드를 어떤 순서에 의해 **동시성**으로 실행할 것인가를 정하는 작업.

- **실행 대기 상태:** 아직 스케줄링이 되지 않아서 실행을 기다리고 있는 상태
- **실행 상태:** 실행 대기 상태에 있는 스레드 중에서 스레드 스케줄링으로 선택된 스레드가 CPU를 점유하고 run() 메소드를 실행하는 상태

스레드 객체를 생성하고 start() 메소드를 호출하면 곧바로 스레드가 실행되는 것처럼 보이지만, 이는 `실행 대기 상태`가 된다. 실행 대기 상태에 있는 스레드중에서 스레드 스케줄링으로 선택된 스레드만이 `실행 상태`가 되는 것이다.

- **종료 상태:** run() 메소드가 종료되어 더 이상 실행할 코드가 없어져 스레드의 실행을 멈추는 것.
- **일시 정지 상태:** 스레드가 실행할 수 없는 상태로 WAITING, TIMED_WAITING, BLOCKED의 세 가지 상태가 존재한다.

# 쓰레드의 우선순위

|필드|설명|
|-|-|
|static int MAX_PRIORITY|스레드가 가질 수 있는 최대 우선순위|
|static int MIN_PRIORITY|스레드가 가질 수 있는 최소 우선순위|
|static int NORM_PRIORITY|스레드가 생성될 때 가지는 기본 우선순위|

`getPriority()`와 `setPriority()` 메소드를 통해 스레드의 우선순위를 반환하거나 변경할 수 있다.
스레드의 우선순위가 가질 수 있는 범위는 1부터 10까지이며, 숫자가 높을수록 우선순위도 높아진다.

```java
package azurealstn;

class ThreadWithRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()); //현재 실행중인 스레드 이름 반환
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Thread01 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new ThreadWithRunnable());
        Thread thread2 = new Thread(new ThreadWithRunnable());

        thread2.setPriority(10);

        thread1.start(); //Thread-0 실행
        thread2.start(); //Thread-1 실행

        System.out.println(thread1.getPriority());
        System.out.println(thread2.getPriority());
    }
}
```

# Main 쓰레드
메인 스레드는 `main()` 메소드를 실행하며 시작된다. 또한 메인 스레드가 없다면 멀티 스레드도 나올 수 없다.

```java
public static void main(String[] args)//메인 스레드 시작 {
	...
} //메인 스레드 끝
```

메인 스레드는 도중에 필요에 따라 작업 스레드들을 만들어서 병렬로 코드를 실행시킬 수 있다.
멀티스레드를 생성해서 멀티태스킹을 수행한다.

![캡처](https://user-images.githubusercontent.com/55525868/108346869-3398b600-7223-11eb-95ba-d7ace9205781.PNG)

[참고 - https://gosmcom.tistory.com/19]

# 동기화
**스레드 동기화**란 **한 스레드가 진행중인 작업을 다른 스레드가 간섭하지 못하도록 막는 것**을 말한다.

만약 싱글스레드의 경우에는 프로세스 내에 단 하나만 존재하므로 딱히 상관이 없다.
하지만 멀티스레드를 보면 같은 프로세스 내에 여러 스레드가 자원을 공유하기 때문에 서로에게 영향을 준다.

즉, 스레드 동기화를 해야 이를 막을 수 있는 먼저 `synchronized`를 이용한 동기화이다.
이 키워드는 **임계 영역을 설정**하는데 사용된다.

![캡처](https://user-images.githubusercontent.com/55525868/108347560-fed92e80-7223-11eb-9276-47a6ddbc721a.PNG)

[참고 - https://gongstudyit.tistory.com/22]

첫 번째 방법은 메소드 앞에 synchronized를 붙이면 메소드 전체가 임계 영역으로 설정되는데
스레드는 synchronized 메소드가 호출된 시점부터 해당 메소드가 포함된 객체의 `lock`을 얻어 작업을 수행한다. 메소드가 종료되면 `lock`은 반환된다.

---

두 번째 방법은 { }인 synchronized 블록의 영역 안으로 들어가면서부터 스레드는 지정된 객체의 `lock`을 얻게 되고, 블록을 벗어나면 `lock`을 반납한다.

즉, 두 방법 다 `lock`을 가지고 있고, 해당 객체의 `lock`을 가지고 있는 스레드만 임계 영역의 코드를 수행할 수 있는 것이다.
그리고 다른 스레드들은 이 `lock`을 얻을 때까지 기다리는 것이다.

# 데드락
**데드락**이란 둘 이상의 스레드가 `lock`을 획득하기 위해 기다리는데 이 lock을 잡고 있는 스레드도 똑같이 다른 lcok을 기다리며 서로 블록 상태에 놓이는 것을 말한다.
즉, 데드락은 다수의 스레드가 같은 lock을 동시에 또는 다른 명령에 의해 획득하려 할 때 발생할 수 있다.

```java
이와 같은 상황에서 데드락이 걸린다.
Thread 1 locks A, waits for B
Thread 2 locks B, waits for A
```

[참고 - https://parkcheolu.tistory.com/19]

- reference

http://www.tcpschool.com/java/java_thread_concept
