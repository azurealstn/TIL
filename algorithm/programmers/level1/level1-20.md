# 소수 찾기

- [문제 보기](https://programmers.co.kr/learn/courses/30/lessons/12921?language=javascript)

## 문제 요약

- 1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 리턴

## 코드

```javascript
'use strict';

function solution(n) {
    const sosu = new Array(n).fill(true)
    sosu[0] = false; //첫번째 1은 소수가 아니다
    for (let i = 2; i ** 2 <= n; i++) {
        if (sosu[i - 1] === true) {
            for (let j = i ** 2; j <= n; j += i) {
                sosu[j - 1] = false;
            }
        }
    }
    return sosu.filter(v => v).length;
}
console.log(solution(10));
```

- 새로운 배열을 생성하는데 그 값은 `fill()` 함수를 이용하여 모두 `true`로 넣는다.
- [에라토스테네스의\_체](https://ko.wikipedia.org/wiki/%EC%97%90%EB%9D%BC%ED%86%A0%EC%8A%A4%ED%85%8C%EB%84%A4%EC%8A%A4%EC%9D%98_%EC%B2%B4)를 이용하여 제곱 단위로 체크를 해야한다.
- 반복문을 돌려 처음 요소도 `true`이면 이번엔 제곱단위로 반복문을 돌려 처음 요소 다음부터는 `false`를 리턴해야 된다.
- `filter()`를 이용하여 `true`인 것을 필터링하여 길이를 구한다.

#### 참고
[velog.io](https://velog.io/@dosanahnchangho/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%86%8C%EC%88%98-%EA%B5%AC%ED%95%98%EA%B8%B0-JavaScript)
