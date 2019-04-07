package eu.smallAllegro.springmvcfirst.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(
                        "/h2-console/**",
                        "/",
                        "/templates/**",
                        "/static/**",
                        "/webjars/**"
                ).permitAll()
                .antMatchers("/customer/**", "/customers/**")
                    .hasRole("CUSTOMER")
                .antMatchers("/product/**","/products/**")
                    .hasRole("PRODUCT")
                .antMatchers("/api/**")
                .hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                    .formLogin().permitAll()
                .and()
                    .logout()
                    .invalidateHttpSession(true)
                    .clearAuthentication(true)
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/")
                    .permitAll()
                .and()
                    .exceptionHandling()
                    .accessDeniedPage("/login")
                .and()
                    .headers().frameOptions().disable().and().httpBasic();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("product").password("p").roles("PRODUCT")
                .and()
                .withUser("customer").password("c").roles("CUSTOMER")
                .and()
                .withUser("admin").password("a").roles("ADMIN","CUSTOMER","PRODUCT");
    }
}
