package userManagementSystemHospital.hospitalSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import userManagementSystemHospital.hospitalSystem.business.entity.Patient;
//
public interface PatientRepository extends JpaRepository<Patient,Integer> {

}
