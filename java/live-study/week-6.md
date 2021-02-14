# 목표
자바의 상속에 대해 학습하세요.

# 학습할 것 (필수)

- 자바 상속의 특징
- super 키워드
- 메소드 오버라이딩
- 다이나믹 메소드 디스패치 (Dynamic Method Dispatch)
- 추상 클래스
- final 키워드
- Object 클래스

## 자바 상속의 특징
상속(inheritance)이란 기존의 클래스에 기능을 추가하거나 `재정의`하여 클래스를 정의하는 것을 말한다.

현실에서 부모가 자식에게 물려주는듯이, 부모 클래스의 모든 필드와 메소드를 물려받아 자식 클래스가 이를 사용할 수 있게 됩니다.

### 상속의 장점

- 클래스를 재활용할 수 있다.
- 자식 클래스에서 중복되는 메소드가 있다면 부모 클래스에 정의해놓고 가져다가 쓸 수 있다. (중복 코드 제거)
- 다형성의 장점을 극대화

```java
package azurealstn;

class Parent {
    private int a = 10;
    public int b = 20;
}

class Child extends Parent {
    public int c = 30;
    void display() {
        System.out.println(b);
        System.out.println(c);
        //System.out.println(a); 에러 발생
    }
}

public class Inheritance01 {
    public static void main(String[] args) {
        Child ch = new Child();
        ch.display();
    }
}
```

## super 키워드
super 키워드는 부모 클래스로부터 상속 받은 필드나 메소드를 자식 클래스에서 참조하는데 사용하는 참조 변수이다.

`this` 키워드는 인스턴스 변수와 지역 변수의 이름이 같을 때 사용하여 구분하였지만,
`super` 키워드는 부모 클래스의 멤버와 자식 클래스의 멤버 이름이 같을 경우에 사용한다.

```java
package azurealstn;

class Parent {
    int a = 10;
}

class Child extends Parent {
    int a = 20;
    void display() {
        System.out.println(a); //20
        System.out.println(this.a); //20
        System.out.println(super.a); //10 (부모 클래스 참조)
    }
}

public class Inheritance01 {
    public static void main(String[] args) {
        Child ch = new Child();
        ch.display();
    }
}
```

`this()`메소드가 같은 클래스의 다른 생성자를 호출할 때 사용한다면,
`super()`메소드는 부모 클래스의 생성자를 호출할 때 사용한다.

*다만 주의할 점이 있다*
만약 자식 클래스에서 매개변수를 가지는 생성자를 선언해야 할 경우에는 부모 클래스에 명시적으로 기본 생성자를 생성해주는 것이 좋다.

```java
package azurealstn;

class Parent {
    int a;
    Parent() { a = 10; }
    Parent(int n) { a = n; }
}

class Child extends Parent {
    int b;
    Child() {
        super(40);
        b = 20;
    }
    void display() {
        System.out.println(a);
        System.out.println(b);
    }
}

public class Inheritance01 {
    public static void main(String[] args) {
        Child ch = new Child();
        ch.display();
    }
}
```

## 메소드 오버라이딩
메소드 오버로딩이란 같은 이름의 메소드를 여러개 정의하는 것이라고 설명했다.
`메소드 오버라이딩`은 부모 클래스의 메소드를 가지고 자식 클래스에서 재정의하여 사용하는 것을 말한다. (상속 관계)

```java
package azurealstn;

class Parent {
    void display() {
        System.out.println("부모클래스의 메소드");
    }
}

class Child extends Parent {
    //재정의
    void display() {
        System.out.println("자식클래스의 메소드");
    }
}

public class Inheritance01 {
    public static void main(String[] args) {
    //다형성
        Parent pa = new Parent();
        pa.display();
        Child ch = new Child();
        ch.display();
        Parent pc = new Child(); //Dynamic Dispatch
        pc.display();
    }
}
```

###  오버로딩과 오버라이딩

- 오버로딩은 새로운 메소드를 정의
- 오버라이딩은 상속받은 기존의 메소드를 재정의

