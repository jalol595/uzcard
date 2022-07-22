package com.example.uzcard.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SpringConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenFilter jwtTokenFilter;

    private static final String[] AUTH_WHITELIST = {
            "/v2/api-docs",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            "/v3/api-docs/**",
            "/swagger-ui/**",
            "/swagger-resources",
            "/swagger-resources/**"
    };

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Authentication
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
       /* auth.inMemoryAuthentication()
                .withUser("Ali").password("{bcrypt}$2a$10$V93CWoH3NxAPC7VzPd9ouuU8PWvZWYdoo94H3HOZ8kFSkBAvYssEe").roles("ADMIN")
                .and()
                .withUser("Vali").password("{noop}valish123").roles("PROFILE");*/
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Authorization
        http.authorizeRequests()
                .antMatchers(AUTH_WHITELIST).permitAll()
                .antMatchers("/auth", "/auth/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
        http.cors().disable().csrf().disable();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        /*return NoOpPasswordEncoder.getInstance();*/
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
