## 캡슐화(encapsulation)

* 다른 클래스에서의 필드나 메서드에 대한 직접적인 접근을 제한한다.
* 구현 내용을 은닉하고 메서드를 통해 필드에 접근한다.
* 이를 통해 필드를 보호하고 입력값을 검증한다.

<br>

월, 일을 입력받는 날짜 클래스를 정의한다고 하자

```java
public class MyDate{
    public int month;
    public int day;
}
```

이와 같이 정의한다면 모든 클래스에서 `MyDate` 객체의 필드에 접근할 수 있게 된다. 즉, 다음이 가능해진다.

```java
MyDate mydate = new MyDate();
mydate.month = -1;
mydate.day = 99;
```

월, 일을 입력받는 날짜 클래스를 정의한다고 하였으므로 그 의미를 생각해 보았을 때 위와 같은 값이 필드에 할당되서는 __안된다__. 

이제 적절한 조건과 함께 다음과 같이 `MyDate` 클래스를 변경하였다.

변경사항은 다음과 같다.

* 필드에 `private` 접근제한자를 지정하여 다른 클래스에서 직접 필드에 접근할 수 없도록 한다.
* 메서드를 통해 필드의 값을 초기화한다.
* 값을 초기화하는 메서드에서 입력값을 검증할 수 있게 하였다.

```java
/**
* MyDate 
*/
public class MyDate {
    private int month;
    private int day;
    
    public MyDate(){ }

    public MyDate(int month, int day) {
        setMonth(month);
        setDay(day);
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (isValidDay(month, day)) {
            this.day = day;
        }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (isValidMonth(month)) {
            this.month = month;
        }
    }

    public void printDate(){
        if(isValidDate(day, month)){
            System.out.println(month + "." + day);
        }else{
            System.out.println("Invalid date");
        }
            // (이하 생략)
    }

```

아래 클래스로 테스트 하였다.

```java
/**
* MyDateTest
*/
public class MyDateTest {
    public static void main(String[] args) {
        MyDate date = new MyDate(1, 1);
        date.printDate();

        MyDate date1 = new MyDate(3, 78);
        date1.printDate();

        MyDate date2 = new MyDate(12, 31);
        date2.printDate();

        MyDate date3 = new MyDate(2, 29);
        date3.printDate();
    }
}
```

> 실행 결과

```shell
1.1
Invalid date
12.31
Invalid date
```

이와 같이 캡슐화를 통해 다음 목적을 달성하였다.

* 다른 클래스에서의 직접적인 접근을 제한
* 구현 내용을 은닉하고 메서드를 통해 필드에 접근
* 이를 통해 필드를 보호하고 입력값을 검증