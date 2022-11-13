package com.ttasjwi.basicsecurity.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 인가 정책 : 모든 요청 -> 인증 필요
        http.authorizeRequests(requests -> requests.anyRequest().authenticated());

        // 인증 정책 : Form 로그인 방식으로 인증
        http.formLogin();
    }
}
