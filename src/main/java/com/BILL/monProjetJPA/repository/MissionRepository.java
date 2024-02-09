package com.BILL.monProjetJPA.repository;

import com.BILL.monProjetJPA.model.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository <Mission, Long> {

    Mission findByMissionName(String name);
}
