## K번째 큰 수

- TreeSet

```java
package algorithm;

import java.io.*;
import java.util.*;

public class Main {
    public static int solution(int n, int k, int[] arr) {
        int result = -1;
        Set<Integer> set = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int l = j + 1; l < n; l++) {
                    set.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }
        int cnt = 0;
        for (int x : set) {
            cnt++;
            if (cnt == k) {
                result = x;
            }
        }
        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(n, k, arr));
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
    @DisplayName("K번째 큰 수1")
    void main_test1() {
        int n = 10;
        int k = 3;
        int[] arr = {13, 15, 34, 23, 45, 65, 33, 11, 26, 42};

        int result = Main.solution(n, k, arr);
        assertThat(result).isEqualTo(143);
        
    }

    @Test
    @DisplayName("K번째 큰 수2")
    void main_test2() {
        int n = 10;
        int k = 1200;
        int[] arr = {23, 26, 50, 17, 34, 35, 50, 22, 53, 41};

        int result = Main.solution(n, k, arr);
        assertThat(result).isEqualTo(-1);
    }

}
```
