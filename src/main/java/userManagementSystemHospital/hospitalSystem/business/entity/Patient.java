package userManagementSystemHospital.hospitalSystem.business.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
//localhost:8080/api/patients/getall
//patient
@Table(name = "patient")
@Data
@AllArgsConstructor
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "nationalId")
    private long nationalId;
    @Column(name = "fathersName")
    private String fathersName;
    @Column(name = "age")
    private int age;
    @Column(name = "cellphoneNumber")
    private long cellphoneNumber;
    @Column(name = "adress")
    private String adress;
    @Column(name = "gender")
    private String gender;
    @Column(name = "bloodgroup")
    private String bloodGroup;
    @Column(name="appoinmentDate")
    private String appoinmentDate;
    @Column(name = "doctor")
    private String doctor;
    @Column(name="policlinic")
    private String policlinic;

    public Patient(){

    }


}
