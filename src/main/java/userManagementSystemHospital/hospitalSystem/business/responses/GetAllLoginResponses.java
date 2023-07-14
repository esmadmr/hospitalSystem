package userManagementSystemHospital.hospitalSystem.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllLoginResponses {
    private String name;
    private String surname;
    private String username;
    private String password;
    private int age;
    private String registerDate;

    public void setId(int id) {
    }
}
