# 목표
자바의 인터페이스에 대해 학습하세요.

# 학습할 것 (필수)

- 인터페이스 정의하는 방법
- 인터페이스 구현하는 방법
- 인터페이스 레퍼런스를 통해 구현체를 사용하는 방법
- 인터페이스 상속
- 인터페이스의 기본 메소드 (Default Method), 자바 8
- 인터페이스의 static 메소드, 자바 8
- 인터페이스의 private 메소드, 자바 9

# 인터페이스 정의하는 방법
자식 클래스가 여러 부모 클래스를 상속받을 수 있다면 다양한 동작을 수행할 수 있을 것이다.
하지만 무분별한 다중 상속은 그 메소드의 본래 목적을 잃어버려 자바에서는 클래스를 통한 다중 상속은 지원하지 않는다.

하지만 다중 상속의 장점은 여전히 좋고 버릴 수 없기 때문에 클래스 대신에 **인터페이스(interface)**라는 것을 통해 다중 상속을 지원하고 있다.

인터페이스는 다른 클래스를 작성할 때 기본이 되는 틀을 제공하며 중간 매개 역할까지 담당하는 일종의 추상 클래스를 의미한다.

**다만 추상 클래스는 추상 메소드 뿐만 아니라 생성자, 필드, 일반 메소드도 포함**될 수 있지만
**인터페이스는 오로지 추상 메소드와 상수만을 포함**할 수 있다.

---

**인터페이스를 선언하는 방법**은 클래스를 작성하는 방법과 같다.

```java
접근제어자 interface 인터페이스 이름 {
	public static final 타입 상수이름 = 값;
	public abstract 메소드이름(인자값);
	//이 두 개만 포함이 가능하다.
	//또한 클래스와는 달리 인터페이스의 모든 필드는 public static final이어야 하며 모든 메소드는 public abstract이어야 한다. (여기서 public은 공통으로 적용되므로 생략이 가능하다.)
}
```

# 인터페이스 구현하는 방법
인터페이스는 추상 클래스와 마찬가지로 자신이 직접 인스턴스를 생성할 수 없다.
즉, 인터페이스가 포함하고 있는 추상 메소드를 구현해 줄 클래스를 따로 작성해야 한다.

**구현 방법**
```java
class 클래스이름 implements 인터페이스이름 {...}
```

다음 예제를 보자

```java
package azurealstn;

interface Animal {
    public abstract void cry();
}

class Cat implements Animal {
    @Override
    public void cry() {
        System.out.println("냐옹");
    }
}
class Dog implements Animal {
    @Override
    public void cry() {
        System.out.println("멍멍");
    }
}
public class Poly {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        cat.cry(); //냐옹
        dog.cry(); //멍멍
    }
}
```

# 인터페이스 레퍼런스를 통해 구현체를 사용하는 방법
위 예제에서 객체를 생성할 때 클래스 타입으로 객체를 생성하였는데,
`Animal`타입으로도 생성이 가능하다.

```java
Animal cat = new Cat(); //냐옹
Animal dog = new Dog(); //멍멍
```

또한 `Animal`인터페이스를 인자로 받는 메소드가 있다면 `Cat`, `Bird`타입의 인스턴스를 인자로 사용가능하다.

```java
package azurealstn;

interface Animal {
    public abstract void cry();
    String getName();
}

class Cat implements Animal {
    @Override
    public void cry() {
        System.out.println("냐옹");
    }

    @Override
    public String getName() {
        return "지킴이";
    }

}
class Dog implements Animal {
    @Override
    public void cry() {
        System.out.println("멍멍");
    }

    @Override
    public String getName() {
        return "네로";
    }

}
public class Poly {
    public static void print(Animal animal) {
        System.out.println(animal.getName());
    }
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        Poly.print(cat);
        Poly.print(dog);
    }
}
```

# 인터페이스 상속
자바에서는 상속과 구현을 동시에 할 수 있다.

```java
문법
class 클래스이름 extends 부모클래스이름 implements 인터페이스이름 {...}
//인터페이스는 인터페이스로부터만 상속받을 수 있으며 여러 인터페이스를 상속받을 수 있다.
```

```java
다중상속
package azurealstn;

interface Animal {
    public abstract void cry();
}
interface Pet {
    public abstract void play();
}

class Cat implements Animal, Pet {
    @Override
    public void cry() {
        System.out.println("냐옹");
    }

    @Override
    public void play() {
        System.out.println("나무타기");
    }
}
class Dog implements Animal, Pet {
    @Override
    public void cry() {
        System.out.println("멍멍");
    }

    @Override
    public void play() {
        System.out.println("공원산책하기");
    }
}
public class Poly {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        cat.cry();
        cat.play();
        dog.cry();
        dog.play();
    }
}
```

# 인터페이스의 기본 메소드 (Default Method), 자바 8
디폴트 메소드는 기본 구현을 가지는 메소드이다. 앞에 `default` 예약어를 붙인다. 또한 접근 제어가 **public**인데 생략 가능하다.

디폴트 메소드는 인터페이스에 이미 구현되어 있으므로 인터페이스를 구현한 클래스에서 코드를 구현할 필요 없다.

**여러 인터페이스의 디폴트 메소드끼리 충돌**이 일어날 수 있는데,
인터페이스를 구현한 클래스에서 디폴트 메소드를 오버라이딩해야 한다.

**디폴트 메소드와 상위 클래스의 메소드끼리 충돌**이 일어날 수 있는데,
상위 클래스의 메소드가 상속되고, 디폴트 메소드는 무시된다.

# 인터페이스의 static 메소드, 자바 8
스테틱 메소드는 인스턴스 생성과 상관없이 인터페이스 타입으로 호출되는 메소드이다.
`static` 예악어를 사용하며, 역시 **public** 생략 가능하다.

이 정적 메소드를 사용할 때는 인터페이스를 직접 참조한다.

# 인터페이스의 private 메소드, 자바 9
보통 외부에서 접근할 수 없도록 `private`을 사용하는데, **Java 8**에서는 사용이 불가능하다. 하지만 **Java 9**부터 지원하고 있다.

[참고 - http://happinessoncode.com/2017/04/19/java8-changes-in-interface/]

## 특징

- 메소드 body가 있고 abstract가 아니다.
- static이거나 non-static일 수 있다.
- 구현 클래스와 인터페이스가 상속되지 않는다.
- 인터페이스에서 다른 메소드를 호출할 수 있다.

[참고 - https://flyburi.com/605]
