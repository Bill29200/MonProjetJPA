package com.BILL.monProjetJPA.model;


import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.*;


@Embeddable
public class WorksforId implements Serializable {

    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "project_id")
    private Long projectId;

    public WorksforId(Long employeeId, Long projectId) {
        this.employeeId = employeeId;
        this.projectId = projectId;
    }

    public WorksforId() {
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorksforId that = (WorksforId) o;
        return Objects.equals(employeeId, that.employeeId) && Objects.equals(projectId, that.projectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, projectId);
    }
}
