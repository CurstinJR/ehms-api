package za.ac.cput.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import za.ac.cput.security.user.CustomUserDetailsService;

/**
 * @Author Curstin Rose - 220275408
 * WebSecurityConfig.java
 * 2022/10/01
 */
@EnableWebSecurity
@EnableConfigurationProperties({WebConfigProperties.class})
public class WebSecurityConfig {

    private final BCryptPasswordEncoder passwordEncoder;
    private final CustomUserDetailsService customUserDetailsService;
    private final WebConfigProperties webConfigProperties;

    @Autowired
    public WebSecurityConfig(BCryptPasswordEncoder passwordEncoder,
                             CustomUserDetailsService customUserDetailsService,
                             WebConfigProperties webConfigProperties) {
        this.passwordEncoder = passwordEncoder;
        this.customUserDetailsService = customUserDetailsService;
        this.webConfigProperties = webConfigProperties;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .cors()
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/auth/**").permitAll()
                .antMatchers("/api/patients/**").hasAnyAuthority("ADMIN", "DOCTOR", "NURSE", "RECEPTIONIST")
                .antMatchers("/api/bills/**").hasAnyAuthority("ADMIN", "DOCTOR", "RECEPTIONIST")
                .antMatchers("/api/vitals/**").hasAnyAuthority("ADMIN", "DOCTOR", "NURSE")
                .antMatchers("/api/appointments/**").hasAnyAuthority("ADMIN", "DOCTOR", "RECEPTIONIST")
                .and()
                .httpBasic();
        return httpSecurity.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
                .authenticationProvider(daoAuthenticationProvider())
                .build();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        daoAuthenticationProvider.setUserDetailsService(customUserDetailsService);
        return daoAuthenticationProvider;
    }

    @Bean
    public WebMvcConfigurer corsMappingConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                WebConfigProperties.Cors cors = webConfigProperties.getCors();
                registry.addMapping("/**")
                        .allowedOrigins(cors.allowedOrigins())
                        .allowedMethods(cors.allowedMethods());
            }
        };
    }
}
