# ****제대로 파는 Git & GitHub - by 얄코****

이 글에서 정리한 내용은 모두 인프런의 ****`제대로 파는 Git & GitHub - by 얄코`**** 강의를 보고 정리한 글입니다.

## 깃 설치

```
git --version
```

```
git config --global core.autocrlf true
```

- 협업시 윈도우와 맥에서 엔터 방식 차이로 인한 오류 방지
- `crlf`에 대한 자세한 설명: [https://www.lesstif.com/gitbook/git-crlf-20776404.html](https://www.lesstif.com/gitbook/git-crlf-20776404.html)

## 깃 최초 설정

Git 전역으로 사용자 이름과 이메일 주소 설정

- GitHub 계정과는 별개

```
git config --global user.name "azurealstn"
```

```
git config --global user.email "azurealstn@naver.com"
```

기본 브랜치명 변경 (요즘 추세 master → main)

```
git config --global init.defaultBranch main
```

## 깃 관리

### Git 초기화

```
git init
```

### Git 상태보기

```
git status
```

### 버전 관리 add

```
git add tigers.yaml
```

```
git add .
```

### commit

```
git commit -m "first commit"
```

### commit과 add를 한꺼번에 하기

- ❗단, 새로 추가된 파일(Untracked)이 없을 때만 적용이 된다.

```
git commit -am "message"
```

### log 확인

```
git log
```

### 변경사항 자세히 확인

```
git diff
```

### 과거로 돌아가기

```
git reset --hard fd377a327b48c24ce257007a5f4c31519d3ebc79
git reset --hard //마지막 커밋으로 되돌리기
git reset --mixed fd377a327b48c24ce257007a5f4c31519d3ebc79 //Working Directory 상태는 유지
git reset --soft fd377a327b48c24ce257007a5f4c31519d3ebc79 //Staging Area 상태는 유지
git reset --hard HEAD~2 //2버전 뒤로 reset하기
```

```
git revert f9d2ea2
```

- reset : 과거로 되돌리데 history에는 남지 않음
- revert : 과거로 되돌리고 history에는 남음

## ****브랜치 생성 / 이동 / 삭제하기****

### 브랜치 생성

```
git branch 브랜치이름
```

### 브랜치 목록

```
git branch
```

### 브랜치 이동

```
git switch 브랜치이름
```

### 브랜치 생성과 이동 동시에

```
git switch -c 브랜치이름
```

### 브랜치 삭제

```
git branch -d 브랜치이름
git branch -D 브랜치이름 //브랜치 강제 삭제
```

### 브랜치 이름 바꾸기

```
git branch -m 기존브랜치명 새로운브랜치명
```

### 여러 브랜치 내역 편리하게 보기

```
git log --all --decorate --oneline --graph
```

## Merge VS Rebase

- 브랜치의 사용 내역들을 남겨둘 필요가 있다면 `merge` 사용
    - merge란, 브랜치들을 냅두고 최근에 커밋한 것만 모아서 병합하므로 잔가지들이 남음
- 히스토리를 깔끔하게 만드는게 중요하다면 `rebase` 사용
    - rebase는, 가지들을 모두 main에다가 이어붙이기 때문에 잔가지들이 남지 않음
- 다른 사람과 협업할 때는 `rebase`를 사용하지 않는 것이 좋다.

### merge

```
git merge 합칠브랜치명
```

- 위 명령어는 먼저 main 브랜치로 이동한 후에 실행한다.
- merge 전으로 돌아가고 싶다면 `reset`
- 이제 필요없는 합칠브랜치명을 삭제

### rebase

```
git rebase main
```

- merge와 다르게 합칠브랜치명으로 먼저 이동한다.
- 여기서 주의할 점이 있는데 ❌
    - 다시 main 브랜치로 이동하면 합친 파일들이 보이지 않는다.
    - 그래서 다시 합칠브랜치명과 `merge`를 해주어야 한다.
- 이제 필요없는 합칠브랜치명을 삭제

이렇게 추가적인 작업 혹은 실험적인 작업이 있을 경우에는 브랜치를 만들어서 각각 작업해서 merge 해주면 되겠다.

## merge 충돌 해결하기

당장 충돌 해결이 어려울 경우 merge 중단

```
git merge --abort
```

해결이 가능한 경우 수정한 부분 `git add .` → `git commit -m ""`

## rebase 충돌 해결하기

당장 충돌 해결이 어려울 경우 rebase 중단

```
git rebase --abort
```

해결이 가능한 경우 수정한 부분 `git add .`

아래 명령어 실행

```
git rebase --continue
```

그 다음 main 브랜치로 이동 후에 다시 `merge` 를 해주면 된다.

그리고 항상 필요없는 브랜치들은 모두 지워주는 것이 좋다.

## GitHub 연동

로컬 저장소와 원격 저장소 연결 추가

```
git remote add origin 주소
```

기본 브랜치명을 main

```
git branch -M main
```

로컬 저장소의 커밋내역들을 원격으로 업로드

```
git push -u origin main
```

다음부터는 그냥 `git push` 만 쳐도 됨

### 협업시 다른 사람이 커밋한 내용 받기

```
git pull
```

만약 로컬 저장소에 원격 저장소에 있는 최신 내역을 받지 못한다면 에러가 발생한다.

만약 내가 커밋을 하고 원격 저장소에도 push되어 있다면 `git pull`을 했을 때 어떤 것을 받아야 할까? - 2가지 방법이 있다.

```
#merge
git pull --no-rebase
```

```
#rebase
git pull --rebase
```

그래서 습관적으로 내가 먼저 커밋을 진행하기 전에 항상 최신 내역으로 update 하는 습관이 필요하다.

- 참고로 협업시 `rebase`를 사용하지 말라했지만 pull 할 때는 rebase를 사용해도 무방하다.

### Working Directory로 되돌리기

`git add`를 해서 Staging Area로 올린파일을 다시 Working Directory로 되돌리기

```
git restore --staged 파일이름
git restore 파일이름 //Woring Directory에서도 없애기
```

### fetch 와 pull의 차이

- 만약 원격 저장소에 커밋되었고 로컬 저장소에서 최신 내역을 받아서 그 소스들을 살펴만 보고 싶다면 바로 `fetch`를 사용한다. 즉, `fetch`를 사용하면 보이지 않는 브랜치가 하나 생기고 내역만 보고싶을 때 그 브랜치에서 봅니다.
- 하지만 원격 저장소에 있는 최신 내역들을 온전히 내 로컬에서 수정하고 커밋하고 싶다면 `pull`을 사용한다.

### stash

한창 개발을 하다가 갑자기 급한 수정건이 들어와서 하던 개발을 멈춰야 하는 상황에서 커밋할 수도 없고.. 멘붕이 오죠.

그럴 때 하던 것들을 잠시 깃에서 다른 공간에 치워둘 수 있는 기능이 바로 `stash` 이다.

```
git stash
git stash pop //stash에 있는 것을 꺼낸다.
```

## 오픈소스 기여하기

1. 먼저 프로젝트 `fork` 하기
2. `git clone`을 해서 커밋과 푸시 진행
3. 그리고 `fork`한 레포지토리에서 `PR`을 보낸다.