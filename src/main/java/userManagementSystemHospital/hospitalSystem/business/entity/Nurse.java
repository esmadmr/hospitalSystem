package userManagementSystemHospital.hospitalSystem.business.entity;

import lombok.Data;
import userManagementSystemHospital.hospitalSystem.business.entity.role.RoleType;

@Data
public class Nurse {
    private String nurse;
    private String fullName;
    private String email;
    private String password;
    private RoleType roleType;

    public void setUserDetails(UserDetail userDetail) {
    }
}
