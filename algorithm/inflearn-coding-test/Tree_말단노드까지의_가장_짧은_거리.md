## Tree 말단노드까지의 가장 짧은 경로

- DFS로 풀어보기
- BFS로 풀어보기 -> 원래는 BFS로 풀어야 함.

### DFS

```java
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node lt, rt;

    public Node(int data) {
        this.data = data;
        lt = rt = null;
    }
}

public class Main {
    static Node root;
    public static int dfs(int L, Node root) {
        if (root.lt == null && root.rt == null) return L; //말단 노드일 경우
        else return Math.min(dfs(L + 1, root.lt), dfs(L + 1, root.rt)); //말단 노드가 아닐 경우
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        System.out.println(dfs(0, root));
    }
}
```

### BFS

```java
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node lt, rt;

    public Node(int data) {
        this.data = data;
        lt = rt = null;
    }
}

public class Main {
    static Node root;
    public static int bfs(Node root) {
        Queue<Node> queue = new LinkedList<>();
        int L = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node cur = queue.poll();
                if (cur.lt == null && cur.rt == null) return L; //말단 노드일 경우
                if (cur.lt != null) queue.offer(cur.lt);
                if (cur.rt != null) queue.offer(cur.rt);
            }
            L++;
        }
        return L;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        System.out.println(bfs(root));
    }
}
```
