package userManagementSystemHospital.hospitalSystem.business.entity.role;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="RoleType")
public class RoleType {
    @Id
    @Column(name = "id")
    private int id;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;


}
