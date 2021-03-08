# 목표
자바의 Input과 Ontput에 대해 학습하세요.

# 학습할 것 (필수)

- 스트림 (Stream) / 버퍼 (Buffer) / 채널 (Channel) 기반의 I/O
- InputStream과 OutputStream
- Byte와 Character 스트림
- 표준 스트림 (System.in, System.out, System.err)
- 파일 읽고 쓰기

## 스트림 (Stream) / 버퍼 (Buffer) / 채널 (Channel) 기반의 I/O

#### 스트림
자바에서 데이터는 스트림을 통해 입출력이 된다.
스트림이란 **단일 방향으로 연속적으로 흘러가는 것**을 말하는데, 물이 흐르듯이 데이터가 출발해서 도착하는 과정의 개념을 말한다.
즉, **스트림이란 데이터가 이동하는 통로**를 말한다.
우리는 스트림이라는 공통적인 입출력 모델이 있기에 쉽게 데이터를 읽고 쓸 수가 있다.

#### 버퍼
**버퍼는 입력속도에 비해 출력속도가 느린경우 데이터를 임시 저장하는 공간**을 말하며, **임시저장장치**라도고 한다.

버퍼링 없이 키보드가 눌릴 때마다 눌린 문자의 정보를 목적지로 바로 이동시키는 것보다 **중간에 메모리 버퍼를 둬서 데이터를 한데 묶어서 이동시키는 것**이 보다 효율적이고 빠를 것이다.
버퍼가 바로 이런 것이다. 성능 개선을 위해 사용한다.

즉, 모아두었다가 한꺼번에 전송하는 방법이다. **버퍼는 그러한 데이터를 보관하는 임시 메모리 공간**이라고 볼 수 있다.

#### 채널
**데이터를 주고 받기 위해서는 스레드와 데이터가 들어간 버퍼 사이의 일종의 터널을 만들어주어야 하는데, 이것이 채널이 하는 역할이다.**
즉, 채널이란 서버-클라이언트간의 통신수단이다.
채널은 파일, 소켓, 데이터그램 등과 같은 다양한 I/O 소스로부터 데이터 블록을 버퍼로 쓰거나 읽어올 수 있다.

- 채널의 특징
	- Socket과 연결되어, 입출력 역할을 수행한다.
	- 입력과 출력을 동시에 수행한다.

## InputStream과 OutputStream

- 프로그램이 출발지냐 도착지냐에 따라 스트림의 종류가 달라지는데, 데이터를 입력받을 때는 입력스트림(InputStream), 데이터를 출력할 때는 출력스트림(OutputStream)이라 부른다.
- 자바의 기본적인 데이터 입출력(I/O) API는 `java.io` 패키지에서 제공하고 있다.
- `java.io` 패키지에는 **File 클래스**와 데이터를 입출력하기 위한 다양한 입출력 스트림 클래스를 제공하고 있다.

