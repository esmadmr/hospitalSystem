package userManagementSystemHospital.hospitalSystem.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import userManagementSystemHospital.hospitalSystem.business.entity.User;
//
@Repository
public interface UserRepository extends  JpaRepository<User,String>{
    User findByUsername(String userName);

}
