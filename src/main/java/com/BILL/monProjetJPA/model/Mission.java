package com.BILL.monProjetJPA.model;



import jakarta.persistence.*;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.SEQUENCE;
//................................................................................................
@Entity(name = "Mission")
@Table(
        name = "mission",
        uniqueConstraints = {
        @UniqueConstraint(name = "mission_name_unique", columnNames = "name")
                           }
       )
//................................................................................................
public class Mission {

    @Id
    @SequenceGenerator(
            name = "mission_sequence",
            sequenceName = "mission_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "mission_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "created_at",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime createdAt;

    @Column(
            name = "mission_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String missionName;
    //................................................................................................
    @ManyToOne
    @JoinColumn(
            name = "employee_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "employee_mission_fk"
            )
    )

    private Employee employee;
    //................................................................................................
    // Constructors
    //................................................................................................
    public Mission() {
    }

    public Mission(String missionName,
                   LocalDateTime createdAt) {
        this.createdAt = createdAt;
        this.missionName = missionName;
    }
    //................................................................................................
    // Getters & Setters
    //................................................................................................
    public Long getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Employee getEmployee() {
        return employee;
    }

    public String getMissionName() {
        return missionName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }
    //................................................................................................
    @Override
    public String toString() {
        return "Mission{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", missionName='" + missionName + '\'' +
                ", employee=" + employee +
                '}';
    }
}
