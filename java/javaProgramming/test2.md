# 8주자 과제: 인터페이스

## 목표

자바의 인터페이스에 대해 학습하세요.

<br>

## 학습할 것

- 인터페이스 정의하는 방법
- 인터페이스 구현하는 방법
- 인터페이스 레퍼런스를 통해 구현체를 사용하는 방법
- 인터페이스 상속
- 인터페이스의 기본 메소드 (Default Method), 자바 8
- 인터페이스의 static 메소드, 자바 8
- 인터페이스의 private 메소드, 자바 9

<br>
<br>
<br>

## 인터페이스 정의하는 방법

인터페이스는 추상클래스의 개념과 비슷합니다. 요즘은 추상클래스는 잘 쓰고, 인터페이스의 기능이 좋아져서 거의 인터페이스만 사용한다고 합니다.  

<br>

인터페이스란 동일한 목적 하에 동일한 기능을 수행하게끔 강제하는 것을 말합니다.  
예를 들어, Animal 인터페이스가 있는데 동일한 기능인 `eat()`이라는 메소드를 만들고, Dog, Cat 등의 클래스를 만들어서 Animal 인터페이스를 상속받으면 이 `eat()`메소드를 강제로 오버라이딩해서 구현하도록 합니다.

<br>

이러면 다형성을 극대화하여 코드도 깔끔해져서 유지보수에도 좋습니다.  
바로 코드로 보겠습니다.

<br>
<br>
<br>

## 인터페이스 구현하는 방법

인터페이스는 `interface` 키워드를 통해 선언할 수 있으며 `implements` 키워드를 통해 인터페이스를 상속받을 수 있습니다.

<br>

일반적으로 클래스 같은 경우는 상속은 한 개만 받을 수 있는데 인터페이스는 여러 개의 인터페이스를 상속받을 수 있습니다. 그래서 확장하기가 쉽습니다.  
필요한 공통 기능을 구현하려면 해당하는 인터페이스를 상속받으면 되겠죠.

<br>

또한 인터페이스는 JAVA 8 이전까지는 상수와 추상메소드만 선언이 가능했지만,  
JAVA 8부터는 디폴트 메소드와 정적 메소드가 추가되었습니다.  
JAVA 8 이전에는 상수와 추상메소드만 선언이 가능했기 때문에 강제성이 그만큼 강했지만 디폴트 메소드와 정적 메소드가 추가된 이 후로는 강제성 안에서 유연함이 생겼다고 할 수 있습니다.  
코드로 보겠습니다.

<br>

### Animal Interface

```java
package com.azurealstn.sociallogin;

public interface Animal {

    /**
     * 필드 선언 규칙.
     * 필드는 공개 필드이고, 스태틱 필드이며, 값을 바꿀 수 없는 상수입니다.
     */
    public static final int DOG_LEGS = 4;
    int CAT_LEGS = 4; //public static final 생략 가능

    /**
     * 추상메소드 규칙
     * 메소드는 공개 메소드이고, 추상메소드입니다.
     */
    public abstract void cry();
    void feeling(); //public abstract 생략 가능
}
```

<br>

### Dog Class

```java
package com.azurealstn.sociallogin;

public class Dog implements Animal {

    @Override
    public void cry() {
        System.out.println("멍멍!!");
    }

    @Override
    public void feeling() {
        System.out.println("기분 좋음!");
    }

    public int legCount() {
        return Animal.DOG_LEGS;
    }
}
```

<br>

### Cat Class

```java
package com.azurealstn.sociallogin;

public class Cat implements Animal {

    @Override
    public void cry() {
        System.out.println("야옹~!");
    }

    @Override
    public void feeling() {
        System.out.println("나른함!~");
    }

    public int legCount() {
        return Animal.CAT_LEGS;
    }
}
```

위 코드를 보시면 `Animal` 인터페이스에 있는 필드는 변경할 수 없는 상수로 그대로 써야합니다.  
그리고 추상메소드는 오버라이딩해서 구현을 강제하고 있습니다. 이러면 공통된 기능을 가지고 규칙을 갖고 각각 구현해서 코드가 좀 더 간결해지고 유지보수에 용이해집니다.

<br>

또한 인터페이스는 인터페이스끼리 상속도 가능합니다. 이 때는 `extends` 키워드를 사용하며 더욱 확장하기에 용이해집니다.

<br>
<br>
<br>

## 인터페이스 레퍼런스를 통해 구현체를 사용하는 방법

