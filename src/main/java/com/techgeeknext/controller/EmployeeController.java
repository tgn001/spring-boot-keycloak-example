package com.techgeeknext.controller;

import com.techgeeknext.model.Department;
import com.techgeeknext.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    @GetMapping("/hello")
    public String hello() {
           return "hello";
    }


    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees() {
            Employee emp1 = Employee.builder().name("aaa").role("user").id(1).build();
            Employee emp2 = Employee.builder().name("bbb").role("user").id(2).build();
            List<Employee> emps = new ArrayList<>();
            emps.add(emp1);
            emps.add(emp2);
            return new ResponseEntity<>(emps, HttpStatus.OK);
    }

    @GetMapping("/departments")
    public ResponseEntity<List<Department>> getDeparts() {
        Department dept1 = Department.builder().name("HR").id(1).build();
        Department dept2 = Department.builder().name("Sales").id(2).build();
        List<Department> departments = new ArrayList<>();
        departments.add(dept1);
        departments.add(dept2);
            return new ResponseEntity<>(departments,HttpStatus.NOT_FOUND);
    }

    @GetMapping("/access-denied-response")
    public String accessDenied() {
        return "Access Denied... You don't have permission.";
    }
}
