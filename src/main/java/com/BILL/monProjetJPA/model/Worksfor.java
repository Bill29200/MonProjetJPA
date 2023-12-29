package com.BILL.monProjetJPA.model;


import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity(name = "Worksfor")
@Table(name = "worksfor")

public class Worksfor {

    @EmbeddedId
    private WorksforId id;

    @ManyToOne
    @MapsId("employeeId")
    @JoinColumn(
            name = "employee_id",
            foreignKey = @ForeignKey(
                    name = "worksfor_employee_id_fk"
            )
    )
    private Employee employee;

    @ManyToOne
    @MapsId("projectId")
    @JoinColumn(
            name = "project_id",
            foreignKey = @ForeignKey(
                    name = "worksfor_project_id_fk"
            )
    )
    private Project project;

    @Column(
            name = "created_at",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime createdAt;


    public Worksfor(WorksforId id,
                     Employee employee,
                     Project project,
                     LocalDateTime createdAt) {
        this.id = id;
        this.employee = employee;
        this.project = project;
        this.createdAt = createdAt;
    }

    public Worksfor(Employee employee,
                     Project project,
                     LocalDateTime createdAt) {
        this.employee = employee;
        this.project = project;
        this.createdAt = createdAt;
    }

    public Worksfor() {
    }

    public WorksforId getId() {
        return id;
    }

    public void setId(WorksforId id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