추상클래스는 객체를 생성할 수 없지만 인터페이스는 객체를 생성할 수 있으며 해당 객체에 구현 클래스로 인스턴스화 할 수 있습니다.

<br>

인터페이스 타입으로 선언한 객체는 구현 클래스 내에서 생성한 메소드나 필드를 사용할 수 없습니다.

### Main Class

```java
public class Main {
    public static void main(String[] args) {
        Animal animal = new Dog();
        Dog dog = new Dog();

        System.out.println(animal.legCount()); //사용 불가
        System.out.println(dog.legCount()); //사용 가능
    }
}
```

<br>
<br>
<br>

## 인터페이스 상속

앞에서 얘기했지만 추상클래스는 다중 상속이 안되지만 인터페이스는 다중 상속이 가능합니다.  

### Exercise Interface

```java
package com.azurealstn.sociallogin;

public interface Exercise {
    
    void swim();
}
```

<br>

### Cat Class

```java
package com.azurealstn.sociallogin;

public class Cat implements Animal, Exercise {

    @Override
    public void cry() {
        System.out.println("야옹~!");
    }

    @Override
    public void feeling() {
        System.out.println("나른함!~");
    }

    public int legCount() {
        return Animal.CAT_LEGS;
    }

    @Override
    public void swim() {
        System.out.println("고양이가 수영합니다..");
    }
}
```

`Cat` 클래스에서 두 개의 인터페이스를 상속받고 있습니다. 만약 뭔가 특정한 공통된 기능을 더 추가하고 싶다면 그냥 해당하는 인터페이스를 상속받고 오버라이딩해서 구현하면 됩니다.

<br>

인터페이스끼리의 상속은 `extends`를 사용합니다.

### Mammalia Interface

```java
package com.azurealstn.sociallogin;

public interface Mammalia extends Animal {
}
```

<br>
<br>
<br>

## 인터페이스의 기본 메소드 (Default Method), 자바 8

Java 8 이전에는 상수와 추상메소드만 사용이 가능했습니다. 그래서 강제성이 굉장히 강했습니다. 하지만 Java 8 부터는 디폴트 메소드와 스태틱 메소드가 생기면서 조금 유연해졌습니다.  

<br>

- 디폴트 메소드는 상속받는 클래스에서 필수로 구현하지 않아도 됩니다. 오버라이딩해서 구현해도 되고 안해도 됩니다.
- 스태틱 메소드는 인터페이스를 이용하여 간단한 기능을 가지는 유틸리티성 인터페이스를 만들 수 있게 합니다.
	- 스태틱 메소드는 구현 클래스 내에서 오버라이딩 불가능합니다. 즉, 인터페이스에서 제공하는 메소드만 사용할 수 있다는 뜻입니다.

### Bank Interface

```java
package com.azurealstn.sociallogin;

public interface Bank {

    default void findPasswordReqeust(String userId) {
        System.out.println(userId + "의 비밀번호를 찾습니다.");
    }

    static void BCAuth(String bankName) {
        System.out.println(bankName + "에서 블록체인 인증을 요청합니다.");
    }
}
```

<br>

### KBBank Class

```java
package com.azurealstn.sociallogin;

public class KBBank implements Bank {

    @Override
    public void findPasswordReqeust(String userId) {
        System.out.println(userId + "가 비밀번호 찾기를 요청하였습니다.");
    }
}
```

<br>

### Main Class

```java
package com.azurealstn.sociallogin;

public class Main {
    public static void main(String[] args) {
        Bank bank = new KBBank();
        bank.findPasswordReqeust("K1234"); //구현클래스에서 재정의해서 사용
        Bank.BCAuth("국민은행"); //인터페이스에 있는 메소드 그대로 사용
    }
}
```

<br>
<br>
<br>

## 인터페이스의 private 메소드, 자바 9

인터페이스의 메소드는 `public`입니다. 그래서 생략도 가능했었죠. 하지만 외부에 공개하지 않도록 만들기 위해 Interface에 대한 캡슐화를 유지할 수 있게 `private`을 사용할 수 있습니다. `private` 접근지시자는 Java 9 부터 사용할 수 있다는 점을 유의하시고 사용하시면 됩니다.

```java
public interface Bank {
	...
    
    private void BankAuthPw(String bankName) {
        System.out.println(bankName + "의 권한 번호는 1234 입니다.");
    }
}
```

인터페이스에서 private 메소드는 그 인터페이스 내에서만 사용할 수 있습니다.

<br>
<br>
<br>

## References

- https://limkydev.tistory.com/197
- https://uoonleen.tistory.com/52
- https://youn12.tistory.com/31
