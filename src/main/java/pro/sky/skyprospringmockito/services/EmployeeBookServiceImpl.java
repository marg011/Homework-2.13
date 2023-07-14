package pro.sky.skyprospringmockito.services;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import pro.sky.skyprospringmockito.exceptions.WrongSymbolsException;
import pro.sky.skyprospringmockito.model.Employee;

@Service
public class EmployeeBookServiceImpl implements EmployeeBookService {

    Map<String, Employee> employees = new HashMap<>();

    public Map<String, Employee> getEmployees() {
        return employees;
    }

    public String addEmployee(String lastName, String firstName, String patronymicName, int salary, String department) {

        validateNames(lastName, firstName, patronymicName);

        Employee employee = new Employee(lastName, firstName, patronymicName, salary, department);
        if (employees.containsKey(employee.getFullName())) {
            throw new RuntimeException("This employee is already in database");
        }
        employees.put(employee.getFullName(), employee);
        return employee.toString();
    }

    public String removeEmployee(String lastName, String firstName, String patronymicName) {

        validateNames(lastName, firstName, patronymicName);

        String fullName = lastName + " " + firstName + " " + patronymicName;
        if (!employees.containsKey(fullName)) {
            throw new RuntimeException("This employee is not in database");
        }
        employees.remove(fullName);
        return fullName;
    }

    public String findEmployee(String lastName, String firstName, String patronymicName) {

        validateNames(lastName, firstName, patronymicName);

        String fullName = lastName + " " + firstName + " " + patronymicName;
        if (!employees.containsKey(fullName)) {
            throw new RuntimeException("This employee is not in database");
        }
        return employees.get(fullName).toString();
    }

    private void validateNames(String lastName, String firstName, String patronymicName){
        if (!(StringUtils.isAlpha(lastName) && (StringUtils.isAlpha(firstName) && StringUtils.isAlpha(patronymicName)))) {
            throw new WrongSymbolsException("Wrong symbols in names");
        }
    }
}
