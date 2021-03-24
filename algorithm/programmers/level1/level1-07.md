# 

- [문제 보기](https://programmers.co.kr/learn/courses/30/lessons/42862?language=javascript)

## 문제 요약

- 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어졌다.
- 체육복이 없는 학생은 바로 앞이나 뒤의 학생이 만약에 여벌의 체육복이 있으면 빌려줄 수 있다. 없다면 빌려줄 수 없다.
- 체육수업을 들을 수 있는 학생의 최댓값을 return

## 코드

```javascript
'use strict';

function solution(n, lost, reserve) {
    let answer = 0;
    let students = [];

    //모든 학생에게 체육복을 준다.
    //학생 번호는 1부터 시작한다. (주의)
    for (let i = 1; i <= n; i++) {
        students.push(1); //1: 체육복 1개
        //체육복을 2개 가져온 학생 1개 더 증가
        if (reserve.includes(i)) {
            students[i-1]++;
        }
        //도난 당한 학생 1개 감소
        if (lost.includes(i)) {
            students[i-1]--;
        }
    }
    for (let i = 0; i < n; i++) {
        //내가 체육복이 없을 때
        if (students[i] === 0) {
            //앞에 있는 사람이 체육복이 2개일 때
            if (students[i - 1] === 2) {
                students[i]++; //내꺼 ++
                students[i - 1]--; //앞에 있는 사람 --

                //뒤에 있는 사람이 체육복이 2개일 때
            } else if (students[i + 1] === 2) {
                students[i]++; //내꺼 ++
                students[i + 1]--; //뒤에 있는 사람 --
            }
        }
    }
    for (let i = 0; i < n; i++) {
        if (students[i] >= 1) {
            answer++;
        }
    }
    return answer;
}
console.log(solution(5, [2, 4], [1, 3, 5]));
```

- 이 문제도 많이 헷갈리고 어려웠다.. 😥
- 먼저 모든 학생에게 1개씩 체육복을 준다.
- 다음으로 여벌의 체육복을 가진 학생에게는 체육복을 1개씩 더 주고, 체육복을 도난 당한 학생에게는 체육복을 1개 감소시킨다. 이 때 `includes()` 함수를 이용해 해당하는 index(i)를 확인할 수 있다.
- 다음으로 내가 체육복이 없을 경우에 내 앞에 있는 사람이 2개 일 때 `++`를 시켜주고, 앞에 있는 사람의 체육복을 `1` 감소시킨다. 뒤에 있는 사람 역시 똑같이 한다.
- 마지막으로 체육복이 1개 이상인 한 사람을 체크하여 `answer`의 개수를 증가시킨다.

#### 시간 복잡도

- O(n)

#### 참고
[velog.io](https://velog.io/@michael00987/javascript%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%B2%B4%EC%9C%A1%EB%B3%B5-8605q509)
