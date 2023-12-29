package com.BILL.monProjetJPA.model;


import jakarta.persistence.*;
import static jakarta.persistence.GenerationType.SEQUENCE;
import java.util.ArrayList;
import java.util.List;

//................................................................................................
@Entity(name = "Employee")
@Table(
        name = "employee",
        uniqueConstraints = {
                @UniqueConstraint(name = "employee_email_unique", columnNames = "email")
        }
)
//................................................................................................
public class Employee {
    @Id
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "employee_sequence"
    )
    @Column(
            name = "id"
    )
    private Long id;

    @Column(
            name = "first_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String firstName;

    @Column(
            name = "last_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String lastName;

    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;

    @Column(
            name = "age",
            nullable = false

    )
    private Integer age;

    @Column(
            name = "position",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String position;
    //................................................................................................
    @OneToOne(
            mappedBy = "employee",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}

    )
    private EmployeeIdBadge employeeIdBadge;

    @OneToMany(
            mappedBy = "employee",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<Mission> missions = new ArrayList<>();

    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            mappedBy = "employee"
    )
    private List<Worksfor> worksfors = new ArrayList<>();
    //................................................................................................
    // constructors
    //................................................................................................
    public Employee(String firstName,
                   String lastName,
                   String email,
                   Integer age,
                   String position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.position= position;
    }

    public Employee() {

    }
    //................................................................................................
    // Getters & Setters
    //................................................................................................
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPosition()
    {
        return this.position;
    }

    public void setPosition(String position)
    {
        this.position = position;
    }
    //................................................................................................

    public void addMission(Mission mission) {
        if (!this.missions.contains(mission)) {
            this.missions.add(mission);
            mission.setEmployee(this);
        }
    }

    public void removeMission(Mission mission) {
        if (this.missions.contains(mission)) {
            this.missions.remove(mission);
            mission.setEmployee(null);
        }
    }

    public void setEmployeeIdCard(EmployeeIdBadge employeeIdBadge) {
        this.employeeIdBadge = employeeIdBadge;
    }

    public List<Mission> getMissions() {
        return missions;
    }

    public List<Worksfor> getWorksfors() {
        return worksfors;
    }

    public void addWorksfor(Worksfor worksfor) {
        if (!worksfors.contains(worksfor)) {
            worksfors.add(worksfor);
        }
    }

    public void removeWorksfor(Worksfor worksfor) {
        worksfors.remove(worksfor);
    }
    //................................................................................................
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +'\'' +
                ", position=" + position +
                '}';
    }
}
