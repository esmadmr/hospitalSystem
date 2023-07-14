package userManagementSystemHospital.hospitalSystem.business.entity.dto;

import lombok.Data;

import java.io.Serializable;
//userdto
@Data
public class UserDTO implements Serializable {
    private String userName;
    private String password;

    public String getUsername() {
        return userName;
    }
}
