## LRU

- 삽입정렬

```java
package algorithm;

import java.io.*;
import java.util.*;

public class Main {
    public static int[] solution(int s, int n, int[] arr) {
        int[] cache = {};
        cache = new int[s];
        for (int x : arr) {
            int pos = -1;
            for (int i = 0; i < s; i++) {
                if (x == cache[i]) {
                    pos = i; //히트된 지점
                }
            }
            if (pos == -1) { //캐시 미스
                for (int i = s - 1; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
            } else { //캐시 히트
                for (int i = pos; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
            }
            cache[0] = x;
        }
        
        return cache;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int x : solution(s, n, arr)) {
            System.out.print(x + " ");
        }
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
    @DisplayName("LRU1")
    void main_test1() {
        int s = 5;
        int n = 9;
        int[] arr = {1, 2, 3, 2, 6, 2, 3, 5, 7};
        
        int[] result = Main.solution(s, n, arr);
        assertThat(result).isEqualTo(new int[]{7, 5, 3, 2, 6});
        
    }

    @Test
    @DisplayName("LRU2")
    void main_test2() {
        int s = 5;
        int n = 20;
        int[] arr = {8, 5, 17, 8, 4, 9, 12, 4, 7, 19, 5, 19, 8, 15, 11, 12, 1, 4, 17, 18};
        
        int[] result = Main.solution(s, n, arr);
        assertThat(result).isEqualTo(new int[]{18, 17, 4, 1, 12});
    }
}
```
