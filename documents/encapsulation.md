## 캡슐화(major0.minor1)

* 다른 클래스에서의 필드나 메서드에 대한 직접적인 접근을 제한한다.
* 구현 내용을 은닉하고 메서드를 통해 필드에 접근한다.
* 이를 통해 필드를 보호하고 입력값을 검증한다.

<br>

엔지니어인 사원 관리를 위해 다음과 같이 클래스를 정의하였다.

```java
public class Engineer{
    public String empId;
    public String name;
    public String addr;
    public int salary;
    public String tech;
    public int bonus;
}

public class EmployeeService {
    public Engineer[] engineerList;
    public int engineerCount;
    public int engineerCapacity = 10;
    
    public EmployeeService() {
        engineerList = new Engineer[engineerCapacity];
    }
}
```

이와 같이 정의한다면 `새로운 엔지니어를 엔지니어 목록에 추가하는 작업` 을 수행하기 위해 아래와 같이 모든 클래스에서 `Engineer` 와 `EmployeeService` 객체의 필드에 직접 접근해야한다.

```java
// Engineer 객체 생성
Engineer engineer1 = new Engineer();
engineer.empId = "001";
engineer.name = "engineer1";
engineer.addr = "seoul";
engineer.salary = 4000;
engineer.tech = "java";
engineer.bonus = 2000;

// EmployeeService 클래스의 engineerList 필드에 engineer1 추가
EmployeeService employeeservice = new EmployeeService();
if(employeeService.engineerCount == employeeservice.engineerCapacity){
    Engineer[] newEngineerList = new Engineer[employeeservice.engineerCapacity * 2];
    System.arraycopy(employeeservice.engineerList, 0, newEngineerList, 0, employeeservice.engineerCapacity);
    employeeservice.engineerList = newEngineerList;
    employeeservice.engineerCapacity *= 2;
}
employeeService.engineerList[employeeService.engineerCount++] = engineer;
```

하지만 이러한 구조는 다음의 문제점이 있다.

* 모든 필드의 제한사항과 구현을 알고있어야 하며 필드에 접근할 때 마다 이를 구현해야한다.

  > 엔지니어 목록에 엔지니어를 추가할 때 마다 배열의 크기 등 제약사항을 확인해야한다.

* 필드에 올바르지 않은 방식으로 접근할 가능성이 있다.

  ```java
  // 만약 다음을 실행시킨다면??
  employeeService.engineerList[11] = Engineer1;
  ```

따라서 다음과 같이 __캡슐화(major0.minor1)__ 한다.

변경사항은 다음과 같다.

* 필드에 `private` 접근제한자를 지정하여 다른 클래스에서 직접 필드에 접근할 수 없도록 한다.
* 메서드를 통해 필드의 값을 초기화하거나 접근한다. 이 과정에서 필드 제한사항 확인 등의 과정이 이루어지며 일부 구현은 은닉된다.

```java
/**
* Engineer
*/
public class Engineer {
    private String empId;
    private String name;
    private String addr;
    private int salary;
    private String tech;
    private int bonus;

    public Engineer(String empId, String name, String addr, int salary, String tech, int bonus) {
        this.empId = empId;
        this.name = name;
        this.addr = addr;
        this.salary = salary;
        this.tech = tech;
        this.bonus = bonus;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    ////////////////////////////
    // 이하 생략
}

```

```java
/**
* EmployeeService
*/
public class EmployeeService {
    private Engineer[] engineerList;
    private int engineerCount;
    private int engineerCapacity = 10;
    
    public EmployeeService() {
        managerList = new Manager[managerCapacity];
    }
    
    public void addEngineer(Engineer engineer) {
        if(engineerCount == engineerCapacity){
            Engineer[] newEngineerList = new Engineer[engineerCapacity * 2];
            System.arraycopy(engineerList, 0, newEngineerList, 0, engineerCapacity);
            engineerList = newEngineerList;
            engineerCapacity *= 2;
        }
        engineerList[engineerCount++] = engineer;
    }
    ////////////////////////
    // 이하 생략
}
```

아래 클래스로 테스트 하였다.

```java
/**
* EmployeeServiceTest
*/
public class EmployeeServiceTest {
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();
        Engineer engineer = new Engineer("001", "John", "Seoul", 4000, "java", 2000);
        employeeService.addEngineer(engineer);
        employeeService.printAllEmployees();
    }
}
```

> 실행 결과

```shell
001 John Seoul 4000 java 2000
```

이와 같이 캡슐화를 통해 다음 목적을 달성하였다.

* 다른 클래스에서의 직접적인 접근을 제한
* 구현 내용을 은닉하고 메서드를 통해 필드에 접근
* 이를 통해 필드를 보호하고 입력값을 검증