![캡처](https://user-images.githubusercontent.com/55525868/109174060-d626db00-77c7-11eb-8c3d-cef0c321bfab.PNG)

### InputStream
**InputStream은 바이트 기반 입력 스트림의 최상위 클래스로 추상 클래스다.**
모든 바이트 기반 입력 스트림은 이 클래스를 상속받아서 만들어진다.

![캡처](https://user-images.githubusercontent.com/55525868/109175667-60bc0a00-77c9-11eb-8753-c58c7b358813.PNG)

#### 주요 메소드

- `read()` : 입력스트림으로부터 1바이트를 읽고 4바이트 int 타입으로 리턴한다.
- `close()` : InputStream을 더 이상 사용하지 않을 경우에 호출

### OutputStream
**OutputStream은 바이트 기반의 출력 스트림의 최상위 클래스로 추상 클래스다.**
모든 바이트 기반 출력 스트림은 이 클래스를 상속받아서 만들어진다.

![캡처](https://user-images.githubusercontent.com/55525868/109176726-71b94b00-77ca-11eb-857a-1a1571ca4308.PNG)

- 출력스트림은 내부에 작은 버퍼(buffer)가 있어서 데이터가 출력되기 전에 버퍼에 쌓였다가 순서대로 출력된다.
- `flush()` 메소드는 버퍼에 잔류하고 있는 데이터를 모두 출력시키고 버퍼를 비우는 역할을 한다.
- `close()` 메소드는 OutputStream을 더 이상 사용하지 않을 때 사용한다.

#### 주요 메소드

- `write()` : 매개 변수로 주어진 int 값에서 끝에 있는 1바이트만 출력 스트림으로 보낸다.

## Byte와 Character 스트림

- 바이트(Byte) 기반 스트림은 그림, 멀티미디어, 문자 등 모든 종류의 데이터를 받고 보낼 수 있으나
- 문자(Char) 기반 스트림은 오직 문자만 받고 보낼 수 있도록 특화되어 있다.

![캡처](https://user-images.githubusercontent.com/55525868/109175116-d1aef200-77c8-11eb-9340-b27877b79cea.PNG)

### Reader
**Reader는 문자 기반 입력 스트림의 최상위 클래스로 추상 클래스다.**
모든 문자 기반 입력 스트림은 이 클래스를 상속받아서 만들어진다.

![캡처](https://user-images.githubusercontent.com/55525868/109177560-484cef00-77cb-11eb-9328-e222c83a57cd.PNG)

#### 기본 메소드

- `read()` : 입력 스트림으로부터 한 개의 문자(2바이트)를 읽고 4바이트 int 타입으로 반환한다.
- `close()` : Reader를 더 이상 사용하지 않을 경우에 호출한다.

### Writer
**Writer는 문자 기반 출력 스트림의 최상위 클래스로 추상 클래스다.**
모든 문자 기반 클래스는 이 클래스를 상속받아서 만들어진다.

![캡처](https://user-images.githubusercontent.com/55525868/109178010-c01b1980-77cb-11eb-90dc-f4125a4f4bb2.PNG)

#### 기본 메소드

- `write()` : 매개 변수로 주어진 int 값에서 끝에 있는 2바이트(한 개의 문자)만 출력 스트림으로 보낸다.
- 역시 `flush()`, `close()` 메소드를 제공한다.

## 표준 스트림 (System.in, System.out, System.err)
콘솔(Console)은 시스템을 사용하기 위해 키보드로 입력을 받고 화면으로 출력하는 소프트웨어를 말한다.

자바는 콘솔로부터 데이터를 입력받을 때 `System.in`을, 콘솔에 데이터를 출력할 때는 `System.out`을, 에러를 출력할 때는 `System.err`를 사용한다.

### System.in
자바는 프로그램이 **콘솔로부터 데이터를 입력받을 수 있도록 System 클래스의 in 정적 필드를 제공**하고 있다. System.in은 InputStream 타입의 필드이므로 다음과 같이 InputStream 변수로 참조가 가능하다.

```java
InputStream is = System.in;
```

- 키보드로부터 어떤 키가 입력되었는지 확인하려면 InputStream의 `read()` 메소드로 한 바이트를 읽으면 된다. 리턴된 int 값에는 *아스키 코드*값이 들어 있다.

```java
int code = is.read();
```

### System.out
**콘솔에서 입력된 데이터를 System.in으로 읽었다면, 콘솔로 데이터를 출력하기 위해서는 System 클래스의 out 정적 필드를 사용한다.** out은 PrintStream 타입의 필드이다.
**PrintStream은 OutputStream의 하위 클래스이므로 out 필드를 OutputStream 타입으로 변환해서 시용할 수 있다.**

```java
OutputStream os = System.out;
```

- 콘솔로 1개의 바이트를 출력하려면 OutputStream의 `write(int b)` 메소드를 이용하면 된다.
- 이 때 바이트 값은 아스키 코드이며, write() 메소드는 아스키 코드를 문자로 콘솔에 출력한다.

```java
byte b = 89;
os.write(b);
os.flush();
```

### System.err
일반적으로 System.out과 마찬가지로 모니터로 지정되는 경우가 많다.

- 정상 출력은 System.out
- 에러 발생시 System.err
- System.err 역시 PrintStream 클래스 타입으로 System.out과 사용법이 동일하다.

```java
System.err.println(e);
```

## 파일 읽고 쓰기
IO 패키지(java.io)에서 제공하는 File 클래스는 파일 크기, 파일 속성, 파일 이름 등의 저옵를 얻어내는 기능과 파일 생성 및 삭제 기능을 제공하고 있다.

```java
//파일 생성
File file = new File("C:\Temp\test.txt");

//파일 존재 확인
boolean isExist = file.exists();
```

### FileReader
FileReader 클래스는 텍스트 파일을 프로그램으로 읽어들일 때 사용하는 문자 기반 스트림이다.
문자 단위로 읽기 때문에 텍스트가 아닌 그림, 오디오 같은 것들은 읽을 수 없다.

```java
FileReader fr = new FileReader("C:\Temp\test.txt");
```

### FileWriter
FileWriter는 텍스트 데이터를 파일에 저장할 때 사용하는 문자 기반 스트림이다. 역시 문자 단위로 저장하기 때문에 그림, 오디오 같은 것은 저장할 수 없다.

```java
FileWriter fw = new FileWriter("C:\Temp\test2.txt");
```
