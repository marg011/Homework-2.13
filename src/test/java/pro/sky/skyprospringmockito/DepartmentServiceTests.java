package pro.sky.skyprospringmockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.skyprospringmockito.exceptions.DepartmentIsBlankException;
import pro.sky.skyprospringmockito.exceptions.NoDepartmentException;
import pro.sky.skyprospringmockito.model.Employee;
import pro.sky.skyprospringmockito.services.DepartmentService;
import pro.sky.skyprospringmockito.services.DepartmentServiceImpl;
import pro.sky.skyprospringmockito.services.EmployeeBookService;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTests {

    private DepartmentService departmentService;

    @Mock
    private EmployeeBookService employeeBookService;

    @BeforeEach
    public void setUp(){
        departmentService = new DepartmentServiceImpl(employeeBookService);
    }

    @Test
    public void getEmployeesByDepartmentTest(){
       assertNotNull(employeeBookService);

       Employee employee = new Employee("Ivanov", "Ivan", "Ivanovich",
               55000, "sales");

        Map<String, Employee> employees = new HashMap<>();
        employees.put("Ivanov Ivan Ivanovich", employee);

       Mockito.when(employeeBookService.getEmployees()).thenReturn(employees);

       List<Employee> expected = new ArrayList<>();
       expected.add(employee);

       List<Employee> actual = departmentService.getEmployeesByDepartment("sales");

       assertEquals(expected, actual);
    }

    @Test
    public void getEmployeesByDepartmentTestExceptions(){
        assertNotNull(employeeBookService);

        Employee employee = new Employee("Ivanov", "Ivan", "Ivanovich",
                55000, "sales");

        Map<String, Employee> employees = new HashMap<>();
        employees.put("Ivanov Ivan Ivanovich", employee);

        Mockito.when(employeeBookService.getEmployees()).thenReturn(employees);

        assertThrows(DepartmentIsBlankException.class, () -> departmentService.getEmployeesByDepartment(""));
        assertThrows(NoDepartmentException.class, () -> departmentService.getEmployeesByDepartment("it"));
    }

    @Test
    public void sumSalaryByDepartmentTest(){
        assertNotNull(employeeBookService);

        Employee employee1 = new Employee("Ivanov", "Ivan", "Ivanovich",
                55000, "sales");
        Employee employee2 = new Employee("Ivanov", "Petr", "Ivanovich",
                45000, "sales");
        Employee employee3 = new Employee("Ivanov", "Andrei", "Ivanovich",
                45000, "it");

        Map<String, Employee> employees = new HashMap<>();
        employees.put("Ivanov Ivan Ivanovich", employee1);
        employees.put("Ivanov Petr Ivanovich", employee2);
        employees.put("Ivanov Andrei Ivanovich", employee3);

        Mockito.when(employeeBookService.getEmployees()).thenReturn(employees);

        int expected = 100_000;

        int actual = departmentService.sumSalaryByDepartment("sales");

        assertEquals(expected, actual);

    }

    @Test
    public void sumSalaryByDepartmentTestExceptions(){
        assertNotNull(employeeBookService);

        Employee employee = new Employee("Ivanov", "Ivan", "Ivanovich",
                55000, "sales");

        Map<String, Employee> employees = new HashMap<>();
        employees.put("Ivanov Ivan Ivanovich", employee);

        Mockito.when(employeeBookService.getEmployees()).thenReturn(employees);

        assertThrows(DepartmentIsBlankException.class, () -> departmentService.sumSalaryByDepartment(""));
        assertThrows(NoDepartmentException.class, () -> departmentService.sumSalaryByDepartment("it"));
    }

    @Test
    public void maxSalaryByDepartmentTest(){
        assertNotNull(employeeBookService);

        Employee employee1 = new Employee("Ivanov", "Ivan", "Ivanovich",
                55000, "sales");
        Employee employee2 = new Employee("Ivanov", "Petr", "Ivanovich",
                45000, "sales");
        Employee employee3 = new Employee("Ivanov", "Andrei", "Ivanovich",
                45000, "it");

        Map<String, Employee> employees = new HashMap<>();
        employees.put("Ivanov Ivan Ivanovich", employee1);
        employees.put("Ivanov Petr Ivanovich", employee2);
        employees.put("Ivanov Andrei Ivanovich", employee3);

        Mockito.when(employeeBookService.getEmployees()).thenReturn(employees);

        int expected = 55_000;

        int actual = departmentService.maxSalaryByDepartment("sales");

        assertEquals(expected, actual);

    }

    @Test
    public void maxSalaryByDepartmentTestExceptions(){
        assertNotNull(employeeBookService);

        Map<String, Employee> employees = new HashMap<>();

        Mockito.when(employeeBookService.getEmployees()).thenReturn(employees);

        assertThrows(DepartmentIsBlankException.class, () -> departmentService.maxSalaryByDepartment(""));
        assertThrows(NoDepartmentException.class, () -> departmentService.maxSalaryByDepartment("it"));
        assertThrows(RuntimeException.class, () -> departmentService.maxSalaryByDepartment("sales"));

    }

    @Test
    public void minSalaryByDepartmentTest(){
        assertNotNull(employeeBookService);

        Employee employee1 = new Employee("Ivanov", "Ivan", "Ivanovich",
                55000, "sales");
        Employee employee2 = new Employee("Ivanov", "Petr", "Ivanovich",
                45000, "sales");
        Employee employee3 = new Employee("Ivanov", "Andrei", "Ivanovich",
                45000, "it");

        Map<String, Employee> employees = new HashMap<>();
        employees.put("Ivanov Ivan Ivanovich", employee1);
        employees.put("Ivanov Petr Ivanovich", employee2);
        employees.put("Ivanov Andrei Ivanovich", employee3);

        Mockito.when(employeeBookService.getEmployees()).thenReturn(employees);

        int expected = 45_000;

        int actual = departmentService.minSalaryByDepartment("sales");

        assertEquals(expected, actual);

    }

    @Test
    public void minSalaryByDepartmentTestExceptions(){
        assertNotNull(employeeBookService);

        Map<String, Employee> employees = new HashMap<>();

        Mockito.when(employeeBookService.getEmployees()).thenReturn(employees);

        assertThrows(DepartmentIsBlankException.class, () -> departmentService.minSalaryByDepartment(""));
        assertThrows(NoDepartmentException.class, () -> departmentService.minSalaryByDepartment("it"));
        assertThrows(RuntimeException.class, () -> departmentService.minSalaryByDepartment("sales"));

    }

    @Test
    public void getEmployeesByDepartmentsTest(){

        Employee employee1 = new Employee("Ivanov", "Ivan", "Ivanovich",
                55000, "sales");
        Employee employee2 = new Employee("Ivanov", "Petr", "Ivanovich",
                45000, "sales");
        Employee employee3 = new Employee("Ivanov", "Andrei", "Ivanovich",
                45000, "it");

        Map<String, Employee> employees = new HashMap<>();
        employees.put("Ivanov Ivan Ivanovich", employee1);
        employees.put("Ivanov Petr Ivanovich", employee2);
        employees.put("Ivanov Andrei Ivanovich", employee3);

        Mockito.when(employeeBookService.getEmployees()).thenReturn(employees);

        Map<String, List<Employee>> expected = new HashMap<>();
        expected.put("sales", Arrays.asList(employee1, employee2));
        expected.put("it", Arrays.asList(employee3));

        Map<String, List<Employee>> actual = departmentService.getEmployeesByDepartments();

        assertEquals(expected.keySet(), actual.keySet());
        assertEquals(expected.size(), actual.size());
        assertEquals(expected.get("sales").get(0), actual.get("sales").get(1));
        assertEquals(expected.get("sales").get(1), actual.get("sales").get(0));
        assertEquals(expected.get("it").get(0), actual.get("it").get(0));
    }

    }
