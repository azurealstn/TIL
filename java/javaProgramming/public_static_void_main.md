## public static void main(String[] args)

자바의 모든 프로그램은 `public static void main(String[] args)` 함수로 시작합니다.

그렇다면 왜 이 함수로 시작하는 것일까?

### public

`main` 메소드는 반드시 실행되어야 합니다. 하지만 접근제한자를 `private`으로 해두면 외부에서 접근을 할 수 없게 됩니다. 그래서 반드시 `public`으로 두어야 합니다.

### static

자바는 변수나 함수를 메모리에 할당하는 방법이 2가지가 있습니다.  
첫번째는 `static 영역`에 선언하는 방법과 두번째는 `heap 영역`에 선언하는 방법

만약 heap 영역에 선언한다면 어떻게 될까요?

heap 영역은 `new 연산자`를 이용해서 객체를 생성하는데 이는 `Garbage Collector`에 대상이 됩니다.

`main` 메소드는 반드시 실행되어야 하기 때문에 가비지 컬렉터에 의해 메모리에서 정리되면 안되겠죠?..

### void

`main` 메소드가 종료되면 프로그램이 아에 종료가 됩니다. 그런게 `return` 값을 받게 되면 어떻게 될까요?

프로그램이 종료가 되기 때문에 `return`의 의미가 없어집니다.  
따라서 타입을 `void`를 의무적으로 사용해야 합니다.

### main

자바의 시작은 `main` 이름으로 시작합니다.  
이는 규칙입니다.

### String[] args

모든 메소드는 매개변수를 사용할 수도 있고, 안할 수도 있습니다.  
하지만 `main` 메소드는 다른 곳에서 호출되는 것이 아닌 프로그램 실행 시 처음으로 수행되는 메소드이기 때문에 매개변수가 반드시 필요합니다.

<br>

위에 `public`, `static`, `void`, `main`, `String[] args` 하나라도 없으면 에러가 발생합니다.

<br>

C, C++은 `main`에 종료상태를 반환하는 `int`타입을 반환시켜서 종료 상태를 반환합니다. 이 종료상태로 프로그램을 완전히 종료시키는 것입니다.  
하지만 C, C++과 달리 Java Program은 `JVM` 위에서 `main thread`를 실행합니다.
따라서 자바 프로그램은 OS에 직접 접근하지 않고, 자원을 직접 할당하지 않고, 어떠한 프로세스 테이블을 차지하지 않습니다.

따라서 Java Program의 `main` 메소드는 종료상태를 반환하지 않습니다.  
그럼 무엇으로 Java Program은 종료상태를 반환시킬까요?

종료상태를 반환할 수 있는건 OS의 프로세스인 JVM이고, `java.lang.Runtime.exit`나 `System.exit`에 의해 종료상태를 반환하여 JVM을 종료시킬 수 있습니다.

## References

- https://mozi.tistory.com/553
- https://www.geeksforgeeks.org/understanding-public-static-void-mainstring-args-in-java/
