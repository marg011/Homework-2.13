package pro.sky.skyprospringmockito.model;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Employee {
    private String lastName;
    private String firstName;
    private String patronymicName;
    private int salary;
    private String department;

    public Employee(String lastName, String firstName, String patronymicName, int salary, String department) {
        this.lastName = StringUtils.capitalize(lastName.toLowerCase());
        this.firstName = StringUtils.capitalize(firstName.toLowerCase());
        this.patronymicName = StringUtils.capitalize(patronymicName.toLowerCase());
        this.salary = salary;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Last name: " + this.lastName + ", first name: "
                + this.firstName + ", patronymic: " + this.patronymicName
                + ", salary: " + this.salary + ", department: " + this.department;


    }

    public String getFullName(){
        return lastName + " " + firstName + " " + patronymicName;
    }

    public String getDepartment() {
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
        return salary == employee.salary && Objects.equals(lastName, employee.lastName) && Objects.equals(firstName, employee.firstName) && Objects.equals(patronymicName, employee.patronymicName) && Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, patronymicName, salary, department);
    }
}
