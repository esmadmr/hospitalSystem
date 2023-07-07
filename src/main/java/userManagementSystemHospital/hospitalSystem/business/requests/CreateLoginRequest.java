package userManagementSystemHospital.hospitalSystem.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateLoginRequest {

    private String fullName;
    private String email;
    private String password;

}
