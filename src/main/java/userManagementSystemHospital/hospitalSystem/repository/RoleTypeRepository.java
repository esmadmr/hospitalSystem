package userManagementSystemHospital.hospitalSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import userManagementSystemHospital.hospitalSystem.business.entity.role.ERole;
import userManagementSystemHospital.hospitalSystem.business.entity.role.RoleType;

import java.util.Optional;

@Repository
public interface RoleTypeRepository extends JpaRepository<RoleType, Long> {
    Optional<RoleType> findByName(ERole name);
}
