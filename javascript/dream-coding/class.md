## class
자바스크립트에서 `class`는 ES6에 추가되었다. 완전히 추가된 것이 아닌 프로토타입을 베이스로 해서 추가된 것이다.

#### 클래스 선언

```javascript
'use strict';

class Person {
  //constructor
  constructor(name, age) {
    this.name = name;
    this.age = age;
  }

  //methods
  speak() {
    console.log(`${this.name}: hello!`);
  }
}
const minsu = new Person('minsu', 27); //Object 생성
console.log(minsu.name);
console.log(minsu.age);
minsu.speak();
```

- 위 코드는 `Person`이라는 class를 선언해주었고, 아래에 `minsu`라는 object를 생성해주었다.

#### Getter, Setter

```javascript
'use strict';

class User {
  constructor(firstName, lastName, age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
  }
}
const user1 = new User('Steve', 'Job', -1);
console.log(user1.age);
```

- `User`이라는 class를 선언하고, `user`이라는 object를 생성해주었다. 여기서 `user1.age`를 `-1`로 잘못 설정했는데도 당연히 정상 출력이 된다.
- 이를 막기 위해 `getter`와 `setter`를 사용한다.

```javascript
'use strict';

class User {
  constructor(firstName, lastName, age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
  }
  //getter
  get age() {
    return this.age;
  }
  
  //setter
  set age(value) {
    this.age = value;
  }
}
const user1 = new User('Steve', 'Job', -1);
console.log(user1.age);
```

- 하지만 이렇게 프로그램을 실행시키면 콜스택이 초과되었다는 에러메시지가 뜰 것이다.
- `get age()`라고 선언을 한 순간에 생성자에 있는 `this.age`는 메모리에 올라가 있는 데이터를 읽어오는 것이 아니라 바로 `get age()`를 호출하게 된다.
- 또한 `set age()`를 선언한 순간 생성자에 있는 `= age;`는 age라는 값을 할당할 때 바로 메모리에 할당하는 것이 아닌 `set age()`를 호출하게 된다.

```javascript
set age(value) {
    this.age = value;
}
```

- 여기에서 보면 위에서 설명했듯이 `this.age = value;`에서 `this.age`를 `value`라는 값을 할당할 때 메모리에 할당하는 것이 아니라 `set age()`를 호출하게 된다.
- 즉, `set age()`를 호출했으니까 또 `this.age = value;`를 실행하고, 이것은 또 `set age()`를 호출하게 되니까 무한 반복이 된다.
- 그래서 에러가 뜨는데 이것은 변수를 조금 다르게 변환해주면 해결된다. (아래 코드)

```javascript
get age() {
  return this._age;
}

set age(value) {
  this._age = value;
}
```

- 나이를 `-(마이너스)`로 설정하면 안되니까 조건문을 달면 된다.

```javascript
set age(value) {
  this._age = value < 0 ? 0 : value;
}
```

- 한 가지더 우리가 이름은 `this._age`라고 했지만 `console.log(user1.age);`에서는 그냥 `age`라고 할 수 있는 이유는 내부적으로 `getter`, `setter` 사용했기에 가능한 것이다.

## 상속과 다형성

```javascript
'use strict';

class Shape {
  constructor(width, height, color) {
    this.width = width;
    this.height = height;
    this.color = color;
  }
  draw() {
    console.log(`drawing ${this.color} color of`);
  }
  getArea() {
    return this.width * this.height;
  }
}

class Rectangle extends Shape { }
class Triangle extends Shape { }

const rectangle = new Rectangle(20, 20, 'blue');
rectangle.draw();
const triangle = new Triangle(20, 20, 'red');
triangle.draw();
```

#### 상속

