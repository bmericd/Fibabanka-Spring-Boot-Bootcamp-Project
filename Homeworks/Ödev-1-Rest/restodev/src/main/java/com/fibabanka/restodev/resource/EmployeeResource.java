package com.fibabanka.restodev.resource;

import com.fibabanka.restodev.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeResource {

    @GetMapping("/api/employee/{id}")
    public Employee getEmployee(@PathVariable("id") long employeeId){
        Employee employee = new Employee(employeeId,"Meriç",13000); //Dummy data
        return employee;
    }

    @GetMapping("/api/employee/get/all")
    public Employee[] getAllEmployees(){
    Employee[] employeeList = new Employee[5];
    employeeList[0] =(new Employee(1,"Meriç",13000));
    employeeList[1] =(new Employee(2,"Osman",14000));
    employeeList[2] = (new Employee(3,"Gizem",25000));

    return employeeList;
    }

    @PostMapping("/api/employee/")
    public Employee postEmployee(@RequestBody Employee employee){
        System.out.println("Employee oluşturuldu! " + employee.getEmployeeName());
        return employee;
    }

    @PutMapping("/api/employee/")
    public Employee putEmployee(@RequestBody Employee employee){
        System.out.println("Employee güncellendi! " + employee.getEmployeeName());
        return employee;
    }

    @DeleteMapping("/api/employee/{id}")
    public void deleteEmployee(@PathVariable("id")long employeeId){
        System.out.println("Employee : + " + employeeId + " silindi! ");
    }
}
