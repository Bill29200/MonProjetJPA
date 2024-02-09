package com.BILL.monProjetJPA.repository;

import com.BILL.monProjetJPA.model.Mission;
import com.BILL.monProjetJPA.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository <Project, Long> {
    Project findByName(String name);
}
