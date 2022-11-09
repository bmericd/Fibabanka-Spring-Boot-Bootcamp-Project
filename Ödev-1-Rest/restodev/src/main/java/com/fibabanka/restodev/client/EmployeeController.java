package com.fibabanka.restodev.client;

import com.fibabanka.restodev.model.Employee;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Controller
public class EmployeeController {

    @GetMapping("/employee/get/{id}")
    @ResponseBody
    public String getEmployee(@PathVariable("id") long employeeId){
        String url = "http://localhost:8080/api/employee/"+employeeId;
        RestTemplate restTemplate = new RestTemplate();
        Employee employee = restTemplate.getForObject(url,Employee.class);

        System.out.println("Employee: " + employee.getEmployeeName());
        return "İşlem başarılı!  Employee : "+ employee.getEmployeeName();
    }

    @GetMapping("/employee/get/all")
    @ResponseBody
    public List<Employee> getAllEmployees(){
        String url = "http://localhost:8080/api/employee/get/all";
        RestTemplate restTemplate = new RestTemplate();
        Employee[] employeeArray = restTemplate.getForObject(url, Employee[].class);
        List<Employee> employeeList = Arrays.asList(employeeArray);
        return employeeList;
    }

    @GetMapping("/employee/post")
    @ResponseBody
    public String postEmployee(@RequestBody Employee employee){
        String url = "http://localhost:8080/api/employee/";
        RestTemplate restTemplate = new RestTemplate();
        Employee response = restTemplate.postForObject(url,employee,Employee.class);

        System.out.println("Employee : " + response.getEmployeeName());
        return "İşlem başarılı!  Employee : "+ response.getEmployeeName();
    }

    @GetMapping("/employee/put")
    @ResponseBody
    public String putEmployee(@RequestBody Employee employee){
        String url = "http://localhost:8080/api/employee/";
        RestTemplate restTemplate = new RestTemplate();
        Employee response = restTemplate.postForObject(url,employee,Employee.class);

        System.out.println("Employee : " + response.getEmployeeName());
        return "Put işlemi başarılı!  Employee : "+ response.getEmployeeName();
    }

    @GetMapping("/employee/delete/{id}")
    @ResponseBody
    public String deleteEmployee(@PathVariable("id") long employeeId){
        String url = "http://localhost:8080/api/employee/" + employeeId;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(url,Employee.class);

        return "İşlem başarılı!  Employee : "+ employeeId + " silindi!";
    }


}
