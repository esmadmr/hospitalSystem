package userManagementSystemHospital.hospitalSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import userManagementSystemHospital.hospitalSystem.business.entity.User;
import userManagementSystemHospital.hospitalSystem.business.requests.CreateLoginRequest;
import userManagementSystemHospital.hospitalSystem.business.responses.GetAllLoginResponses;
import userManagementSystemHospital.hospitalSystem.business.service.UserService;
import userManagementSystemHospital.hospitalSystem.repository.UserRepository;

import java.util.List;

//user controller
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/showUser")
    public User showUser(@RequestBody Integer id){
        return userService.findOne(id);
    }

    @GetMapping("/getAll")
    public List<GetAllLoginResponses> getAll(){
        return userService.getAll();
    }
    @PostMapping("/addUser")
    public void addUser(CreateLoginRequest createLoginRequest){
        this.userService.addUser(createLoginRequest);
    }
}
