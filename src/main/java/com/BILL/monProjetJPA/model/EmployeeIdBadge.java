package com.BILL.monProjetJPA.model;


import jakarta.persistence.*;
import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "EmployeeIdBadge")
@Table(
        name = "employee_id_badge",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "employee_id_badge_number_unique",
                        columnNames = "badge_number"
                )
        }
)
public class EmployeeIdBadge {

    @Id
    @SequenceGenerator(
            name = "employee_badge_id_sequence",
            sequenceName = "employee_badge_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "employee_badge_id_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "badge_number",
            nullable = false,
            length = 15
    )
    private String badgeNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "employee_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "employee_id_fk"
            )
    )
    private Employee employee;

    public EmployeeIdBadge(String badgeNumber) {
        this.badgeNumber = badgeNumber;
    }

    public EmployeeIdBadge(String badgeNumber, Employee employee) {
        this.badgeNumber = badgeNumber;
        this.employee = employee;
    }

    public EmployeeIdBadge() {
    }

    public Long getId() {
        return id;
    }

    public String getBadgeNumber() {
        return badgeNumber;
    }

    @Override
    public String toString() {
        return "EmployeeIdBadge{" +
                "id=" + id +
                ", badgeNumber='" + badgeNumber + '\'' +
                ", employee=" + employee +
                '}';
    }

}
