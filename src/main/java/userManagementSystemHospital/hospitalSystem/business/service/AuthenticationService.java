package userManagementSystemHospital.hospitalSystem.business.service;

import userManagementSystemHospital.hospitalSystem.business.entity.dto.UserDTO;
//authservice
public interface AuthenticationService {
    public boolean authenticateUser(UserDTO userDTO);
}
