# Graph

앞서 트리 자료구조를 살펴보았다. 트리란 루트 노드가 있고, 부모-자식 관계가 성립하여 계층형 모델이라고 불리며, 두 개의 노드 사이에 반드시 1개의 경로만을 가지며 위에서 아래로 연결되는 사이클이 없는 방향 그래프이다.

## Graph 개념

위에서 트리를 사이클이 없는 방향 그래프라고 정의했다. 왜 트리가 사이클이 없는 방향 그래프인지 아래 그림을 보자.

![graph1](https://user-images.githubusercontent.com/55525868/222881906-229c5e6c-5209-4c9d-9afd-4dbe98a51427.png)

위 그림에서 트리가 Edge의 방향을 위로 또는 아래로 조정할 수도 있고, 방향을 아에 가지지 않을 수도 있고, Edge가 자기 자신을 가리키게 할 수도 있고, 방향이 돌고 돌아 노드들끼리 Circle이 형성될 수도 있다??

만약 위와 같은 트리가 형성되면 굉장히 복잡해지고, 트리를 사용하는 목적이 사라질 것이다. 그래서 위의 그림을 그래프라고 한다. 트리는 루트가 있고, 들어오는 곳이 한 개이고, 사이클이 없는 아래로만 흐른다는 제약이 있지만 그래프는 그러한 제약이 없다. 따라서 트리는 그래프 중에서도 특수한 케이스에 해당하는 자료구조이다.

## Graph 종류

![graph2](https://user-images.githubusercontent.com/55525868/222881911-55e6a898-79ed-4ab3-b15f-28adbc92288d.png)

그래프는 방향이 있을수도, 없을수도 있다. 방향이 있는 그래프를 방향(Directed) 그래프와 방향이 없는 그래프를 무방향(Undirected) 그래프라고 한다. 

> 💡 트리는 사이클이 없는 방향 그래프이므로 방향을 표시해주어야 하는데 생각해보면 트리는 항상 위에서 아래로 흐르므로 방향 표시를 생략한 것이다. 

![graph3](https://user-images.githubusercontent.com/55525868/222881912-01b88ef5-a159-4181-871e-75597a15b5fe.png)

위 그림에서 Circle을 형성한 그래프와 그렇지 않은 그래프가 있가 있다. 한 개 이상의 Circle이 있는 그래프를 순환(Cyclic) 그래프라고 하고 Circle이 한 개도 없는 그래프를 비순환(Acyclic) 그래프라고 한다.

## Graph를 표현하는 방법

그래프를 표현하는 방법에는 2가지 방법이 있다. (그래프에는 자식 노드 개념이 없다. 따라서 인접한 노드가 무엇인지 표현하기 위해 행렬이나 리스트를 이용하는 것이다.)

- 인접행렬(Adjacency matrix)
- 인접리스트(Adjacency list)

### 인접행렬

인접행렬이란 그래프의 연결관계를 행렬로 표현하여 이차원배열로 나타내는 방식을 의미한다.

> `adjacent[a][b]` : a에서 b로 가는 간선이 존재할 경우 1, 없으면 0으로 나타낸다.

무방향 그래프의 경우 a에서 b로 가는 가선이 있을 경우 b에서 a로 가는 간선 역시 항상 존재한다. 이는 무방향 그래프의 인접행렬은 항상 대칭행렬인 것을 알 수 있다.

인접행렬의 장점

- 구현이 간단하다.
- 정점끼리 연결이 되어있는지 확인하려면 `adjacent[a][b]`의 값이 1인지만 확인하면 되기 때문에 연결여부에 대한 탐색이 빠르다.

인접행렬의 단점

- 메모리가 많이 든다. 예를 들어, 정점이 10,000개면 10,000*10,000 크기의 배열을 만들어야 한다.
- 시간복잡도가 `O(N^2)`이 된다. 즉, 정점이 10,000개면 10,000*10,000의 반복문을 돌아야 한다.

![graph4](https://user-images.githubusercontent.com/55525868/222881915-47e9c045-d821-499a-9f39-04654d227146.png)

- 위 그림에서 1번 노드에서 갈 수 있는 노드가 2, 3, 4가 있으므로 2차원 배열에 1로 체크해준다. 아래 과정에서도 마찬가지로 2차원 배열에 1로 체크한다.
- 2번 노드에서 갈 수 있는 노드가 1 하나 있다.
- 3번 노드에서 갈 수 있는 노드는 1, 4가 있다.
- 4번 노드에서 갈 수 있는 노드는 1, 3이 있다.

### 인접리스트

인접리스트란 각각의 노드에 연결된 노드들을 원소로 갖는 리스트들의 배열을 의미한다.

> `adjacent[i]` : i번째 노드에 연결된 노드들을 원소로 갖는 리스트

인접리스트 역시 무방향 그래프인 경우 본인 노드 인덱스의 리스트 내에 서로를 원소로 갖게 된다. 즉, 처음 노드의 개수가 N개라고 할 때 무방향 그래프의 인접리스트에서 총 노드의 개수은 2N개가 된다.

**인접리스트 장점**

- 현재 노드의 연결된 노드들을 찾기가 쉽다.
- 간선의 개수만큼만 메모리가 생성되기 때문에 메모리를 효율적으로 사용할 수 있다.
- 인접행렬처럼 노드가 10,000개가 있으면 10,000*10,000번 돌릴 필요없이 간선의 개수만큼만 돌면 되기 때문에 `O(N)`의 시간복잡도를 갖는다.

**인접리스트 단점**

- 2차원 배열처럼 인덱스가 아닌 리스트이기 때문에 정점간의 연결관계를 찾을 때 탐색이 느리다.
- 인접행렬은 `adjacent[a][b]`로 접근해서 1인지만 확인하면 되므로 `O(1)`로 찾을 수 있지만, 인접리스트는 `adjacent[i]`에 들어가서 처음부터 하나하나 찾아야하므로 최악의 경우 `O(V)`의 시간복잡도가 될 수 있다.

![graph5](https://user-images.githubusercontent.com/55525868/222881918-0e966c9a-eadd-4b9a-8138-c18f5e3584fb.png)

- 위 그림에서 1번 노드에서 갈 수 있는 노드가 2, 3, 4가 있으므로 1번 인덱스에 있는 리스트에 2, 3, 4노드들을 추가해준다. 아래 과정에서도 마찬가지로 진행한다.
- 2번 노드에서 갈 수 있는 노드가 1 하나 있다.
- 3번 노드에서 갈 수 있는 노드는 1, 4가 있다.
- 4번 노드에서 갈 수 있는 노드는 1, 3이 있다.

**인접행렬과 인접리스트의 장단점**을 정리하면 아래 표와 같다.

||인접행렬|인접리스트|
|---|---|---|
|시간복잡도|O(N*N)|O(N)|
|두 정점의 연결여부|`adjacent[a][b]=1`로 바로 확인|`adjacent[i]`의 리스트에서 순차적으로 확인|
|메모리|N*N만큼의 메모리 차지|간선의 개수만큼의 메모리 차지|

## Graph를 검색하는 방법

그래프를 검색하는 방법 2가지가 있다.

- 깊이우선검색(DFS: Depth-First Search)
- 넓이우선검색(BFS: Breadth-First Search)

### DFS

DFS는 깊이우선검색으로 하나의 자식 노드를 방문하면 해당 노드의 자식 노드를 또 그 노드의 자식노드를 깊게 들어가서 확인하는 방법이다. 그래서 깊이우선검색이라 하며, DFS는 재귀를 이용해야 한다.

### BFS

BFS는 넓이우선검색으로 하나의 자식 노드를 방문하면 해당 노드의 자식 노드가 아닌 형제 노드들을 먼저 다 방문한다. 그 다음 자식 노드의 형제 노드들을 방문하고 위 과정을 반복한다. 그 BFS는 깊이 파고드는 것이 아니라 먼저 레벨별로 모두 방문한다고 생각하면 된다.

### 방문순서

아래 그림은 DFS의 방문순서와 BFS의 방문순서를 나타낸 그림이다. 차이는 DFS는 자식노드가 있으면 계속 파고 들어가지만 BFS는 레벨별로 방문한다는 것을 알 수 있다.

![dfs-bfs-1](https://user-images.githubusercontent.com/55525868/222948365-d8b8ae06-88dc-4022-a3f3-9601bb91704e.png)

### DFS 구현하기

DFS는 자식 노드가 있으면 해당 자식 노드를 계속 깊이 방문해야 하기 때문에 Stack 자료구조를 기반으로 구현한다. (DFS는 재귀함수를 이용하면 더 쉽게 더 멋지게 구현할 수 있다.)

**예제에서 사용되는 생성된 그래프는 아래 그림 참고!**

![dfs-bfs-2](https://user-images.githubusercontent.com/55525868/222948367-e2af7f76-8bbb-4361-ad28-5983fcbaf2ab.png)

**재귀를 사용하지 않고 DFS 구현**

```java
package com.azurealstn.algorithm.try1.bfsdfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class GraphV1 {
    class Node {
        int data; //데이터는 정수로 표현
        LinkedList<Node> adjacent; //인접리스트 사용
        boolean marked; //방문한 노드는 또 방문하지 않도록 체크변수
        //노드 생성시 아래와 같이 초기화 해준다.
        public Node(int data) {
            this.data = data; //정수 할당
            this.marked = false; //marked를 false로 초기화
            adjacent = new LinkedList<>(); //LinkedList 생성
        }
    }
    Node[] nodes; //노드들을 저장할 배열선언
    GraphV1(int size) {
        nodes = new Node[size]; //그래프 객체 생성시 노드 개수(size) 고정
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i); //노드 데이터와 배열 인덱스를 동일하게 초기화 (0부터 시작)
        }
    }
    //두 정점을 연결하는 간선 추가
    void addEdge(int v1, int v2) {
        Node n1 = nodes[v1];
        Node n2 = nodes[v2];

        //인접한 노드를 연결하는 LinkedList에 상대노드가 있는지 확인 후에 없으면 서로 추가한다.
        if (!n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2);
        }
        if (!n2.adjacent.contains(n1)) {
            n2.adjacent.add(n1);
        }
    }
    //dfs 호출시 0번부터 시작
    void dfs() {
        dfs(0);
    }
    void dfs(int v) { //v: 현재 정점
        Node root = nodes[v]; //현재 노드를 가져온다.
        Stack<Node> stack = new Stack<>(); //스택 생성
        stack.push(root); //스택에 현재 노드 추가
        root.marked = true; //방문한 노드를 다시 방문하지 않도록 marked를 true로 한다.
        while (!stack.isEmpty()) { //스택이 비어있지 않을 동안 반복
            Node cur = stack.pop(); //현재 노드를 꺼낸다.
            for (Node n : cur.adjacent) { //꺼낸 노드의 인접한 노드들의 반복문을 돌린다.
                if (n.marked == false) { //방문하지 않은 노드인 경우에만 스택에 추가한다.
                    n.marked = true;
                    stack.push(n);
                }
            }
            visit(cur); //방문한 노드 출력
        }
    }

    void visit(Node cur) {
        System.out.print(cur.data + " ");
    }
}
public class DfsNoRecursive {
    public static void main(String[] args) {
        GraphV1 G = new GraphV1(9); //9개의 노드 생성
        G.addEdge(0, 1);
        G.addEdge(1, 2);
        G.addEdge(1, 3);
        G.addEdge(2, 4);
        G.addEdge(2, 3);
        G.addEdge(3, 4);
        G.addEdge(3, 5);
        G.addEdge(5, 6);
        G.addEdge(5, 7);
        G.addEdge(6, 8);
        G.dfs(); //결과: 0 1 3 5 7 6 8 4 2
    }
}
```

**재귀를 사용한 DFS 구현**

```java
package com.azurealstn.algorithm.try1.bfsdfs;


import java.util.LinkedList;
import java.util.Stack;

class GraphV2 {
    class Node {
        int data; //데이터는 정수로 표현
        LinkedList<Node> adjacent; //인접리스트 사용
        boolean marked; //방문한 노드는 또 방문하지 않도록 체크변수
        //노드 생성시 아래와 같이 초기화 해준다.
        public Node(int data) {
            this.data = data; //정수 할당
            this.marked = false; //marked를 false로 초기화
            adjacent = new LinkedList<>(); //LinkedList 생성
        }
    }
    Node[] nodes; //노드들을 저장할 배열선언
    GraphV2(int size) {
        nodes = new Node[size]; //그래프 객체 생성시 노드 개수(size) 고정
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i); //노드 데이터와 배열 인덱스를 동일하게 초기화 (0부터 시작)
        }
    }
    //두 정점을 연결하는 간선 추가
    void addEdge(int v1, int v2) {
        Node n1 = nodes[v1];
        Node n2 = nodes[v2];

        //인접한 노드를 연결하는 LinkedList에 상대노드가 있는지 확인 후에 없으면 서로 추가한다.
        if (!n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2);
        }
        if (!n2.adjacent.contains(n1)) {
            n2.adjacent.add(n1);
        }
    }
    //LinkedList가 노드의 주소를 가지고 있기 때문에 파라미터로 Node를 받아야 한다.
    void dfsR(Node cur) {
        if (cur == null) {
            return; //재귀에서 중요한 점은 loop가 계속 돌기 때문에 꼭 종료 처리를 해주어야 한다.
        }
        cur.marked = true; //현재 노드를 방문체크
        visit(cur); //현재 노드를 먼저 출력한다.
        for (Node n : cur.adjacent) { //꺼낸 노드의 인접한 노드들의 반복문을 돌린다.
            if (n.marked == false) { //방문하지 않은 노드인 경우에만 재귀호출을 한다.
                dfsR(n); //재귀호출
            }
        }
    }

    //시작 인덱스를 다양하게 테스트하기 위해 아래 메서드 생성
    void dfsR(int v) {
        Node cur = nodes[v];
        dfsR(cur);
    }
    //파라미터가 없으면 인덱스가 0부터 시작
    void dfsR() {
        dfsR(0);
    }

    void visit(Node cur) {
        System.out.print(cur.data + " ");
    }
}
public class DfsUseRecursive {
    public static void main(String[] args) {
        GraphV2 G = new GraphV2(9); //9개의 노드 생성
        G.addEdge(0, 1);
        G.addEdge(1, 2);
        G.addEdge(1, 3);
        G.addEdge(2, 4);
        G.addEdge(2, 3);
        G.addEdge(3, 4);
        G.addEdge(3, 5);
        G.addEdge(5, 6);
        G.addEdge(5, 7);
        G.addEdge(6, 8);
        G.dfsR(); //결과: 0 1 2 4 3 5 6 8 7
    }
}
```


### BFS 구현하기

BFS는 레벨별로 먼저 방문해야 하기 때문에 이에 적합한 자료구조는 Queue를 이용하면 된다. (자바에서 Queue는 인터페이스이기 때문에 LinkedList나 ArrayList를 구현체로 사용하면 된다.)

```java
package com.azurealstn.algorithm.try1.bfsdfs;

import java.util.LinkedList;
import java.util.Queue;

class GraphV3 {
    class Node {
        int data; //데이터는 정수로 표현
        LinkedList<Node> adjacent; //인접리스트 사용
        boolean marked; //방문한 노드는 또 방문하지 않도록 체크변수
        //노드 생성시 아래와 같이 초기화 해준다.
        public Node(int data) {
            this.data = data; //정수 할당
            this.marked = false; //marked를 false로 초기화
            adjacent = new LinkedList<>(); //LinkedList 생성
        }
    }
    Node[] nodes; //노드들을 저장할 배열선언
    GraphV3(int size) {
        nodes = new Node[size]; //그래프 객체 생성시 노드 개수(size) 고정
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i); //노드 데이터와 배열 인덱스를 동일하게 초기화 (0부터 시작)
        }
    }
    //두 정점을 연결하는 간선 추가
    void addEdge(int v1, int v2) {
        Node n1 = nodes[v1];
        Node n2 = nodes[v2];

        //인접한 노드를 연결하는 LinkedList에 상대노드가 있는지 확인 후에 없으면 서로 추가한다.
        if (!n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2);
        }
        if (!n2.adjacent.contains(n1)) {
            n2.adjacent.add(n1);
        }
    }

    //bfs 호출시 0번부터 시작
    void bfs() {
        bfs(0);
    }
    void bfs(int v) { //v: 현재 정점
        Node root = nodes[v]; //현재 노드를 가져온다.
        Queue<Node> Q = new LinkedList<>(); //큐 생성
        Q.offer(root); //큐에 현재 노드 추가
        root.marked = true; //방문한 노드를 다시 방문하지 않도록 marked를 true로 한다.
        while (!Q.isEmpty()) { //큐가 비어있지 않을 동안 반복
            Node cur = Q.poll(); //현재 노드를 꺼낸다.
            for (Node n : cur.adjacent) { //꺼낸 노드의 인접한 노드들의 반복문을 돌린다.
                if (n.marked == false) { //방문하지 않은 노드인 경우에만 스택에 추가한다.
                    n.marked = true;
                    Q.offer(n);
                }
            }
            visit(cur);
        }
    }

    void visit(Node cur) {
        System.out.print(cur.data + " ");
    }
}
public class Bfs {
    public static void main(String[] args) {
        GraphV3 G = new GraphV3(9); //9개의 노드 생성
        G.addEdge(0, 1);
        G.addEdge(1, 2);
        G.addEdge(1, 3);
        G.addEdge(2, 4);
        G.addEdge(2, 3);
        G.addEdge(3, 4);
        G.addEdge(3, 5);
        G.addEdge(5, 6);
        G.addEdge(5, 7);
        G.addEdge(6, 8);
        G.bfs(); //결과: 0 1 2 3 4 5 6 7 8
    }
}
```

## References

- [엔지니어대한민국 - 그래프](https://www.youtube.com/watch?v=fVcKN42YXXI)
- [엔지니어대한민국 - DFS, BFS 구현](https://www.youtube.com/watch?v=_hxFgg7TLZQ&t=505s)
- https://bigsong.tistory.com/33
- https://duwjdtn11.tistory.com/515
- https://dailymapins.tistory.com/29
- https://born2bedeveloper.tistory.com/42