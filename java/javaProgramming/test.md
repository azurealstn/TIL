# 6주차 과제: 상속

## 목표

자바의 상속에 대해 학습하세요.

<br>

## 학습할 것

- 자바 상속의 특징
- super 키워드
- 메소드 오버라이딩
- 다이나믹 메소드 디스패치 (Dynamic Method Dispatch)
- 추상 클래스
- final 키워드
- Object 클래스

<br>
<br>
<br>

## 자바 상속의 특징

상속이란, 부모가 자식에게 물려준다는 의미입니다. 자바에서 상속도 마찬가지입니다. 자바에서 상속이란 **부모 클래스에서 정의된 필드와 메소드를 자식 클래스가 물려받는 것입니다.**

<br>

### 상속이 필요한 이유

객체지향 프로그래밍에서 **상속**은 필수적입니다. 그 이유는 다음과 같습니다.

- 공통적인 코드는 상속을 통해 부모 클래스의 필드나 메소드를 가져와서 사용할 수 있습니다. 이러면 **중복된 코드를 줄여서 코드가 더욱 간결해집니다.**
- OOP란 결국 코드의 확장성과 재활용을 용이하게 만들기 위한 기법입니다. 상속을 사용함으로써 코드를 확장시킬 수 있으며 유지보수가 쉬워집니다.

<br>

### 상속 특징

- 명칭은 보통 부모 클래스: super class, 자식 클래스: sub class 라고 부릅니다.
- 자바에서는 다중 상속을 지원하지 않습니다. 따라서 **extends** 뒤에는 하나의 부모 클래스만 올 수 있습니다.
- 자바에서는 상속의 횟수에 제한을 두지 않습니다.
- 최상위 클래스는 **Object 클래스**입니다.

상속의 단점도 존재합니다. 하지만 이는 다루지 않겠습니다. 좀 더 깊이 들어가야하기 때문에 자세히 알고 싶으시다면 Effective Java나 오브젝트 책을 한번 보는 것이 좋을 것 같습니다. (저도 얼른 봐야되는데 말이죠..ㅎㅎ;)

<br>

### 상속 사용하는 방법

상속은 어떻게 사용하는지 간단히 예제를 보겠습니다.

### Animal Class

```java
package com.azurealstn.sociallogin.inherit;

public class Animal {

    public String name;
    public String gender;
    public int age;
    public String species;

    public void eat() {
        System.out.println(name + "(이)는 " + species + " 사료를 먹습니다.");
    }
}
```

<br>

### Dog Class

```java
package com.azurealstn.sociallogin.inherit;

public class Dog extends Animal {

    public void namePrint() {
        name = "피피";
        System.out.println("개의 이름은 " + name + " 입니다.");
    }
}
```

코드를 보면 자식 클래스인 `Dog`가 부모 클래스인 `Animal`을 상속받아서 `Dog` 클래스에서 굳이 `name` 필드를 생성하지 않아도 사용할 수 있는 것을 확인할 수 있습니다.

<br>
<br>
<br>

## super 키워드

**super는 자식 클래스가 부모 클래스로부터 상속 받은 멤버를 참조할 때 사용하는 참조 변수**입니다. 쉽게 말해서 클래스 내의 인스턴스 변수와 지역 변수의 이름이 서로 같을 때는 `this` 키워드를 통해 구별했었습니다. 이와 마찬가지로 부모 클래스와 자식 클래스의 변수명이 같은 때는 `super` 키워드를 사용합니다.

<br>

바로 예제를 보도록 하죠.

```java
package com.azurealstn.sociallogin.inherit;

public class Dog extends Animal {

    String name = "쿠쿠"; //Dog의 인스턴스 변수

    public void namePrint() {
        super.name = "피피"; //Animal의 인스턴스 변수
        System.out.println("개의 이름은 " + super.name + " 입니다.");
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.namePrint(); //개의 이름은 피피 입니다.
    }
}
```

- 출력된 결과를 확인해 보면 `피피` 라는 이름으로 출력된 것을 확인할 수 있습니다.

<br>

### super()

`super()`는 `this()`와 유사합니다. `this()`는 같은 클래스 내의 오버로딩된 다른 생성자를 호출할 때 사용한다면 `super()`는 부모 클래스의 생성자를 호출할 때 사용합니다.

