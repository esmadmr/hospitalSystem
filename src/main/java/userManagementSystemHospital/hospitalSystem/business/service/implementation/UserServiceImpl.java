package userManagementSystemHospital.hospitalSystem.business.service.implementation;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import userManagementSystemHospital.hospitalSystem.business.entity.User;
import userManagementSystemHospital.hospitalSystem.business.service.UserService;
import userManagementSystemHospital.hospitalSystem.repository.UserRepository;

import java.util.Scanner;

@Service
@Data
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void register() {

    }

    public void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ad ve soyad: ");
        String fullName = scanner.nextLine();
        System.out.print("E-posta: ");
        String email = scanner.nextLine();
        System.out.print("Şifre: ");
        String password = scanner.nextLine();

        // Loglama işlemi
        logUserDetails(fullName, email, password);
    }

    @Override
    public void addUser() {

    }

    public void logUserDetails(String fullName, String email, String password) {
        // Burada loglama işlemleri gerçekleştirilir
        System.out.println("Kullanıcı girişi loglandı:");
        System.out.println("Ad ve Soyad: " + fullName);
        System.out.println("E-posta: " + email);
        System.out.println("Şifre: " + password);
    }
    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        // Kullanıcıyı veritabanından bul ve döndürt
        User user = (User) userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Kullanıcı bulunamadı: " + username);
        }
        return user;
    }
}

