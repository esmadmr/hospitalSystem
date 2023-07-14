package userManagementSystemHospital.hospitalSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import userManagementSystemHospital.hospitalSystem.business.entity.dto.UserDTO;
import userManagementSystemHospital.hospitalSystem.business.requests.CreateLoginRequest;
import userManagementSystemHospital.hospitalSystem.business.responses.GetAllLoginResponses;
import userManagementSystemHospital.hospitalSystem.business.service.PatientsService;
import userManagementSystemHospital.hospitalSystem.business.service.UserService;
import userManagementSystemHospital.hospitalSystem.business.service.implementation.AuthenticationServiceImpl;
import userManagementSystemHospital.hospitalSystem.business.service.implementation.UserServiceImpl;

import java.util.List;
//usercontroller
@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;
    public UserController(PatientsService patientsService) {
        this.userService = userService;
    }
    private UserServiceImpl userServiceImpl;
    private AuthenticationServiceImpl authenticationServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl, AuthenticationServiceImpl authenticationServiceImpl) {
        this.userServiceImpl = userServiceImpl;
        this.authenticationServiceImpl = authenticationServiceImpl;
    }

    @PostMapping("/users/login")
    public ResponseEntity<String> login(@RequestBody UserDTO userDTO) {
        if (authenticationServiceImpl.authenticateUser(userDTO)) {
            // Kullanıcı kimlik doğrulama doğru

            return ResponseEntity.ok("Giriş başarılı");
        } else {

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Kimlik doğrulama başarısız");
        }
    }

    @GetMapping("/getall")
    public List<GetAllLoginResponses> getAll(){
        return userService.getAll();
    }
    @PostMapping("/addUser")
    public void addUser(CreateLoginRequest createLoginRequest){
        this.userService.addUser(createLoginRequest);
    }

}