<br>

바로 예제를 보도록 하겠습니다.

### Animal Class

```java
package com.azurealstn.sociallogin.inherit;

public class Animal {

    public String name;
    public String gender;
    public int age;
    public String species;

    public Animal(String name, String gender, int age, String species) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.species = species;
    }

    public void eat() {
        System.out.println(name + "(이)는 " + species + " 사료를 먹습니다.");
    }
}
```

<br>

### Dog Class

```java
package com.azurealstn.sociallogin.inherit;

public class Dog extends Animal {

    String name = "쿠쿠";

    public Dog(String name, String gender, int age, String species) {
        super(name, gender, age, species); //초기화
    }

    public void namePrint() {
        super.name = "피피";
        System.out.println("개의 이름은 " + super.name + " 입니다.");
    }

    public static void main(String[] args) {
        Dog dog = new Dog("피피", "Male", 3, "개");
        dog.namePrint();
    }
}
```

코드를 보시면 부모 클래스의 생성자를 호출하기 위해서는 `super()`를 사용합니다.  
그렇다면 **왜 super()를 사용해야 할까요?**

<br>

자식 클래스의 인스턴스를 생성하면 자식의 멤버와 부모의 멤버가 모두 합쳐진 하나의 인스턴스가 생성됩니다. 그래서 자식 클래스가 부모 클래스의 멤버들을 사용할 수 있는 것이죠.  
**이 때 부모 클래스 멤버의 초기화 작업이 수행되어야 하기 때문에 자식 클래스의 생성자에서 부모 클래스의 생성자가 호출되어야 합니다.** 만약 생성자 호출을 하지 않으면 컴파일 에러가 발생합니다.

<br>
<br>
<br>

## 메소드 오버라이딩

오버라이딩(Overriding)이란 상속 관계에 있는 부모 클래스에서 이미 정의된 메소드를 자식 클래스에서 재정의하는 것을 말합니다.

<br>

오버라이딩은 왜 사용하는 것일까요?

<br>

이유는 간단합니다. 부모 클래스로부터 상속받은 메소드를 그대로 사용해도 되지만 만약에 가져온 메소드를 커스터마이징 하고 싶다면 어떻게 해야할까요? 다시 비슷한 메소드를 정의해야 할까요?  
바로 오버라이딩해서 부모 클래스로부터 받은 메소드는 그대로 쓰고 나머지 필요한 로직을 작성해주시면 됩니다. 바로 아래 코드처럼요.

```java
@Override
public void eat() {
	super.eat();
	System.out.println("먹은 후에 산책시킬 것을 권장합니다."); //로직 추가
}
```

- 메소드 오버라이딩을 할 경우 메소드 위에 `@Override`를 붙여주세요! 필수는 아니지만 개발은 혼자하는 것이 아니기 때문에 쓰는 것을 권장합니다.

<br>

### 오버라이딩 조건

- 오버라이딩이란 메소드의 동작만을 재정의하는 것이므로, 메소드 선언부는 기존 메소드와 완전히 동일해야 합니다.
- 부모 클래스의 메소드보다 접근 제어자를 더 좁은 범위로 변경할 수 없습니다.

<br>

### 오버로딩 & 오버라이딩

자바를 처음 배울 때 오버로딩 & 오버라이딩의 차이가 굉장히 헷갈렸습니다.  
간단히 정리하면 오버로딩(Overloading)은 새로운 메소드를 정의하는 것이고,  
오버라이딩(Overriding)은 상속 받은 기존의 메소드를 재정의하는 것입니다.  
바로 예제를 보겠습니다.

```java
public class Dog extends Animal {

    String name = "쿠쿠";

    public Dog(String name, String gender, int age, String species) {
        super(name, gender, age, species);
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("먹은 후에 산책시킬 것을 권장합니다.");
    }
    //Overloading
    public void eat(int time) {
        System.out.println(time + "분 후에 " + super.name + "(이)는 " + super.species + " 사료를 먹습니다.");
    }

    public void namePrint() {
        super.name = "피피";
        System.out.println("개의 이름은 " + super.name + " 입니다.");
    }

    public static void main(String[] args) {
        Dog dog = new Dog("피피", "Male", 3, "개");
        dog.namePrint(); //개의 이름은 피피 입니다.
        dog.eat(30); //30분 후에 피피(이)는 개 사료를 먹습니다.
    }
}
```

