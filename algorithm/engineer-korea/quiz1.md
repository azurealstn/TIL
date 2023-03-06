## 정렬이 되어 있고, 고유한 정수로만 이루어진 배열이 있다. 이 배열로 이진검색트리를 구현하시오.

![array1](/images/data-structure/array1.png)

1. 정렬이 되어 있는 배열을 이진검색트리로 구현하려면 먼저 중간값을 구해야 한다.
2. 중간값은 `(startIndex + endIndex) / 2`로 구할 수 있다.
3. 중간값을 트리의 노드로 추가한다. 노드를 추가할 때 이전의 중간값보다 추가한 노드보다 작다면 왼쪽에, 크다면 오른쪽에 배치하는 것이 핵심이다.

위 과정을 반복하면 아래와 같은 트리가 완성된다. 트리의 노드들을 보면 처음에 중간값 4를 기준으로 왼쪽은 4보다 작고, 오른쪽은 4보다 큰 것을 확인할 수 있다.

![binary_tree1](/images/data-structure/binary_tree1.png)

따라서 트리에서 특정 숫자 5를 찾으려면 4를 기준으로 오른쪽으로 7을 기준으로 왼쪽으로 찾아서 결국 숫자 5를 찾게 된다. 한번 이동할 때마다 찾아야 하는 데이터의 양이 절반씩 줄어듬으로 시간복잡도는 `O(log N)`이 걸린다.

## 구현해보기

위 과정을 살펴보면 중간값을 찾고 그 안에 또 중간값을 찾는 과정이 반복된다. 따라서 이것을 메서드로 만들어서 재귀적으로 호출하면 더 좋겠다.

**필요한 변수**

- Array: 배열
- startIndex: 시작 인덱스
- endIndex: 끝 인덱스
- midIndex: 중간 인덱스

```java
package com.azurealstn.algorithm.try1.mid;

class Tree {
    class Node {
        int data; //노드 데이터
        Node left; //왼쪽 노드
        Node right; //오른쪽 노드
        public Node(int data) {
            this.data = data;
        }
    }
    Node root; //트리가 시작되는 root 노드
    //배열을 받아서 트리 만드는 일을 시작해주는 메서드
    public void makeTree(int[] a) {
        root = makeTreeR(a, 0, a.length - 1); //root 멤버변수에 처음으로 초기화한다.
    }

    public Node makeTreeR(int[] a, int startIndex, int endIndex) {
        //메서드를 반복적으로 수행하다가 시작 인덱스가 끝 인덱스보다 커지면 null을 반환한다.
        //끝나는 시점을 명확히 하는 것은 재귀호출에서 굉장히 중요하다.
        if (startIndex > endIndex) return null;
        int midIndex = (startIndex + endIndex) / 2;
        Node node = new Node(a[midIndex]); //중간 인덱스로 노드 생성
        node.left = makeTreeR(a, startIndex, midIndex - 1); //왼쪽 노드는 root보다 작아야 하므로 끝 인덱스를 midIndex - 1로
        node.right = makeTreeR(a, midIndex + 1, endIndex); //오른쪽 노드는 root보다 커야 하므로 시작 인덱스를 midIndex + 1로
        return node;
    }

    //트리가 잘 만들어졌는지 확인하는 메서드
    public void searchBTree(Node n, int find) { //n: 현재 노드, find: 찾으려는 정수
        if (find < n.data) {
            System.out.println("Data is smaller than " + n.data);
            searchBTree(n.left, find);
        } else if (find > n.data) {
            System.out.println("Data is bigger than " + n.data);
            searchBTree(n.right, find);
        } else {
            System.out.println("Data Found!!");
        }
    }
}
public class MidTest {
    public static void main(String[] args) {
        int[] a = new int[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        Tree t = new Tree();
        t.makeTree(a);
        t.searchBTree(t.root, 2);
    }
}
```

- 코드를 직접 작성하고 결과까지 확인해보면 이해가 바로 간다! ~~(사실 강의를 보는게 더 좋겠죠.)~~

## Reference

- [엔지니어대한민국 - 이진검색트리 활용](https://www.youtube.com/watch?v=9ZZbA2iPjtM)