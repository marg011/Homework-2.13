package pro.sky.skyprospringmockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.skyprospringmockito.model.Employee;
import pro.sky.skyprospringmockito.services.EmployeeBookService;
import pro.sky.skyprospringmockito.services.EmployeeBookServiceImpl;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmployeeBookServiceTests {

    EmployeeBookService employeeBookService;

    @BeforeEach
    public void setUp() {
        employeeBookService = new EmployeeBookServiceImpl();
    }

    @Test
    public void addEmployeeTest() {
        Employee employee = new Employee("Ivanov", "Ivan", "Ivanovich",
                55000, "sales");

        Map<String, Employee> expected = new HashMap<>();
        expected.put("Ivanov Ivan Ivanovich", employee);

        employeeBookService.addEmployee("Ivanov", "Ivan", "Ivanovich",
                55000, "sales");

        Map<String, Employee> actual = employeeBookService.getEmployees();

        assertEquals(expected, actual);
    }

    @Test
    public void addEmployeeTestException() {
        employeeBookService.addEmployee("Ivanov", "Ivan", "Ivanovich",
                55000, "sales");

        assertThrows(RuntimeException.class, () -> employeeBookService.addEmployee("Ivanov", "Ivan", "Ivanovich",
                55000, "sales"));
    }

    @Test
    public void removeEmployeeTest() {
        Employee employee1 = new Employee("Ivanov", "Ivan", "Ivanovich",
                55000, "sales");

        Employee employee2 = new Employee("Ivanov", "Petr", "Ivanovich",
                85000, "it");

        Map<String, Employee> expected = new HashMap<>();
        expected.put("Ivanov Ivan Ivanovich", employee1);

        employeeBookService.addEmployee("Ivanov", "Ivan", "Ivanovich",
                55000, "sales");

        employeeBookService.addEmployee("Ivanov", "Petr", "Ivanovich",
                85000, "it");

        employeeBookService.removeEmployee("Ivanov", "Petr", "Ivanovich");

        Map<String, Employee> actual = employeeBookService.getEmployees();

        assertEquals(expected, actual);
    }

    @Test
    public void removeEmployeeTestException() {

        assertThrows(RuntimeException.class, () -> employeeBookService.removeEmployee("Ivanov", "Ivan", "Ivanovich"));
    }

    @Test
    public void findEmployeeTest() {

        String expected = "Last name: Ivanov, first name: Ivan, patronymic: Ivanovich, salary: 55000, department: sales";

        employeeBookService.addEmployee("Ivanov", "Ivan", "Ivanovich",
                55000, "sales");

        String actual = employeeBookService.findEmployee("Ivanov", "Ivan", "Ivanovich");

        assertEquals(expected, actual);
    }

    @Test
    public void findEmployeeTestException() {

        assertThrows(RuntimeException.class, () -> employeeBookService.findEmployee("Ivanov", "Ivan", "Ivanovich"));
    }

}




