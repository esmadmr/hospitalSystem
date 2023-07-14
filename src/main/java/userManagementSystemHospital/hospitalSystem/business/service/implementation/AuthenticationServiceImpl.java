package userManagementSystemHospital.hospitalSystem.business.service.implementation;

import org.springframework.stereotype.Service;
import userManagementSystemHospital.hospitalSystem.business.entity.User;
import userManagementSystemHospital.hospitalSystem.business.entity.dto.UserDTO;
import userManagementSystemHospital.hospitalSystem.business.service.AuthenticationService;
import userManagementSystemHospital.hospitalSystem.repository.UserRepository;

//authentication serviceimpl
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
//kimlik doğrulama servisi
    private UserRepository userRepository;

    public AuthenticationServiceImpl(){};

    public AuthenticationServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public boolean authenticateUser(UserDTO userDTO) {
        User user = userRepository.findByUsername(userDTO.getUsername());
        if (user != null && user.getPassword().equals(userDTO.getPassword())) {
            return true; // Kimlik doğrulama başarılı
        }
        return false; // Kimlik doğrulama başarısız
    }
}

