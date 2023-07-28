package userManagementSystemHospital.hospitalSystem.business.requests;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

//userdto
@Data
public class UserDTO implements Serializable {
    private String name;
    private String surname;
    private String username;
    private String password;
    private String email;
    private Set<String> role;
}
