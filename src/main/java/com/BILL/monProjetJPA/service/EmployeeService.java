package com.BILL.monProjetJPA.service;

import com.BILL.monProjetJPA.model.Employee;
import com.BILL.monProjetJPA.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    //...................................................................
    //                              Create
    //...................................................................
    public Employee create (Employee employee)
    {
        return employeeRepository.save(employee);
    }
    //...................................................................
    //                              Read
    //...................................................................
    public List<Employee> getAll()
    {
        return employeeRepository.findAll();
    }

    public Employee getByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }
    public Long count() {
        return employeeRepository.count();
    }
    //...................................................................
    //                              Update
    //...................................................................
    public Employee update(Employee employee) {
        return employeeRepository.save(employee);
    }
    //...................................................................
    //                              Delete
    //...................................................................
    public void delete(Employee employee)
    {
        employeeRepository.delete(employee);
    }

}
