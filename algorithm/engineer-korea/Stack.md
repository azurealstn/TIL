# Stack

자바에서 Stack은 `java.util.Stack`을 import하여 사용할 수 있으며, 자바의 컬렉션 프레임워크 중 List 인터페이스의 구현체이다. 직접 스택을 구현하지 않아도 자바에서 제공하는 라이브러리를 이용하면 쉽게 사용할 수 있다.

## Stack 개념

Stack은 '쌓다' 라는 의미로 어떠한 저장 공간에 데이터를 계속 쌓아올리는 것을 말한다.

![Stack2](https://user-images.githubusercontent.com/55525868/221592954-c090fca8-de63-4d2d-a3e9-0ef93cc66286.png)

위 그림처럼 쌓다보면 가장 마지막에 넣은 데이터를 먼저 꺼내게 되는데 이러한 구조 LIFO(Last In First Out)라고 한다.

> 스택이 비어있는데 데이터를 꺼내려고 하면 **스택 언더플로우(Stack Underflow)** 에러 발생
> 스택이 꽉 차 있는데 데이터를 더 넣으려고 하면 **스택 오버플로우(Stack Overflow)** 에러 발생

Stack에는 다음과 같은 메서드가 있다.

- `pop()` : 스택에서 데이터를 꺼낸다.
- `push()` : 스택에 데이터를 넣는다.
- `peek()` : 스택의 제일 상단에 있는 데이터를 조회한다.
- `isEmpty()` : 스택이 비어있는지 체크한다.

## Stack의 활용 예시

- 콜 스택
- DFS 알고리즘

## Stack 구현하기

```java
package com.azurealstn.algorithm.try1.stack;

import java.util.EmptyStackException;

/**
 * 어떠한 타입이 와도 상관없게 T 타입 선언
 */
class Stack<T> {
    class Node<T> {
        private T data; //데이터
        private Node<T> next; //다음 노드

        //Node 생성시 data 할당
        public Node(T data) {
            this.data = data;
        }
    }

    //스택의 제일 상단을 가리키는 top 멤버변수 선언
    private Node<T> top;

    public T pop() {
        //top이 null이면 스택이 비어있으므로 EmptyStackException을 던진다.
        if (top == null) {
            throw new EmptyStackException();
        }
        T item = top.data; //item 변수에 top 데이터 저장
        top = top.next; //top의 다음 노드를 top으로 만들어준다.
        return item; //pop한 데이터를 반환한다.
    }

    public void push(T item) {
        Node<T> t = new Node<>(item); //데이터를 가지고 Node 생성
        t.next = top; //생성한 노드의 다음 노드에 top으로 변경
        top = t; //이제 그 top은 push한 Node가 된다. -> push 노드가 top이 된다.
    }

    public T peek() {
        //top이 null이면 스택이 비어있으므로 EmptyStackException을 던진다.
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.data; //top의 데이터를 반환
    }

    public boolean isEmpty() {
        return top == null; //top이 null인지 체크 -> true면 비어있음, false면 비어있지 않음
    }
}
public class MyStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop()); //3
        System.out.println(stack.peek()); //2
        System.out.println(stack.isEmpty()); //false
        System.out.println(stack.pop()); //2
        System.out.println(stack.pop()); //1
        System.out.println(stack.isEmpty()); //true
        System.out.println(stack.pop()); //EmptyStackException
    }
}

```

## Reference

- [엔지니어대한민국 - Stack](https://www.youtube.com/watch?v=whVUYv0Leg0)
- https://cocoon1787.tistory.com/691