package userManagementSystemHospital.hospitalSystem.business.requests;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//patientrequest
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePatientsRequest {
    private int id;
    private String name;
    private String surname;
    private long nationalId;
    private String fathersName;
    private int age;
    private long cellphoneNumber;
    private String adress;
    private String gender;
    private String bloodGroup;
    private String appoinmentDate;
    private String doctor;
    private String policlinic;
}
