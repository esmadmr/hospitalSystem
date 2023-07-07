package userManagementSystemHospital.hospitalSystem.business.entity.role;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="RoleType")
public class RoleType {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "roleType")
    private String roleType;
    @Column(name = "userRole")
    private String userRole;



}
