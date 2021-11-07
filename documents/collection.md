## Java Collection

* 자료구조를 추상화한 api 를 사용하여 생산성을 향상시킨다.
* `Collection` , `List` ,  `Set` 등의 기본 인터페이스를 제공하므로 이를 확장하고 다형적으로 활용할 수 있다.

<br>

![](collection/collection1.png)

컬렉션 프레임워크의 계층 구조는 위와 같다. 이외에도 `ArrayList` 와 `Vector` 는  `RandomAccess` 인터페이스를 상속하는 등 행동을 정의한 다른 인터페이스들을 자료구조에 따라 추가로 상속받는다.

`Map` 인터페이스가 `Collection` 인터페이스를 상속하지 않는 것에 주의해야한다.

각각의 인터페이스와 클래스에 대한 정보는 공식 문서를 참고한다.

> https://docs.oracle.com/javase/8/docs/api/

연결 리스트, 큐, 스택, 우선순위 큐 등의 자료구조가 기본적으로 제공되므로 이러한 자료구조에 대한 구현을 하지 않고 표준화된 api 를 통해 데이터에 접근함으로써 생산성을 향상시킬 수 있다.

또한, 컬렉션 프레임워크에는 제네릭을 도입하였는데, 제네릭을 사용함으로써 잘못된 타입의 객체를 컴파일 시점에서 파악하고 타입 캐스팅( + instanceof) 을 피하여 코드를 간결하게 유지할 수 있게 되었다.

<br>

지금까지의 프로그램에서 입력된 값을 저장하기 위해 배열을 사용하였다.

```java
public class EmployeeListService{
    private Employee[] employees = new Employee[10];
    // 중략
    
    public void addEmployee(Employee employee) {
		if(count == capacity){
            Employee[] newEmployees = new Employee[capacity * 2];
            System.arraycopy(employees, 0, newEmployees, 0, capacity);
            employees = newEmployees;
            capacity *= 2;
        }
        employees[count++] = employee;
    }
    // 이하 생략
}
```

간단하게 구현하였지만 자료 구조를 변경할 일이 생긴다면 `EmployeeListService` 클래스의 모든 부분을 수정하여야 한다. 자료 구조에 대한 메서드가 표준화 되지 않았기 때문이다.

이제 이를 컬렉션 api 를 사용하여 표준화한다.

```java
public class EmployeeListService{
	private ArrayList<Employee> list = new ArrayList<>();
    // 중략
    public void addEmployee(Employee employee) {
		list.add(employee);
	}
    // 이하 생략
}
```

표준화된 api 를 사용하여 생산성을 대폭 향상시켰으며, 자료 구조에 대한 수정이 필요하면 적절한 인터페이스를 구현한 뒤 교체하여 다형적으로 사용 가능하다.

