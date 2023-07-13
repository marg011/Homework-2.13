package pro.sky.skyprospringmockito.model;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Employee {
    private static int id;
    private final int EmployeeId;
    private String lastName;
    private String firstName;
    private String patronymicName;
    private int salary;
    private int department;

    public Employee(String lastName, String firstName, String patronymicName, int salary, int department) {
        this.EmployeeId = id;
        this.lastName = StringUtils.capitalize(lastName.toLowerCase());
        this.firstName = StringUtils.capitalize(firstName.toLowerCase());
        this.patronymicName = StringUtils.capitalize(patronymicName.toLowerCase());
        this.salary = salary;
        this.department = department;
        id++;
    }

    @Override
    public String toString() {
        return "ID: " + this.EmployeeId + ", last name: " + this.lastName + ", first name: "
                + this.firstName + ", patronymic: " + this.patronymicName
                + ", salary: " + this.salary + ", department: " + this.department;


    }

    public String getFullName(){
        return lastName + " " + firstName + " " + patronymicName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return EmployeeId == employee.EmployeeId && salary == employee.salary && Objects.equals(lastName, employee.lastName) && Objects.equals(firstName, employee.firstName) && Objects.equals(patronymicName, employee.patronymicName) && department==employee.department;
    }

    @Override
    public int hashCode() {
        return Objects.hash(EmployeeId, lastName, firstName, patronymicName, salary, department);
    }
}
