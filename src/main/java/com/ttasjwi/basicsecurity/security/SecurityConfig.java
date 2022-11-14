package com.ttasjwi.basicsecurity.security;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


@Slf4j
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 인가 정책 : 모든 요청 -> 인증 필요
        http.authorizeRequests(requests -> requests.anyRequest().authenticated());

        // 인증 정책 : Form 로그인 방식으로 인증
        http.formLogin()
//                .loginPage("/loginPage")
                .defaultSuccessUrl("/")
                .failureUrl("/login")
                .usernameParameter("userId")
                .passwordParameter("passwd")
                .loginProcessingUrl("/login_proc")
//                .successHandler(loginSuccessHandler())
//                .failureHandler(loginFailureHandler())
                .permitAll(); // form 로그인과 관련된 요청은 모두 허락
    }

    private static AuthenticationSuccessHandler loginSuccessHandler() {
        return (request, response, authentication) -> {
            log.info("authentication : {}", authentication.getName());
            response.sendRedirect("/");
        };
    }

    private static AuthenticationFailureHandler loginFailureHandler() {
        return (request, response, exception) -> {
            log.info("exception : {}", exception.getMessage());
            response.sendRedirect("/login");
        };
    }

}
