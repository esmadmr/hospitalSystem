package userManagementSystemHospital.hospitalSystem.business.service;


import userManagementSystemHospital.hospitalSystem.business.entity.User;
import userManagementSystemHospital.hospitalSystem.business.requests.CreatePatientsRequest;
import userManagementSystemHospital.hospitalSystem.business.responses.GetAllLoginResponses;
import userManagementSystemHospital.hospitalSystem.business.responses.GetAllPatientsResponse;

import java.util.List;

public interface UserService {
    void register();
    void login();
    void addUser();

    User loadUserByUsername(String userName);

}