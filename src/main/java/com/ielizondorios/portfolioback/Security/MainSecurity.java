
package com.ielizondorios.portfolioback.Security;


import com.ielizondorios.portfolioback.Security.Service.UserDetailsImpl;
import com.ielizondorios.portfolioback.Security.jwt.JwtEntryPoint;
import com.ielizondorios.portfolioback.Security.jwt.JwtTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MainSecurity extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsImpl userDetailsServiceImpl;
    @Autowired
    JwtEntryPoint jwtEntryPoint;
    
    @Bean
    public JwtTokenFilter jwtTokenFilter(){
        return new JwtTokenFilter(); 
    }
    
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
}
