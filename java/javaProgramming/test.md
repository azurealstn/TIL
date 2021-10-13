# 10주차 과제: 멀티쓰레드 프로그래밍

## 목표

자바의 멀티쓰레드 프로그래밍에 대해 학습하세요.

<br>

## 학습할 것

- Thread 클래스와 Runnable 인터페이스
- 쓰레드의 상태
- 쓰레드의 우선순위
- Main 쓰레드
- 동기화
- 데드락

<br>
<br>
<br>

## Thread 클래스와 Runnable 인터페이스

자바에서 쓰레드를 사용하기 위해서는 두 가지 방법이 있습니다.

- Thread 클래스를 상속받아 구현
- Runnable 인터페이스를 상속받아 구현

그 전에 먼저 쓰레드가 무엇인지 한번 알아보겠습니다.  
지금부터 나오는 개념들은 모두 [점프 투 자바](https://wikidocs.net/230)를 참고했습니다. 중간중간에 다른 사이트에서 참고한 것들은 References에 적어 놓겠습니다!

<br>

쓰레드를 알기 위해서는 먼저 프로세스의 개념부터 알고 가는게 좋습니다.

<br>

### Thread

프로세스란 동작하고 있는 프로그램을 말합니다. 프로그램이란 파일 시스템에 있는 실행 파일(.exe ...)을 말합니다. 보통 한 개의 프로세스는 한 가지 일을 하지만 쓰레드를 이용하게 되면 한 프로세스 내에서 두 가지 또는 그 이상의 일을 **동시해** 할 수 있습니다.

<br>

### Thread Class

```java
package com.azurealstn.sociallogin.Thread;

public class Test extends Thread {

    int seq; //어떤 쓰레드인지 확인하기 위해 쓰레드의 순번
    public Test(int seq) {
        this.seq = seq;
    }

    @Override
    public void run() {
        System.out.println(this.seq + "thread start");
        try {
            Thread.sleep(1000); //1초
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(this.seq + "thread end");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Test(i);
            thread.start();
        }
        System.out.println("main end");
    }
}
```

Thread 클래스를 상속받으면 `run()` 메소드를 구현할 수 있습니다. 그리고 구현한 `run()` 메소드를 호출하려면 `start()` 메소드를 호출해주면 됩니다.

<br>

실행 결과 순서는 0부터 순서대로 출력되지 않고 랜덤으로 출력되는 것을 확인할 수 있습니다. 즉, 쓰레드는 순서에 상관없이 동시에 실행된다는 점을 알 수 있습니다. 

<br>

위 코드는 쓰레드가 모두 종료되기도 전에 `main()` 메소드가 종료된 것을 확인할 수 있습니다.  
`join()` 메소드를 사용하면 쓰레드가 종료될 때까지 기다리게 하는 메소드입니다. 즉, `join()` 메소드를 사용하면 모든 쓰레드가 종료된 후에 `main()` 메소드를 종료시킬 수 있습니다.

<br>

### Runnable Interface

Thread를 사용할 때 Thread 클래스보다는 Runnable 인터페이스를 더 많이 사용합니다.

```java
package com.azurealstn.sociallogin.Thread;

import java.util.ArrayList;

public class Test implements Runnable {

    int seq; //어떤 쓰레드인지 확인하기 위한 쓰레드의 순번
    public Test(int seq) {
        this.seq = seq;
    }

    @Override
    public void run() {
        System.out.println(this.seq + "thread start");
        try {
            Thread.sleep(1000); //1초
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(this.seq + "thread end");
    }

    public static void main(String[] args) {
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Test(i));
            thread.start();
            threads.add(thread);
        }
        for (int i = 0; i < threads.size(); i++) {
            Thread thread = threads.get(i);
            try {
                thread.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("main end");
    }
}
```

Runnable 인터페이스의 장점은 Thread 클래스는 상속받으면 다른 클래스들은 상속받을 수 없습니다. 하지만 Runnable 인터페이스는 인터페이스이기 때문에 다른 클래스를 상속받아서 확장성과 재사용성이 용이해집니다. 또한 Thread 를 한번 사용하면 재사용이 불가능하지만, Runnable 을 이용하여 Thread 를 구현하면 재사용할 수 있습니다.

<br>
<br>
<br>

## 쓰레드의 상태

쓰레드를 다루다 보면 쓰레드의 행동을 직접 제어해야할 경우가 있습니다.  
예를 들어, 1000장의 문서를 복사해야 하는데 공유된 프린터는 1개 밖에 없도 가정하십니다.  
분명 다른 사람들도 써야하기 때문에 한꺼번에 1000장을 복사할 순 없습니다.  
그래서 100장씩 나누어서 복사하고 그 때마다 다른 사람들이 사용할 수 있게 통제할 수 있습니다.

<br>

이와 마찬가지로 쓰레드도 행동을 통제할 필요가 있는데 그 전에 쓰레드의 상태를 먼저 알아야 합니다.

![쓰레드](https://user-images.githubusercontent.com/55525868/137091007-0643f8c7-6a6b-408c-990a-2c3e0c0022fa.JPG)

스레드가 `start()` 하게 되면 위 그림과 같은 상태로 진행됩니다.

- 경우에 따라서 쓰레드는 실행 상태에서 실행 대기 상태로 가지 않을 수도 있습니다.
- 실행 상태에서 일시 정지 상태로 가기도 하는데, 일시 정지 상태는 쓰레드가 실행할 수 없는 상태입니다.
- 쓰레드가 다시 실행 상태로 가기 위해서는 일시 정지 상태에서 실행 대기 상태로 가야합니다.

<br>

이러한 쓰레드의 상태를 알 수 있는 방법이 `getState()` 메소드가 있습니다.  
`getState()`의 쓰레드 상태에 따른 `Thread.State` 열거 상수가 있습니다.

![쓰레드_상태](https://user-images.githubusercontent.com/55525868/137094396-ddff1fd6-c701-4c6c-8555-8bcc77461b69.JPG)

<br>

### Test Class

```java
package com.azurealstn.sociallogin.Thread;

public class Test extends Thread {

    private TargetThread targetThread;

    public Test(TargetThread targetThread) {
        this.targetThread = targetThread;
    }

    @Override
    public void run() {
        while (true) {
            Thread.State state = targetThread.getState(); //쓰레드 상태
            System.out.println("타겟 쓰레드 상태: " + state);

            //객체 생성 상태일 경우 실행 대기 상태로 만듬
            if (state == Thread.State.NEW) {
                targetThread.start();
            }

            //종료 상태일 경우 while문 종료
            if (state == Thread.State.TERMINATED) {
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (Exception e) {}
        }
    }

    public static void main(String[] args) {
        Test test = new Test(new TargetThread());
        test.start();
    }
}
```

<br>

### TargetThread

```java
package com.azurealstn.sociallogin.Thread;

public class TargetThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100000000; i++) {} //RUNNABLE 상태 유지

        try {
            Thread.sleep(1500); //TIMED_WAITING 생태 유지
        } catch (Exception e) {}

        for (int i = 0; i < 100000000; i++) {} //RUNNABLE 상태 유지
    }
}
```

<br>

쓰레드 상태 순서 : NEW -> RUNNABLE -> TIMED_WAITING -> RUNNABLE -> TERMINATED

자세한 부분은 https://widevery.tistory.com/27 이 블로그를 참고해주세요.

<br>
<br>
<br>

## 쓰레드의 우선순위

멀티쓰레드는 동시성(Concurrency) 또는 병렬성(Parallelism)으로 실행됩니다.

- 동시성 : 멀티 작업을 위해 하나의 코어에서 멀티쓰레드가 번갈아가며 실행하는 성질
- 병렬성 : 멀티 작업을 위해 멀티 코어에서 개별 쓰레드를 동시에 실행하는 성질

싱글 코어 CPU를 이용한 멀티쓰레드 작업은 병렬적으로 실행되는 것처럼 보이지만, 사실은 번갈아가며 실행하는 동시성 작업입니다. 즉, 실행하는 것이 워낙에 빨라서 병렬성으로 보일 뿐입니다.

<br>

### 쓰레드 스케줄링

쓰레드의 개수가 코어의 수보다 많을 경우 쓰레드를 어떤 순서에 의해 동시성으로 실행할 것인지를 결정해야 하는데 이것을 쓰레드 스케줄링이라고 합니다. 쓰레드 스케줄링에 의해 쓰레드들은 아주 짧은 시간에 번갈아가면서 `run()` 메소드를 조금씩 실행합니다.

<br>

우선순위는 1 ~ 10까지 부여가 되고 10이 가장 높습니다. 만약 우선순위를 변경하고 싶으면 `setPriority()` 메소드를 이용하면 됩니다.

<br>
<br>
<br>

## References

- https://wikidocs.net/230
- https://aileen93.tistory.com/105
- https://widevery.tistory.com/27
- https://deftkang.tistory.com/56
