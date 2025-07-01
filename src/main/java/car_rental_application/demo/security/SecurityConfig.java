package car_rental_application.demo.security;

import car_rental_application.demo.fliter.CustomAuthenticationFilter;
import car_rental_application.demo.fliter.CustomAuthorizationFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final long expirationTime;
    private final String secretKey;

    public SecurityConfig(UserDetailsService userDetailsService,
                          PasswordEncoder passwordEncoder,
                          @Value("${jwt.expirationTime}") long expirationTime,
                          @Value("${jwt.secretKey}") String secretKey) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
        this.expirationTime = expirationTime;
        this.secretKey = secretKey;
    }

    private static final String[] AUTH_WHITELIST = {
            "**/swagger-resources/**",
            "/swagger-ui.html",
            "/v2/api-docs",
            "/webjars/**"
    };


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }




    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Create custom authentication filter
        CustomAuthenticationFilter customAuthFilter = new CustomAuthenticationFilter(
                authenticationManagerBean(),
                expirationTime,
                secretKey
        );
        customAuthFilter.setFilterProcessesUrl("/api/auth/login"); // Explicit login URL

        http.csrf().disable();
        http.cors(); // Enable CORS
        http.sessionManagement().sessionCreationPolicy(STATELESS);

        // Public endpoints
        http.authorizeRequests()
                .antMatchers(
                        "/api/auth/login",
                        "/api/auth/register",  // Changed from /registration/**
                        "/api/auth/registration",
                        "/api/auth/refresh-token"
                ).permitAll()
                .antMatchers(AUTH_WHITELIST).permitAll();

        // Role-based authorization
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/users/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_MANAGER")
                .antMatchers(HttpMethod.POST, "/api/users/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_MANAGER")
                .antMatchers(HttpMethod.PUT, "/api/users/**").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/users/**").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers("/api/cars/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_MANAGER")
                .antMatchers("/api/orders/**").authenticated()
                .antMatchers("/api/payment/**", "/api/delivery/**").hasAnyAuthority("ROLE_USER")
                .anyRequest().authenticated();

        // Add filters
        http.addFilter(customAuthFilter);
        http.addFilterBefore(
                new CustomAuthorizationFilter(secretKey),
                UsernamePasswordAuthenticationFilter.class
        );
    }


    @Bean
    public BasicAuthenticationEntryPoint swaggerAuthenticationEntryPoint() {
        BasicAuthenticationEntryPoint entryPoint = new BasicAuthenticationEntryPoint();
        entryPoint.setRealmName("Swagger Realm");
        return entryPoint;
    }


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}