```java
package azurealstn;

class Parent {
    void display() {
        System.out.println("부모클래스의 메소드");
    }
}

class Child extends Parent {
    //오버라이딩 (매개변수나 타입이 같다.)
    void display() {
        System.out.println("자식클래스의 메소드");
    }
    //오버로딩 (매개변수나 타입이 다르다.)
    void display(String str) {
        System.out.println(str);
    }
}

public class Inheritance01 {
    public static void main(String[] args) {
        Child ch = new Child();
        ch.display(); //오버라이딩
        ch.display("오버로딩 예제");
    }
}
```

## 다이나믹 메소드 디스패치 (Dynamic Method Dispatch)
`Method Dispatch`: 어떤 메소드를 호출할지 결정하여 실제로 실행시키는 과정

### Static Dispatch
컴파일 시점에서 컴파일러가 특정 메소드를 호출할 것이라는 걸 명확하게 알고 있는 경우  
컴파일 시 생성된 바이트코드에도 이 정보가 그대로 남아있다.

### Dynamic Dispatch
상위 개념인 인터페이스 혹은 추상 클래스에서 정의된 추상 메소드를 호출하는 경우에 해당한다.

```java
Parent pa = new Child(); //이 경우
```

### Double Dispatch
Dispatch가 연속으로 이뤄지는 것을 말한다.

[참고 - https://defacto-standard.tistory.com/413]

## 추상 클래스
다형성이란 하나의 객체가 여러가지 타입을 가질 수 있는 것을 말한다.
다만 `instanceof`연산자를 이용하여 참조 변수가 참조하고 있는 인스턴스의 실제 타입을 확인할 수 있다.

```java
문법
참조변수 instanceof 클래스이름
package azurealstn;

class Parent { }
class Child extends Parent { }

public class Inheritance01 {
    public static void main(String[] args) {
        Parent pa = new Parent();
        System.out.println(pa instanceof Object); //true
        System.out.println(pa instanceof Parent); //true
        System.out.println(pa instanceof Child); //false
        
        Parent c = new Child();
        System.out.println(c instanceof Object); //true
        System.out.println(c instanceof Parent); //true
        System.out.println(c instanceof Child); //true
    }
}
```

그렇다면 추상 메소드란 무엇인가
자식 클래스에서 반드시 오버라이딩을 해야만 사용할 수 있는 메소드를 정의합니다.

- 예를 들어, 모듈처럼 공통적인 부분은 미리 만들어진 것을 사용하고 이를 받아 자신이 필요한 부분만 재정의하여 사용한다.

```java
문법
abstract 반환타입 메소드이름();
```

---

추상 클래스란 하나 이상의 추상 메소드를 포함하는 클래스를 말한다.

- 반드시 사용되어야 하는 메소드를 추상 클래스에 추상 메소드로 선언해 놓으면, 이 클래스를 상속 받는 모든 클래스에서 이 추상 메소드를 반드시 재정의해야 한다.

```java
package azurealstn;

abstract class Animal { abstract void cry(); }
class Cat extends Animal {
    @Override
    void cry() {
        System.out.println("냐옹");
    }
}
class Dog extends Animal {
    @Override
    void cry() {
        System.out.println("멍멍");
    }
}
public class Poly {
    public static void main(String[] args) {
        Cat c = new Cat();
        Dog d = new Dog();
        c.cry();
        d.cry();
    }
}
```

### 추상 클래스 사용 목적
목적은 추상 메소드가 포함된 클래스를 상속받는 자식 클래스가 반드시 추상 메소드를 구현하도록 하기 위함.
만약 일반 메소드였다면 구현할수도 안할수도 있기 때문이다.

## Object 클래스
자바에서 Object 클래스는 모든 클래스의 부모 클래스가 되는 클래스다.
따라서 자바의 모든 클래스는 자동으로 Object 클래스를 상속받게 된다.

- 자바의 모든 객체에서 `toString()`이나 `clone()`과 같은 메소드를 사용할 수 이유가 해당 메소드들이 Object 클래스의 메소드이기 때문이다.

[참고 - http://www.tcpschool.com/java/intro]
