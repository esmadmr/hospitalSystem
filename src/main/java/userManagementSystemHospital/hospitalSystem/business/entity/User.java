package userManagementSystemHospital.hospitalSystem.business.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import userManagementSystemHospital.hospitalSystem.business.entity.role.RoleType;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//users
@Entity(name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //users bir entity ve çoğul olmak zorunda
    private String name;
    private String surname;
    private String username;
    private String password;
    private String age;
    private String email;
    private boolean enabled;
    private Date registerDate;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }


//    @ManyToOne
//    @JoinTable(
//            name = "roleType",
//            joinColumns = @JoinColumn(
//                    name = "id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(
//                    name = "name", referencedColumnName = "roleType"))
//    private Collection<RoleType> roles;
//
//    @ManyToOne
//    @JoinColumn(name = "name")
//    private Department department;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(  name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_type_id"))
    private Set<RoleType> roles = new HashSet<>();

//    @JsonIgnore
//    @OneToMany(mappedBy="user",fetch=FetchType.EAGER)
//    private Set<Authority> authorities;
}
