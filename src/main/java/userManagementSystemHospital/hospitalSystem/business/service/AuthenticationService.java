package userManagementSystemHospital.hospitalSystem.business.service;

import userManagementSystemHospital.hospitalSystem.business.entity.dto.UserDTO;

public interface AuthenticationService {
    public boolean authenticateUser(UserDTO userDTO);
}
