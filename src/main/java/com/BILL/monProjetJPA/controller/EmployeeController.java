package com.BILL.monProjetJPA.controller;


import com.BILL.monProjetJPA.model.Employee;
import com.BILL.monProjetJPA.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //...................................................................
    //                              Create
    //...................................................................
    @PostMapping ("/add")
    public Employee create(@RequestBody Employee employee) {
        return employeeService.create(employee);
    }

    //...................................................................
    //                              Read
    //...................................................................
    @GetMapping(path = "/all")
    public ResponseEntity<List<Employee>> getAll() {
        List<Employee> employees = employeeService.getAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping(path ="/get/{email}")
    public Employee getEmployeeByEmail(@PathVariable("email") String email) {
        return employeeService.getByEmail(email);

    }

    @GetMapping("/count")
    public Long count() {
        return employeeService.count();
    }

    //...................................................................
    //                            Update
    //...................................................................
    @PutMapping("/update")
    public ResponseEntity<Employee> update(@RequestBody Employee employee) {
        Employee updateEmployee = employeeService.update(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    //......................................................................
    //                 Delete
    //......................................................................
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody Employee employee) {
        employeeService.delete(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    //......................................................................
}
//......................................................................



//    public Employee findEmployeeById(Long id) {
//        return employeeRepo.findEmployeeById(id)
//                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
//    }

