## LRU(캐시)

- `삽입정렬`을 이용한다.
- Cache Hit일 경우와 Cache Miss일 경우를 나누어서 생각하면 좀 더 쉬워진다.

```java
import java.io.*;
import java.util.*;

public class Main {
    public static int[] solution(int s, int n, int[] arr) {
        int[] answer = {};
        int[] cache = new int[s];

        for (int x : arr) {
            int pos = -1;
            //pos를 저장하기 위한 반복문
            for (int i = 0; i < s; i++) {
                if (x == cache[i]) { //Cache Hit
                    pos = i; //히트된 지점(인덱스)
                }
            }
            if (pos == -1) { //Cache Miss
                for (int i = s - 1; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
            } else { //Cache Hit
                for (int i = pos; i >= 1; i--) { //히트된 지점부터 루프를 돌린다.
                    cache[i] = cache[i - 1];
                }
            }
            cache[0] = x;
        }
        answer = cache;

        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int x : solution(s, n, arr)) {
            System.out.print(x + " ");
        }
    }
}
```
