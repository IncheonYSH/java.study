# Java Study

1. 사원 관리 프로그램을 주제로 프로그램을 작성한다.
2. 객체지향 언어의 특징을 하나씩 반영하며 점진적으로 어떠한 변화가 생기는지, 이점은 무엇인지 기록한다.

<br>

# 캡슐화(encapsulation)

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

<br>

# 상속(inheritance)

* 높은 코드 재활용성을 제공한다.
* 클래스 간의 계층적 관계를 구성한다.

<br>

사원관리를 위해 vo객체를 생성하고 이를 배열에 저장한다. 이를 위해 다음과 같은 클래스와 메서드를 작성하였다.

![](README/inheritance1-1635868180511.png)

`Engineer` 와 `Manager` 는 모두 사원이지만 type이 다르다는 이유로 따로 취급되며 같은 메서드가 반복된다.

이를 상속을 통해 다음과 같이 변경할 수 있다.

![](README/inheritance2-1635870577897.png)

이 과정을 통해

* 코드 재사용성을 높였으며
* 클래스 간의 계층 관계를 구성하였다.

이러한 관계가 구성되어있기 때문에 차후 새로운 형태의 직원이 생기더라도 `Employee` 클래스를 상속받아 vo 를 생성하여 처리하면 된다.

<br>

> 참고)
>
> 다음 코드에서
>
> ```java
> public class Animal{
>     public void eat(){
>         System.out.println("Animal eat");
>     }
> }
> 
> public class Cat extends{
>     @Override
>     public void eat(){
>         System.out.println("Cat eat");
>     }
>     
>     public void meow(){
>         System.out.println("애옹");
>     }
> }
> ```
>
> 1. Type casting
>
>    ```java
>    Cat cat = new Cat();
>    Animal animal = cat;
>    animal.eat();
>    ```
>
>    여기서 `Animal animal = cat;` 에서 암시적 __upcasting__이 발생했다.
>
>    명시적으로 할 수도 있지만 컴파일러가 `Cat` 이 `Animal` 임을 알기 때문에 그러지 않아도 된다.
>
>    한편, 아래와 같이 호출하면 컴파일러 오류가 발생한다.
>
>    ```java
>    animal.meow();
>    ```
>
>    animal 은 `Cat` 클래스의 인스턴스이지만 __컴파일러는 참조변수의 타입만을 인식하므로__ 오류가 발생하게된다.
>
>    컴파일러가 이를 인식하게 하려면 다음과 같이 __downcasting__ 해야 한다. Downcasting 수행 시 실행 후 생성될 인스턴스의 타입에 유의해야한다.
>
>    ```java
>    ((Cat) animal).meow();
>    ```
>
>     
>
> 2. Virtual method invocation
>
>    컴파일 시점에는 참조변수 타입 클래스의 메서드가 호출된다.
>
>    런타임 시점에서는 참조변수가 실제로 참조하는 인스턴스의 메서드가 호출된다(없으면 그 바로 위 부모 클래스의 메서드가 호출된다).
>
>    따라서 위 코드들의 실행 결과는 다음과 같다.
>
>    ```shell
>    Cat eat #animal eat 이 출력되지않는다. Virtual method invocation 가 발생했다.
>    애옹 #명시적 downcasting 이 일어났다.
>    ```

<br>

# 다형성(polymorphism)

* 역할과 구현을 분리한다.
* 인터페이스를 구현한 객체 인스턴스를 실행 시점에 유연하게 변경할 수 있다.
* 따라서 __인터페이스를 안정적으로 잘 설계하여야 한다.__

