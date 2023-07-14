package userManagementSystemHospital.hospitalSystem.controller;


import org.springframework.web.bind.annotation.*;
import userManagementSystemHospital.hospitalSystem.business.service.PatientsService;
import userManagementSystemHospital.hospitalSystem.business.requests.CreatePatientsRequest;
import userManagementSystemHospital.hospitalSystem.business.responses.GetAllPatientsResponse;
import java.util.List;
//patient controller
@RestController
@RequestMapping("/api/patients")
public class PatientController {
    private PatientsService patientsService;
    public PatientController(PatientsService patientsService) {
        this.patientsService = patientsService;
    }

    @GetMapping("/getall")
    public List<GetAllPatientsResponse> getAll(){
        return patientsService.getAll();
    }

    @PostMapping("/add")
    public void add(CreatePatientsRequest createPatientsRequest){
        this.patientsService.add(createPatientsRequest);
    }
    @DeleteMapping("/delete")
    public void delete(CreatePatientsRequest createPatientsRequest){
        this.patientsService.delete(createPatientsRequest);
    }

}
