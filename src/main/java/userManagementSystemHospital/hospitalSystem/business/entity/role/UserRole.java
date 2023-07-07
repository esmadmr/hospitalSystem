package userManagementSystemHospital.hospitalSystem.business.entity.role;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "userRole")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "userRole")
    private String userRole;
}


// authorities.add(new void SimpleGrantedAuthority(role.getName());


