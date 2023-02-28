# LinkedList

LinkedList 자료구조에 대해 간략히 알아보겠습니다. LinkedList는 자바 컬렉션 프레임워크 중 List 인터페이스의 구현체이다. List 자료구조의 특징이 순서가 있는 데이터 집합으로 중복이 허용된다.

## LinkedList 개념

![LinkedList5](https://user-images.githubusercontent.com/55525868/221391857-36c6049b-b1c0-4874-800c-d62edc03c409.png)

LinkedList란 일렬로 연결된 데이터를 저장할 때 사용한다. 데이터를 저장할 수 있는 공간을 노드(Node)라 하며, 각 노드는 다음 데이터의 주소를 가지고 있다.

###  배열과 비교하기
배열의 구조는 동일한 크기의 메모리 공간이 빈틈없이 연속적으로 나열된 자료구조이다. 따라서 배열의 크기를 한번 정하면 늘이거나 줄일 수가 없다. (고정적 크기)

따라서 배열에서 중간에 데이터를 추가하려면 새로운 크기의 배열을 다시 선언하여 복사해서 추가해야한다.  
하지만 LinkedList는 다음 데이터의 주소를 가지고 있기 때문에 중간에 데이터 삽입이 빠르다. 또한 데이터를 크기가 정해지지 않는다. (가변적 크기)  
단점은 LinkedList는 인덱스가 없기 때문에 조회할 때 처음 노드부터 찾아나가야 한다.

## LinkedList 단방향, 양방향 개념

![LinkedList3](https://user-images.githubusercontent.com/55525868/221391862-7690bc0d-a776-4f23-8958-7b7085e3152e.png)

처음 그림처럼 특정 노드를 조회할 경우 처음부터 한 방향으로 찾는 것이 바로 단방향 LinkedList이다.따라서 앞에 head 주소 하나만 가지고 있다.

반면에 양방향 LinkedList는 앞에 head 주소와 뒤에 tail 주소를 양쪽에 모두 갖고 있기 때문에 조회할 때 단방향 LinkedList보다 빠르다. 다만 메모리를 더 잡아먹는다는 단점이 있다.

## LinkedList 메서드

- `append(int data)` : 리스트의 맨 마지막 노드에 데이터 추가
- `remove(int data)` : 리스트의 특정 데이터 삭제 

## LinkedList 단방향 구현

```java
package com.azurealstn.algorithm.try1.linkedlist;

class LinkedList {
    Node head;

    static class Node {
        int data; //데이터
        Node next = null; //다음 노드를 null로 초기화
    }

    //LinkedList 객체 생서잇 header 노드 생성
    LinkedList() {
        head = new Node();
    }

    public void append(int data) {
        Node end = new Node(); //추가할 노드 생성
        end.data = data; //생성한 노드의 데이터 할당
        Node n = head; //Node n을 head로 초기화
        while (n.next != null) { //head부터 다음 노드가 null이 아닐 때까지 Loop!
            n = n.next; //null이 아니면 n을 다음 노드로 계속 이동한다.
        }
        n.next = end; //위 while문을 돌고나면 n은 마지막 노드가 되고 그 마지막 노드의 다음 노드에 end를 할당
    }

    public void remove(int data) {
        Node n = head; //Node n을 head로 초기화
        while (n.next != null) { //head부터 다음 노드가 null이 아닐 때까지 Loop!
            if (n.next.data == data) { //만약 다음 노드의 데이터가 삭제하려는 data와 같다면
                n.next = n.next.next; //다음 노드는 그 다음 노드를 가리키게 한다.
            } else { //다음 노드의 데이터가 삭제하려는 data와 같지 않다면
                n = n.next; //n을 계속 다음 노드로 이동시켜서 삭제할 데이터를 찾는다.
            }
        }
    }

    public void retrieve() { //단순 리스트 출력 메서드
        Node n = head.next; //head의 다음 노드부터 출력
        while (n.next != null) {
            System.out.print(n.data + " -> ");
            n = n.next; //다음 노드로 이동
        }
        System.out.println(n.data); //마지막 노드 출력
    }

}

public class SinglyLinkedList {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.retrieve();
        ll.remove(1);
        ll.retrieve();
    }
}
```

## Reference

- [유튜브 - 엔지니어대한민국]("https://www.youtube.com/@eleanorlim/videos")