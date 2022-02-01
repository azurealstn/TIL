## K번째 큰 수

- TreeSet 활용
    - TreeSet은 레드-블랙 트리로 구현되어 있어 정렬까지 가능하다.
    - `Collections.reverseOrder()` : 생략하면 오름차순, 명시하면 내림차순
- 3중 for문으로 모든 경우 탐색

```java
import java.io.*;
import java.util.*;

public class Main {
    public static int solution(int n, int k, int[] arr) {
        int answer = 0;
        answer = -1;
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
            if (cnt == k) return x;
        }
        return answer;
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
    }
}
```
