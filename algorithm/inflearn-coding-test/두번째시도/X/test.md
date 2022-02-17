## 교육과정 설계

- Queue

```java
package algorithm;

import java.io.*;
import java.util.*;

public class Main {
    public static String solution(String a, String b) {
        String result = "YES";
        Queue<Character> queue = new LinkedList<>();
        ArrayList<Character> list1 = new ArrayList<>();
        ArrayList<Character> list2 = new ArrayList<>();
        for (char x : a.toCharArray()) {
            list1.add(x);
        }
        for (char x : b.toCharArray()) {
            queue.offer(x);
        }
        for (char ax : a.toCharArray()) {
            for (int i = 0; i < queue.size(); i++) {
                if (ax != queue.poll()) {
                    continue;
                } else {
                    list2.add(ax);
                    break;
                }
            }
        }
        if (!list1.equals(list2)) return "NO";

        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        String a = br.readLine();
        String b = br.readLine();
        System.out.println(solution(a, b));
        br.close();
    }
}
```

### 다른 방법

```java
package algorithm;

import java.io.*;
import java.util.*;

public class Main {
    public static String solution(String a, String b) {
        String result = "YES";
        Queue<Character> queue = new LinkedList<>();
        for (char x : a.toCharArray()) {
            queue.offer(x);
        }
        for (char x : b.toCharArray()) {
            if (queue.contains(x)) { //필수과목
                if (x != queue.poll()) return "NO";
            }
        }
        if (!queue.isEmpty()) return "NO";

        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        String a = br.readLine();
        String b = br.readLine();
        System.out.println(solution(a, b));
        br.close();
    }
}
```

### 테스트코드

```java
package algorithm;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.*;

class MainTest {
    
    @Test
    @DisplayName("교육과정 설계1")
    void main_test1() {
        String a = "CBA";
        String b = "CBDAGE";
        
        String result = Main.solution(a, b);
        assertThat(result).isEqualTo("YES");
        
    }

    @Test
    @DisplayName("교육과정 설계2")
    void main_test2() {
        String a = "CBA";
        String b = "CGEADB";
        
        String result = Main.solution(a, b);
        assertThat(result).isEqualTo("NO");
        
    }
}
```

---

## 응급실

- Queue
- 객체 활용

```java
package algorithm;

import java.io.*;
import java.util.*;

class Person {
    public int id;
    public int priority;

    public Person(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }
}
public class Main {
    public static int solution(int n, int m, int[] arr) {
        int result = 0;
        Queue<Person> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.offer(new Person(i, arr[i]));
        }
        while (!queue.isEmpty()) {
            Person tmp = queue.poll();
            for (Person x : queue) {
                if (x.priority > tmp.priority) {
                    queue.offer(tmp);
                    tmp = null;
                    break;
                }
            }
            if (tmp != null) { //가장 높은 우선순위
                result++;
                if (tmp.id == m) return result;
            }
        }
        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(n, m, arr));
        br.close();
    }
}
```

### 테스트코드

```java
package algorithm;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.*;

class MainTest {
    
    @Test
    @DisplayName("응급실1")
    void main_test1() {
        int n = 5;
        int m = 2;
        int[] arr = {60, 50, 70, 80, 90};
        
        int result = Main.solution(n, m, arr);
        assertThat(result).isEqualTo(3);
        
    }

    @Test
    @DisplayName("응급실2")
    void main_test2() {
        int n = 6;
        int m = 3;
        int[] arr = {70, 60, 90, 60, 60, 60};
        
        int result = Main.solution(n, m, arr);
        assertThat(result).isEqualTo(4);
    }
}
```
