package userManagementSystemHospital.hospitalSystem.business.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collection;
//department
@Table(name = "department")
@Data
@AllArgsConstructor
@Entity
public class Department {
    //department
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name="departmentType")
    private String departmentType;

    public Department(){

    }
//    @OneToMany(mappedBy = "policlinic")
//    private Collection<User> users;

}
