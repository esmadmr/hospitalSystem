package userManagementSystemHospital.hospitalSystem.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.security.config.Customizer.withDefaults;

//yetkilendirme kurallarını belirlediğim class

@Configuration
@EnableWebSecurity
@EnableJpaRepositories(basePackages = "userManagementSystemHospital.hospitalSystem.repository")
public class SecurityConfig extends WebSecurityConfiguration {

    @Bean
    //public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        //return http
          //      .authorizeHttpRequests((requests) -> requests
            //            .requestMatchers("/**").permitAll()).build();

        protected void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeHttpRequests((authz) -> authz
                            .anyRequest().authenticated()
                    )
                    .httpBasic(withDefaults());
        }

        //return http.build();

//        return http.formLogin(form -> form
//                        .loginPage("/login")
//                        .permitAll()).build();

//                .authorizeHttpRequests(requests -> requests
//                        .requestMatchers("/").hasAnyRole("Secretary", "Doctor", "Nurse","Manager")
//                        .anyRequest().authenticated()
//                )
//                .formLogin(form -> form
//                        .loginPage("/login")
//                        .permitAll()
//                )
//                .logout(logout -> logout
//                        .permitAll());

//        return http.build();
   // }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
