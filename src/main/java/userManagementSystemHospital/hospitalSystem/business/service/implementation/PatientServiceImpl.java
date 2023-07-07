package userManagementSystemHospital.hospitalSystem.business.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import userManagementSystemHospital.hospitalSystem.business.service.PatientsService;
import userManagementSystemHospital.hospitalSystem.business.requests.CreatePatientsRequest;
import userManagementSystemHospital.hospitalSystem.business.responses.GetAllPatientsResponse;
import userManagementSystemHospital.hospitalSystem.repository.PatientsRepository;
import userManagementSystemHospital.hospitalSystem.business.entity.Patient;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientsService {
    private PatientsRepository patientsRepository;
    public PatientServiceImpl(){};

    public PatientServiceImpl(PatientsRepository patientsRepository){
        this.patientsRepository = patientsRepository;
    }


    @Override
    public List<GetAllPatientsResponse> getAll() {
        List<Patient> patients = patientsRepository.findAll();
        List<GetAllPatientsResponse> patientsResponse = new ArrayList<GetAllPatientsResponse>();

         for (Patient patient : patients){
             GetAllPatientsResponse responseItem = new GetAllPatientsResponse();
             responseItem.setId(patient.getId());
             responseItem.setName(patient.getName());
             responseItem.setName(patient.getSurname());
             patientsResponse.add(responseItem);

         }
        return  patientsResponse;
    }



    @Override
    public void add(CreatePatientsRequest createPatientsRequest) {
        Patient patient = new Patient();
        patient.setName(createPatientsRequest.getName());
        this.patientsRepository.save(patient);
    }

    @Override
    public void delete(CreatePatientsRequest createPatientsRequest) {
        Patient patient = new Patient();
        patient.setName(createPatientsRequest.getName());
        this.patientsRepository.delete(patient);
    }



}
