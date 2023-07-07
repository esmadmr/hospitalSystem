package userManagementSystemHospital.hospitalSystem.business.entity;

import lombok.Data;

@Data
public class Secretary {
    private String secretary;
    private String fullName;
    private String email;
    private String password;

    public void setUserDetails(UserDetail userDetail) {
    }
}
