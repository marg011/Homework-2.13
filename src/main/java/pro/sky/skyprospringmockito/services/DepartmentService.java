package pro.sky.skyprospringmockito.services;

import pro.sky.skyprospringmockito.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {

    List<Employee> getEmployeesByDepartment(String department);
    int sumSalaryByDepartment(String department);

    int maxSalaryByDepartment(String department);

    int minSalaryByDepartment(String department);

    Map<String, List<Employee>> getEmployeesByDepartments();
}
