package userManagementSystemHospital.hospitalSystem.business.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllPatientsResponse {
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
