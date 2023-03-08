# Hash Table

만약에 어떤 사람이 유튜브 동영상을 다운로드 받아서 그대로 자신의 영상을 올리게 되면 에러가 발생한다. 바로 중복된 영상이라고 경고를 내리는데 이게 가능한 이유가 `Hash Table`이다.

## Hash Table 개념

```shell
F(key) -> Hash Code -> Index -> Value
```

Hash Table이란 검색하고자 하는 `Key값`을 입력받고 입력받은 Key값을 `해시 함수`를 이용하여 반환받은 `Hash Code`를 배열의 `index`로 환산해서 `데이터(Value)`를 저장하고 접근하는 방식을 Hash Table이라 한다. (위에서 설명한 키워드들을 하나씩 알아보자.)

> Key값은 문자열이나 숫자, 파일 데이터가 될 수 있다.

## Hash Table 과정

![hash1](/images/data-structure/hash1-1.png)

- Hash Table의 가장 큰 장점은 검색 속도가 매우 빠르다는 점이다.
- 위 그림에서 `Key값`을 `해시 함수`를 이용하여 `Hash Code`를 반환한다. - 이 때 해시코드는 정수이다.
- 배열을 고정된 크기만큼 미리 만들어 놓는다. (0, 1, 2, ...)
- `(해시코드 % 배열의 개수) -> 나머지 결과값`을 배열에 나누어 담는다.
- 이는 해시코드값 자체가 배열의 인덱스로 사용되기 때문에 해시코드로 데이터의 위치를 바로 접근할 수 있기 때문에 검색 속도가 매우 빠른 것이다. (시간복잡도: `O(1)`)

## Hash 충돌

Hash Table은 검색 속도가 매우 빠르다는 장점이 있어서 좋다고 할 수 있지만 한 가지 문제점이 있다.

![hash2](/images/data-structure/hash-2.png)

- 위 그림에서 사람들이 있고, 숙소에는 사람들의 "성" 이니셜을 따서 숙소의 방들이 있다. (K: 김씨, C: 채씨, M: 민씨, L: 이씨)
- 사람들을 "성" 이니셜에 맞게 각각의 숙소방에 배치하려고 하는데 만약 사람들의 "성"이 모두 "김씨" 라면 위 그림처럼 한 방에만 꽉차 있을 것이다. (그렇게 되면 공간 효율이 굉장히 떨어질 것이다.)
- 그래서 방을 나눌 때 효율적으로 배분할 수 있도록 **효율적인 규칙**을 만드는 것이 굉장히 중요한데 이것을 Hash Function 알고리즘이다.
- 해시함수의 알고리즘이 좋지 않을 때 한 방안에 여러 개의 데이터가 생기기 때문에 **충돌**이 발생할 수 있는데 이를 **Hash Collison(해시 충돌)**이 일어난다고 한다.

> 👻 Hash Table의 최대 장점은 검색 속도가 `O(1)`이라는 장점이 있지만 위와 같이 해시 충돌이 발생하면 최대 `O(N)`만큼의 시간복잡도를 갖는다.

## Hash 알고리즘과 충돌

- **Different Keys -> Same Code**
  - 서로 다른 키값을 가지로 해시 함수를 돌리면 동일한 Hash Code가 반환될 수 있다.
  - 그 이유는 키값은 문자열이기 때문에 문자열의 가지수는 무한한데 반해, Hash Code 즉, 정수는 유한하기 때문이다.
  - 따라서 Hash 알고리즘이 아무리 좋아도 충돌이 발생할 수 있다.
- **Different Code -> Same Index**
  - 서로 다른 Hash Code는 `(해시코드 % 배열의 개수)` 연산에 의해 Index로 환산해도 배열의 방은 한정되어 있기 때문에 같은 Index를 사용할 수 있다.

따라서 위 2가지의 경우에 의해 충돌이 발생한다. 따라서 이러한 충돌을 최소화하기 위해 좋은 Hash 알고리즘을 만드는 것은 Hash Table에서 굉장히 중요한 관건이 될 수 있다.

## Hash 충돌 해결법

Hash 충돌을 해결하기 위한 다양한 방법이 있지만 아래 두 가지 방법을 응용한 방법들이다.

**Open Addressing (개방 주소법)**

![hash3](/images/data-structure/hash3.png)

- Open Addressing 방식 중에서도 `Linear Probing`, `Quadratic probing`, `Double hashing probing` 3가지 방식이 있는데 그 중에서 `Linear Probing` 방식을 알아본다.
- 해시 충돌이 발생하면 즉, 배열의 방에 이미 데이터가 들어가있다면 다른 방에 해당 데이터를 배치(삽입)하는 방식을 말한다.
- 공개 주소 방식이라고도 불리는 이 알고리즘은 충돌(Collision)이 발생하면 데이터를 저장할 방을 찾는다. 따라서 최악의 경우에는 비어있는 방을 찾지 못하고 탐색을 시작한 위치까지 되돌아 올 수도 있다.


**Separate Chaining (분리 연결법)**

![hash1](/images/data-structure/hash1-1.png)

- 위에서 살펴본 **Hash Table 과정** 섹션에서 나온 그림이 바로 **Separate Chaining 방식**이라고 할 수 있다.
- 일반적으로 Open Addressing 방식은 Separate Chaining 방식보다 느리다.
- Separate Chaining 방식은 배열의 방들이 있을 때 각각의 방들은 List의 자료구조를 갖는다.
- Open Addressing 방식은 배열의 빈 방을 찾는 방식이라면 Separate Chaining 방식은 해시 충돌이 발생하면 즉, 해당하는 방에 이미 데이터가 있다면 해당 방 안에 `LinkedList`를 선언하여 데이터가 할당될 때마다 `LinkedList`에 추가하면 된다.
- 자바에서 **HashMap**이 Separate Chaining 방식을 사용한다.

> `Open Address` vs `Separate Chaining`
> - 두 방식모두 최악의 경우 `O(M)`이다.
> - Open Address 방식은 연속된 공간에 데이터를 저장하기 때문에 Separate Chaining에 비해 캐시 효울이 좋다. 따라서 데이터의 개수가 충분히 적다면 Open Address 방식이 Separate Chaining 방식보다 성능이 더 좋다.
> - 다만 Open Address 방식은 방(버킷)을 계속 사용해야 하기 때문에 Separate Chaining 방식의 경우 테이블의 메모리를 줄일 수 있다.

## Hash Table 구현하기

## References

- https://github.com/JaeYeopHan/Interview_Question_for_Beginner/tree/master/DataStructure#hash-table
- [쉬운코드 - 맵과 해시테이블](https://www.youtube.com/watch?v=ZBu_slSH5Sk)