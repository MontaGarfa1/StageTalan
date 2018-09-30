package com.stageMonta.TalanTunisie.security;


import com.stageMonta.TalanTunisie.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN", "USER").and()
				.withUser("mariem").password("mariouma").roles("USER");*/

        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        // http.formLogin().loginPage("/login");
       http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        // http.formLogin();
        ////http.authorizeRequests().antMatchers("/login/**", "/register/**").permitAll();
        //// http.authorizeRequests().anyRequest().authenticated();
        http
                .authorizeRequests()
                .antMatchers("/console/**", "/reset", "/login").permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .requestMatchers()
                .antMatchers("/login", "/oauth/authorize", "/oauth/confirm_access", "/reset")
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated();
        http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
        http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

        /*
         * .antMatchers(/secured/).access("hasROLE('ROLE_ADMIN')")
         * .anyRequest().permitAll() .and() .formLogin()
         * .usernameParameter("username").passwordParameter("password");
         */
    }
}
