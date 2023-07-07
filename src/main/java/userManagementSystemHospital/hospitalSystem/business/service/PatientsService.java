package userManagementSystemHospital.hospitalSystem.business.service;

import userManagementSystemHospital.hospitalSystem.business.requests.CreatePatientsRequest;
import userManagementSystemHospital.hospitalSystem.business.responses.GetAllPatientsResponse;

import java.util.List;

public interface PatientsService {
    List<GetAllPatientsResponse> getAll();
    void add(CreatePatientsRequest createPatientsRequest);
    void delete(CreatePatientsRequest createPatientsRequest);

}
