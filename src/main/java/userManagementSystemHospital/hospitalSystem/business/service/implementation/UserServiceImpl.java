package userManagementSystemHospital.hospitalSystem.business.service.implementation;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import userManagementSystemHospital.hospitalSystem.business.entity.Patient;
import userManagementSystemHospital.hospitalSystem.business.entity.User;
import userManagementSystemHospital.hospitalSystem.business.requests.CreateLoginRequest;
import userManagementSystemHospital.hospitalSystem.business.responses.GetAllLoginResponses;
import userManagementSystemHospital.hospitalSystem.business.responses.GetAllPatientsResponse;
import userManagementSystemHospital.hospitalSystem.business.service.UserService;
import userManagementSystemHospital.hospitalSystem.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

//user serviceimpl
@Service
@Data
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void register() {

    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    public User findOne(Integer userId) {
        return userRepository.findById((long) userId).orElse(null);
    }

    public void logUserDetails(String name, String surname, String password) {
        // Burada loglama işlemleri gerçekleştirilir
        System.out.println("Kullanıcı girişi loglandı:");
        System.out.println("Ad: " + name);
        System.out.println("Soyad: " + surname);
        System.out.println("Şifre: " + password);
    }
    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        // Kullanıcıyı veritabanından bul ve döndürt
        User user = userRepository.findByUsername(username).orElse(null);
        if (user == null) {
            throw new UsernameNotFoundException("Kullanıcı bulunamadı: " + username);
        }
        return user;
    }

    @Override
    public List<GetAllLoginResponses> getAll() {
        GetAllLoginResponses getAllLoginResponses = new GetAllLoginResponses();
        getAllLoginResponses.setName("Ramazan");
        return List.of(getAllLoginResponses);
    }

    @Override
    public void register(CreateLoginRequest createLoginRequest) {

    }

    @Override
    public void login(CreateLoginRequest createLoginRequest) {

    }

    @Override
    public void addUser(CreateLoginRequest createLoginRequest) {

    }
}

