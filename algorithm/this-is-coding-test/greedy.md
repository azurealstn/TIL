# 그리디 알고리즘
그리디(탐욕) 알고리즘은 **현재 상황에서 당장의 좋은 것만 고르는 방법**을 말한다.  
하지만 이는 최적의 정답을 보장할 수 없다.  

왜냐하면 트리 구조 형태의 그래프를 예로 들면,  
그리디 같은 경우는 당장의 높은 숫자만 고른다고 최적의 해를 구할 수는 없다.

## 거스름 돈

```java
package azurealstn;

public class Main {
    public static void main(String[] args) {
        int n = 1260;
        int cnt = 0;
        int[] coinTypes = {500, 100, 50, 10};

        for (int i = 0; i < coinTypes.length; i++) {
            cnt += n / coinTypes[i];
            n %= coinTypes[i];
        }
        System.out.println(cnt);

    }
}
```

- 가장  큰 단위부터 먼저 처리를 한다. 그럴려면 `coinTypes`는 내림차순으로 정렬되어 있어야 한다.
- 하지만 이것이 그리디 문제인 이유는 최적의 해를 보장하기 때문인데 이는 **큰 단위가 항상 작은 단위의 배수이기 때문에 가능한 부분이다.**
- `O(N)`
