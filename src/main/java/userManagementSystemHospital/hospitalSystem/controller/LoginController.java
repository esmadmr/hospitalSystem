package userManagementSystemHospital.hospitalSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import userManagementSystemHospital.hospitalSystem.business.entity.dto.UserDTO;
import userManagementSystemHospital.hospitalSystem.business.service.implementation.AuthenticationServiceImpl;
import userManagementSystemHospital.hospitalSystem.business.service.implementation.UserServiceImpl;
import userManagementSystemHospital.hospitalSystem.business.requests.CreateLoginRequest;
//log controller
@RestController
public class LoginController {
    private UserServiceImpl userServiceImpl;
    private AuthenticationServiceImpl authenticationServiceImpl;

    @Autowired
    public LoginController(UserServiceImpl userServiceImpl, AuthenticationServiceImpl authenticationServiceImpl) {
        this.userServiceImpl = userServiceImpl;
        this.authenticationServiceImpl = authenticationServiceImpl;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDTO userDTO) {
        if (authenticationServiceImpl.authenticateUser(userDTO)) {
            // Kullanıcı kimlik doğrulama doğru

            return ResponseEntity.ok("Giriş başarılı");
        } else {

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Kimlik doğrulama başarısız");
        }
    }

}
