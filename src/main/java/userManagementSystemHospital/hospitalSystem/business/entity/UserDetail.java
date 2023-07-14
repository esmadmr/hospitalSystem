package userManagementSystemHospital.hospitalSystem.business.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import userManagementSystemHospital.hospitalSystem.business.entity.role.UserRole;
import userManagementSystemHospital.hospitalSystem.repository.UserRepository;

import java.util.*;
//userDetails
@Data
public class UserDetail implements UserDetails {
    private int id;
    private String userName;
    private String password;

    public Collection<? extends GrantedAuthority> getAuthorities(Set<UserRole> roles) {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (UserRole role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getUserRole()));
        }

        return authorities;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getAuthorities();
    }

    public String getUsername() {
            return userName;
        }

    @Override
    public String getPassword() {
        return password;
    }

        @Autowired
        private UserRepository userRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        return null;

//        return new User(
//                user.getUserName(), user.getPassword(), getAuthorities((Collection<RoleType>) user.getRoles()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }


}




