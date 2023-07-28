package userManagementSystemHospital.hospitalSystem.business.service.implementation;

import org.springframework.stereotype.Service;
import userManagementSystemHospital.hospitalSystem.business.service.PatientsService;
import userManagementSystemHospital.hospitalSystem.business.requests.CreatePatientsRequest;
import userManagementSystemHospital.hospitalSystem.business.responses.GetAllPatientsResponse;
import userManagementSystemHospital.hospitalSystem.repository.PatientRepository;
import userManagementSystemHospital.hospitalSystem.business.entity.Patient;

import java.util.ArrayList;
import java.util.List;
//patient serviceimpl
@Service
public class PatientServiceImpl implements PatientsService {
    private PatientRepository patientRepository;
    public PatientServiceImpl(){};

    public PatientServiceImpl(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }


    @Override
    public List<GetAllPatientsResponse> getAll() {
        List<Patient> patients = patientRepository.findAll();
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
        this.patientRepository.save(patient);
    }

    @Override
    public void delete(CreatePatientsRequest createPatientsRequest) {
        Patient patient = new Patient();
        patient.setName(createPatientsRequest.getName());
        this.patientRepository.delete(patient);
    }



}