위 코드를 보시면 오버라이딩은 부모의 것을 그대로 사용하되 자식 클래스에서 재정의하여 사용하고 있고 오버로딩은 완전히 새로운 메소드를 정의하고 있습니다.

<br>

오버로딩을 사용하는 이유는 비슷한 메소드명을 매번 짓기가 어렵기 때문에 사용합니다.  
예를 들어, 두 수를 더하는 메소드와 세 수를 더하는 메소드가 있다면 서로 이름을 다르게 해야한다면 조금 이름을 생각하는데 시간을 쏟게 될 것입니다. 하지만 오버로딩을 사용하면 간단합니다.

```java
public int add(int x, int y) {
	return x + y;
}

public int add(int x, int y, int z) { 
	return x + y + z; 
}
```

오버로딩의 조건은 다음과 같습니다.

<br>

- 메소드명이 같아야 합니다.
- 파라미터의 개수나 타입이 달라야 합니다.
- 파라미터의 개수와 타입은 같고 리턴 타입이 다른 경우에는 오버로딩이 성립되지 않습니다.

<br>
<br>
<br>

## 다이나믹 메소드 디스패치 (Dynamic Method Dispatch)

자바 공부하면서 `Dynamic Method Dispatch`란 말을 처음 들어보았습니다. 좀 생소했지만 역시 구글에 검색하니 많은 자료가 있더군요.

<br>

`Dynamic Method Dispatch`란 오버라이딩된 메소드에 대한 호출이 컴파일타임이 아닌 런타임에 확인되는 메커니즘이라 합니다.

- 자바는 호출이 발생할 때 참조되는 객체의 유형에 따라 해당 메소드를 실행합니다. 따라서 이 결정은 런타임에 이루어집니다. -> 컴파일타임에는 객체의 유형을 알 수가 없는 걸로 해석이 되는군요.

`Dynamic Method Dispatch`를 다른 말로 **실행시간 다형성(runtime polyporphism)**이라고 합니다. `runtime polyporphism`은 컴파일타임이 아닌 런타임에 **upcasting**된 자식 클래스의 오버라이딩된 메소드를 호출하는 것을 말합니다. 이러면 실행시간에 어떤 자식 클래스의 오버라이딩된 메소드를 호출할지가 명확해집니다.  

<br>

예제를 한번 보도록 하겠습니다.

```java
package com.azurealstn.sociallogin.inherit;

public class Super {
    void print() {
        System.out.println("Super.print");
    }
}

class Sub1 extends Super {
    @Override
    void print() {
        System.out.println("Sub1.print");
    }
}

class Sub2 extends Super {
    @Override
    void print() {
        System.out.println("Sub2.print");
    }

    public static void main(String[] args) {
        Super ref = new Super();
        ref.print();
        ref = new Sub1();
        ref.print();
        ref = new Sub2();
        ref.print();
    }
}
```

부모 클래스인 Super 객체 타입인 `ref`에 자식 객체인 `Sub1`과 `Sub2`를 대입하면 **upcasting**이 이루어지고, `ref`는 대입될 때마다 자식 객체의 주소를 가리키게 됩니다.

<br>

### 결론

**upcasting과 overriding을 통해 rumtime polymorphism을 구현할 수 있습니다.**  
자세한 설명은 https://velog.io/@maigumi/Dynamic-Method-Dispatch 이 블로그를 보시면 좋을 것 같습니다.

<br>
<br>
<br>

## References

- https://jyoel.tistory.com/39
- https://it-mesung.tistory.com/39
- https://imasoftwareengineer.tistory.com/74
- https://freestrokes.tistory.com/72
- https://scshim.tistory.com/67
- http://tcpschool.com/java/java_inheritance_overriding
- https://2018-start.tistory.com/46
- https://www.geeksforgeeks.org/dynamic-method-dispatch-runtime-polymorphism-java/
- https://velog.io/@maigumi/Dynamic-Method-Dispatch