- 자, 먼저 `Shape` 이라는 공통적인 상위 클래스를 하나 정의해 놓는다.
- `Shape`에는 `Rectangle(직사각형)`이 있고, `Triangle(삼각형)` 등이 있을 수 있는데, 여기서도 `width`, `height`, `color`를 똑같이 써야한다면 다시 정의해서 써야할까?  
- 그럴 필요없이 `Shape`에 있는 공통적인 것들은 가져다가 사용할 수 있는데 이것을 `상속(Inheritance)`이라고 한다. 말 그대로 부모의 것을 물려받는 것이다.

#### 다형성

- 여기서 다양성이 또 빛을 발한다.

```javascript
const rectangle = new Rectangle(20, 20, 'blue');
rectangle.draw();
console.log(rectangle.getArea()); //400
const triangle = new Triangle(20, 20, 'red');
triangle.draw();
console.log(triangle.getArea()); //400
```

- 직사각형의 `getArea()`는 `400`이 맞지만, 삼각형은 1/2로 나누어야한다. 이 때 우리가 필요한 함수를 재정의해서 사용할 수가 있는데 이것을 `재정의(Overriding)`이라고 한다.

```javascript
class Rectangle extends Shape { }
class Triangle extends Shape {
  draw() {
  	super.draw();
    console.log('❌');
  }
  //Overriding
  getArea() {
    return (this.width * this.height) / 2;
  }
}

const rectangle = new Rectangle(20, 20, 'blue');
rectangle.draw();
console.log(rectangle.getArea());
const triangle = new Triangle(20, 20, 'red');
triangle.draw();
console.log(triangle.getArea());
```

- `Triangle` 클래스에 `getArea()` 이 함수를 재정의한 것이다. 이것이 가능하려면 먼저 상위 클래스의 상속을 받아야 한다. `draw()` 역시 재정의할 수 있다.
- 하지만 만약에 우리가 `draw()` 함수를 상위 클래스에 있는 `draw()`의 내용도 출력하게 만들고 싶고, 우리가 정의한 내용도 출력하게 만들고 싶다면 `super` 이라는 키워드를 사용하면 상위 클래스의 내용 그대로 가져올 수 있다.

---

여기서 그냥 넘기기 아쉬워서 사실 자바스크립트에는 없는 개념인 Overloading에 대해 잠깐 짚고 넘어가겠다.(자바에서는 사용을 한다. ⭕)  
앞서 Overriding은 상속 받은 클래스가 상위 클래스의 메소드를 재정의해서 사용한 것을 말했다.

```java
class Calc {
    int add(int a, int b) {
        return a + b;
    }
    // Overloading
    int add(int a) {
        return a + 1;
    }
    // Overloading
    double add(double a, double b) {
        return a + b;
    }
}

public class Calculation {
    public static void main(String[] args) {
        Calc calc = new Calc();
        int result1 = calc.add(3, 7);
        int result2 = calc.add(4);
        double result3 = calc.add(3.5, 5.5);

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }
}
```

- 위 코드는 자바로 된 코드이다. `Calc`라는 클래스에 `add()` 함수가 총 3개가 있다. 하지만 각 함수는 **매개변수의 개수가 다르고, type도 다르며, return값도 다르다.**
- 여기서 알 수 있듯이 우리가 이 `Overloading`을 사용하는 이유는 비슷한 함수들을 다시 이름을 짓기가 까다로워서 메소드이름을 다 같게 사용하는 것이다.
- 다만 Overloading 사용하기 위해 조건이 있는 위에 말했듯이 매개변수의 개수나, type 또는 return 값이 달라야 한다.

## instanceof

```javascript
console.log(rectangle instanceof Rectangle); //true
console.log(triangle instanceof Rectangle); //false
console.log(triangle instanceof Triangle); //true
console.log(triangle instanceof Shape); //true
console.log(triangle instanceof Object); //true
```

- `instanceof`는 왼쪽에 있는 object가 오른쪽에 있는 클래스의 인스턴스인지 아닌지 구별해준다.
- 리턴값은 `true`, `false`이다.
- 자바스크립트의 모든 Object는 이 `Object` 클래스를 상속받고 있다.
