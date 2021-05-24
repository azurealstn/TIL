### Refresh와 Redirect

- Refresh는 몇초뒤 자동으로 해당 url에 요청을하게 됩니다.

```
resp.addHeader("Refresh", "1;url=list");
```

- Redirect는 회원등록시 결과를 출력하지않고 그 즉시 회원목록화면으로 이동하게됩니다.

```
resp.sendRedirect("list");
```

### 정리

- 작업 결과를 출력하지 않고 즉시 다른 페이지로 이동하기를 원한다면 '리다이렉트'
- 잠깐이나마 작업 결과를 출력하고 다른 페이지로 이동하기를 원한다면 '리프레시'
