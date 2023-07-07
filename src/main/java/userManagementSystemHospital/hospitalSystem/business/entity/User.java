package userManagementSystemHospital.hospitalSystem.business.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import userManagementSystemHospital.hospitalSystem.business.entity.role.RoleType;

import java.util.Collection;

@Entity(name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //users bir entity ve çoğul olmak zorunda
    private String name;
    private String surname;
    private String username;
    private String password;
    private String age;
    private boolean enabled;
    @DateTimeFormat
    private String registerDate;

//    @ManyToMany
//    @JoinTable(
//            name = "userRole",
//            joinColumns = @JoinColumn(
//                    name = "id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(
//                    name = "userRole", referencedColumnName = "userRole"))
//    private Collection<RoleType> roles;


}
