# Queue

자바에서 Queue는 `java.util.Queue`를 import하여 사용할 수 있으며, 자바의 Collection 인터페이스를 상속받은 인터페이스이다. 즉, 자바 컬렉션 프레임워크 중 하나이다. 자바에서 Queue를 사용할 때는 인터페이스이기 때문에 아래 코드와 같이 구현체로 LinkedList를 생성해서 사용한다.

```java
Queue<T> Q = new LinkedList<>()
```

## Queue 개념

먼저 Queue의 뜻을 검색해보면 "줄을 서는 것" 라는 의미로, 먼저 들어온 데이터가 먼저 나가는 구조의 저장 공간을 말한다.

![Queue](https://user-images.githubusercontent.com/55525868/221825404-5a7ea39d-065c-4064-ad8d-1fb92688ef21.png)


그림을 보았듯이 Queue는 Stack과는 달리 구멍이 양쪽 끝에 뚫려 있으며, 먼저 들어온 데이터가 먼저 나간다고 해서 FIFO(First In First Out)이라고 한다.

Queue에는 다음과 같은 메서드가 있다.

- `add()` : 맨 끝에 데이터 추가
- `remove()` : 맨 앞에 데이터 삭제
- `peek()` : 맨 앞에 데이터 조회
- `isEmpty()` : 큐가 비어있는지 체크

> 💡 add()와 offer(), remove()와 poll(), element()와 peek() 비교하기
> 자바에서 Queue의 메서드 중 데이터를 추가하는 메서드가 두 개 있다. 또한 데이터를 삭제하는 메서드가 두 개 있고, 맨 앞의 데이터를 조회하는 메서드도 두 개가 있다. 왜 이러한 똑같은 기능이 두 개씩 있는걸까?

### add() vs offer()

|add()|offer()|
|------|---|
|값 추가 성공시 true 반환|값 추가 성공시 true 반환|
|큐가 꽉 찬 경우 IllegalStateException 발생|값 추가 실패시 false 반환|

### remove() vs poll()

|remove()|poll()|
|------|---|
|삭제된 데이터 반환|삭제된 데이터 반환|
|큐가 비어있는 경우 NoSuchElementException 발생|큐가 비어있는 경우 null 반환|

### element() vs peek()

|element()|peek()|
|------|---|
|큐의 맨 앞에 있는 데이터 반환|큐의 맨 앞에 있는 데이터 반환|
|큐가 비어있는 경우 NoSuchElementException 발생|큐가 비어있는 경우 null 반환|

결국 문제가 있는 상황에서 Exception을 발생시키는지(add, remove, element), 아니면 그냥 null 혹은 false를 반환시키는지(offer, poll, peek)에 차이가 있다.

참고: https://cocoon1787.tistory.com/774

## Queue 활용 예시

- 은행창구 번호표 대기
- 놀이공원 줄서기
- BFS
- PriorityQueue

## Queue 구현하기

```java
package com.azurealstn.algorithm.try1.queue;

import java.util.NoSuchElementException;

class Queue<T> {
    class Node<T> {
        private T data; //데이터
        private Node<T> next; //다음 노드

        //Node 생성시 data 할당
        public Node(T data) {
            this.data = data;
        }
    }

    //Queue는 앞뒤로 주소를 알고 있어야 한다.
    private Node<T> first;
    private Node<T> last;

    public void add(T item) {
        Node<T> t = new Node<>(item); //T 타입의 Node 생성
        if (last != null) {
            last.next = t; //last가 null이 아니라면 last의 다음 노드에다가 t 값 할당
        }
        last = t; //t는 마지막 노드를 가리킨다.
        if (first == null) {
            first = last; //first가 null이면 first는 last가 된다.
        }
    }

    public T remove() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        T data = first.data; //first 데이터를 저장해두고,
        first = first.next; //데이터를 삭제했으므로 first를 그 다음 노드를 가리키게 한다.

        if (first == null) {
            last = null; //삭제했을 때 노드가 비어있는 경우 last도 null로 변경
        }
        return data;
    }

    public T peek() {
        //first가 null이면 Exception 발생
        if (first == null) {
            throw new NoSuchElementException();
        }
        //first가 null이 아니면 first 데이터 출력
        return first.data;
    }

    public boolean isEmpty() {
        //first가 null인지만 체크하면 된다.
        return first == null;
    }
}
public class MyQueue {
    public static void main(String[] args) {
        Queue<Integer> Q = new Queue<>();
        Q.add(1);
        Q.add(2);
        Q.add(3);
        System.out.println(Q.remove()); //1
        System.out.println(Q.peek()); //2
        System.out.println(Q.remove()); //2
        System.out.println(Q.isEmpty()); //false
        System.out.println(Q.remove()); //3
        System.out.println(Q.isEmpty()); //true
        System.out.println(Q.remove()); //NoSuchElementException 발생
    }
}

```

## Reference

- [엔지니어대한민국 - 큐](https://www.youtube.com/watch?v=W3jNbNGyjMs)
- https://cocoon1787.tistory.com/774