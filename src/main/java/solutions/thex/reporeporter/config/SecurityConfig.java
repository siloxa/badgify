package solutions.thex.reporeporter.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * Implementation of
 * {@link org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter}
 * for application security configurations.
 *
 * @author Soroush Shemshadi
 * @version 1.0.0
 * @since 1.0.0
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UnauthorizedEntryPoint unauthorizedEntryPoint;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http//
                .authorizeRequests()
                .antMatchers("/favicon.ico", "/icons/flags/**", "/api/**").permitAll()//
                .antMatchers("/admin/**").hasAnyAuthority("ADMIN")//
                .antMatchers("/user/**").hasAnyAuthority("USER")//
                .anyRequest().authenticated()//
                .and()//
                .exceptionHandling().authenticationEntryPoint(unauthorizedEntryPoint)//
                .and()//
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

}
