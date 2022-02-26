package solutions.thex.reporeporter.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UnauthorizedEntryPoint unauthorizedEntryPoint;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http//
                .authorizeRequests()//
                .antMatchers("/actuator/**").hasIpAddress("127.0.0.1")//
                .antMatchers("/favicon.ico").permitAll()//
                .antMatchers("/api/**").permitAll()//
                .antMatchers("/admin/**").hasAnyAuthority("ADMIN")//
                .antMatchers("/user/**").hasAnyAuthority("USER")//
                .anyRequest().authenticated()//
                .and()//
                .exceptionHandling().authenticationEntryPoint(unauthorizedEntryPoint)//
                .and()//
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

}
