package pro.sky.skyprospringmockito.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyprospringmockito.services.EmployeeBookService;

@RestController
public class EmployeeBookController {
    private final EmployeeBookService employeeBookService;

    public EmployeeBookController(EmployeeBookService employeeBookService) {
        this.employeeBookService = employeeBookService;
    }

    @GetMapping(path = "/add")
    public String addEmployee(@RequestParam("lastName") String lastName,
                              @RequestParam ("firstName") String firstName,
                              @RequestParam ("patronymicName") String patronymicName,
                              @RequestParam ("salary") int salary,
                              @RequestParam ("department") int department){
        return employeeBookService.addEmployee(lastName, firstName, patronymicName, salary, department);
    }

    @GetMapping(path = "/remove")
    public String removeEmployee(@RequestParam ("lastName") String lastName,
                                 @RequestParam ("firstName") String firstName,
                                 @RequestParam ("patronymicName") String patronymicName){
        return employeeBookService.removeEmployee(lastName, firstName, patronymicName);
    }
    @GetMapping(path = "/find")
    public String findEmployee(@RequestParam ("lastName") String lastName,
                               @RequestParam ("firstName") String firstName,
                               @RequestParam ("patronymicName") String patronymicName){
        return employeeBookService.findEmployee(lastName, firstName, patronymicName);
    }





}
