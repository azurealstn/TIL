## Array

- 배열은 같은 타입의 데이터들을 모아놓은 바구니를 말한다. 우리가 일일이 하나하나 선언할 필요없이 비슷한 것들을 한데 묶어놓는 것이다.
- `Index`로 접근이 가능하다.

### 배열 선언

```javascript
'use strict';

const arr1 = new Array(); 
const arr2 = [1, 2, 3];

console.log(arr1); //[], 빈 배열
console.log(arr2); //[1, 2, 3]
console.log(arr2[0]); //1, Index로 접근
console.log(arr2.length); //3, 배열의 길이
console.log(arr2[arr2.length - 1]); //3, 배열의 마지막 요소

//모든 요소 출력 (3가지 방법)
for (let i = 0; i < arr2.length; i++) {
  console.log(arr2[i]);
}
for (let num of arr2) {
  console.log(num);
}
arr2.forEach(value => console.log(value));
```

### 배열의 삽입과 삭제

```javascript
//삽입
arr2.push(4, 5);
console.log(arr2); //[1, 2, 3, 4, 5]

//삭제
arr2.pop();
console.log(arr2); //[1, 2, 3, 4]

//앞에서 삽입 : unshift
arr2.unshift(0);
console.log(arr2); //[0, 1, 2, 3, 4]

//앞에서 삭제 : shift
arr2.shift();
console.log(arr2); //[1, 2, 3, 4]

console.clear();
//지정된 위치에 삭제 : splice
console.log(arr2); //[1, 2, 3, 4]
arr2.splice(1, 1);
console.log(arr2); //[1, 3, 4]
arr2.splice(1, 1, 2, 3);
console.log(arr2); //[1, 2, 3, 4]

//combine arrays
const arr3 = ['a', 'b'];
const newArr = arr2.concat(arr3);
console.log(newArr); //[1, 2, 3, 4, 'a', 'b']

//indexOf
console.clear();
console.log(arr2);
console.log(arr2.indexOf(1)); //0번째 Index
console.log(arr2.indexOf(-1)); //-1, 없는 값은 -1출력
console.log(arr2.includes(2)); //true
console.log(arr2.includes(-1)); //false

//lastIndexOf
arr2.push(2);
console.log(arr2.lastIndexOf(2)); //4, 2요소의 맨 마지막 Index를 출력

//join
{
  const fruits = ['apple', 'banana', 'orange'];
  const fruit = fruits.join(',');
  console.log(fruit); //apple,banana,orange
}

//split
{
  const fruits = '🍎, 🥝, 🍌, 🍒';
  const fruit = fruits.split(',');
  console.log(fruit); //["🍎", " 🥝", " 🍌", " 🍒"]
}

//reverse
{
  const array = [1, 2, 3, 4, 5];
  const re = array.reverse();
  console.log(re); //[5, 4, 3, 2, 1]
}

//slice
{
  const array = [1, 2, 3, 4, 5];
  const newArr = array.slice(2, 5);
  console.log(newArr); //[3, 4, 5]
}

class Student {
  constructor(name, age, enrolled, score) {
    this.name = name;
    this.age = age;
    this.enrolled = enrolled;
    this.score = score;
  }
}
const students = [
  new Student('A', 29, true, 45),
  new Student('B', 28, false, 80),
  new Student('C', 30, true, 90),
  new Student('D', 40, false, 66),
  new Student('E', 18, true, 88),
];

//find
{
  const good = students.find(v => v.score === 90);
  console.log(good); //Student {name: "C", age: 30, enrolled: true, score: 90}
}

//filter
{
  const enroll = students.filter(v => v.enrolled === true);
  console.log(enroll); //[Student, Student, Student]
}

//map
{
  const score = students.map(v => v.score);
  console.log(score); //[45, 80, 90, 66, 88]
}

//some
{
  const score50 = students.some(v => v.score < 50);
  console.log(score50); //true
  const score51 = students.every(v => v.score < 50);
  console.log(score51); //false
}

//reduce
{
  const result = students.reduce((acc, cur) => acc + cur.score, 0);
  console.log(result); //sum
  console.log(result / students.length); //average
}

//sort
{
  const score = students.map(v => v.score);
  const sorted = score.sort((a, b) => a - b);
  console.log(sorted.join(', ')); //45, 66, 80, 88, 90
}
```

- 여기서 중요한 점은 `push`나 `pop`보다 `unshift`나 `shift`가 훨 느리다. 그래서 `push`, `pop`을 쓰는 것이 좋다.
- 그 이유는 `push`나 `pop`은 기존 데이터에서 맨 뒤에 삽입하거나 삭제하기에 기존 데이터는 가만히 있고 쉽게 삽입하거나 삭제가 가능하다. 하지만 `unshift`나 `shift`는 앞에다 삽입이나  삭제하기 때문에 기존에 있던 데이터들을 오른쪽으로 한칸씩 이동시켜야 하기 때문에 배열의 길이가 길수록 더 느리게 작동할 것이다.
- `splice()`에서 첫번째 파라미터는 `Index`부터 두번째 파라미터는 몇개를 지울 건지, 그 뒤부터는 `push`가 될 요소들이다.
- `concat()` : 두 배열을 합치는 함수이다.
- `indexOf()` : 배열의 요소를 파라미터로 받아서 그 요소의 `Index`를 출력
- `includes()`: 배열의 요소를 파라미터로 받아서 있으면 `true`, 없으면 `false`를 출력
- `lastIndexOf()` : 배열의 요소를 파라미터로 받아서 그 요소의 마지막 `Index`를 출력
- `join()` : array를 string으로 변환
- `split()` : a string into substrings, 구분자를 꼭 전달해주어야 한다.
- `reverse()` : 배열 자체를 reverse 시킨다.
- `slice()` : 원하는 구간을 파라미터로 받아서 리턴한다.
- `find()` : 콜백함수를 파라미터로 받아서 학생을 한명한명 확인하면서 score가 90점인 학생을 찾는다.
- `filter()` : 말 그대로 필터링할 때 사용한다. 조건에 맞는 학생을 필터링해서 새로운 배열을 리턴한다.
- `map()` : 콜백함수를 호출하면서 함수에 의해 연산되어 매핑되어 새로운 배열이 생성된다.
- `some()` : Determines whether the specified callback function returns true for any element of an array.
- `every()` : some()과는 다르게 모든 학생들을 검사하여 한명이라도 조건에 맞지않으면 false를 리턴한다.
- `reduce()` : 배열에 있는 값을 누적할 때 사용.
- `sort()` : 오름차순 또는 내림차순으로 정렬할 때 사용.

### 출제 링크

[위 예제에서 문제 보기](https://www.youtube.com/watch?v=3CUjtKJ7PJg&list=PLv2d7VI9OotTVOL4QmPfvJWPJvkmv6h-2&index=9)
