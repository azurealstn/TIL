## Tree_말단노드까지의_가장짧은경로

- DFS, BFS 활용

```java
package algorithm;

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node lt, rt;
    public Node(int data) {
        this.data = data;
    }
}
class Main {
    static Node root;
    public static int dfs(int L, Node root) {
        if (root.lt == null && root.rt == null) return L;
        else return Math.min(dfs(L + 1, root.lt), dfs(L + 1, root.rt));
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
        br.close();
    }
}
```

---

```java
package algorithm;

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node lt, rt;
    public Node(int data) {
        this.data = data;
    }
}
class Main {
    static Node root;
    public static int bfs(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int L = 0;
        while (!queue.isEmpty()) {
            int len = queue.size(); //해당 레벨의 사이즈
            for (int i = 0; i < len; i++) {
                Node cur = queue.poll();
                if (cur.lt == null && cur.rt == null) return L;
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
        br.close();
    }
}
```