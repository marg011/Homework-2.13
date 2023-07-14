package pro.sky.skyprospringmockito.services;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringmockito.exceptions.DepartmentIsBlankException;
import pro.sky.skyprospringmockito.exceptions.NoDepartmentException;
import pro.sky.skyprospringmockito.model.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeBookService employeeBookService;

    public DepartmentServiceImpl(EmployeeBookService employeeBookService) {
        this.employeeBookService = employeeBookService;
    }

    public List<Employee> getEmployeesByDepartment(String department){

        throwExceptions(department);

        return employeeBookService.getEmployees().values().stream()
                .filter(e -> e.getDepartment().contains(department))
                .collect(Collectors.toList());
    }

    public int sumSalaryByDepartment(String department){

        throwExceptions(department);

        return employeeBookService.getEmployees().values().stream()
                .filter(e -> e.getDepartment().contains(department))
                .map(employee -> employee.getSalary())
                .mapToInt(Integer::valueOf)
                .sum();
    }

    public int maxSalaryByDepartment(String department){

        throwExceptions(department);

        return employeeBookService.getEmployees().values().stream()
                .filter(e -> e.getDepartment().contains(department))
                .map(employee -> employee.getSalary())
                .max(Integer::compare)
                .orElseThrow(() -> new RuntimeException("Employee with max salary is not found"));
    }

    public int minSalaryByDepartment(String department){

        throwExceptions(department);

        return employeeBookService.getEmployees().values().stream()
                .filter(e -> e.getDepartment().contains(department))
                .map(employee -> employee.getSalary())
                .min(Integer::compare)
                .orElseThrow(() -> new RuntimeException("Employee with min salary is not found"));
    }

    public Map<String, List<Employee>> getEmployeesByDepartments(){

        Map<String, List<Employee>> employeesByDepartments = new HashMap<>();

        List<String> departments = getDepartments();
        for (String dep : departments) {
            List<Employee> empls = employeeBookService.getEmployees().values().stream()
                    .filter(e -> e.getDepartment().contains(dep))
                    .collect(Collectors.toList());
            employeesByDepartments.put(dep, empls);
        }
        return employeesByDepartments;
    }

    private List<String> getDepartments(){
        return employeeBookService.getEmployees().values().stream()
                .map(employee -> employee.getDepartment())
                .distinct()
                .collect(Collectors.toList());
    }

    private void throwExceptions(String department){
        if (department.isBlank()){
            throw new DepartmentIsBlankException("Department is blank");
        }
        if (!getDepartments().contains(department)){
            throw new NoDepartmentException("No such department");
        }
    }

}
