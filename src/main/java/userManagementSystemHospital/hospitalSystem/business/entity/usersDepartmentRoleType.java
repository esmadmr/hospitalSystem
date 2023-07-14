package userManagementSystemHospital.hospitalSystem.business.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import org.hibernate.annotations.NotFound;
import userManagementSystemHospital.hospitalSystem.business.entity.role.RoleType;

import java.util.List;

@Entity

public class usersDepartmentRoleType {
    @ManyToMany
            //@JoinTable(
              //      name = "users",
                //    joinColumns = @JoinColumn(name = "departmentType")
            //)
    User users;
    @NotFound


    @ManyToMany
    Policlinic policlinic;

    @ManyToMany
    RoleType roleType;
}
