package com.BILL.monProjetJPA.repository;

import com.BILL.monProjetJPA.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository <Employee,Long> {
    Employee findByEmail(String email);
}
