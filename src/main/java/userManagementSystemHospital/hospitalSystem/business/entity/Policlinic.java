package userManagementSystemHospital.hospitalSystem.business.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
//pol
@Table(name = "Policlinic")
@Data
@AllArgsConstructor
@Entity
public class Policlinic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name="policlinicName")
    private String policlinicName;

    public Policlinic(){

    }

}