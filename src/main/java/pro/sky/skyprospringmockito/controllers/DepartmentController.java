package pro.sky.skyprospringmockito.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyprospringmockito.model.Employee;
import pro.sky.skyprospringmockito.services.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/{department}/employees")
    public List<Employee> getEmployeesByDepartment(@PathVariable String department){
        return departmentService.getEmployeesByDepartment(department);
    }

    @GetMapping(path = "/{department}/salary/sum")
    public int sumSalaryByDepartment(@PathVariable String department){
        return departmentService.sumSalaryByDepartment(department);
    }

    @GetMapping(path = "/{department}/salary/max")
    public int maxSalaryByDepartment(@PathVariable String department){
        return departmentService.maxSalaryByDepartment(department);
    }

    @GetMapping(path = "/{department}/salary/min")
    public int minSalaryByDepartment(@PathVariable String department){
        return departmentService.minSalaryByDepartment(department);
    }

    @GetMapping(path = "/employees")
    public Map<String, List<Employee>> getEmployeesByDepartments(){
        return departmentService.getEmployeesByDepartments();
    }
}
