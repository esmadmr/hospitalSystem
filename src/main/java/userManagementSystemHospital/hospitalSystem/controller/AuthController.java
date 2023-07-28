package userManagementSystemHospital.hospitalSystem.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import userManagementSystemHospital.hospitalSystem.business.entity.User;
import userManagementSystemHospital.hospitalSystem.business.entity.UserDetail;
import userManagementSystemHospital.hospitalSystem.business.responses.JwtResponse;
import userManagementSystemHospital.hospitalSystem.business.requests.UserDTO;
import userManagementSystemHospital.hospitalSystem.business.entity.role.ERole;
import userManagementSystemHospital.hospitalSystem.business.entity.role.RoleType;
import userManagementSystemHospital.hospitalSystem.business.responses.MessageResponse;
import userManagementSystemHospital.hospitalSystem.repository.RoleTypeRepository;
import userManagementSystemHospital.hospitalSystem.repository.UserRepository;
import userManagementSystemHospital.hospitalSystem.security.jwt.JwtUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleTypeRepository roleTypeRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody UserDTO userDTO) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userDTO.getUsername(), userDTO.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtil.generateJwtToken(authentication);

        UserDetail userDetails = (UserDetail) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO) {
        if (userRepository.existsByUsername(userDTO.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Kullanıcı zaten tanımlı!"));
        }

        if (userRepository.existsByEmail(userDTO.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Girmiş olduğunuz mail kullanımda!"));
        }

        // Create new user's account
        User user = new User(userDTO.getUsername(),
                userDTO.getEmail(),
                encoder.encode(userDTO.getPassword()));

        Set<String> strRoles = userDTO.getRole();
        Set<RoleType> roles = new HashSet<>();

        if (strRoles == null) {
            RoleType userRole = roleTypeRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Rol bulunamadı."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin" -> {
                        RoleType adminRole = roleTypeRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Rol bulunamadı."));
                        roles.add(adminRole);
                    }
                    case "doctor" -> {
                        RoleType doctorRole = roleTypeRepository.findByName(ERole.ROLE_DOCTOR)
                                .orElseThrow(() -> new RuntimeException("Rol bulunamadı."));
                        roles.add(doctorRole);
                    }
                    case "patient" -> {
                        RoleType patientRole = roleTypeRepository.findByName(ERole.ROLE_PATIENT)
                                .orElseThrow(() -> new RuntimeException("Role bulunamadı."));
                        roles.add(patientRole);
                    }
                    default -> {
                        RoleType userRole = roleTypeRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Role bulunamadı."));
                        roles.add(userRole);
                    }
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("Kullanıcı başarıyla kaydedildi.!"));
    }
}
