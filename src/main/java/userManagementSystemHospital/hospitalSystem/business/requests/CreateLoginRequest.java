package userManagementSystemHospital.hospitalSystem.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//loginrequest
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateLoginRequest {

    private String name;
    private String surname;
    private String username;
    private String password;
    private int age;
    private String registerDate;

}
