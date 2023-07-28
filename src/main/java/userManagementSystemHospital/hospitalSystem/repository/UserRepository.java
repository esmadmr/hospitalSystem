package userManagementSystemHospital.hospitalSystem.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import userManagementSystemHospital.hospitalSystem.business.entity.User;

import java.util.Optional;

//
@Repository
public interface UserRepository extends  JpaRepository<User,Long>{
    Optional<User> findByUsername(String userName);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
