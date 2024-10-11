package com.example.CollegeDirectoryManagementSystem.directory.config;

////import org.springframework.context.annotation.Bean;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
////import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
////import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
////import org.springframework.security.crypto.password.PasswordEncoder;
////
////@EnableWebSecurity
////public class SecurityConfig extends WebSecurityConfigurerAdapter {
////	@Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http.csrf().disable()
////            .authorizeRequests()
////            .requestMatchers("/admin/**").hasRole("ADMINISTRATOR")
////            .requestMatchers("/faculty/**").hasRole("FACULTY_MEMBER")
////            .requestMatchers("/student/**").hasRole("STUDENT")
////            .anyRequest().authenticated()
////            .and()
////            .formLogin()
////            .loginPage("/login")
////            .defaultSuccessUrl("/dashboard", true)  // Redirect to dashboard after login
////            .and()
////            .logout().permitAll();
////    }
////
////    @Bean
////    public PasswordEncoder passwordEncoder() {
////        return new BCryptPasswordEncoder();
////    }
////}
//
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////import org.springframework.security.core.userdetails.UserDetailsService;
////import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
////import org.springframework.security.crypto.password.PasswordEncoder;
////import org.springframework.security.web.SecurityFilterChain;
////import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
////
////@SuppressWarnings("unused")
////@Configuration
////public class SecurityConfig {
////
////    @Bean
////    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////        http
////            .authorizeHttpRequests((requests) -> requests
////                .requestMatchers("/public/**").permitAll()  // Allow access to public endpoints
////                .anyRequest().authenticated()           // All other requests require authentication
////            )
////            .formLogin((form) -> form
////                .loginPage("/login")                   // Custom login page
////                .permitAll()
////            )
////            .logout((logout) -> logout.permitAll());
////
////        return http.build();
////    }
////
////    @Bean
////    public PasswordEncoder passwordEncoder() {
////        return new BCryptPasswordEncoder();           // Use BCrypt for password encoding
////    }
////
////    @Bean
////    public UserDetailsService userDetailsService() {
////        // Define your custom UserDetailsService or use the default in-memory one
////        return null; // You would typically return your user details service implementation here
////    }
////}
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .authorizeHttpRequests(authorizeRequests ->
//                authorizeRequests
//                    .requestMatchers("/admin/**").hasRole("ADMIN")
//                    .requestMatchers("/faculty/**").hasRole("FACULTY")
//                    .requestMatchers("/student/**").hasRole("STUDENT")
//                    .requestMatchers("/", "/home", "/public/**").permitAll()
//                    .anyRequest().authenticated()
//            )
//            .formLogin(formLogin ->
//                formLogin
//                    .loginPage("/login")
//                    .defaultSuccessUrl("/dashboard", true)
//                    .permitAll()
//            )
//            .logout(logout ->
//                logout
//                    .permitAll()
//            );
//
//        return http.build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user")
            .password(passwordEncoder().encode("password"))
            .roles("USER")
            .build());
        return manager;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/login").permitAll() // Allow access to the login page
                .anyRequest().authenticated() // All other URLs require authentication
            )
            .formLogin(form -> form
                .loginPage("/login") // Custom login page URL
                .defaultSuccessUrl("/home", true) // Redirect after successful login
                .permitAll()
            )
            .logout(logout -> logout
                .permitAll()
            );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Password encoder
    }
}


